package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);


    private JugadorRepository jugadorRepository;

    private JugadorDtoConvert jugadorDtoConvert;


    public JugadorService(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
        jugadorDtoConvert = new JugadorDtoConvert();
    }




    ////CRUD
        //--> CREATE
    public JugadorDTO createPlayer(JugadorDTO jugadorDtoNew){

        Jugador jugadorEntity = jugadorDtoConvert.convertDtoToPlayer(jugadorDtoNew);

        if (jugadorEntity.getId() != null){

            log.warn("No puedes crear un jugador con valor en el campo id");

        }

        jugadorRepository.save(jugadorEntity);
        log.info("Jugador creado correctamente");

        return jugadorDtoNew;

    }


        //--> READ
    public List<JugadorDTO> findAllPlayers(){

        List<JugadorDTO> listaJugadoresDto = new ArrayList<>();
        JugadorDTO jugadorDTO;

        for (Jugador jugadoresIter : jugadorRepository.findAll()) {

            jugadorDTO = jugadorDtoConvert.convertPlayerToDto(jugadoresIter);
            listaJugadoresDto.add(jugadorDTO);

        }

        return listaJugadoresDto;

    }

    public JugadorDTO getOne(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        JugadorDTO jugadorDTO = jugadorDtoConvert.convertPlayerToDto(jugadorOpt.get());

        return jugadorDTO;
    }

        //--> UPDATE

        //--> DELETE

}
