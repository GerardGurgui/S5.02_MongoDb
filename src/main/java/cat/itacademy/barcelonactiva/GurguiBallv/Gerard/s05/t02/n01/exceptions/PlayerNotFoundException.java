package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions;


public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(){

    }

    public PlayerNotFoundException(String message){

        super(message);
    }

}
