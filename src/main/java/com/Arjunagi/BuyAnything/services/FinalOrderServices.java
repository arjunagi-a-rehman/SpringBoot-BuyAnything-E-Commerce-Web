package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.order.FinalOrder;
import com.Arjunagi.BuyAnything.repository.IFinalOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalOrderServices {
    @Autowired
    IFinalOrderRepo finalOrderRepo;

    public void addFinalOrder(FinalOrder finalOrder) {
        finalOrder.setOrderQuantity(finalOrder.getCartItems().size());
        finalOrder.setAddress(finalOrder.getUser().getAddress().stream().filter(o-> o.isSelected()).findFirst().orElseThrow());
        finalOrderRepo.save(finalOrder);
    }

    public List<FinalOrder> getAll() {
        return finalOrderRepo.findAll();
    }
}
