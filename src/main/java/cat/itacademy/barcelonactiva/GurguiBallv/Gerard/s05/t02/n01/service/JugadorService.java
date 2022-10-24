package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game.GameFunctions;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoJugadorToJugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);


    //INYECCIONES POR CONSTRUCTOR, FINAL POR INMUTABLE??
    private final JugadorRepository jugadorRepository;

    private final TiradaRepository tiradaRepository;

    private final DtoJugadorToJugador mapper;


    public JugadorService(JugadorRepository jugadorRepository, TiradaRepository tiradaRepository, DtoJugadorToJugador mapper){
        this.jugadorRepository = jugadorRepository;
        this.tiradaRepository = tiradaRepository;
        this.mapper = mapper;
    }



    ////CRUD
        //--> CREATE
    public Jugador createPlayer(JugadorDTO jugadorDtoNew){

        Jugador jugadorEntity = mapper.map(jugadorDtoNew);

        //-- CAMBIAR POR EXCEPTION
        if (jugadorEntity.getId() != null){

            log.warn("No puedes crear un jugador con valor en el campo id");

        }

        log.info("Jugador creado correctamente");

        return jugadorRepository.save(jugadorEntity);

    }


        //--> READ
    public List<Jugador> findAllPlayers(){

        return jugadorRepository.findAll();

    }

    public Jugador getOne(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        //-- CAMBIAR POR EXCEPTION
        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        return jugadorOpt.get();
    }



        //--> UPDATE

        //--> DELETE



    ////FUNCIONALIDADES JUEGO

    //TIRAR DADOS
    public Jugador realizarTirada(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        //CAMBIAR POR EXCEPTION
        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        Jugador jugador = jugadorOpt.get();

        //TIRA DADOS, MODIFICA VALORES TIRADA DADOS
        Tirada tirada = GameFunctions.tirarDados();

        //COMPRUEBA SUMA DE LA TIRADA
        boolean ganadorRonda = GameFunctions.comprobarTirada(tirada.getResultadoTirada());

        //COMPRUEBA TOTAL RONDAS GANADAS
        if (ganadorRonda){

            boolean ganadorPartida = GameFunctions.sumarPuntuacionRonda(jugador);

            if (ganadorPartida){
                jugador.setVictoria(1);
            }
        }

        //REVISAR BIEN
        jugador.addTirada(tirada);

        //HACE FALTA?? ES RARO, CON JUGADOR DESDE EL MAIN YA SE GUARDA POR LA RELACION
        tiradaRepository.save(tirada);


        return jugador;

    }

}
