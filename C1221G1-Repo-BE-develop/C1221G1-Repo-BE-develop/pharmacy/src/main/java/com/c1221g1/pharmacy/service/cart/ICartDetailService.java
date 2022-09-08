package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.dto.cart.CartDtoForList;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ICartDetailService {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: check exist of cart and medicine object. if not exist then add error into bindingResult
     *
     * @param cartDetailDto
     * @param bindingResult
     */
    void checkExistOfLinksObject(List<CartDetailDto> cartDetailDto, BindingResult bindingResult);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: save new cart detail to databse
     *
     * @param cartDetail
     */
    void save(CartDetail cartDetail);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Update detail of item in cart, when user change quantity (Add to cart, remove from cart, reduce quantity
     *
     * @param cartDetail
     */
    void updateItemCartDetail(CartDetail cartDetail);

    List<CartDtoForList> getListByCartId(Integer cartId);
}
