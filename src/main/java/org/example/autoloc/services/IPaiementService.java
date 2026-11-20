package org.example.autoloc.services;

import org.example.autoloc.entities.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);
    Paiement modifierPaiement(Paiement paiement);
    List<Paiement> consulterPaiements();
    Paiement consulterPaiementById(long idPaiement);
    void supprimerPaiementById(long idPaiement);
}
