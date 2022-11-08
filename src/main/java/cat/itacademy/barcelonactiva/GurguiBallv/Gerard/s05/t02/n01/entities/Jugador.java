package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "jugadores")
public class Jugador {

    @Id
    private String id;
    private String nombre;
    private String email;
    private String contrasenya; // añadir SQL

    private int puntuacion;
    private int victoria;
    private int acierto;

    private LocalDate fechaRegistro;


//    @DBRef
    private List<Tirada> tiradas;


    public Jugador() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getPuntuacion() {
        return puntuacion;
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

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Tirada> getTiradas() {
        return tiradas;
    }

    public void setTiradas(List<Tirada> tiradas) {
        this.tiradas = tiradas;
    }


    //ADD TIRADAS JUGADOR

    public void addTirada(Tirada tirada){

        if (tiradas == null){

            tiradas = new ArrayList<>();
        }

        tiradas.add(tirada);

    }
}
