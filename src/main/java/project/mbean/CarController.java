package project.mbean;

import project.service.CarService;
import project.uito.CarUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller("carController")
@SessionScope
public class CarController {

    @Autowired //@Inject - java ee
    CarService carService;

    List<CarUITO> carList;

    @PostConstruct
    public void init(){
        carList = carService.getAllCar();
        System.out.println(carList);
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public List<CarUITO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarUITO> carList) {
        this.carList = carList;
    }
}

