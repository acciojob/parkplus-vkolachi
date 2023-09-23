package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setAddress(address);
        parkingLotRepository1.save(parkingLot);
        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
        Spot spot=new Spot();
        ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
        spot.setParkingLot(parkingLot);
        if(numberOfWheels==2){
            spot.setSpotType(SpotType.TWO_WHEELER);
        }else if(numberOfWheels==3){
            spot.setSpotType(SpotType.FOUR_WHEELER);
        }
        else {
            spot.setSpotType(SpotType.OTHERS);
        }
        spot.setOccupied(false);
        spot.setPricePerHour(pricePerHour);

        parkingLot.getSpotList().add(spot);
        parkingLotRepository1.save(parkingLot);
        return spot;


    }

    @Override
    public void deleteSpot(int spotId) {

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {

    }

    @Override
    public void deleteParkingLot(int parkingLotId) {

    }
}
