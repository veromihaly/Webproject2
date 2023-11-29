package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.OwnerDTO;

@Repository
public interface OwnerRepo extends JpaRepository<OwnerDTO, Long> {
}
