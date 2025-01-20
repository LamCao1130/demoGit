package t3h.edu.vn.ss.controller.admin;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import t3h.edu.vn.ss.dto.AccountDto;
import t3h.edu.vn.ss.entity.AccountEntity;
import t3h.edu.vn.ss.repository.AccountRepository;
import t3h.edu.vn.ss.service.AccountService;

import java.util.List;

@Controller
@RequestMapping("admin/account")
public class AdminAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public String list(Model model) {
        List<AccountEntity> list = accountService.findAll();
        model.addAttribute("list", list);
        return "admin/account/list";
    }

    @GetMapping("/addform")
    public String addForm(Model model) {
        AccountDto accountDto = new AccountDto();
        model.addAttribute("accountDto", accountDto);
        return "admin/account/add";
    }


    @PostMapping("/add")
    public String addSave(@Valid @ModelAttribute("accountDto") AccountDto accountDto, BindingResult result,
                          Model model, RedirectAttributes redirectAttributes) {
        if(!accountDto.getRepassword().equals(accountDto.getPassword())) {
            result.rejectValue("repassword","error.accountDto", "mật khẩu nhập lại không đúng");

        }
        if(result.hasErrors()) {
//            model.addAttribute("accountDto", accountDto);
            return "admin/account/add";
        }

        else{
            try{
                accountService.add(accountDto);
            }
            catch(Exception e){

            }
        }
        redirectAttributes.addAttribute("str","thêm account thành công");
        return "redirect:/admin/account/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        AccountEntity account = accountService.findById(id);
        accountService.delete(account);
        return "redirect:/admin/account/list";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam("id") int id, Model model) {
        AccountEntity account = accountService.findById(id);
        model.addAttribute("account", account);
        return "admin/account/update";
    }

    @GetMapping("/updatesave")
    public String updateSave(@RequestParam("id") int id , @RequestParam("email") String email, @RequestParam("role") String role, @RequestParam("gender") String gender, @RequestParam("sdt") String phone, @RequestParam("fullname") String fullname,Model model) {
        AccountEntity account = accountService.findById(id);
        boolean chooseRole = true;
        if(role.equals("1")){
            chooseRole = true;
        }
        else {
            chooseRole = false;
        }
        int gen = Integer.parseInt(gender);
        account.setEmail(email);
        account.setPhoneNumber(phone);
        account.setFullname(fullname);
        account.setIsAdmin(chooseRole);
        account.setGender(gen);
        accountService.update(account);
        return "redirect:/admin/account/list";
    }






//    @GetMapping("/listaccount")
//    public String listAccount(Model model) {
//        List<AccountEntity> list = accountRepository.findAll();
//        model.addAttribute("list", list);
//        return "adminaccount";
//    }
//
//    @GetMapping("/addaccount")
//    public String addAccount(Model model) {
//        return "adminaddaccount";
//    }
//
//    @GetMapping("/deleteaccount")
//    public String deleteAccount(@RequestParam("id") String id, Model model ) {
//        int accountId = Integer.parseInt(id);
//        accountRepository.deleteById(accountId);
//        List<AccountEntity> list = accountRepository.findAll();
//        model.addAttribute("list", list);
//        return "adminaccount";
//    }



}
