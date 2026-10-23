package com.autoloc.service.impl;

import com.autoloc.entity.Contrat;
import com.autoloc.repository.ContratRepository;
import com.autoloc.service.ContratService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {

    private final ContratRepository contratRepository;

    public ContratServiceImpl(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Contrat introuvable avec l'id " + id));
    }

    @Override
    public Contrat update(Long id, Contrat contrat) {
        Contrat existant = getById(id);
        contrat.setIdContrat(id);
        // Les paiements ne sont pas exposés dans le JSON : on les conserve,
        // sinon orphanRemoval les supprimerait lors du save().
        contrat.setPaiements(existant.getPaiements());
        return contratRepository.save(contrat);
    }

    @Override
    public void delete(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new EntityNotFoundException("Contrat introuvable avec l'id " + id);
        }
        contratRepository.deleteById(id);
    }
}
