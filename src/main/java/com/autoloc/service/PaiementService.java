package com.autoloc.service;

import com.autoloc.entity.Paiement;

import java.util.List;

public interface PaiementService {

    Paiement create(Paiement paiement);

    List<Paiement> getAll();

    Paiement getById(Long id);

    Paiement update(Long id, Paiement paiement);

    void delete(Long id);
}
