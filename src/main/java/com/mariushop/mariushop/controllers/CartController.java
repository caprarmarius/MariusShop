package com.mariushop.mariushop.controllers;

import com.mariushop.mariushop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mariushop-frontend.web.app/")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService cartService;

    @DeleteMapping("/{id}/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@PathVariable Integer id, @PathVariable String username) {
        cartService.deleteById(id, username);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersCart(@PathVariable String username) {
        cartService.deleteByUser(username);
    }
}
