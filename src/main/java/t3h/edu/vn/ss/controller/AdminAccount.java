package t3h.edu.vn.ss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t3h.edu.vn.ss.Entity.AccountEntity;
import t3h.edu.vn.ss.repository.AccountRepository;

import java.util.List;

@Controller
public class AdminAccount {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/listaccount")
    public String listAccount(Model model) {
        List<AccountEntity> list = accountRepository.findAll();
        model.addAttribute("list", list);
        return "adminaccount";
    }

}
