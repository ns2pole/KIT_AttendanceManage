package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("contact", new Contact());
        return "index";
    } 

        

    @PostMapping("/save")
    public String save(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }
}
