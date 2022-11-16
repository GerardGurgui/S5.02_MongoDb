package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Launch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaunchRepository extends MongoRepository<Launch,String> {

    List<Launch> findByidJugadorIgnoreCase(String idJugador);

    List<Launch> getByIdJugadorIgnoreCase(String idJugador);

    void deleteAllById(List<Launch> listaLaunches, String id);
}
