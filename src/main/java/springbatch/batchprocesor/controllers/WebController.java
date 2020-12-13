package springbatch.batchprocesor.controllers;

import lombok.SneakyThrows;
import net.sf.jasperreports.engine.JRException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbatch.batchprocesor.services.ReportService;


import java.io.FileNotFoundException;

@RestController
public class WebController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private ReportService service;

    @SneakyThrows
    @RequestMapping("/launch")
    public String sendMsg(){

        JobParameters jobParameters =
                new JobParametersBuilder()
                        .addLong("time",System.currentTimeMillis()).toJobParameters();

        jobLauncher.run(job, jobParameters);

        return "Done";
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReportDetails(format);
    }
}
