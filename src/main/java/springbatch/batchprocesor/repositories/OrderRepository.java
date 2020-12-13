package springbatch.batchprocesor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbatch.batchprocesor.model.OrderHeader;
import springbatch.batchprocesor.model.Person;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderHeader, Integer> {

    List<OrderHeader> findAllByOrderNumberEquals(Integer orderId);


}
