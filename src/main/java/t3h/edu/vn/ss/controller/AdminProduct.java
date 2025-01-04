package t3h.edu.vn.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t3h.edu.vn.ss.Entity.ProductEntity;
import t3h.edu.vn.ss.repository.ProductRepository;

import java.util.List;

@Controller
public class AdminProduct {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/listproduct")
    public String listProduct(Model model) {
        List<ProductEntity> list = productRepository.findAllProductsAllTable();
        model.addAttribute("list", list);
        return "adminproduct";
    }
}
