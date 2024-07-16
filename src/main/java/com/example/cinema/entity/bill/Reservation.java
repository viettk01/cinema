package com.example.cinema.entity.bill;

import com.example.cinema.entity.User;
import com.example.cinema.entity.cinema.Seat;
import com.example.cinema.entity.cinema.ShowTime;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    boolean status;
    LocalDate createAt;
    LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="seat_id")
    Seat seat;

    @ManyToOne
    @JoinColumn(name="showtime_id")
    ShowTime showTime;
}
