package batch.batchlet.chunkJobs;

import javax.batch.api.chunk.AbstractItemReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class CsvReader extends AbstractItemReader {

    private static String FILE_NAME = "person_data.csv";
    private BufferedReader fileReader;

    @Override
    public void open(Serializable serializable) throws Exception {
        fileReader = new BufferedReader(
                new InputStreamReader(
                        this.getClass()
                                .getClassLoader()
                                .getResourceAsStream(FILE_NAME), StandardCharsets.UTF_8));
        fileReader.readLine();
    }

    @Override
    public void close() throws Exception {
        if (fileReader != null)
            fileReader.close();

    }

    @Override
    public Object readItem() throws Exception {

        String item = fileReader.readLine();
        System.out.println("Item  " + item);
        if (item != null) {
            return item;
        }
        return null;

    }
}
