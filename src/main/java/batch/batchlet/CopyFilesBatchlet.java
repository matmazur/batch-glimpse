package batch.batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.ejb.Schedule;
import javax.inject.Named;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Named
public class CopyFilesBatchlet extends AbstractBatchlet {


    private static final String ORIGINAL = "D:/original";
    private static final String TARGET = "D:/target";

    public CopyFilesBatchlet() {
        System.out.println(CopyFilesBatchlet.class.getName() + "created");
    }

//    @Schedule(hour = "*",minute = "*",second = "*/10")
    public String process() throws Exception {

        try {

            Files
                    .list(Paths.get(ORIGINAL))
                    .forEach(path -> {
                        try {
                            Files.copy(path, Paths.get(TARGET, path.getFileName().toFile().getName()));
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        } catch (UncheckedIOException e) {
            System.out.println("CopyBatchlet Failed");
            return "MOVE_FAILED";
        }
        System.out.println("CopyBatchlet Success");
        return "MOVE_SUCCESS";
    }


}
