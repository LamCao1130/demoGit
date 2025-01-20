package t3h.edu.vn.ss.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t3h.edu.vn.ss.entity.BrandEntity;
import t3h.edu.vn.ss.entity.ProductEntity;
import t3h.edu.vn.ss.service.BrandService;
import t3h.edu.vn.ss.service.ProductService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @GetMapping("/home")
    public String home(Model model) {
        List<ProductEntity> list = productService.find12NewProduct();
        List<BrandEntity> lb = brandService.findAllBrand();
        model.addAttribute("lb", lb);
        model.addAttribute("list", list);
        return "customer/home";
    }
}
