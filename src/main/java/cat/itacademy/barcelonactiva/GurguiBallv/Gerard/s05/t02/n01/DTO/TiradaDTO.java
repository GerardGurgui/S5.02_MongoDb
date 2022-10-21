package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;

import java.io.Serializable;

public class TiradaDTO {

    //PENSAR BIEN QUE GUARDO EN BDD Y QUE QUIERO MOSTRAR, ESTADISTIDICAS, RESULTADOS ETC
    private Long id;
    private int dado1;
    private int dado2;
    private int resultadoTirada;

//    private JugadorDTO jugadorDTO;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public int getResultadoTirada() {
        return resultadoTirada;
    }

    public void setResultadoTirada(int resultadoTirada) {
        this.resultadoTirada = resultadoTirada;
    }

//    public JugadorDTO getJugadorDTO() {
//        return jugadorDTO;
//    }
//
//    public void setJugadorDTO(JugadorDTO jugadorDTO) {
//        this.jugadorDTO = jugadorDTO;
//    }
}
