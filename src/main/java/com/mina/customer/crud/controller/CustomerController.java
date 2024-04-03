package com.mina.customer.crud.controller;

import com.mina.customer.crud.model.Customer;
import com.mina.customer.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/list")
    public String showCustomers(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customersList",customers);
        return "customers/customer-list";
    }
    @GetMapping("/showForm")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customers/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id , Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "customers/add-form";
    }
    @GetMapping("/delete")
    public String removeCustomer(@RequestParam("customerId") int id , Model model){
        Customer customer = customerService.findById(id);
        customerService.remove(customer);
        return "redirect:/customers/list";
    }



}
