package rs.payspot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryContainer {

	@Autowired
	private LocationWPRepository locationWPRepository;
	
	public LocationWPRepository getLocationWPRepository() {
		return locationWPRepository;
	}
}
