package com.spring.rest;

import com.spring.entities.Customer;
import com.spring.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;


    @RestController
@RequestMapping(value = "/api")
public class CustomerRestController {
    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

   @RequestMapping(value = "/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer theCustomer =customerService.getCustomer(customerId);
if(theCustomer==null){
    throw new CustomerNotFoundException("customer id not Found : "+customerId);
}
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

        @PutMapping("/customers")
        public Customer updateCustomer(@RequestBody Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }


        @DeleteMapping("/customers/{customerId}")
        public String deleteCustomer(@PathVariable int customerId){

            Customer theCustomer = customerService.getCustomer(customerId);
            if(theCustomer==null){
                throw new CustomerNotFoundException("customer id not Found : "+customerId);
            }

            customerService.deleteCustomer(customerId);
        return "deleted customer id:"+customerId;
    }






}
