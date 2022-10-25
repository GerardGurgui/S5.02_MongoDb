package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
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
    private String nombre;
    private String email; //supuestamente recibe calificaciones en email, será DTO
    private String pais; //para tema servidores

    private int puntuacion;
    private int victoria;

    @Column(name = "porcentaje_acierto")
    private int acierto;
    private String contrasenya; // PER ENCRIPTAR SI DONA TEMPS

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;


    //Lazy para las peticiones que le pedimos y no todo lo relacionado
    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    private Set<Tirada> tiradas;


    public Jugador() {
    }

    public Jugador(String nombre,String email, String pais) {
        this.nombre = nombre;
        this.email = email;
        this.pais = pais;

    }

    ////

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
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


}
