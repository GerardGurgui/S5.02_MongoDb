package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;


import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tiradas")
public class Tirada {

    private String id;

    private String idJugador;
    private int dado1;
    private int dado2;
    private int resultado;

    public Tirada() {
    }

    public Tirada(String idJugador, int dado1, int dado2, int resultado) {
        this.idJugador = idJugador;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.resultado = resultado;
    }

        public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
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

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
