package com.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import com.autoloc.enums.ModePaiement;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private BigDecimal montant;
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}
