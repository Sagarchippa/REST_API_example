package com.example.REST_API_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepo;
    public List<AmazonCart> getCartDetails() {
        return cartRepo.getCartDetails();
    }

    public int addCartDetails(AmazonCart item) {
        System.out.println(item.getId()+" "+item.getName()+" "+item.getPrice());
        return cartRepo.addCartDetails(item);
    }

    public int updateCartDetails(AmazonCart item) {
        return cartRepo.updateCartDetails(item);
    }

    public int deleteCartDetails(int id) {
        return cartRepo.deleteCartDetails(id);
    }
}
