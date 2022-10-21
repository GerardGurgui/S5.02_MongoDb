package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import com.sun.istack.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    private int puntuacion;
    private int victoria;

    private String contrasenya; // DTO? JWT SECURITY?

    @Column(name = "fecha_registro")
    private LocalDate localDate;


//    @JsonIgnore //evitar error recursivo, pero claro no muestra lista dados por jugador
//                arreglar con DTO??
    //eager aqui??
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    private Set<Tirada> tiradas;


    public Jugador() {
    }

    public Jugador(String nombre, LocalDate localDate) {
        this.nombre = nombre;
        this.localDate = localDate;
        puntuacion = 0;
        victoria = 0;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Set<Tirada> getTiradas() {
        return tiradas;
    }

    public void setTiradas(Set<Tirada> tiradas) {
        this.tiradas = tiradas;
    }

    public int getVictoria() {
        return victoria;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    ////
    public void addTirada(Tirada tirada){

        if (tiradas == null){
            tiradas = new HashSet<>();
        }

        tiradas.add(tirada);

//        tirada.setJugador(this);

    }


    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", victoria=" + victoria +
//                ", localDate=" + localDate +
//                ", tiradas=" + tiradas +
                '}';
    }
}
