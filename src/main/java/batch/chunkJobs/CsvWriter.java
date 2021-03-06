package batch.chunkJobs;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@Stateless
public class CsvWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void writeItems(List<Object> list) throws Exception {

        System.out.println("persis");
        list.stream().peek(p-> System.out.println(p)).forEach(p->entityManager.persist(p));
    }
}
