package batch.decider;

import batch.batchlet.CopyFilesBatchlet;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JobDecider implements Decider {
    @Override
    public String decide(StepExecution[] stepExecutions) throws Exception {

        if (Files.exists(Paths.get(CopyFilesBatchlet.TARGET))) {
            System.out.println("Import data");
            return "IMPORT_DATA";
        } else {
            System.out.println("No file");
            return "NO_FILE";
        }
    }
}
