package com.driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;

    Boolean paymentCompleted;

    PaymentMode paymentMode;
    @OneToOne
    @JoinColumn
    Reservation reservation;
}
