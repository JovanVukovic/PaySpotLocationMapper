package rs.payspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.payspot.entity.LocationWP;

@Repository
public interface LocationWPRepository extends JpaRepository<LocationWP, Long>{

	LocationWP findBySifra(String sifra);
}
