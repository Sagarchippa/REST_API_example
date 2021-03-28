package com.example.REST_API_example;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("cart")
@Api(value = "product operations controller",description = "GETtting,POSTing,PUTting and DELETing data")
public class CartController {

    @Autowired
    CartService cartService;

    @Value("${my.greeting: THIS IS DEFAULT VALUE.. IF my.greeting NOT found}")
    public String greet;

    @Value("${my.list.values}")
    public List<String> values;

    @Value("#{3+5}")
    private int value;

    //accessing data using spring expression language
    @Value("#{cartController.greet.concat(' ').concat(cartController.values.get(0))}")
    private String ex_wishes;

    Logger logger= LoggerFactory.getLogger(CartController.class);
    @ApiOperation(value = "say hello baby!", notes = "this api fetch cart details")
    @ApiResponses(
            value={
                    @ApiResponse(code = 401,message = "EVANIKI TELSU"),
                    @ApiResponse(code = 403,message = "DEVUDI PAINE BHAARAM VESAM"),
                    @ApiResponse(code = 404,message = "DEENI GURINCHI CHEPPALSINA AVSARAM LEDU")
            }
    )
    @GetMapping("get")
    public List<AmazonCart> getCartDetails(){
        logger.trace("hey anna namasteee");
        logger.trace(greet);
        logger.trace(values.get(0));
        logger.trace(Integer.toString(value));
        logger.trace(ex_wishes);
        return cartService.getCartDetails();
    }

    @PostMapping("add")
    public int addCartDetails(@RequestBody AmazonCart amazonCart){
       return cartService.addCartDetails(amazonCart);
    }

    @PutMapping("update")
    public int updateCartDetails(@RequestBody AmazonCart amazonCart){
      return cartService.updateCartDetails(amazonCart);
    }

    @DeleteMapping("delete/{id}")
    public int deleteCartDetails(int id) {
      return cartService.deleteCartDetails(id);
    }
}
