package com.example.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddress() {
        return addressService.getAddress();
    }

    @PostMapping
    public void registerNewAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }


    @PutMapping(path = "{id}")
    public void updateAddress(
            @PathVariable("id") Long id, @RequestBody Address address) {
        addressService.updateAddress(id, address);
    }

    @DeleteMapping(path = "{addressId}")
    public void deleteAddress(@PathVariable("addressId") Long id) {
        addressService.deleteAddress(id);
    }
}
