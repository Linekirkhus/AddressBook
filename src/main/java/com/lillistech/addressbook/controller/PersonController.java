package com.lillistech.addressbook.controller;

import com.lillistech.addressbook.model.Person;
import com.lillistech.addressbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    // Display list of people
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPeople", personService.getAllPeople());
        return "index";
    }

    // Creating new Contact
    @GetMapping("/showNewContactForm")
    public String showNewContactForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "new_contact";
    }

    // Save to database
    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("person") Person person) {
        personService.saveContact(person);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") Long id, Model model) {
        // Get Contact from Service
        Person person = personService.getContactById(id);
        // Set Contact as a Model attribute to pre-populate form
        model.addAttribute("person", person);
        return "update_contact";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable(value = "id") Long id) {
        // Call delete method
        this.personService.deleteContactById(id);
        return "redirect:/";
    }
}
