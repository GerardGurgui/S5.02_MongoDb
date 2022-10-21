package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.TiradaDTO;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

/*LINKS DE AYUDA
*
* https://www.youtube.com/watch?v=rKj1NhXuHuk
* open bootcamp
* java guides
* Json ignore --> passwords https://de-vraag.com/es/54542256
* */

@SpringBootApplication
public class S05T02N01GurguiBallveGerardApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(S05T02N01GurguiBallveGerardApplication.class, args);
		JugadorRepository jugadorRepository = context.getBean(JugadorRepository.class);
		TiradaRepository tiradaRepository = context.getBean(TiradaRepository.class);


		LocalDate localDate = LocalDate.now();

		//JUGADORES
		Jugador jugador1 = new Jugador("Gerard",localDate);
		//Proves DTO PASSWORD
		jugador1.setPassword("password");

		Jugador jugador2 = new Jugador("Ramesh",localDate);

		//JUGADOR TIENE UNA LISTA DE TIRADAS, QUE A SU VEZ CADA TIRADA CONTIENE EL DADO?? PERO NO DADO ID

		//INSTANCIAR 2 DADOS PARA CADA JUGADOR?? SE PUEDE REPETIR PARA TIRADA??

		Tirada tirada1 = new Tirada();
		tirada1.setDado1(2);
		tirada1.setDado2(6);
		tirada1.setResultadoTirada(8);

		Tirada tirada2 = new Tirada();
		tirada2.setDado1(3);
		tirada2.setDado2(1);
		tirada2.setResultadoTirada(4);

		Tirada tirada3 = new Tirada();
		tirada3.setDado1(5);
		tirada3.setDado2(4);
		tirada3.setResultadoTirada(9);

		jugador1.addTirada(tirada1);
		jugador1.addTirada(tirada2);


		jugador2.addTirada(tirada3);


		jugadorRepository.save(jugador1);

//		jugadorRepository.save(jugador2);







	}

}
