package com.t3h.demo;

import java.time.LocalDate;

//projection
//getXXX tự động ánh xạ đến cột tương ứng của KQ trà ra
public interface CustomerOrderProj {
    Long getOrderNumber();

    LocalDate getOrderDate();

    LocalDate getRequiredDate();

    LocalDate getShippedDate();

    String getStatus();

    String getComments();

    Long getCustomerNumber();
    // cột ko tồn tại trong kq - trả null
    Long getZXCXZ();

    // cột thiếu ko hiện ra kq
}
