package com.systemRealEstate.systemRealEstate.service.Implementation;

import com.systemRealEstate.systemRealEstate.exception.CanNotCreateException;
import com.systemRealEstate.systemRealEstate.exception.NotFoundException;
import com.systemRealEstate.systemRealEstate.model.Reservation;
import com.systemRealEstate.systemRealEstate.repository.ReservationRepository;
import com.systemRealEstate.systemRealEstate.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl  implements IReservationService {


    @Autowired
    private ReservationRepository repository;


    @Override
    public List<Reservation> getAll() {
        Iterable<Reservation> reservations = repository.findAll();
        List<Reservation> list = new ArrayList<>();
        for(Reservation reservation : reservations){
            list.add(reservation);
        }
        return list;
    }

    @Override
    public Optional<Reservation> getById(Long id) {
        Optional<Reservation> reservationOptional = repository.findById(id);
        if (reservationOptional.isPresent()){
            return reservationOptional;
        }
        throw new NotFoundException("No se encontro la reserva con el id "+id+ " en la base de datos");
    }

    @Override
    @Transactional
    public void addReservation(Reservation reservation) {
        try{
            repository.save(reservation);
        }catch (Exception e){
            throw new CanNotCreateException("No se pudo hacer la reserva "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateReservation(Long id, Reservation updatedReservation) {
        if (!repository.existsById(id)){
            throw new NotFoundException("No se encontro la reserva que se quiere actualizar");
        }else{
            updatedReservation.setId(id);
            repository.save(updatedReservation);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("La reserva no se encontro en la base de datos");
        }else{
            repository.deleteById(id);
        }
    }

    @Override
    public List<Reservation> getReservationsByIdProperty(Long idProperty) {
        Iterable<Reservation> reservations = repository.getReservationsByIdProperty(idProperty);
        List<Reservation> reservationList = new ArrayList<>();
        for(Reservation aux : reservations){
            reservationList.add(aux);
        }
        return reservationList;
    }
}
