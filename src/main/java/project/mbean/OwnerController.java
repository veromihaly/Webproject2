package project.mbean;

/**
 * @author s727953
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import project.service.CarService;
import project.service.OwnerService;
import project.uito.CarUITO;
import project.uito.OwnerUITO;
//import org.primefaces.context.RequestContext;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

@Controller("ownerController")
@SessionScope
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CarService carService;

    private String actionLabel;
    private OwnerUITO ownerUiTO;
    private List<OwnerUITO> ownerUiToList;

    private List<CarUITO> carUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoOwner() {
        System.out.println(this.getOwnerUiTO());
        ownerService.doSaveOwner(this.getOwnerUiTO());
        getAllOwner();
        this.setOwnerUiTO(new OwnerUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner Details", "Owner Details added/Updated Successfully.");

        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    /**
     * Default load all the Owner info
     */
    @PostConstruct
    public void getAllOwner() {
        if (!this.getOwnerUiToList().isEmpty()) {
            this.getOwnerUiToList().clear();
            this.getCarUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + ownerService);
        this.getOwnerUiToList().addAll(ownerService.doFetchAllOwner());
        this.getCarUiToList().addAll(carService.getAllCar());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Owner info
     *
     * @return
     */

    public void deleteOwner(OwnerUITO ownerUiTO) {
        ownerService.doDeleteOwner(ownerUiTO);
        getAllOwner();
    }

    public void editOwner(OwnerUITO ownerUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(ownerUiTO, this.getOwnerUiTO());
        System.out.println(this.getOwnerUiTO());
    }

    public OwnerUITO getOwnerUiTO() {
        if (ownerUiTO == null) {
            ownerUiTO = new OwnerUITO();
        }
        return ownerUiTO;
    }

    public void setOwnerUiTO(OwnerUITO ownerUiTO) {
        this.ownerUiTO = ownerUiTO;
    }

    public List<OwnerUITO> getOwnerUiToList() {
        if (null == ownerUiToList) {
            ownerUiToList = new ArrayList<>();
        }
        return ownerUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<CarUITO> getCarUiToList() {
        if (carUiToList == null) {
            carUiToList = new ArrayList<>();
        }
        return carUiToList;
    }

    public void setCarUiToList(List<CarUITO> carUiToList) {
        this.carUiToList = carUiToList;
    }
}
