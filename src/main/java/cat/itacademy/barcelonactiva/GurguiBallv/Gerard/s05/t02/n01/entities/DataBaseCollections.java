package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

//CLASE AUTOINCREMENTAL DE COLECCIONES

@Document(collection = "database_collections")
public class DataBaseCollections {

    @Id
    private String id;

    private long sequence;

    public DataBaseCollections() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
