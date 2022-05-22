package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/one")
    public CustomerDto findOne(@RequestParam("id") Long id){
        return customerService.findOne(id);
    }

    @GetMapping("/all")
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @PostMapping("/save")
    public CustomerDto save(@RequestBody CustomerDto customerDto){
        return customerService.save(customerDto);
    }

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id){
        customerService.remove(id);
    }

}