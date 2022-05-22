package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerController {

    @GetMapping("/one")
    ResponseEntity<CustomerDto> findOne(@RequestParam("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<CustomerDto>> findAll();

    @PostMapping("/save")
    ResponseEntity<CustomerDto> save(@RequestBody CustomerDto userDto);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id);

}