/*package com.mariushop.mariushop.controllers;

import com.mariushop.mariushop.dtos.EmailDTO;
import com.mariushop.mariushop.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mariushop-frontend.web.app")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
    }
}*/
