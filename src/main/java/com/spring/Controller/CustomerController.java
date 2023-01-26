package com.spring.Controller;


import com.spring.dao.CustomerDAO;
import com.spring.entities.Customer;
import com.spring.service.CustomerServiceImpl;
import com.spring.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;


    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> custs = customerService.getCustomers();
        model.addAttribute("customers",custs);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer theCustomer = new Customer();
        model.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }


    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerId") int theId,Model theModel){

        Customer customer =customerService.getCustomer(theId);

        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        customerService.deleteCustomer(theId);

    return "redirect:/customer/list";
    }

}
