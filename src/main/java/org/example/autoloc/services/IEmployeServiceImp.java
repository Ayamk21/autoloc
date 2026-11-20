package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Agence;
import org.example.autoloc.entities.Employe;
import org.example.autoloc.repositories.AgenceRepository;
import org.example.autoloc.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> consulterEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe consulterEmployeById(long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmployeById(long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        // 1. Récupérer l'employé
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé introuvable : " + idEmploye));

        // 2. Le détacher de son agence (le côté @ManyToOne est le propriétaire de la relation)
        employe.setAgence(null);

        // 3. Sauvegarder : agence_id passe à NULL en base
        return employeRepository.save(employe);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        // 1. Récupérer l'employé et l'agence
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé introuvable : " + idEmploye));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + idAgence));

        // 2. Affecter l'agence à l'employé (côté propriétaire @ManyToOne)
        employe.setAgence(agence);

        // 3. Sauvegarder : agence_id prend la valeur idAgence en base
        return employeRepository.save(employe);
    }
}
