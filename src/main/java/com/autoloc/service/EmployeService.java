package com.autoloc.service;

import com.autoloc.entity.Employe;

import java.util.List;

public interface EmployeService {

    Employe create(Employe employe);

    List<Employe> getAll();

    Employe getById(Long id);

    Employe update(Long id, Employe employe);

    void delete(Long id);
}
