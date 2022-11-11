package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
* Convertir de jugadorDto a JugadorEntidad
* implementamos la interfaz Imapper, recibe un jugadorDto (el que introduce el usuario)
* nos devuelve el jugador que guardaremos en BDD
* @component para poder inyectar en las clases donde necesitamos
* */

@Component
public class DtoToPlayer implements IMapper <JugadorDTO, Jugador>{


    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private PasswordEncoder encoder; //añadir SQL

    public DtoToPlayer(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
    }


    @Override
    public Jugador map(JugadorDTO jugadorDTO) {

        Jugador jugadorEntity = new Jugador();

//        QUE PASA SI HAY 2 ANONIMOS??
        if (jugadorDTO.getNombre().isEmpty()){
            jugadorEntity.setNombre("Anónimo");
        } else {
            jugadorEntity.setNombre(jugadorDTO.getNombre());
        }

        jugadorEntity.setEmail(jugadorDTO.getEmail());
        jugadorEntity.setContrasenya(encoder.encode(jugadorDTO.getContrasenya())); // añadir SQl
        jugadorEntity.setFechaRegistro(LocalDate.now());
        jugadorEntity.setPuntuacion(0);
        jugadorEntity.setVictoria(0);

        return jugadorEntity;
    }




}
