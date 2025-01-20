package t3h.edu.vn.ss.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t3h.edu.vn.ss.entity.ProductEntity;
import t3h.edu.vn.ss.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("customer")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search")
    public String list(@RequestParam("search") String search, @RequestParam(defaultValue = "1") String page , Model model) {
        int epage = Integer.parseInt(page);

        List<ProductEntity> list = productService.findProductByName(search);
        int n = list.size()/9;
        if(list.size()%9!=0){
            ++n;
        }
        List<ProductEntity> listp = productService.findProductByNameAndPage(search, epage);
        model.addAttribute("npage",n);
        model.addAttribute("search",search);
        model.addAttribute("list", listp);
        model.addAttribute("cpage", epage);
        return "customer/search";
    }

}
