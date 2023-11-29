package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.CarDTO;

@Repository
public interface CarRepo extends JpaRepository<CarDTO, Long> {

    CarDTO findTitleByCarBrand(String carBrand);

    //CarDTO findByCarBrandContainsAndCarIdExistsAndOrderByCarBrand()
}