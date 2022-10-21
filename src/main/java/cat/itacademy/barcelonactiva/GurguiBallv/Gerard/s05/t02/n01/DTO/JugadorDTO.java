package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class JugadorDTO implements Serializable {

    //PENSAR BIEN QUE GUARDO EN BDD Y QUE QUIERO MOSTRAR, ESTADISTIDICAS, RESULTADOS ETC
    //NO PASSWORD
    private Long id;
    private String userName;
    private LocalDate localDate;
    private int puntuacion;
    private int victoria;

    private Set<TiradaDTO> listaTiradas;

    public JugadorDTO() {
        listaTiradas = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getVictoria() {
        return victoria;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    public Set<TiradaDTO> getListaTiradas() {
        return listaTiradas;
    }

    public void setListaTiradas(Set<TiradaDTO> listaTiradas) {
        this.listaTiradas = listaTiradas;
    }
}
