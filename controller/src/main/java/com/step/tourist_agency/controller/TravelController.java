package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.TravelDto;
import com.step.tourist_agency.service.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/one")
    public TravelDto findOne(@RequestParam("id") Long id){
        return travelService.findOne(id);
    }

    @GetMapping("/all")
    public List<TravelDto> findAllByOrder(@RequestParam("orderId") Long orderId){
        return travelService.findAllByOrder(orderId);
    }

    @GetMapping("/all")
    public List<TravelDto> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "type") String sortBy){
        return travelService.findAll(pageNo, pageSize, sortBy);
    }


    @PostMapping("/save")
    public TravelDto save(@RequestBody TravelDto travelDto){
        return travelService.save(travelDto);
    }

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id){
        travelService.remove(id);
    }

}