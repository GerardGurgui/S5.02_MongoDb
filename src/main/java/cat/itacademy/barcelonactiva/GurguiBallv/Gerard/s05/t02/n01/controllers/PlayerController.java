package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.controllers;


import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.PlayerDto;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Player;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Launch;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.PlayerRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.security.payload.MessageResponse;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.PlayerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerService playerService, PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
    }


    //--> CREATE

//    @PostMapping("/add")
//    public Jugador addPlayer(@RequestBody JugadorDTO jugadorDTO){
//
//        return jugadorService.create(jugadorDTO);
//
//    }

    //--> READ

    @GetMapping("/get/findAll")
    public List<Player> getAllPlayers(){

        return playerService.getAll();

    }

    @GetMapping("/get/findOne/{id}")
    public ResponseEntity<Player> getOnePlayer(@PathVariable String id){

        return ResponseEntity.ok(playerService.getOne(id));

    }


    @GetMapping("/getThrows/{idPlayer}")
    public List<Launch> getAllDadosOnePlayer(@PathVariable String idPlayer){

        return playerService.getDadosOnePlayer(idPlayer);

    }


    //--> UPDATE

    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerDto playerDto,
                                               @PathVariable String id){

        return new ResponseEntity<>(playerService.update(playerDto, id), HttpStatus.OK);

    }


    //--> DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deletePlayer(@PathVariable String id){

        playerService.deleteOnePlayer(id);

        return ResponseEntity.ok().body(new MessageResponse("Player deleted succesfully"));

    }

    @DeleteMapping("/deleteThrows/{id}")
    public ResponseEntity<MessageResponse> deleteThrowsOnePlayer(@PathVariable String id){

        playerService.deleteTiradasOnePlayer(id);

        return ResponseEntity.ok().body(new MessageResponse("Throws from player deleted succesfully"));
    }


    ////// DADOS
    @PostMapping("/game/throws/{id}")
    public Player throwsDice(@PathVariable String id,
                             @RequestHeader(HttpHeaders.AUTHORIZATION)
                             String token){


        return playerService.realizarTirada(id);

    }


    //// PORCENTAJES

    //LISTA DE PORCENTAJE DE CADA JUGADOR
    @GetMapping("/percentage/players")
    public Map<String,Integer> showPercentage(){

        return playerService.porcentajeJugadores();
    }

    //EL PORCENTAJE MEDIO TOTAL DE LOS JUGADORES
    @GetMapping("/ranking")
    public int showAllAverage(){

        return playerService.porcentajeMediaTotal();

    }

    @GetMapping("/ranking/loser")
    public Map<String, Integer> showLoser(){

        return playerService.porcentajeJugadorLoser();

    }

    @GetMapping("/ranking/winner")
    public Map<String, Integer> showWinner(){

        return playerService.porcentajeJugadorWinner();

    }

}
