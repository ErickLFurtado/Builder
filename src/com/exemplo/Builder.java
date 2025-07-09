package com.exemplo;

import com.exemplo.cars.CarType;
import com.exemplo.components.Engine;
import com.exemplo.components.Gps;
import com.exemplo.components.Transmission;
import com.exemplo.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGps(Gps gps);
}
