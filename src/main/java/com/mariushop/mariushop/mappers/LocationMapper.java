package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.LocationDTO;
import com.mariushop.mariushop.entities.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LocationMapper {

    private final AddressMapper addressMapper;

    public LocationDTO mapLocationToLocationDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .locationName(location.getName())
                .addressDTO(addressMapper.mapAddressToAddressDTO(location.getAddress()))
                .build();
    }
}
