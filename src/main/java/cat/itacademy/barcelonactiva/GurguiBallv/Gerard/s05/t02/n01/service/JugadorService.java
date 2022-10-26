package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.IdPlayerException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game.GameFunctions;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoToPlayer;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);


    //INYECCIONES POR CONSTRUCTOR, FINAL POR INMUTABLE??
    private final JugadorRepository jugadorRepository;

    private final TiradaRepository tiradaRepository;

    private final DtoToPlayer dtoToPlayer;


    public JugadorService(JugadorRepository jugadorRepository, TiradaRepository tiradaRepository,
                          DtoToPlayer dtoToPlayer){
        this.jugadorRepository = jugadorRepository;
        this.tiradaRepository = tiradaRepository;
        this.dtoToPlayer = dtoToPlayer;
    }



    ////CRUD
        //--> CREATE
    public Jugador createPlayer(JugadorDTO jugadorDtoNew){

        Jugador jugadorEntity = dtoToPlayer.map(jugadorDtoNew);

        if (jugadorEntity.getId() != null){

            throw new IdPlayerException("EL nuevo jugador no puede contener un valor ID");

        }

        //COMPROBAR NOMBRE REPETIDO AL CREAR
        List<Jugador> jugadores = findAllPlayers();
        GameFunctions.validarNombre(jugadorEntity.getNombre(),jugadores);


        log.info("Jugador creado correctamente");

        return jugadorRepository.save(jugadorEntity);

    }


        //--> READ
    public List<Jugador> findAllPlayers(){

        return jugadorRepository.findAll();

    }

    public Jugador getOne(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);


        if (jugadorOpt.isEmpty()){

            throw new PlayerNotFoundException("No existe el jugador con id " +id);

        }

        return jugadorOpt.get();
    }



        //--> UPDATE

    public Jugador update(JugadorDTO jugadorDTO, Long id){

        //--> comprobar comportamiento con exceptions
        if (id == null){

            throw new IdPlayerException("El id del jugador a actualizar no puede ser nulo");
        }

        if (!jugadorRepository.existsById(id)){

            throw new PlayerNotFoundException("El jugador no existe");
        }

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        //ACTUALIZAMOS LOS ATRIBUTOS QUE SE PUEDEN INTRODUCIR EL USUARIO
        jugadorOpt.get().setNombre(jugadorDTO.getNombre());
        jugadorOpt.get().setEmail(jugadorDTO.getEmail());
        jugadorOpt.get().setPais(jugadorDTO.getPais());


        return jugadorRepository.save(jugadorOpt.get());

    }




    //FALTAAAAA
        //--> DELETE TIRADAS 1 JUGADOR
    public void deleteTiradas(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        if (jugadorOpt.isEmpty()){

            throw new PlayerNotFoundException("No existe el jugador con id " +id);

        }

        //prova4e5r435
        Tirada tirada;

        int i = 0;



        //---- PENDIENTE
        //PENDENT BORRAR TIRADAS-- comprobar primero si teine tiradas
        //exception si no tiene

        while (i <= jugadorOpt.get().getTiradas().size() &&
                   jugadorOpt.get().getTiradas() != null){

            tirada = tiradaRepository.getById(id);

            jugadorOpt.get().getTiradas().clear();
            tiradaRepository.delete(tirada);
            i++;
        }


        if (jugadorOpt.get().getTiradas().isEmpty()){
            log.warn("Se han eliminado correctamente las tiradas del jugador");
        }

    }




    ////FUNCIONALIDADES JUEGO

    //TIRAR DADOS- REGISTRO TIRADAS - PORCENTAJE
    public Jugador realizarTirada(Long id){

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        //CAMBIAR POR EXCEPTION
        if (jugadorOpt.isEmpty()){
            log.warn("no existe el jugador");
        }

        Jugador jugador = jugadorOpt.get();

        //TIRA DADOS
        Tirada tirada = GameFunctions.tirarDados();

        //COMPROBACIONES PUNTUACION
        comprobarTirada(jugador,tirada);

        //ASIGNAR TIRADA Y PORCENTAJES
        asignarTirada(jugador,tirada);

        return jugador;

    }

    public void comprobarTirada(Jugador jugador, Tirada tirada){


        //COMPRUEBA SUMA DE LA TIRADA
        boolean ganadorRonda = GameFunctions.comprobarTirada(tirada.getResultadoTirada());

        //COMPRUEBA TOTAL RONDAS GANADAS
        if (ganadorRonda){

            boolean ganadorPartida = GameFunctions.sumarPuntuacionRonda(jugador);
            jugador.setAcierto(100);

            if (ganadorPartida){
                jugador.setVictoria(1);
                //ALGO QUE ACABE EL JUEGO
            }

        } else {
            jugador.setAcierto(0);
        }

    }

    public void asignarTirada(Jugador jugador, Tirada tirada){

        jugador.addTirada(tirada);

        int porcentaje = GameFunctions.calcularPorcentajeJugador(jugador);
        jugador.setAcierto(porcentaje);

        //HACE FALTA?? ES RARO, CON JUGADOR DESDE EL MAIN YA SE GUARDA POR LA RELACION
        tiradaRepository.save(tirada);

    }

    ////

}
