package batch.batchlet.chunkJobs;

import batch.batchlet.User;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.util.StringTokenizer;

@Named
public class CsvProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object o) throws Exception {
        System.out.println("Processing " + o);
        Thread.sleep(1000);

        String data = (String) o;
        User user = createUser(data);
        return user;
    }


    private User createUser(String data) {

        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        User user = new User();
        user.setName(tokenizer.nextToken());
        user.setLastname(tokenizer.nextToken());
        user.setAge(Integer.valueOf(tokenizer.nextToken()));

        return user;

    }
}
