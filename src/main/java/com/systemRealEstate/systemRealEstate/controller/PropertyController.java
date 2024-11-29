package com.systemRealEstate.systemRealEstate.controller;

import com.systemRealEstate.systemRealEstate.controller.DTO.PropertyDTO;
import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    private IPropertyService service;

    @GetMapping("/properties")
    public ResponseEntity<?> getAll(){
    List<Property> listProperty = service.getAll();

    List<PropertyDTO> listDTO  = listProperty.stream().map(p ->{
        PropertyDTO propertyDTO = new PropertyDTO(
           p.getId(),p.getName(),p.getDescription(),p.getPrice(),
           p.getImages(),p.getLatitude(),p.getLength()
        );
        return propertyDTO;

    }).collect(Collectors.toList());

    return ResponseEntity.ok(listDTO);


    }
}
