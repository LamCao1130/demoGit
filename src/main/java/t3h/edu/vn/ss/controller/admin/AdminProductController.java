package t3h.edu.vn.ss.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t3h.edu.vn.ss.entity.BrandEntity;
import t3h.edu.vn.ss.entity.CategoryEntity;
import t3h.edu.vn.ss.entity.ColorEntity;
import t3h.edu.vn.ss.entity.ProductEntity;
import t3h.edu.vn.ss.repository.ProductRepository;
import t3h.edu.vn.ss.service.BrandService;
import t3h.edu.vn.ss.service.CategoryService;
import t3h.edu.vn.ss.service.ColorService;
import t3h.edu.vn.ss.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("admin/product")
public class AdminProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    ColorService colorService;

    @GetMapping("/list")
    public String listProduct(Model model) {
        List<ProductEntity> list = productService.findAllProductsAllTable();
        model.addAttribute("list", list);
        return "admin/product/list";
    }

    @GetMapping("/addform")
    public String addForm(Model model) {
        List<CategoryEntity> lc = categoryService.findAll();
        model.addAttribute("categories", lc);
        List<BrandEntity> lb = brandService.findAllBrand();
        model.addAttribute("brands", lb);
        List<ColorEntity> cl = colorService.findAll();
        model.addAttribute("colors", cl);
        return "admin/product/add";
    }

    @PostMapping("/addproduct")
    public String addProduct(Model model) {
        return "admin/product/add";
    }

}
