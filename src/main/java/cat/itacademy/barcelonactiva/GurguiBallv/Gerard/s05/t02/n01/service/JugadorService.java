package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.ExistentEmailException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.ExistentUserNameException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.IdPlayerException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game.GameFunctions;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoToPlayer;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final DtoToPlayer mapper;
    private final TiradaRepository tiradaRepository;

    public JugadorService(JugadorRepository jugadorRepository, DtoToPlayer mapper, TiradaRepository tiradaRepository) {
        this.jugadorRepository = jugadorRepository;
        this.mapper = mapper;
        this.tiradaRepository = tiradaRepository;
    }

    ////CRUD
        //--> CREATE
    public Jugador create(JugadorDTO jugadorDTO){

        Jugador jugadorEntity = mapper.map(jugadorDTO);

        Boolean existe = jugadorRepository.existsByUsername(jugadorEntity.getUsername());


        if (existe && !jugadorEntity.getUsername().equalsIgnoreCase("Anónimo")){

            throw new ExistentUserNameException("El nombre del jugador ya existe");
        }

        return jugadorRepository.save(jugadorEntity);

    }


        //--> READ
    public List<Jugador> getAll(){

        return jugadorRepository.findAll();
    }


    public Jugador getOne(String id){

        Optional<Jugador> jugador = jugadorRepository.findById(id);

        if (jugador.isEmpty()){

            throw new PlayerNotFoundException("No existe el jugador con id " +id);

        }

        return jugador.get();
    }

    public List<Tirada> getDadosOnePlayer(String idJugador){

        return tiradaRepository.findByidJugadorIgnoreCase(idJugador);

    }

        //--> UPDATE

    public Jugador update(JugadorDTO jugadorDTO, String id){

        if (jugadorRepository.existsByUsername(jugadorDTO.getUsername())){

            throw new ExistentUserNameException("El nombre del jugador ya existe");
        }

        if (jugadorRepository.existsByEmail(jugadorDTO.getEmail())){

            throw new ExistentEmailException("El email ya existe");
        }

        if (id == null) {

            throw new IdPlayerException("El id del jugador a actualizar no puede ser nulo");
        }

        if (!jugadorRepository.existsById(id)) {

            throw new PlayerNotFoundException("El jugador no existe");
        }

        Optional<Jugador> jugadorOpt = jugadorRepository.findById(id);

        jugadorOpt.get().setUsername(jugadorDTO.getUsername());
        jugadorOpt.get().setEmail(jugadorDTO.getEmail());

        return jugadorRepository.save(jugadorOpt.get());

    }

        //--> DELETE

    public void deleteOnePlayer(String id){

        jugadorRepository.deleteById(id);

    }


    public void deleteTiradasOnePlayer(String id){

        Jugador jugador = getOne(id);

        List<Tirada> listaTiradas = jugador.getTiradas();

        tiradaRepository.deleteAllById(listaTiradas,id);

    }


    //TIRADA

    public Jugador realizarTirada(String id){

        Jugador jugador = jugadorRepository.findById(id).get();

        Tirada tirada = GameFunctions.tirarDados();

        comprobarTirada(jugador,tirada);
        asignarTirada(jugador,tirada);

        return jugador;

    }

    public void comprobarTirada(Jugador jugador, Tirada tirada) {


        //COMPRUEBA SUMA DE LA TIRADA
        boolean ganadorRonda = GameFunctions.comprobarTirada(tirada.getResultado());

        //COMPRUEBA TOTAL RONDAS GANADAS
        if (ganadorRonda) {

            boolean ganadorPartida = GameFunctions.sumarPuntuacionRonda(jugador);
            jugador.setAcierto(100);

            if (ganadorPartida) {
                jugador.setVictoria(1);
                //ALGO QUE ACABE EL JUEGO
            }

        } else {
            jugador.setAcierto(0);
        }

    }

    public void asignarTirada(Jugador jugador, Tirada tirada) {

        //añadir la tirada al jugador
        jugador.addTirada(tirada);
        tirada.setIdJugador(jugador.getId());

        //con el resultado de la tirada y sus puntuaciones calculamos el porcentaje
        int porcentaje = GameFunctions.calcularPorcentajeJugador(jugador);
        jugador.setAcierto(porcentaje);

        //guardar cambios en repositorios
        jugadorRepository.save(jugador);
        tiradaRepository.save(tirada);

    }

    //// PORCENTAJES
    public Map<String, Integer> porcentajeJugadores() {

        //EXCEPTION DE SI TIENE TIRADAS O NO???

        List<Jugador> jugadores = getAll();

        return GameFunctions.calcularPorcentajeJugadores(jugadores);

    }


    public int porcentajeMediaTotal() {

        //TOTAL TIRADAS TOTS ELS JUGADORS * 100 / NUM JUGADORS
        List<Jugador> jugadores = getAll();

        return GameFunctions.calcularPorcentajeMedio(jugadores);

    }


    public Map<String, Integer> porcentajeJugadorLoser() {

        List<Jugador> jugadores = getAll();

        return GameFunctions.calcularPorcentajeLoser(jugadores);

    }

    public Map<String, Integer> porcentajeJugadorWinner() {

        List<Jugador> jugadores = getAll();

        return GameFunctions.calcularPorcentajeWinner(jugadores);

    }




}
