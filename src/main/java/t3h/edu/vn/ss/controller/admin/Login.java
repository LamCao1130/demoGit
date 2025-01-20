package t3h.edu.vn.ss.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t3h.edu.vn.ss.config.UserDetailServiceImpl;
import t3h.edu.vn.ss.entity.AccountEntity;
import t3h.edu.vn.ss.service.AccountService;

@Controller
@RequestMapping("admin")
public class Login {

    @Autowired
    AccountService accountService;


    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }





}
