package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class JugadorDTO implements Serializable {

    //PENSAR BIEN QUE GUARDO EN BDD Y QUE QUIERO MOSTRAR, ESTADISTIDICAS, RESULTADOS ETC
    //NO PASSWORD
    private Long id;
    private String nombre;
    private LocalDate localDate;
    private int puntuacion;
    private int victoria;
    private Set<TiradaDTO> tiradas;

    public JugadorDTO() {
//        tiradas = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Set<TiradaDTO> getTiradas() {
        return tiradas;
    }

    public void setTiradas(Set<TiradaDTO> tiradas) {
        this.tiradas = tiradas;
    }

    public void addTiradaDto(TiradaDTO tiradaDTO){

        if (this.tiradas == null){
            tiradas = new HashSet<>();
        }

        tiradas.add(tiradaDTO);

    }
}
