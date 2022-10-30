package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.DataBaseCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CollectionsGeneratorService {

    private MongoOperations mongoOperations;

    public CollectionsGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateCollection(String collectionName){

        DataBaseCollections counter = mongoOperations.findAndModify(query(where("_id").is(collectionName)),
                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
                DataBaseCollections.class);

        return !Objects.isNull(counter) ? counter.getSequence() : 1;

    }
}
