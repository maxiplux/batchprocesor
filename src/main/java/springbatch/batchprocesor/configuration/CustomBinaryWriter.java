package springbatch.batchprocesor.configuration;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import springbatch.batchprocesor.model.Person;

import java.util.List;

public class CustomBinaryWriter extends AbstractItemStreamItemWriter<Byte[]> {


    @Override
    public void write(List<? extends Byte[]> items) throws Exception {

    }
}
