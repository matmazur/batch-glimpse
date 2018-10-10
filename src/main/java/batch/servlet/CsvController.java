package batch.servlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("csv")
public class CsvController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobOperator job = BatchRuntime.getJobOperator();

        long jobId = job.start("csvToDb",new Properties());

        System.out.println("job id " + jobId);
        resp.getWriter().println("job id " +jobId);


    }
}
