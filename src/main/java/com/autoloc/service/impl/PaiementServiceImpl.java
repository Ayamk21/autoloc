package com.autoloc.service.impl;

import com.autoloc.entity.Paiement;
import com.autoloc.repository.PaiementRepository;
import com.autoloc.service.PaiementService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementServiceImpl(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @Override
    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement getById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Paiement introuvable avec l'id " + id));
    }

    @Override
    public Paiement update(Long id, Paiement paiement) {
        if (!paiementRepository.existsById(id)) {
            throw new EntityNotFoundException("Paiement introuvable avec l'id " + id);
        }
        paiement.setIdPaiement(id);
        return paiementRepository.save(paiement);
    }

    @Override
    public void delete(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new EntityNotFoundException("Paiement introuvable avec l'id " + id);
        }
        paiementRepository.deleteById(id);
    }
}
