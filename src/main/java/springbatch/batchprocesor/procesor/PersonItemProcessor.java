package springbatch.batchprocesor.procesor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import springbatch.batchprocesor.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {

        person.setFileData(this.getFileData());

        log.info("Converting (" + person + ") into (" + person + ")");

        return person;
    }

    private byte[] getFileData() {

        try {
            log.info(" Reading file content from getFileData ");
            File file = ResourceUtils.getFile("classpath:review.pdf");

            return  Files.readAllBytes(file.toPath());
        }
        catch (IOException e) {
            log.error("getFileData {}", e.getMessage());
            throw new RuntimeException(e);
        }


    }

}
