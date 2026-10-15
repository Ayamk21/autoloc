package com.autoloc.service;

import com.autoloc.entity.Vehicule;

import java.util.List;

public interface VehiculeService {

    Vehicule create(Vehicule vehicule);

    List<Vehicule> getAll();

    Vehicule getById(Long id);

    Vehicule update(Long id, Vehicule vehicule);

    void delete(Long id);
}
