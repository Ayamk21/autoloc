package com.autoloc.service.impl;

import com.autoloc.entity.Agence;
import com.autoloc.repository.AgenceRepository;
import com.autoloc.service.AgenceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository agenceRepository;

    public AgenceServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence getById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Agence introuvable avec l'id " + id));
    }

    @Override
    public Agence update(Long id, Agence agence) {
        if (!agenceRepository.existsById(id)) {
            throw new EntityNotFoundException("Agence introuvable avec l'id " + id);
        }
        agence.setIdAgence(id);
        return agenceRepository.save(agence);
    }

    @Override
    public void delete(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new EntityNotFoundException("Agence introuvable avec l'id " + id);
        }
        agenceRepository.deleteById(id);
    }
}
