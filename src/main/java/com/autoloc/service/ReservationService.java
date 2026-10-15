package com.autoloc.service;

import com.autoloc.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);

    List<Reservation> getAll();

    Reservation getById(Long id);

    Reservation update(Long id, Reservation reservation);

    void delete(Long id);
}
