package batch.batchlet.chunkJobs;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CsvWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void writeItems(List<Object> list) throws Exception {

        list.stream().peek(p-> System.out.println(p)).forEach(p->entityManager.persist(p));
    }
}
