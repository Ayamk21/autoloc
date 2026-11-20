
package org.example.autoloc.Controllers;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Client;
import org.example.autoloc.services.IClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private IClientService clientService;

    @PostMapping("/ajoute")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @GetMapping("/getAll")
    public List<Client> getAllClients() {
        return clientService.consulterClients();
    }

    @GetMapping("/getById/{idClient}")
    public Client getClientById(@PathVariable Long idClient) {
        return clientService.consulterClientById(idClient);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteClient(@PathVariable Long idClient) {
        clientService.supprimerClientById(idClient);
    }
}
