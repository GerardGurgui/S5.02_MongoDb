package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;


public class JugadorDTO {

    private String nombre;
    private String contrasenya; //AÑADIR SQL
    private String email;



    public JugadorDTO() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
