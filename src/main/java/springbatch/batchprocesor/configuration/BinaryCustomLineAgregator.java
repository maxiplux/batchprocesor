package springbatch.batchprocesor.configuration;

import org.springframework.batch.item.file.transform.LineAggregator;
import springbatch.batchprocesor.model.Person;

public class BinaryCustomLineAgregator implements LineAggregator<Byte[]>
        {








            @Override
            public String aggregate(Byte[] bytes) {
                return bytes.toString();
            }
        }
