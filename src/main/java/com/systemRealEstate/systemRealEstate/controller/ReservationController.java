package com.systemRealEstate.systemRealEstate.controller;

import com.systemRealEstate.systemRealEstate.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ReservationController {

    @Autowired
    private IReservationService service;
}
