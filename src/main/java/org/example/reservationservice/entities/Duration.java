package org.example.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "durations")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Duration {

    @Id
    private String durationId;

    @Column(nullable = false)
    private String reservationId;

    private LocalDateTime actualStart;

    private LocalDateTime actualEnd;

    @OneToOne
    @JoinColumn(name = "reservationId", insertable = false, updatable = false)
    private Reservation reservation;
}
