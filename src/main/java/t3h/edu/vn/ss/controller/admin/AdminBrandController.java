package t3h.edu.vn.ss.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t3h.edu.vn.ss.entity.BrandEntity;
import t3h.edu.vn.ss.repository.BrandRepository;

import java.util.List;

@Controller
@RequestMapping("admin/brand")
public class AdminBrandController {

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/listbrand")
    public String listBrand(Model model) {
        List <BrandEntity> list = brandRepository.findAll();
        model.addAttribute("list", list);
        return "adminbrand";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List <BrandEntity> list = brandRepository.findAll();
        model.addAttribute("list", list);
        return "admin/brand/list";
    }

    @GetMapping("/addform")
    public String addForm(Model model) {
        return "admin/brand/add";
    }

    @GetMapping("/addsave")
    public String addSave(@RequestParam("namebrand") String nameBrand, @RequestParam("img") String img , Model model) {
        BrandEntity brand = new BrandEntity();
        brand.setBrandName(nameBrand);
        brand.setBrandImg(img);
        brandRepository.save(brand);
        return "redirect:/admin/brand/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        int idbrand = Integer.parseInt(id);
        BrandEntity brand = brandRepository.findById(idbrand);
        brandRepository.delete(brand);
        return "redirect:/admin/brand/list";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam("id") String idbrand, Model model) {
        BrandEntity brand = brandRepository.findById(Integer.parseInt(idbrand));
        model.addAttribute("brand", brand);
        return "admin/brand/update";
    }

//    @GetMapping("updatesave")
//    public String updateSave(@RequestParam("idbrand") String idbrand, @RequestParam("namebrand") String namebrand,@RequestParam("img") String img , Model model) {
//        BrandEntity brand = brandRepository.findById(Integer.parseInt(idbrand));
//    }


}
