package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.controllers;


import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.security.payload.MessageResponse;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class JugadorController {

    private final JugadorService jugadorService;
    private final JugadorRepository jugadorRepository;




    public JugadorController(JugadorService jugadorService, JugadorRepository jugadorRepository) {
        this.jugadorService = jugadorService;
        this.jugadorRepository = jugadorRepository;
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
    public List<Jugador> getAllPlayers(){

        return jugadorService.getAll();

    }

    @GetMapping("/get/findOne/{id}")
    public ResponseEntity<Jugador> getOnePlayer(@PathVariable String id){

        return ResponseEntity.ok(jugadorService.getOne(id));

    }


    @GetMapping("/get/getTiradas/{idJugador}")
    public List<Tirada> getAllDadosOnePlayer(@PathVariable String idJugador){

        return jugadorService.getDadosOnePlayer(idJugador);

    }


    //--> UPDATE

    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<Jugador> updatePlayer(@RequestBody JugadorDTO jugadorDTO,
                                                @PathVariable String id){

        return new ResponseEntity<>(jugadorService.update(jugadorDTO, id), HttpStatus.OK);

    }


    //--> DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deletePlayer(@PathVariable String id){

        jugadorService.deleteOnePlayer(id);

        return ResponseEntity.ok().body(new MessageResponse("Jugador eliminado correctamente"));

    }

    @DeleteMapping("/deleteTiradas/{id}")
    public ResponseEntity<MessageResponse> deleteDadosOnePlayer(@PathVariable String id){

        jugadorService.deleteTiradasOnePlayer(id);

        return ResponseEntity.ok().body(new MessageResponse("Tiradas del jugador eliminadas"));
    }


    ////// DADOS
    @PostMapping("/game/tirada/{id}")
    public Jugador tirarDados(@PathVariable String id){

        return jugadorService.realizarTirada(id);

    }


    //// PORCENTAJES

    //LISTA DE PORCENTAJE DE CADA JUGADOR
    @GetMapping("/get/porcentajes/jugadores")
    public Map<String,Integer> mostrarPorcentajes(){

        return jugadorService.porcentajeJugadores();
    }

    //EL PORCENTAJE MEDIO TOTAL DE LOS JUGADORES
    @GetMapping("/get/ranking")
    public int mostrarPorcentajeMediaTotal(){

        return jugadorService.porcentajeMediaTotal();

    }

    @GetMapping("/get/ranking/loser")
    public Map<String, Integer> mostrarLoser(){

        return jugadorService.porcentajeJugadorLoser();

    }

    @GetMapping("/get/ranking/winner")
    public Map<String, Integer> mostrarWinner(){

        return jugadorService.porcentajeJugadorWinner();

    }

}
