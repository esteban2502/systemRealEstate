package com.systemRealEstate.systemRealEstate.service.Implementation;

import com.systemRealEstate.systemRealEstate.exception.CanNotCreateException;
import com.systemRealEstate.systemRealEstate.exception.NotFoundException;
import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.repository.PropertyRepository;
import com.systemRealEstate.systemRealEstate.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        throw new NotFoundException("No se encontro el Registro en la base de datos");
    }

    @Override
    public void addPropery(Property property) {
        try{
            repository.save(property);
        }catch (Exception e){
            throw new CanNotCreateException("Informacion sobre el error "+e);
        }



    }

    @Override
    public void updateProperty(Long id, Property updatedProperty) {
        updatedProperty.setId(id);
        repository.save(updatedProperty);
    }

    @Override
    public void deleteById(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("No se encontro el registro en la base de datos");
        }else{
            repository.deleteById(id);
        }

    }


}
