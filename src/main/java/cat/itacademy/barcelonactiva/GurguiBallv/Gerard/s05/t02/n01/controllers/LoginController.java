package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.controllers;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/registro")
public class LoginController {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private JugadorRepository jugadorRepository;



    @ModelAttribute("jugador")
    public JugadorDTO returnNewDtoPlayer(){

        return new JugadorDTO();
    }


    @GetMapping
    public String showAll(Model model){

        List<Jugador> jugadores = jugadorService.getAll();

        model.addAttribute("jugadores", jugadores);

        return "jugadores";

    }

    @PostMapping
    public String registrarJugador(@ModelAttribute ("jugador") JugadorDTO jugadorDTO){

        jugadorService.create(jugadorDTO);

        return "redirect:/registro?exito";

    }




}
