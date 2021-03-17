package com.learn.springboot;

import com.learn.spring.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo2")
public class DemoTwo extends BaseController {
    public String helloAnnotation() {

        return "DemoTwo!";
    }
}
