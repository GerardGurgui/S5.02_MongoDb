package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;

public class TiradaDtoConvert {

    ///DTO

    public TiradaDTO convertTiradaToDTO(Tirada tirada){

        TiradaDTO tiradaDTO = new TiradaDTO();

        tiradaDTO.setId(tirada.getId());
        tiradaDTO.setDado1(tirada.getDado1());
        tiradaDTO.setDado2(tirada.getDado2());
        tiradaDTO.setResultadoTirada(tirada.getResultadoTirada());


        return tiradaDTO;

    }

    public Tirada convertDtoToTirada(TiradaDTO tiradaDTO){

        Tirada tirada = new Tirada();

        tirada.setId(tiradaDTO.getId());
        tirada.setDado1(tiradaDTO.getDado1());
        tirada.setDado2(tiradaDTO.getDado2());
        tirada.setResultadoTirada(tiradaDTO.getResultadoTirada());

        return tirada;

    }
}
