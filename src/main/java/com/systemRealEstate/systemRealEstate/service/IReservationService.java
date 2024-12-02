package com.systemRealEstate.systemRealEstate.service;

import com.systemRealEstate.systemRealEstate.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IReservationService {

    List<Reservation> getAll();
    Optional<Reservation> getById(Long id);
    void addReservation(Reservation reservation);
    void updateReservation(Long id,Reservation updatedReservation);
    void deleteById(Long id);
}
