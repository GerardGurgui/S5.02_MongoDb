package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Optional;

//--> SWAGGER LOCALHOST http://localhost:8080/swagger-ui.html#/

/*LINKS DE AYUDA
*
* Registrar en dos tablas relacionadas --> https://www.youtube.com/watch?v=rKj1NhXuHuk
* open bootcamp
* java guides
* Json ignore --> passwords https://de-vraag.com/es/54542256
* CRUD completo --> DTOS CORRECTES?? https://www.youtube.com/watch?v=z_dLYcQqSHI
* SERIALIZABLE?? --> https://stackoverflow.com/questions/49003908/why-while-using-spring-boot-i-need-entities-to-be-serializable
* 				--> https://www.baeldung.com/jpa-entities-serializable
* */

//Exclude para mongo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S05T02N01GurguiBallveGerardApplication {

	public static void main(String[] args) {

		SpringApplication.run(S05T02N01GurguiBallveGerardApplication.class, args);

		LocalDate localDate = LocalDate.now();

		//JUGADORES
//		Jugador jugador1 = new Jugador("hola","gerrigb1@hotmail.com","Spain");
//		Jugador jugador3 = new Jugador("holaaa","gerrigb1@hotmail.com","Spain");
//		Jugador jugador4 = new Jugador("holaaaa","gerrigb1@hotmail.com","Spain");
//		//Proves DTO PASSWORD
//		jugador1.setContrasenya("password");
//
//		Jugador jugador2 = new Jugador("Ramesh",localDate);

		//JUGADOR TIENE UNA LISTA DE TIRADAS, QUE A SU VEZ CADA TIRADA CONTIENE EL DADO?? PERO NO DADO ID

		//INSTANCIAR 2 DADOS PARA CADA JUGADOR?? SE PUEDE REPETIR PARA TIRADA??

//		Tirada tirada1 = new Tirada();
//		tirada1.setDado1(2);
//		tirada1.setDado2(6);
//		tirada1.setResultadoTirada(8);
//
//		Tirada tirada2 = new Tirada();
//		tirada2.setDado1(3);
//		tirada2.setDado2(1);
//		tirada2.setResultadoTirada(4);
////
////		Tirada tirada3 = new Tirada();
////		tirada3.setDado1(5);
////		tirada3.setDado2(4);
////		tirada3.setResultadoTirada(9);
//
//		jugador1.addTirada(tirada1);
////		jugador1.addTirada(tirada2);
////		jugador2.addTirada(tirada3);
//
//
//		jugadorRepository.save(jugador1);


//		Optional<Jugador> jugador = jugadorRepository.findById(jugador1.getId());
//
//		jugador.get().addTirada(tirada1);

//		jugadorRepository.save(jugador2);


	}

}
