package project.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class OwnerUITO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4840260415183676656L;
    private Long ownerId;
    private String ownerName;

    private String password;
    private String address1;
    private String emailId;
    private CarUITO carUITO;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public CarUITO getCarUITO() {
        return carUITO;
    }

    public void setCarUITO(CarUITO carUITO) {
        this.carUITO = carUITO;
    }

    @Override
    public String toString() {
        return "OwnerUITO [ownerId=" + ownerId + ", ownerName=" + ownerName + ", password=" + password + ", address1="
                + address1 + ", emailId=" + emailId + ", carUITO=" + carUITO + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
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
        OwnerUITO other = (OwnerUITO) obj;
        if (ownerName == null) {
            if (other.ownerName != null)
                return false;
        } else if (!ownerName.equals(other.ownerName))
            return false;
        return true;
    }

}

