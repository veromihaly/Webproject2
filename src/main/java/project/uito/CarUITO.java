package project.uito;

import java.io.Serializable;
import java.util.List;

public class CarUITO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long carId;
    private String carBrand;

    private List<OwnerUITO> ownerUITOLst;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public List<OwnerUITO> getOwnerUITOLst() {
        return ownerUITOLst;
    }

    public void setOwnerUITOLst(List<OwnerUITO> ownerUITOLst) {
        this.ownerUITOLst = ownerUITOLst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carId == null) ? 0 : carId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarUITO other = (CarUITO) obj;
        if (carId == null) {
            if (other.carId != null)
                return false;
        } else if (!carId.equals(other.carId))
            return false;
        return true;
    }

}

