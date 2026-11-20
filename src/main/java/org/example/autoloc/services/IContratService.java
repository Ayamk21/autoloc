package org.example.autoloc.services;
import org.example.autoloc.entities.Contrat;
import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contrat);
    List<Contrat> consulterContrats();
    Contrat consulterContratById(long idContrat);
    void supprimerContratById(long idContrat);
}
