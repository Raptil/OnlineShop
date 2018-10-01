package com.example.onlineShop.service.Impl;

import com.example.onlineShop.domain.dto.BasketDTO;
import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.domain.mapper.BasketMap;
import com.example.onlineShop.domain.mapper.UserMap;
import com.example.onlineShop.repository.BasketRepository;
import com.example.onlineShop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Transactional
    public BasketDTO getBasket(Integer id){
        return BasketMap.toDTO(basketRepository.findBasketByBasketId(id));
    }

    public BasketDTO getBasket(UserDTO user){
        if(user == null) return null;
        return BasketMap.toDTO(basketRepository.findBasketByUser(UserMap.toEntity(user)));
    }

    public BasketDTO addBasket(BasketDTO basketDTO,UserDTO user){
        if(user==null) return null;
        basketDTO.setUser(user);
        return BasketMap.toDTO(basketRepository.save(BasketMap.toEntity(basketDTO)));
    }

    public void addProductToBasket(ProductDTO product,Integer basketId){
        BasketDTO basketDTO=getBasket(basketId);
        List<ProductDTO> products = basketDTO.getProducts();
        products.add(product);
        basketDTO.setTotalCost(basketDTO.getTotalCost()+product.getCost());
        basketDTO.setProducts(products);
        basketRepository.save(BasketMap.toEntity(basketDTO));
    }

    public BasketDTO addProductToBasket(ProductDTO productDTO,BasketDTO basketDTO){
        List<ProductDTO> products;
        if(basketDTO.getProducts()==null)products=new ArrayList<>();
        else products=basketDTO.getProducts();
        products.add(productDTO);
        basketDTO.setTotalCost(basketDTO.getTotalCost()+productDTO.getCost());
        basketDTO.setProducts(products);
        return basketDTO;
    }

    public List<ProductDTO> getProductsFromBasket(Integer basketId){

        return getBasket(basketId).getProducts();
    }


}
