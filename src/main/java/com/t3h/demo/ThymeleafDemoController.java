package com.t3h.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
public class ThymeleafDemoController {

    static List<Person> persons = List.of(
            new Person("A12",15, LocalDate.of(1999, 1, 1), "TESTA", 100.5, "https://shopping.viavilab.com/assets/images/products/thumbs/32_150x150.jpg"),
            new Person("A13",16, LocalDate.of(1997, 5, 4), "jounA", 101.6, "https://shopping.viavilab.com/assets/images/products/thumbs/09012020043156_59802_150x150.jpg"),
            new Person("A14",19, LocalDate.of(1998, 11, 7), "basdA", 103.1, "https://shopping.viavilab.com/assets/images/products/thumbs/77_150x150.jpg"),
            new Person("A15",21, LocalDate.of(1996, 6, 2), "sadas", 104.4, null),
            new Person("A16",31, LocalDate.of(1994, 6, 2), "humanet", 1.4, null)
    );

    @GetMapping("/persons")
    public ModelAndView persons() {
        ModelAndView pview = new ModelAndView();
        pview.addObject("persons", persons);
        pview.setViewName("persons");
        return pview;
    }

    /**
     * list person ẩn id theo mỗi dòng của person
     * click vào name trên bảng person
     * truyền id vào BE
     * upper case name của person
     * đồ ra trang Details person
     * nếu person theo id ko tồn tại thì hiện thị msg ko tìm thấy
     */
    @GetMapping("/person/{id}")
    public ModelAndView person(@PathVariable String id) {
        Person p = persons.stream()
                .filter(p1 -> p1.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (p != null) {
            p.uppperCaseName();
        }
        log.info("person by id={} -> p: {}", id, p);
        ModelAndView pDetailsView = new ModelAndView();
        pDetailsView.addObject("p", p);
        pDetailsView.addObject("idInput", id);
        pDetailsView.setViewName("personDetails");
        return  pDetailsView;
    }



}

@Data
@AllArgsConstructor
class Person {
    String id;
    int age;
    LocalDate birthday;
    String name;
    Double salary;
    String photo;

    public void uppperCaseName() {
        name = name.toUpperCase();
    }
}
