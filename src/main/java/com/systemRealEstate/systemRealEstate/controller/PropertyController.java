package com.systemRealEstate.systemRealEstate.controller;

import com.systemRealEstate.systemRealEstate.controller.DTO.PropertyDTO;
import com.systemRealEstate.systemRealEstate.controller.DTO.errorDTO;
import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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
                p.getId(),p.getName(),p.getDescription(),p.getType(),p.getMaxGuest(),p.getNumRooms(),
                p.getNumBeds(),p.getNumBathrooms(),p.getPrice(),
                 p.getImages(),p.getLatitude(),p.getLength(),p.getUser()
        );
        return propertyDTO;

    }).collect(Collectors.toList());

    return ResponseEntity.ok(listDTO);


    }

    @GetMapping("/property/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Property> property = service.getById(id);
        if(property.isPresent()){
            PropertyDTO propertyDTO = new PropertyDTO(
                    property.get().getId(), property.get().getName(),
                    property.get().getDescription(),property.get().getType(),
                    property.get().getMaxGuest(),property.get().getNumRooms(),
                    property.get().getNumBeds(),property.get().getNumBathrooms(),
                    property.get().getPrice(), property.get().getImages(),
                    property.get().getLatitude(), property.get().getLength(),
                    property.get().getUser()
            );

            return ResponseEntity.ok(propertyDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/property/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){

        Property property = new Property(
                propertyDTO.getId(),propertyDTO.getName(),propertyDTO.getDescription(),
                propertyDTO.getType(),propertyDTO.getMaxGuest(),
                propertyDTO.getNumRooms(),propertyDTO.getNumBeds(),
                propertyDTO.getNumBathrooms(),propertyDTO.getPrice(),
                propertyDTO.getImages(),propertyDTO.getLatitude(),
                propertyDTO.getLength(),propertyDTO.getHost()
        );

        service.updateProperty(id,property);

        return ResponseEntity.ok().build();

    }


    @PostMapping("/property")
    public ResponseEntity<?> addProperty(@RequestBody PropertyDTO propertyDTO){
        Property property = new Property(
                propertyDTO.getId(), propertyDTO.getName(), propertyDTO.getDescription(),
                propertyDTO.getType(),propertyDTO.getMaxGuest(),propertyDTO.getNumRooms(),
                propertyDTO.getNumBeds(),propertyDTO.getNumBathrooms(), propertyDTO.getPrice(),
                propertyDTO.getImages(), propertyDTO.getLatitude(), propertyDTO.getLength(),
                propertyDTO.getHost()
        );


            service.addProperty(property);

            return ResponseEntity.created(URI.create("/api/property/"+property.getId())).build();


    }

    @DeleteMapping("property/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

            service.deleteById(id);
            return ResponseEntity.ok().build();


    }
}
