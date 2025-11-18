package com.t3h.demo;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<OrderEntity> findAll();

    OrderEntity findByOrderNumber(Long orderNumber);

    OrderEntity findByOrder(LocalDate orderDate);
}
