package com.systemRealEstate.systemRealEstate.service.Implementation;

import com.systemRealEstate.systemRealEstate.exception.CanNotCreateException;
import com.systemRealEstate.systemRealEstate.exception.NotFoundException;
import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.repository.PropertyRepository;
import com.systemRealEstate.systemRealEstate.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        throw new NotFoundException("No se encontro la propiedad con el id "+id+" en la base de datos");
    }

    @Override
    @Transactional
    public void addProperty(Property property) {
        try{
            repository.save(property);
        }catch (Exception e){
            throw new CanNotCreateException("No se puede guardar la propiedad "+e.getMessage());
        }



    }

    @Override
    @Transactional
    public void updateProperty(Long id, Property updatedProperty) {
        if(!repository.existsById(id)){
            throw new NotFoundException("No se encuentra la propiedad con el id "+id+" que se quiere actualizar");
        }else{
            updatedProperty.setId(id);
            repository.save(updatedProperty);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("No se encontro la propiedad con el id "+id+" en la base de datos");
        }else{
            repository.deleteById(id);
        }

    }


}
