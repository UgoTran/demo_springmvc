package com.t3h.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    // JPA query
    List<OrderEntity> findByStatusAndCustomerNumber(String status, Long cid);

    // 1 - Dùng raw join - trả về List<Map>: dùng nhanh, ko cần quan tâm đến object hứng và kq ko thao tác gì
    // nhúng sql
    @Query(nativeQuery = true,
    value = "SELECT " +
            " o.*, " +
            " c.customerName , " +
            " c.phone " +
            "FROM " +
            " orders o " +
            "LEFT JOIN customers c ON " +
            " c.customerNumber = o.customerNumber;")
    List<Map> findOrdersAndCustomer();

    // 1.1 - Dùng raw join - trả về List<(interface)> - projection
    @Query(nativeQuery = true,
            value = "SELECT " +
                    " o.*, " +
                    " c.customerName , " +
                    " c.phone " +
                    "FROM " +
                    " orders o " +
                    "LEFT JOIN customers c ON " +
                    " c.customerNumber = o.customerNumber;")
    List<CustomerOrderProj> findOrdersAndCustomer2();


    // ko dùng raw join trả về thẳng entity
    // kq chỉ trả về  những cột thêo object trả ra, nhữngcột từ bảng khác bị null
    // entity chỉ ánh xạ 1  - 1 đến bảng đó
    @Query(nativeQuery = true,
            value = "SELECT " +
                    " o.*, " +
                    " c.customerName , " +
                    " c.phone " +
                    "FROM " +
                    " orders o " +
                    "LEFT JOIN customers c ON " +
                    " c.customerNumber = o.customerNumber;")
    List<OrderEntity> findOrdersAndCustomer3();

    // dùng entity join

    // dùng entity relation
}
