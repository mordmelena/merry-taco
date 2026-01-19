package com.example.tacocloud.data;

import java.util.List;
import java.util.Optional;
import com.example.tacocloud.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
