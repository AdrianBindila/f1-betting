package org.f1.service;

import org.f1.dto.DriverDTO;
import org.f1.model.Driver;
import org.f1.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriver(Long driverId) {
        return driverRepository.findById(driverId).orElseThrow();
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver updateDriver(Long driverId, DriverDTO driverDTO) {
        Driver driver = driverRepository.findById(driverId).orElseThrow();
        driver.setDriverName(driverDTO.getDriverName());
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long driverId){
        driverRepository.deleteById(driverId);
    }
}
