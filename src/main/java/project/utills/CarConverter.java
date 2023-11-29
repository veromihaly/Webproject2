package project.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import project.service.CarService;
import project.uito.CarUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarConverter implements Converter {

    @Autowired
    private CarService carService;

    private static final Logger LOG = LoggerFactory.getLogger(CarConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        LOG.info("getAsObject: " + carService);

        CarUITO carUITO = new CarUITO();
        carUITO.setCarBrand(string);
        carUITO = carService.getCar(carUITO);
        System.out.println(carUITO.toString());
        return carUITO;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        LOG.info("getAsString obj class: " + obj.getClass().getName());
        if (obj instanceof CarUITO) {
            CarUITO dept = (CarUITO) obj;
            LOG.info("getAsString def name: " + dept.getCarBrand());
            return dept.getCarBrand();
        } else {
            StringBuilder sbError = new StringBuilder("The object of class ");
            sbError.append(obj.getClass().getName()).append(" is not of CarUITO");
            throw new ClassCastException(sbError.toString());
        }
    }
}
