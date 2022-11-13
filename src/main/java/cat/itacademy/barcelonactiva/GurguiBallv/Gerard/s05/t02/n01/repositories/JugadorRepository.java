package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Jugador;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends MongoRepository<Jugador,String> {

    Optional<Jugador> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Jugador findByIdIgnoreCase(String id);

    List<Tirada> getTiradasByidIgnoreCase(String idJugador);


}
