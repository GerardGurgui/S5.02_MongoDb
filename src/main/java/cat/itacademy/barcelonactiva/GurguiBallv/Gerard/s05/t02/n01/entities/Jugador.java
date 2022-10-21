package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import com.sun.istack.NotNull;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jugadores")
public class Jugador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    private int puntuacion;
    private int victoria;

    private String password; // DTO? JWT SECURITY?

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

    public Jugador(String userName, LocalDate localDate) {
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", nombre='" + userName + '\'' +
                ", puntuacion=" + puntuacion +
                ", victoria=" + victoria +
                ", localDate=" + localDate +
                ", tiradas=" + tiradas +
                '}';
    }
}
