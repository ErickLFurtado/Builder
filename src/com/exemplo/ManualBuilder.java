package com.exemplo;

import com.exemplo.cars.CarManual;
import com.exemplo.cars.CarType;
import com.exemplo.components.Engine;
import com.exemplo.components.Gps;
import com.exemplo.components.Transmission;
import com.exemplo.components.TripComputer;

public class ManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private Gps gps;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public CarManual getResult(){
        return new CarManual(type, seats, engine, transmission, tripComputer, gps);
    }
}
