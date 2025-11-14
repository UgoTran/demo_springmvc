package com.t3h.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
public class ThymeleafDemoController {

    @GetMapping("/persons")
    public ModelAndView persons(){
        ModelAndView pview = new ModelAndView();
        List<Person> persons = List.of(
                new Person(15, LocalDate.of(1999, 1, 1), "TESTA", 100.5, "https://shopping.viavilab.com/assets/images/products/thumbs/32_150x150.jpg"),
                new Person(16, LocalDate.of(1997, 5, 4), "jounA", 101.6, "https://shopping.viavilab.com/assets/images/products/thumbs/09012020043156_59802_150x150.jpg"),
                new Person(19, LocalDate.of(1998, 11,7), "basdA", 103.1, "https://shopping.viavilab.com/assets/images/products/thumbs/77_150x150.jpg"),
                new Person(21, LocalDate.of(1996, 6, 2), "sadas", 104.4, null),
                new Person(31, LocalDate.of(1994, 6, 2), "humanet", 1.4, null)
        );

        pview.addObject("persons", persons);
        pview.setViewName("persons");
        return pview;
    }

}

@Data
@AllArgsConstructor
class Person{
    int age;
    LocalDate birthday;
    String name;
    Double salary;
    String photo;
}
