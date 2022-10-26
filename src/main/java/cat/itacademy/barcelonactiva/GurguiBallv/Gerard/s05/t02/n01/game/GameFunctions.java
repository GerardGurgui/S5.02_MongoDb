package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.game;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.exceptions.ExistentUserNameException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class GameFunctions {


    public static void inicioJuego(){



    }


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

    //(TOTAL TIRADAS * LAS QUE SE HAN GANADO / JUGADORES)*100
    public static int calcularPorcentajeJugador(Jugador jugador){

        //calcular porcentaje
            //necesito la puntuación (cuantos 7 ha sacado)
            //necesito el total de tiradas que ha realizado
        //recorrer lista tiradas??

        //comparar total puntuacion con total tiradas??
        int puntuacion = jugador.getPuntuacion();

        int tiradasRealizadas = jugador.getTiradas().size();

        return (puntuacion * 100)/ tiradasRealizadas;

    }


    public static Map<String,Integer> calcularPorcentajeJugadores(List<Jugador> jugadores){

        Map<String,Integer> jugadoresAcierto = new HashMap<>();

        int acierto;

        for (Jugador jugador : jugadores) {

            acierto = jugador.getAcierto();

            jugadoresAcierto.put(jugador.getNombre(),acierto);

        }

        return jugadoresAcierto;

    }

    public static int calcularPorcentajeMedio(List<Jugador> jugadores){

        Set<Tirada> totalTiradas;

        int total = 0;

        for (Jugador jugadorsIter : jugadores) {

            totalTiradas = jugadorsIter.getTiradas();
            total += totalTiradas.size();

        }

        return (total * 100) / jugadores.size();

    }



}
