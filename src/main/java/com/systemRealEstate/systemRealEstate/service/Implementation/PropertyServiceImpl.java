package com.systemRealEstate.systemRealEstate.service.Implementation;

import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.repository.PropertyRepository;
import com.systemRealEstate.systemRealEstate.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements IPropertyService {


    @Autowired
    private PropertyRepository repository;

    @Override
    public List<Property> getAll() {
        Iterable<Property> properties = repository.findAll();
        List<Property> list = new ArrayList<>();
        for(Property aux : properties){
            list.add(aux);
        }
        return list;
    }

    @Override
    public Optional<Property> getById(Long id) {
    Optional<Property> property = repository.findById(id);
    if(property.isPresent()){
            return property;
        }
        return null;
    }

    @Override
    public void addPropery(Property property) {
        repository.save(property);
    }

    @Override
    public void updateProperty(Long id, Property updatedProperty) {
        updatedProperty.setId(id);
        repository.save(updatedProperty);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
