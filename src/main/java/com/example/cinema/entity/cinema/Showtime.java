package com.example.cinema.entity.cinema;

import com.example.cinema.entity.movie.Movie;
import com.example.cinema.model.enums.AuditoriumType;
import com.example.cinema.model.enums.GraphicsType;
import com.example.cinema.model.enums.ScreeningTimeType;
import com.example.cinema.model.enums.TranslationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ScreeningTimeType screeningTimeType;
    @Enumerated(EnumType.STRING)
    private GraphicsType graphicsType;
    @Enumerated(EnumType.STRING)
    private AuditoriumType auditoriumType;
    @Enumerated(EnumType.STRING)
    private TranslationType translationType;

    private LocalDate screeningDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "movies_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name= "auditorium_id")
    private Auditorium auditorium;
}
