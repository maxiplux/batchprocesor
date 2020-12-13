package springbatch.batchprocesor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbatch.batchprocesor.model.OrderDetails;
import springbatch.batchprocesor.model.OrderHeader;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findAllByOrderNumberEquals(Integer orderId);

}
