package springbatch.batchprocesor.services;



import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import springbatch.batchprocesor.model.OrderDetails;
import springbatch.batchprocesor.model.OrderHeader;
import springbatch.batchprocesor.model.Person;
import springbatch.batchprocesor.repositories.OrderDetailsRepository;
import springbatch.batchprocesor.repositories.OrderRepository;
import springbatch.batchprocesor.repositories.PersonRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private PersonRepository repository;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\temp\\";
        List<Person> employees = repository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html"))
        {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf"))
        {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }

        return "report generated in path : " + path;
    }


    public String exportReportDetails(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\temp\\";
        List<OrderHeader> headersDataSource = orderRepository.findAllByOrderNumberEquals(10100);

        List<OrderDetails> detailDataSource= orderDetailsRepository.findAllByOrderNumberEquals(10100);
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:invoices.jrxml");


        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(headersDataSource);

        JRBeanCollectionDataSource dataSourceDetail = new JRBeanCollectionDataSource(detailDataSource);


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");


        parameters.put("employeeDataSource", dataSourceDetail);

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html"))
        {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf"))
        {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }

        return "report generated in path : " + path;
    }



}
