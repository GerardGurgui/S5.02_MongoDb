package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/*
* Convertir de jugadorDto a JugadorEntidad
* implementamos la interfaz Imapper, recibe un jugadorDto (el que introduce el usuario)
* nos devuelve el jugador que guardaremos en BDD
* @component para poder inyectar en las clases donde necesitamos
* */

@Component
public class DtoToPlayer implements IMapper <JugadorDTO, Jugador>{

    @Override
    public Jugador map(JugadorDTO jugadorDTO) {

        Jugador jugadorEntity = new Jugador();

        //QUE PASA SI HAY 2 ANONIMOS??
        if (jugadorDTO.getNombre().isEmpty()){
            jugadorEntity.setNombre("Anónimo");

        } else {
            jugadorEntity.setNombre(jugadorDTO.getNombre());
        }

        jugadorEntity.setId(jugadorDTO.getId());
        jugadorEntity.setEmail(jugadorDTO.getEmail());
        jugadorEntity.setPais(jugadorDTO.getPais());

        jugadorEntity.setFechaRegistro(LocalDate.now());
        jugadorEntity.setPuntuacion(0);
        jugadorEntity.setVictoria(0);

        return jugadorEntity;
    }




}
