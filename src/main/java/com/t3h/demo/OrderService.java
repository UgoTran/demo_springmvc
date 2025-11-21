package com.t3h.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderEntity> findAll();

    List<OrderEntity> findAll(String status, Long cid);

    List<Map> findOrdersAndCustomer();

    List<CustomerOrderProj> findOrdersAndCustomer2();

    List<OrderEntity> findOrdersAndCustomer3();

    OrderEntity findByOrderNumber(Long orderNumber);

    OrderEntity findByOrder(LocalDate orderDate);
}
