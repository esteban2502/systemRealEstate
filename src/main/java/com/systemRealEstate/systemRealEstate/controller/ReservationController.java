package com.systemRealEstate.systemRealEstate.controller;

import com.systemRealEstate.systemRealEstate.controller.DTO.ReservationDTO;
import com.systemRealEstate.systemRealEstate.exception.CanNotCreateException;
import com.systemRealEstate.systemRealEstate.model.Reservation;
import com.systemRealEstate.systemRealEstate.service.IReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class ReservationController {

    @Autowired
    private IReservationService service;

    @GetMapping("/reservations")
    public ResponseEntity<?> getAll() {

        List<Reservation> reservations = service.getAll();
        List<ReservationDTO> listDTO = reservations.stream().map(
                        r -> new ReservationDTO(
                                r.getId(), r.getProperty(), r.getUser(),
                                r.getStartDay(), r.getEndDay()
                        )

                )
                .collect(Collectors.toList());

        return ResponseEntity.ok(listDTO);

    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Reservation> reservationOptional = service.getById(id);

        if (reservationOptional.isPresent()) {
            ReservationDTO reservationDTO = new ReservationDTO(
                    reservationOptional.get().getId(), reservationOptional.get().getProperty(),
                    reservationOptional.get().getUser(), reservationOptional.get().getStartDay(),
                    reservationOptional.get().getEndDay()
            );

            return ResponseEntity.ok(reservationDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> addReservation(@Valid @RequestBody ReservationDTO reservationDTO){
        Reservation reservation = new Reservation(
                reservationDTO.getId(),reservationDTO.getProperty(),
                reservationDTO.getUser(),reservationDTO.getStartDay(),
                reservationDTO.getEndDay()
        );

       service.addReservation(reservation);

       return ResponseEntity.created(URI.create("/reservation/"+reservation.getId())).build();

    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO){
        Reservation reservation = new Reservation(
                reservationDTO.getId(),reservationDTO.getProperty(),reservationDTO.getUser(),
                reservationDTO.getStartDay(),reservationDTO.getEndDay()
        );
        service.updateReservation(id,reservation);

        return ResponseEntity.ok().build();
    }



}
