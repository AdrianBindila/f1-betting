package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.DriverDTO;
import org.f1.model.Driver;
import org.f1.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    private final ModelMapper modelMapper;

    public DriverController(DriverService driverService, ModelMapper modelMapper) {
        this.driverService = driverService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<DriverDTO> getDriver(@PathVariable Long driverId) {
        if (driverId == null) {
            return ResponseEntity.badRequest().build();
        }
        Driver driver = driverService.getDriver(driverId);

        if (driver == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            DriverDTO driverDTO = modelMapper.map(driver, DriverDTO.class);
            return ResponseEntity.ok(driverDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        List<DriverDTO> driverDTOS = drivers.stream().map(driver -> modelMapper.map(driver, DriverDTO.class)).toList();
        return ResponseEntity.ok(driverDTOS);
    }

    @PostMapping
    public ResponseEntity<DriverDTO> addDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverName().isEmpty() || dto.getDriverName().isBlank()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Driver d = driverService.addDriver(modelMapper.map(dto, Driver.class));
        return new ResponseEntity<>(modelMapper.map(d, DriverDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable Long driverId, @RequestBody DriverDTO driverDTO) {
        if (driverId == null || driverDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Driver driver = driverService.updateDriver(driverId, driverDTO);

        try {
            DriverDTO dto = modelMapper.map(driver, DriverDTO.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long driverId) {
        if (driverId == null) {
            return ResponseEntity.badRequest().build();
        }

        driverService.deleteDriver(driverId);
        return ResponseEntity.ok().build();
    }
}
