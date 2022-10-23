package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoJugadorToJugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);


    //INYECCIONES POR CONSTRUCTOR, FINAL POR INMUTABLE??
    private final JugadorRepository jugadorRepository;

    private final DtoJugadorToJugador mapper;


    public JugadorService(JugadorRepository jugadorRepository, DtoJugadorToJugador mapper){
        this.jugadorRepository = jugadorRepository;
        this.mapper = mapper;
    }




    ////CRUD
        //--> CREATE
    public Jugador createPlayer(JugadorDTO jugadorDtoNew){

        Jugador jugadorEntity = mapper.map(jugadorDtoNew);

        if (jugadorEntity.getId() != null){

            log.warn("No puedes crear un jugador con valor en el campo id");

        }

        log.info("Jugador creado correctamente");

        return jugadorRepository.save(jugadorEntity);

    }


        //--> READ
    public List<Jugador> findAllPlayers(){

//        List<JugadorDTO> listaJugadoresDto = new ArrayList<>();
//        JugadorDTO jugadorDTO;
//
//        for (Jugador jugadoresIter : jugadorRepository.findAll()) {
//
//            jugadorDTO = mapper.map(jugadoresIter);
//            listaJugadoresDto.add(jugadorDTO);
//
//        }

        return jugadorRepository.findAll();

    }

    public Jugador getOne(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        return jugadorOpt.get();
    }

        //--> UPDATE

        //--> DELETE

}
