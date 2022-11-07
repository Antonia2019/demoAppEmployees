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
    public void updateAddress(Long id, Address address) {
        Address addressToUpdate = addressRepository.findById(id).
                orElseThrow(()-> new IllegalStateException("Address with id "+ id + " doesn't exist"));
        addressToUpdate.setOras(address.getOras());
        addressToUpdate.setStrada(address.getStrada());
        addressToUpdate.setNumar(address.getNumar());

        addressRepository.saveAndFlush(addressToUpdate);
    }


}
