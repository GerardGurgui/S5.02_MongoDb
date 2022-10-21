package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class JugadorDtoConvert {


    private TiradaDtoConvert tiradaDtoConvert;

    public JugadorDtoConvert(){
        tiradaDtoConvert = new TiradaDtoConvert();
    }

    ////DTO
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

        //RECORRU LA LLISTA DE TIRADASDTO

        for (Tirada tirada : tiradasToDto) {
            tiradaDTO = tiradaDtoConvert.convertTiradaToDTO(tirada);
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

            tirada = tiradaDtoConvert.convertDtoToTirada(tiradaDTO);
            jugador.addTirada(tirada);

        }

        return jugador;
    }




}
