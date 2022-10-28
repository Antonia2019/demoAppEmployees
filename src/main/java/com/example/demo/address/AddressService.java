package com.example.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public void addNewAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Transactional
    public void updateAddress(Long id, String oras, String strada, Integer numar) {
        Address address = addressRepository.findById(id).
                orElseThrow(()-> new IllegalStateException("Address with id "+ id + " doesn't exist"));
        address.setOras(oras);
        address.setStrada(strada);
        address.setNumar(numar);
    }


}
