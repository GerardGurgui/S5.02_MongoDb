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

    @Autowired
    private JugadorRepository jugadorRepository;

//    private JugadorDtoConvert jugadorDtoConvert;


//    public JugadorService(JugadorRepository jugadorRepository){
//        this.jugadorRepository = jugadorRepository;
////        jugadorDtoConvert = new JugadorDtoConvert();
//    }

    /////DTO -JUGADOR

    public JugadorDTO convertPlayerToDto(Jugador jugador){

        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setId(jugador.getId());
        jugadorDTO.setNombre(jugador.getNombre());
        jugadorDTO.setLocalDate(jugador.getLocalDate());
        jugadorDTO.setPuntuacion(jugador.getPuntuacion());
        jugadorDTO.setVictoria(jugador.getVictoria());

//        OBTENC LA LLISTA DE TIRADAS ENTITAT DE LA ENTITAT JUGADOR
        Set<Tirada> tiradasToDto = jugador.getTiradas();

        //LES ANIRE GUARDAN A UNA VARIABLE TIRADA DTO
        TiradaDTO tiradaDTO;

        //RECORRU LA LLISTA DE TIRADASDTO, LES VAIG CONVERTIN UNA A UNA
        //I AFEGINLAS A LA LLISTA DEL JUGADOR

        for (Tirada tirada : tiradasToDto) {
            tiradaDTO = convertTiradaToDTO(tirada);
            jugadorDTO.addTiradaDto(tiradaDTO);
        }

        return jugadorDTO;
    }

    public Jugador convertDtoToPlayer(JugadorDTO jugadorDTO){

        Jugador jugador = new Jugador();

        jugador.setId(jugadorDTO.getId());
        jugador.setNombre(jugadorDTO.getNombre());
        jugador.setLocalDate(jugadorDTO.getLocalDate());
        jugador.setPuntuacion(jugadorDTO.getPuntuacion());
        jugador.setVictoria(jugadorDTO.getVictoria());


        Set<TiradaDTO> tiradasDtoToTirada = jugadorDTO.getTiradas();
        Tirada tirada;

        for (TiradaDTO tiradaDTO : tiradasDtoToTirada) {

            tirada = convertDtoToTirada(tiradaDTO);
            jugador.addTirada(tirada);

        }

        return jugador;
    }


    ////DTO TIRADA

    public TiradaDTO convertTiradaToDTO(Tirada tirada){

        TiradaDTO tiradaDTO = new TiradaDTO();

        tiradaDTO.setId(tirada.getId());
        tiradaDTO.setDado1(tirada.getDado1());
        tiradaDTO.setDado2(tirada.getDado2());
        tiradaDTO.setResultadoTirada(tirada.getResultadoTirada());


        return tiradaDTO;

    }

    public Tirada convertDtoToTirada(TiradaDTO tiradaDTO){

        Tirada tirada = new Tirada();

        tirada.setId(tiradaDTO.getId());
        tirada.setDado1(tiradaDTO.getDado1());
        tirada.setDado2(tiradaDTO.getDado2());
        tirada.setResultadoTirada(tiradaDTO.getResultadoTirada());

        return tirada;

    }








    ////CRUD
        //--> CREATE
    public JugadorDTO createPlayer(JugadorDTO jugadorDtoNew){

        Jugador jugadorEntity = convertDtoToPlayer(jugadorDtoNew);

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

            jugadorDTO = convertPlayerToDto(jugadoresIter);
            listaJugadoresDto.add(jugadorDTO);

        }

        return listaJugadoresDto;

    }

    public JugadorDTO getOne(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        JugadorDTO jugadorDTO = convertPlayerToDto(jugadorOpt.get());

        return jugadorDTO;
    }

        //--> UPDATE

        //--> DELETE

}
