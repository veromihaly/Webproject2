package project.service.impl;

/**
 * @author s727953
 *
 */

import java.util.ArrayList;
import java.util.List;

import project.repository.CarRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.entity.CarDTO;
import project.service.CarService;
import project.uito.CarUITO;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Override
    public List<CarUITO> getAllCar() {
        List<CarUITO> carUITOLst = new ArrayList<>();
        List<CarDTO> carDTOLst = carRepo.findAll();

        carDTOLst.forEach(dto -> {
            CarUITO tmpUiTO = new CarUITO();

            BeanUtils.copyProperties(dto, tmpUiTO);
            carUITOLst.add(tmpUiTO);
        });

        return carUITOLst;
    }

    @Override
    public CarUITO getCar(CarUITO carUITO) {
        System.out.println(">>>>> "+carUITO.getCarBrand());
        CarDTO dto = carRepo.findTitleByCarBrand(carUITO.getCarBrand());
        CarUITO uito = new CarUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }
}
