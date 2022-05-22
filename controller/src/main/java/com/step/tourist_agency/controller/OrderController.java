package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.OrderDto;
import com.step.tourist_agency.dto.OrderTravelDto;
import com.step.tourist_agency.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/one")
    public OrderDto findOne(@RequestParam("id") Long id) {
        return orderService.findOne(id);
    }



    @GetMapping("/one/full")
    public OrderTravelDto findOneFull(@RequestParam("id") Long id) {
        return orderService.findOneFull(id);
    }



    @GetMapping("/all")
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }



    @GetMapping("/all/full")
    public List<OrderTravelDto> findAllFull() {
        return orderService.findAllFull();
    }



    @PostMapping("/save")
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id){
        orderService.remove(id);
    };

}