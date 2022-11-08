package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends MongoRepository<Jugador,String> {


    Jugador findByIdIgnoreCase(String id);

    Boolean existsBynombreIgnoreCase(String nombre);


}
