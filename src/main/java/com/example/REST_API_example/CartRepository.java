package com.example.REST_API_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    @Autowired
    JdbcTemplate jdbct;

    public List<AmazonCart> getCartDetails() {
        return jdbct.query("select *from cart",
                (rs,rowNum)-> new AmazonCart(rs.getInt("id"),rs.getString("name"),rs.getInt("price"))
        );
    }

    public int addCartDetails(AmazonCart cartItem) {
        return jdbct.update("insert into cart (id,name,price) values (?,?,?)",cartItem.getId(),cartItem.getName(),cartItem.getPrice());
    }

    public int updateCartDetails(AmazonCart cartItem) {
        return jdbct.update("update cart set name=? where id=?",cartItem.getName(),cartItem.getId());
    }

    public int deleteCartDetails(int id) {
        return jdbct.update("delete from cart where id=?",id);
    }
}
