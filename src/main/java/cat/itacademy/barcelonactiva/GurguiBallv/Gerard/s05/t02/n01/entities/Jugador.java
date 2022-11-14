package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "jugadores")
public class Jugador {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Jugador{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", puntuacion=" + puntuacion +
                ", victoria=" + victoria +
                ", acierto=" + acierto +
                ", fechaRegistro=" + fechaRegistro +
                ", tiradas=" + tiradas +
                '}';
    }
}
