package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO;


public class PlayerDto {

    private String username;
    private String password; //AÑADIR SQL
    private String email;

    public PlayerDto() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
