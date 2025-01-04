package t3h.edu.vn.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AminController {


    @GetMapping("/home")
    public String home(){

        return "adminhome";
    }

}
