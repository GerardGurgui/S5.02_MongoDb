package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);

    private JugadorRepository jugadorRepository;

    private JugadorDtoConvert JugadorDtoConvert;


    public JugadorService(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
        this.JugadorDtoConvert = new JugadorDtoConvert();
    }


    ////CRUD
        //--> CREATE
    public JugadorDTO createPlayer(JugadorDTO jugadorDTO){

        Jugador jugadorEntity = JugadorDtoConvert.convertDtoToPlayer(jugadorDTO);

        if (jugadorEntity.getId() != null){

            log.warn("No puedes crear un jugador con valor en el campo id");

        }

        jugadorRepository.save(jugadorEntity);
        log.info("Jugador creado correctamente");

        return jugadorDTO;

    }


        //--> READ
    public List<JugadorDTO> findAllPlayers(){

        List<JugadorDTO> listaJugadoresDto = new ArrayList<>();
        JugadorDTO jugadorDTO;

        for (Jugador jugadoresIter : jugadorRepository.findAll()) {

            jugadorDTO = JugadorDtoConvert.convertPlayerToDto(jugadoresIter);
            listaJugadoresDto.add(jugadorDTO);

        }

        return listaJugadoresDto;

    }

        //--> UPDATE

        //--> DELETE

}
