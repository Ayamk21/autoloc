package org.example.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.autoloc.entities.Contrat;
public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
