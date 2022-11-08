package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01;

//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.JugadorRepository;
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.TiradaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

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
*
* //MONGO
* Generador ids de colecciones --> https://www.javaguides.net/2019/12/spring-boot-mongodb-crud-example-tutorial.html
*
* */

//Exclude para mongo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableMongoRepositories(basePackageClasses = JugadorRepository.class)
public class S05T02N01GurguiBallveGerardApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(S05T02N01GurguiBallveGerardApplication.class, args);

		JugadorRepository jugadorRepository = context.getBean(JugadorRepository.class);

		LocalDate localDate = LocalDate.now();
//
//		Jugador jugador = new Jugador();
//
//		jugador.setId(100);
//
//		Tirada tirada = new Tirada(3,6,9);
//		Tirada tirada1 = new Tirada(3,6,9);
//
//		jugador.addTirada(tirada);
//		jugador.addTirada(tirada1);
//
//		jugadorRepository.save(jugador);

	}

}
