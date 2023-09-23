package com.driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    SpotType spotType;

    int pricePerHour;

    Boolean occupied;
    @ManyToOne
     @JoinColumn
    ParkingLot parkingLot;

    @OneToMany(mappedBy = "spot",cascade =CascadeType.ALL)
    List<Reservation> reservationList=new ArrayList<>();






















}
