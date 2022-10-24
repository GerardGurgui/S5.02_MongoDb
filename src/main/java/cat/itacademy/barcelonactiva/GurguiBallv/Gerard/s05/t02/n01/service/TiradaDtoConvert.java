package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import org.springframework.beans.factory.annotation.Autowired;

public class TiradaDtoConvert {


    public static TiradaDTO convertTiradaToDTO(Tirada tirada){

        TiradaDTO tiradaDTO = new TiradaDTO();

        tiradaDTO.setDado1(tirada.getDado1());
        tiradaDTO.setDado2(tirada.getDado2());
        tiradaDTO.setResultadoTirada(tirada.getResultadoTirada());


        return tiradaDTO;

    }

    public static Tirada convertDtoToTirada(TiradaDTO tiradaDTO){

        Tirada tirada = new Tirada();

        tirada.setDado1(tiradaDTO.getDado1());
        tirada.setDado2(tiradaDTO.getDado2());
        tirada.setResultadoTirada(tiradaDTO.getResultadoTirada());

        return tirada;

    }
}
