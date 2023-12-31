package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.repository.IAddressRepo;
import com.Arjunagi.BuyAnything.repository.IUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServices {
    @Autowired
    IAddressRepo addressRepo;
    @Autowired
    IUserRepo userRepo;
    public void AddAddress(Address address, Integer id) {
        address.setUser(userRepo.findById(id).orElseThrow());
        addressRepo.save(address);
    }
    @Transactional
    public void updateAllStatus(boolean status){

    }
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public List<Address> getAllForUser(Integer userId) {
        return addressRepo.findByUserId(userId);
    }

//    public String updateSelected(Integer id){
//        Address address=addressRepo.findById(id).orElseThrow();
//        addressRepo.
//    }

    public void updateList(List<Address> addresses){
        addressRepo.saveAll(addresses);
    }
}
