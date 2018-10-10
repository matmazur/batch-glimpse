package batch.decider;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;

public class JobDecider implements Decider {
    @Override
    public String decide(StepExecution[] stepExecutions) throws Exception {
        return null;
    }
}
