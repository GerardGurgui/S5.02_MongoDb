package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import org.springframework.stereotype.Component;

@Component
public class GameFunctions {


    public static void inicioJuego(){



    }





    public static Tirada tirarDados(){

        Tirada tirada = new Tirada();

        int dado1 = numRandom();
        tirada.setDado1(dado1);

        int dado2 = numRandom();
        tirada.setDado2(dado2);

        int resultado = dado1 + dado2;

        tirada.setResultadoTirada(resultado);

        return tirada;

    }


    public static int numRandom(){

        int numero = (int) ((Math.random() * ((6 - 1) + 1)) + 1);

        return numero;
    }


    public static boolean comprobarTirada(int resultado){

        boolean ganadorRonda = false;

        if (resultado == 7){

            ganadorRonda = true;

        }

        return ganadorRonda;
    }

    public static boolean sumarPuntuacionRonda(Jugador jugador){

        boolean ganadorPartida = false;

        int puntuacionTotal = jugador.getPuntuacion();
        puntuacionTotal++;
        jugador.setPuntuacion(puntuacionTotal);

        if (jugador.getPuntuacion() == 3){
            ganadorPartida = true;
        }

        return ganadorPartida;

    }

}
