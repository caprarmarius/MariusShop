package com.mariushop.mariushop.controllers;

import com.mariushop.mariushop.dtos.LocationDTO;
import com.mariushop.mariushop.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mariushop-frontend.web.app/")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO newLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocationById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public LocationDTO updateLocation(@PathVariable Integer id, @RequestBody LocationDTO locationDTO) {
        return locationService.updateLocationById(id, locationDTO);
    }
}
