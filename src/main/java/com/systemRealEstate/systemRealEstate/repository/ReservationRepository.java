package com.systemRealEstate.systemRealEstate.repository;

import com.systemRealEstate.systemRealEstate.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {


    @Query("SELECT r FROM Reservation r WHERE r.property.id = :idProperty")
     List<Reservation> getReservationsByIdProperty(@Param("idProperty") Long idProperty);
}
