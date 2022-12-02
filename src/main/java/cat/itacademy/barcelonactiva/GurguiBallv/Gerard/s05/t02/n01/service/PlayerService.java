package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.PlayerDto;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Player;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Launch;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.*;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game.GameFunctions;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoToPlayer;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.PlayerRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.LaunchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final DtoToPlayer mapper;
    private final LaunchRepository launchRepository;

    public PlayerService(PlayerRepository playerRepository, DtoToPlayer mapper, LaunchRepository launchRepository) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
        this.launchRepository = launchRepository;
    }


    //---> INICIO - FIN JUEGO


    ////CRUD
    //--> CREATE
    public Player create(PlayerDto playerDto) {

        //MAPEAR DE DTO A ENTIDAD (COMPROBACIÓN DE NOMBRE VACÍO)
        Player playerEntity = mapper.map(playerDto);

        //COMPROBAR SI YA EXISTE ESE JUGADOR O NO
        Boolean existe = playerRepository.existsByUsername(playerEntity.getUsername());

        if (existe && !playerEntity.getUsername().equalsIgnoreCase("Anónimo")) {

            throw new ExistentUserNameException("El nombre del jugador ya existe");
        }

        return playerRepository.save(playerEntity);

    }


    //--> READ
    public List<Player> getAll() {

        return playerRepository.findAll();
    }


    public Player getOne(String id) {

        Optional<Player> jugador = playerRepository.findById(id);

        if (jugador.isEmpty()) {

            throw new PlayerNotFoundException("No existe el jugador con id " + id);

        }

        return jugador.get();
    }

    public List<Launch> getDadosOnePlayer(String idJugador) {

        return launchRepository.findByidJugadorIgnoreCase(idJugador);

    }

    //--> UPDATE

    public Player update(PlayerDto playerDto, String id) {

        if (playerRepository.existsByUsername(playerDto.getUsername())) {

            throw new ExistentUserNameException("El nombre del jugador ya existe");
        }

        if (playerRepository.existsByEmail(playerDto.getEmail())) {

            throw new ExistentEmailException("El email ya existe");
        }

        if (id == null) {

            throw new IdPlayerException("El id del jugador a actualizar no puede ser nulo");
        }

        if (!playerRepository.existsById(id)) {

            throw new PlayerNotFoundException("El jugador no existe");
        }

        Optional<Player> jugadorOpt = playerRepository.findById(id);

        jugadorOpt.get().setUsername(playerDto.getUsername());
        jugadorOpt.get().setEmail(playerDto.getEmail());

        return playerRepository.save(jugadorOpt.get());

    }


    //--> DELETE

    public void deleteOnePlayer(String id) {

        playerRepository.deleteById(id);

    }


    public void deleteTiradasOnePlayer(String id) {

        //REVISAR

        Player player = getOne(id);

        List<Launch> listaLaunches = player.getTiradas();
        String idTirada;


        if (listaLaunches.isEmpty()) {

            throw new NoThrowsPlayerException("El jugador no tiene tiradas registradas");

        }

        for (Launch launch : listaLaunches) {

            idTirada = launch.getId();
            launchRepository.deleteById(idTirada);

        }

        player.getTiradas().clear();
        player.setAcierto(0);
        player.setPuntuacion(0);

        //GUARDAR CAMBIOS
        playerRepository.save(player);

    }


    //----- TIRADA DE DADOS------

    public Player realizarTirada(String id) {

        Player player = playerRepository.findById(id).get();

        Launch launch = GameFunctions.tirarDados();

        comprobarTirada(player, launch);
        asignarTirada(player, launch);

        return player;

    }

    public void comprobarTirada(Player player, Launch launch) {


        //COMPRUEBA SUMA DE LA TIRADA
        boolean ganadorRonda = GameFunctions.comprobarTirada(launch.getResultado());

        //COMPRUEBA TOTAL RONDAS GANADAS
        if (ganadorRonda) {

            boolean ganadorPartida = GameFunctions.sumarPuntuacionRonda(player);
            player.setAcierto(100);

            if (ganadorPartida) {
                player.setVictoria(1);
                //ALGO QUE ACABE EL JUEGO
            }

        } else {
            player.setAcierto(0);
        }

    }

    public void asignarTirada(Player player, Launch launch) {

        //añadir la tirada al jugador
        player.addTirada(launch);
        launch.setIdJugador(player.getId());

        //con el resultado de la tirada y sus puntuaciones calculamos el porcentaje
        int porcentaje = GameFunctions.calcularPorcentajeJugador(player);
        player.setAcierto(porcentaje);

        //guardar cambios en repositorios
        launchRepository.save(launch);
        playerRepository.save(player);

    }


    ////------- PORCENTAJES ---------
    public Map<String, Integer> porcentajeJugadores() {

        //EXCEPTION DE SI TIENE TIRADAS O NO???

        List<Player> jugadores = getAll();

        return GameFunctions.calcularPorcentajeJugadores(jugadores);

    }


    public int porcentajeMediaTotal() {

        //TOTAL TIRADAS TOTS ELS JUGADORS * 100 / NUM JUGADORS
        List<Player> jugadores = getAll();

        return GameFunctions.calcularPorcentajeMedio(jugadores);

    }


    public Map<String, Integer> porcentajeJugadorLoser() {

        List<Player> jugadores = getAll();

        return GameFunctions.calcularPorcentajeLoser(jugadores);

    }

    public Map<String, Integer> porcentajeJugadorWinner() {

        List<Player> jugadores = getAll();

        return GameFunctions.calcularPorcentajeWinner(jugadores);

    }


}
