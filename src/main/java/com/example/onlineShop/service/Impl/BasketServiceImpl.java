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

import java.util.List;

@Transactional
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Transactional
    public BasketDTO getBasket(Integer id){
        return BasketMap.toDTO(basketRepository.findBasketByBasketId(id));
    }

    public BasketDTO getBasket(UserDTO user){
        if(user == null) return null;
        return BasketMap.toDTO(basketRepository.findBasketByUser(UserMap.toEntity(user)));
    }

    public BasketDTO addBasket(UserDTO user){
        if(user==null) return null;
        BasketDTO basketDTO=new BasketDTO();
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

    public List<ProductDTO> getProductsFromBasket(Integer basketId){

        return getBasket(basketId).getProducts();
    }


}
