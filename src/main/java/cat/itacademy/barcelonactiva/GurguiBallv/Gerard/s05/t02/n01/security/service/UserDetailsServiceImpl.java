package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.security.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Autentica un usuario de la base de datos
 *
 * Authentication Manager llama al método loadUserByUsername de esta clase
 * para obtener los detalles del usuario de la base de datos cuando
 * se intente autenticar un usuario
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JugadorRepository jugadorRepository;


    /*
    * Se añade la ruta de la clase User, ya que en este metodo no puede haber 2 clases iguales con spring
    * se interactura con nuestra bases de datos para usuarios, con el repositorio
    * */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador jugador = jugadorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                jugador.getUsername(),jugador.getPassword(),new ArrayList<>());
    }
}
