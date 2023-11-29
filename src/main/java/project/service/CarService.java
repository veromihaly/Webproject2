package project.service;

import java.util.List;

import project.uito.CarUITO;

public interface CarService {

    List<CarUITO> getAllCar();

    CarUITO getCar(CarUITO carUITO);

}
