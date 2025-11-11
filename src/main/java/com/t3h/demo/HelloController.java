package com.t3h.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// định nghĩa đây là controller theo mô hình MVC
@Controller
//  nhúng log vào class, biến mặc định là log
@Slf4j
public class HelloController {

    //hướng đường dẫn theo req GET
    @GetMapping(value = {"", "/"})
    // trả dữ liệu theo body - mặc định json
    @ResponseBody
    public ResponseEntity hello() {
        //trả data theo body
        return ResponseEntity.ok("Hello World");
    }


    //vd1: tạo hàm hứng /eportal/trades?tradeId=2001 và in ra tradeId
    @PostMapping("/eportal/trades")
    @ResponseBody
    public ResponseEntity etrades(@RequestParam int tradeId,
                                  @RequestParam String page) {
        // ResponseEntity đại diện cho response trả về client(postman, browser)
        // @RequestParam hứng param theo tên biến sau nó, param:
        //log in thông báo ra console
        log.info("tradeId: {}; page: {}", tradeId, page);
        return ResponseEntity.ok("tradeId=" + tradeId + " page: " + page);
    }

    //vd 2 : lấy giá trị nằm trên path: /users/1; /users/1/albums/2
    // /users/1
    @GetMapping("/users/{userId}")
    public ResponseEntity getPath1(@PathVariable String userId) {
        log.info("user id: {}", userId);
        return ResponseEntity.ok("user id=" + userId);
    }

    //đẩy dữ liệu req body form-data và param trên url
    @PostMapping("/upload")
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file,
                                           @RequestParam int id) {
        String fileName = file.getOriginalFilename();
        log.info("id {}; fileName: {}; size: {}", id, fileName, file.getSize());
        return ResponseEntity.ok("File uploaded successfully. " + fileName);
    }//đẩy dữ liệu req body form-data và param trên url


    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user) {
        // @RequestBody hứng data theo dạng json(mặc định)/ xml
        log.info("user: {}", user);
        return ResponseEntity.ok(user);
    }
}
