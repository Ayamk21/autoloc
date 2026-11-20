
package org.example.autoloc.Controllers;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Reservation;
import org.example.autoloc.services.IReservationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private IReservationService reservationService;

    @PostMapping("/ajoute")
    public Reservation ajouterReservation(
            @RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/getById/{idReservation}")
    public Reservation getReservationById(
            @PathVariable Long idReservation) {
        return reservationService.consulterReservationById(idReservation);
    }

    @PutMapping("/update")
    public Reservation updateReservation(
            @RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(
            @PathVariable Long idReservation) {
        reservationService.supprimerReservationById(idReservation);
    }
}
