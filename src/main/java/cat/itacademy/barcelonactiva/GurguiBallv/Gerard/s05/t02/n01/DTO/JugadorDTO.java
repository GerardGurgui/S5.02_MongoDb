package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;



public class JugadorDTO {


    //ATRIBUTOS QUE INTRODUCIRÁ EL USUARIO
    private String nombre;
    private String email;
    private String pais;

    public JugadorDTO() {

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
}
