package com.example.cinema.entity.bill;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bill_combo")
public class BillCombo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int quantity;
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name= "bill_id")
    Bill bill;

    @ManyToOne
    @JoinColumn(name = "combo_id")
    Combo combo;
}
