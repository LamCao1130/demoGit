package t3h.edu.vn.ss.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t3h.edu.vn.ss.entity.BrandEntity;
import t3h.edu.vn.ss.entity.ProductEntity;
import t3h.edu.vn.ss.service.BrandService;
import t3h.edu.vn.ss.service.ProductService;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @GetMapping("brand")
    public String brand(@RequestParam("id") String id, @RequestParam("page") String page , Model model) {
        int bid = Integer.parseInt(id);
        int epage = Integer.parseInt(page);
        BrandEntity br = brandService.getBrandById(bid);
        List<ProductEntity> list = productService.findProductByBrandId(bid);
        int n = list.size()/9 ;
        if(list.size()%9 !=0){
            ++n;
        }
        List<ProductEntity> listp = productService.findProductByBrandIdAndPage(bid, epage);
        model.addAttribute("npage", n);
        model.addAttribute("number",list.size());
        model.addAttribute("list", listp);
        model.addAttribute("brand", br);
        model.addAttribute("cpage", epage);
        return "customer/brand";
    }

}
