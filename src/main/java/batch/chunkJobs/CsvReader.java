package batch.chunkJobs;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

@Named
public class CsvReader extends AbstractItemReader {

    private static String FILE_NAME = "D:/target/person_data.csv";
    private BufferedReader fileReader;

    @Override
    public void open(Serializable serializable) throws Exception {
        fileReader = new BufferedReader(new FileReader(FILE_NAME));

        fileReader.readLine();
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

    @Override
    public void close() throws Exception {
        if (fileReader != null)
            fileReader.close();

    }
}
