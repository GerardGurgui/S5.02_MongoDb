package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Player;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Launch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {

    Optional<Player> findByUsername(String username);

    Optional<Player> findOneByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Player findByIdIgnoreCase(String id);

    List<Launch> getTiradasByidIgnoreCase(String idJugador);


}
