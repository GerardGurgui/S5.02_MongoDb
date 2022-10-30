package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.controllers;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.CollectionsGeneratorService;
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.JugadorService;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class JugadorController {


//    private final JugadorService jugadorService;

    private final CollectionsGeneratorService collectionsGeneratorService;

    private final JugadorService jugadorService;


    public JugadorController(CollectionsGeneratorService collectionsGeneratorService, JugadorService jugadorService){
        this.jugadorService = jugadorService;
        this.collectionsGeneratorService = collectionsGeneratorService;
    }

    ////----> CRUD

        //--> CREATE
    @PostMapping("/add")
    public Jugador addPlayer(@Validated @RequestBody JugadorDTO jugadorDTO){

        jugadorDTO.setId(collectionsGeneratorService.generateCollection(Jugador.SEQUENCE_NAME));

        return jugadorService.createPlayer(jugadorDTO);



//        return new ResponseEntity<>(jugadorService.createPlayer(jugadorDTO), HttpStatus.CREATED);

    }


        //--> READ
    @GetMapping("/findAll")
    public List<Jugador> getAllPlayers(){

        return jugadorService.findAllPlayers();

    }


//    @GetMapping("/findOne/{id}")
//    public ResponseEntity<Jugador> getOnePlayer(@PathVariable Long id){
//
//        return ResponseEntity.ok(jugadorService.getOne(id));
//
//    }
//
//        //--> UPDATE
//
//    @PutMapping("/updatePlayer/{id}")
//    public ResponseEntity<Jugador> updatePlayer(@RequestBody JugadorDTO jugadorDTO,
//                                                @PathVariable Long id){
//
//        return new ResponseEntity<>(jugadorService.update(jugadorDTO, id), HttpStatus.OK);
//
//    }
//
//        //--> DELETE
//
//    @DeleteMapping("/deleteTiradas/{id}")
//    public void deletePlayer(@PathVariable Long id){
//
//        jugadorService.deleteTiradas(id);
//    }


    ////FUNCIONALIDADES JUEGO

        //INICIO JUEGO





        //JUGADOR REALIZA TIRADA

//    @PostMapping("/game/tirada/{id}")
//    public ResponseEntity<Jugador> realizaTirada(@PathVariable Long id){
//
//        return ResponseEntity.ok(jugadorService.realizarTirada(id));
//
//    }
//
//
//        //LISTA DE PORCENTAJE DE CADA JUGADOR
//    @GetMapping("/porcentajes/jugadores")
//    public Map<String,Integer> mostrarPorcentajes(){
//
//        return jugadorService.porcentajeJugadores();
//    }
//
//    //EL PORCENTAJE MEDIO TOTAL DE LOS JUGADORES
//    @GetMapping("/ranking")
//    public int mostrarPorcentajeMediaTotal(){
//
//       return jugadorService.porcentajeMediaTotal();
//
//    }
//
//    @GetMapping("/ranking/loser")
//    public Map<String, Integer> mostrarLoser(){
//
//        return jugadorService.porcentajeJugadorLoser();
//
//    }
//
//    @GetMapping("/ranking/winner")
//    public Map<String, Integer> mostrarWinner(){
//
//        return jugadorService.porcentajeJugadorWinner();
//
//    }


}
