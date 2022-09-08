package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.dto.cart.CartDtoForList;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.cart.ICartDetailRepository;
import com.c1221g1.pharmacy.repository.cart.ICartRepository;
import com.c1221g1.pharmacy.service.cart.ICartDetailService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService {
    @Autowired
    private ICartDetailRepository iCartDetailRepository;

    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private IMedicineService iMedicineService;

    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: check exist of cart and medicine object. if not exist then add error into bindingResult
     *
     * @param cartDetailDto
     * @param bindingResult
     */
    @Override
    public void checkExistOfLinksObject(List<CartDetailDto> cartDetailDtos, BindingResult bindingResult) {
        int i = 0;

        for (CartDetailDto cartDetail : cartDetailDtos) {
            String medicineId = cartDetail.getMedicine().getMedicineId();
            String medicineName = cartDetail.getMedicine().getMedicineName();
            Long quatityInStorage = this.iMedicineStorageService.checkMedicineQuantity(medicineId);
            if (this.iMedicineStorageService.checkExistInMedicineStorage(medicineId)) {
                if (quatityInStorage < 1) {
                    bindingResult.pushNestedPath("cartDetail[" + i + "]");
                    bindingResult.rejectValue("medicine", "medicine.soldOut", medicineName + " hiện tại đã hết hàng");
                    bindingResult.popNestedPath();
                } else if (cartDetail.getQuantity() > quatityInStorage) {
                    bindingResult.pushNestedPath("cartDetail[" + i + "]");
                    bindingResult.rejectValue("medicine", "medicine.tooMuch",
                            medicineName + " hiện tại chỉ còn " + quatityInStorage + " sản phẩm");
                    bindingResult.popNestedPath();
                }
            } else {
                bindingResult.pushNestedPath("cartDetail[" + i + "]");
                bindingResult.rejectValue("medicine", "medicine.soldOut", medicineName + " hiện tại đã hết hàng");
                bindingResult.popNestedPath();
            }
            i++;
        }
    }

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: save new cart detail to databse
     *
     * @param cartDetail
     */
    @Override
    public void save(CartDetail cartDetail) {
        this.iCartDetailRepository.save(cartDetail);
    }

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Update detail of item in cart, when user change quantity (Add to cart, remove from cart, reduce quantity
     *
     * @param cartDetail
     */
    @Override
    public void updateItemCartDetail(CartDetail cartDetail) {
    }

    @Override
    public List<CartDtoForList> getListByCartId(Integer cartId) {
        return this.iCartDetailRepository.findCartDetailByCartId(cartId, false);
    }
}
