package com.autoloc.service;

import com.autoloc.entity.Agence;

import java.util.List;

public interface AgenceService {

    Agence create(Agence agence);

    List<Agence> getAll();

    Agence getById(Long id);

    Agence update(Long id, Agence agence);

    void delete(Long id);
}
