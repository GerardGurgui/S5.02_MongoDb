package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiradaRepository extends MongoRepository<Tirada,String> {

    List<Tirada> findByidJugadorIgnoreCase(String idJugador);

    List<Tirada> getByIdJugadorIgnoreCase(String idJugador);

    void deleteAllById(List<Tirada> listaTiradas, String id);
}
