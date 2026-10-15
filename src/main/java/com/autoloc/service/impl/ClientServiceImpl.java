package com.autoloc.service.impl;

import com.autoloc.entity.Client;
import com.autoloc.repository.ClientRepository;
import com.autoloc.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Client introuvable avec l'id " + id));
    }

    @Override
    public Client update(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable avec l'id " + id);
        }
        client.setIdClient(id);
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable avec l'id " + id);
        }
        clientRepository.deleteById(id);
    }
}
