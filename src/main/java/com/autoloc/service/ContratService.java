package com.autoloc.service;

import com.autoloc.entity.Contrat;

import java.util.List;

public interface ContratService {

    Contrat create(Contrat contrat);

    List<Contrat> getAll();

    Contrat getById(Long id);

    Contrat update(Long id, Contrat contrat);

    void delete(Long id);
}
