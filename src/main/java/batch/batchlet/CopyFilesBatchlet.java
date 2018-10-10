package batch.batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.ejb.Singleton;
import javax.inject.Named;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Named
@Singleton
public class CopyFilesBatchlet extends AbstractBatchlet {

    public static final String ORIGINAL = "D:/original";
    public static final String TARGET = "D:/target";

    public CopyFilesBatchlet() {
        System.out.println(CopyFilesBatchlet.class.getName() + " created");
    }

//        @Schedule(hour = "*",minute = "*",second = "*/20")
    public String process() throws Exception {

        if (Files.notExists(Paths.get(ORIGINAL))) {
            Files.createDirectory(Paths.get(ORIGINAL));
        }
        if (Files.notExists(Paths.get(TARGET))) {
            Files.createDirectory(Paths.get(TARGET));
        }

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
