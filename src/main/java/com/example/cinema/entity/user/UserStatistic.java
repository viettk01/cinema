package com.example.cinema.entity.user;

import com.example.cinema.model.enums.UserRank;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_statistics")
public class UserStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer points;
    private Long totalSpending;

    @Enumerated(EnumType.STRING)
    private UserRank userRank;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
