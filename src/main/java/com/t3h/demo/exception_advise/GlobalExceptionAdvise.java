package com.t3h.demo.exception_advise;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INSUFFICIENT_STORAGE;

@ControllerAdvice // đánh dấu xử lý exception xảy ra, khi chưa được xử lý (chưa bắt - catch)
@Slf4j
public class GlobalExceptionAdvise {

    @Autowired
    HttpServletRequest request;

    // định nghĩa ra 1 hàm xử lý và lỗi
    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity handleNumberFormatException(NumberFormatException e) {
        // ném ra json lỗi dùng chung: code, message, date time, custom(url gọi vào, file lỗi)
        return new ResponseEntity(
                Map.of(
                        "code", "L01",
                        "msg", "Lỗi tính toán",
                        "url", request.getRequestURL().toString(),
                        "details", e.getMessage(),
                        "dateTime", LocalDateTime.now()
                ),
                INSUFFICIENT_STORAGE
        );
    }
}
