package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.AddressDTO;
import com.mariushop.mariushop.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AddressMapper {

    public AddressDTO mapAddressToAddressDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .addressCountry(address.getCountry())
                .addressCity(address.getCity())
                .addressStreet(address.getStreet())
                .build();
    }
}

