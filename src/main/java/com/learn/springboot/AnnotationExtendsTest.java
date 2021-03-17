package com.learn.springboot;

import com.learn.spring.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationExtendsTest extends BaseController {

    @RequestMapping("/helloAnnotation")
    public String helloAnnotation() {

        return "AnnotationExtendsTest!";
    }
}
