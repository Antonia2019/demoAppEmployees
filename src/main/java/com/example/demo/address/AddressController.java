package com.example.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddresses")
    public List<Address> getAddress() {

        return addressService.getAddress();
    }

    @PostMapping("/registerAddress")
    public void registerNewAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }


    @PutMapping(path = "/updateAddress/{id}")
    public void updateAddress(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String oras,
            @RequestParam(required = false) String strada,
            @RequestParam(required = false) Integer numar) {
        addressService.updateAddress(id, oras, strada, numar);
    }

    @DeleteMapping(path = "/deleteAddress/{addressId}")
    public void deleteAddress(@PathVariable("addressId") Long id) {
        addressService.deleteAddress(id);
    }
}
