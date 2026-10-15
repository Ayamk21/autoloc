package com.autoloc.service;

import com.autoloc.entity.Equipement;

import java.util.List;

public interface EquipementService {

    Equipement create(Equipement equipement);

    List<Equipement> getAll();

    Equipement getById(Long id);

    Equipement update(Long id, Equipement equipement);

    void delete(Long id);
}
