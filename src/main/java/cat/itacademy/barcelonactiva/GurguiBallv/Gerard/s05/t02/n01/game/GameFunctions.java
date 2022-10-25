package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.ExistentUserNameException;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service.JugadorService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameFunctions {



    public static void inicioJuego(){



    }

    //--> REGISTRO USER
        //COMPROBAR NOMBRE NO REPETIDO

    public static void validarNombre(String nombre, List<Jugador> jugadores){

        int i = 0;

        while (i < jugadores.size()){

            if (jugadores.get(i).getNombre().equals(nombre)){


                throw new ExistentUserNameException("El nombre de usuario ya existe");

            }

            i++;
        }


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

    ////PORCENTAJES-ESTADISTICAS
    public static int calcularPorcentaje(Jugador jugador){

        //calcular porcentaje
            //necesito la puntuación (cuantos 7 ha sacado)
            //necesito el total de tiradas que ha realizado
        //recorrer lista tiradas??

        //comparar total puntuacion con total tiradas??
        int puntuacion = jugador.getPuntuacion();

        int tiradasRealizadas = jugador.getTiradas().size();

        int porcentaje = (puntuacion * 100)/ tiradasRealizadas;

        return porcentaje;

    }

}
