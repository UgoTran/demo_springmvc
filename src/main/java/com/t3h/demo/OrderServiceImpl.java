package com.t3h.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service // đáng dấu là service, tự động thêm vào bộ nhớ chung cuả spring và có thể nhúng vòo file khác
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired// nhúng các file có đánh dấu @xxx, ko cần tạo obj theo file đ́ó
    private OrderRepo orderRepo;

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = orderRepo.findAll();
        log.info("Orders size:{}", orders.size());
        return orders;
    }

    @Override
    public List<OrderEntity> findAll(String status, Long cid) {
        return orderRepo.findByStatusAndCustomerNumber(status, cid);
    }

    @Override
    public List<Map> findOrdersAndCustomer() {
        return orderRepo.findOrdersAndCustomer();
    }

    @Override
    public List<CustomerOrderProj> findOrdersAndCustomer2() {
        return orderRepo.findOrdersAndCustomer2();
    }

    @Override
    public List<OrderEntity> findOrdersAndCustomer3() {
        return  orderRepo.findOrdersAndCustomer3();
    }

    @Override
    public OrderEntity findByOrderNumber(Long orderNumber) {
        return orderRepo.findById(orderNumber)
                .orElse(null);
    }

    @Override
    public OrderEntity findByOrder(LocalDate orderDate) {
        return null;
    }
}
