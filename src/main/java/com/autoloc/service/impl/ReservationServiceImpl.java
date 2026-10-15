package com.autoloc.service.impl;

import com.autoloc.entity.Reservation;
import com.autoloc.repository.ReservationRepository;
import com.autoloc.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Reservation introuvable avec l'id " + id));
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation introuvable avec l'id " + id);
        }
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation introuvable avec l'id " + id);
        }
        reservationRepository.deleteById(id);
    }
}
