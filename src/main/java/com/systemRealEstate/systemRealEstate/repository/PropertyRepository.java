package com.systemRealEstate.systemRealEstate.repository;

import com.systemRealEstate.systemRealEstate.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property,Long> {
}
