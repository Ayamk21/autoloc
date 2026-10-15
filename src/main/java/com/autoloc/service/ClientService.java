package com.autoloc.service;

import com.autoloc.entity.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client);

    List<Client> getAll();

    Client getById(Long id);

    Client update(Long id, Client client);

    void delete(Long id);
}
