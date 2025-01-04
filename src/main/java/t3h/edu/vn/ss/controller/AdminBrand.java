package t3h.edu.vn.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t3h.edu.vn.ss.Entity.BrandEntity;
import t3h.edu.vn.ss.repository.BrandRepository;

import java.util.List;

@Controller
public class AdminBrand {

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/listbrand")
    public String listBrand(Model model) {
        List <BrandEntity> list = brandRepository.findAll();
        model.addAttribute("list", list);
        return "adminbrand";
    }
}
