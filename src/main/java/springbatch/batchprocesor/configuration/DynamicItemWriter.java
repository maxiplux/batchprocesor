package springbatch.batchprocesor.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.core.io.UrlResource;
import springbatch.batchprocesor.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


@Slf4j
public class DynamicItemWriter<P> implements ItemStream, ItemWriter<Person> {

    private Map<String, FileOutputStream> writers = new HashMap<>();



    private ExecutionContext executionContext;

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        this.executionContext = executionContext;
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
    }

    @Override
    public void close() throws ItemStreamException {
        for(FileOutputStream outputStream:writers.values())
        {
            try
            {
                outputStream.close();
            } catch (IOException e) {
                log.error("Error clonsing file {}" , e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void write(List<? extends Person> items) throws Exception {
        for (Person item : items)
        {
            FileOutputStream ffiw = getFlatFileItemWriter(item);
            ffiw.write(item.getFileData());
        }
    }





    public FileOutputStream getFlatFileItemWriter(Person item) throws FileNotFoundException {
        String key = "/Users/juanfmosquera/Downloads/jwt refresh/batchprocesor/src/main/resources/"+item.getFirstName()+".pdf";
        FileOutputStream rr = writers.get(key);
        File file = new File(key);
        rr = new FileOutputStream(file);

        return rr;
    }
}
