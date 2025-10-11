package org.example.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.reservationservice.domain.enums.ReservationStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {

    @Id
    private String reservationId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String spotId;

    @Column(nullable = false)
    private String vehicleId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId", insertable = false, updatable = false)
    private Vehicule vehicule;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Duration duration;


}
