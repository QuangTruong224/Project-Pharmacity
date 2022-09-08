package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.dto.cart.CartDtoForList;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Integer> {
    @Query(value = "SELECT cd.cart_detail_quantity            AS quantity,\n" +
            "       ((m.medicine_import_price +\n" +
            "         (m.medicine_import_price * m.medicine_retail_sale_profit / 100)\n" +
            "            ) / medicine_conversion_rate) AS price,\n" +
            "       cd.cart_id                         AS cartId,\n" +
            "       m.medicine_image                        medicineImage,\n" +
            "       m.medicine_name                        medicineName,\n" +
            "       d.discount_value                   AS discount\n" +
            "FROM cart_detail cd\n" +
            "         JOIN cart c ON cd.cart_id = c.cart_id\n" +
            "         JOIN medicine m ON cd.medicine_id = m.medicine_id\n" +
            "         JOIN discount d ON c.discount_id = d.discount_id\n" +
            "WHERE c.cart_status = :status\n" +
            "AND c.cart_id = :cartId", nativeQuery = true)
    List<CartDtoForList> findCartDetailByCartId(@Param("cartId") Integer cartId, @Param("status") boolean status);
}
