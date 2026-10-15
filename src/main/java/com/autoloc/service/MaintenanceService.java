package com.autoloc.service;

import com.autoloc.entity.Maintenance;

import java.util.List;

public interface MaintenanceService {

    Maintenance create(Maintenance maintenance);

    List<Maintenance> getAll();

    Maintenance getById(Long id);

    Maintenance update(Long id, Maintenance maintenance);

    void delete(Long id);
}
