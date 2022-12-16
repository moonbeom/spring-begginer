package hello.core.controller;

import hello.core.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Product helloApi(@RequestParam("name") String name,
                            @RequestParam("price") int price,
                            @RequestParam("stock") int stock) {
        Product water = new Product();
        water.setName(name);
        water.setStock(price);
        water.setPrice(stock);

        return water;
    }
}