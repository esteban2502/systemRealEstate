package com.systemRealEstate.systemRealEstate.repository;

import com.systemRealEstate.systemRealEstate.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
