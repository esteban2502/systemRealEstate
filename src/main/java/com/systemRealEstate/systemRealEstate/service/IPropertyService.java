package com.systemRealEstate.systemRealEstate.service;


import com.systemRealEstate.systemRealEstate.model.Property;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IPropertyService {

 List<Property> getAll();
 Optional<Property> getById(Long id);
 void addProperty(Property property);
 void updateProperty(Long id, Property updatedProperty);
 void deleteById(Long id);


}
