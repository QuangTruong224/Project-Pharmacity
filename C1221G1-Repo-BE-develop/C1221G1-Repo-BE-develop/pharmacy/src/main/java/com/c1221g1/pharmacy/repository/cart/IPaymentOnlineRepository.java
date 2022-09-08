package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.dto.cart.PaymentOnlineForLookup;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPaymentOnlineRepository extends JpaRepository<PaymentOnline, Integer> {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database with payment id and customer name
     *
     * @param paymentOnlineIdVal
     * @param customerNameVal
     * @param pageable
     * @return
     */
    @Query(value = "SELECT DATE(time_create)              AS dateCreate,\n" +
            "       TIME(time_create)              AS timeCreate,\n" +
            "       po.payment_id                  AS paymentId,\n" +
            "       c2.customer_name               AS customerName,\n" +
            "       po.note                        AS note,\n" +
            "        (sum(m.medicine_import_price *\n" +
            "           (1 + medicine_retail_sale_profit / 100) / m.medicine_conversion_rate\n" +
            "           * cd.cart_detail_quantity) * (1 - d.discount_value)) AS totalPrice\n" +
            "FROM payment_online po\n" +
            "         JOIN cart c ON po.cart_id = c.cart_id\n" +
            "          JOIN discount d ON c.discount_id = d.discount_id\n" +
            "         JOIN customer c2 ON c.customer_id = c2.customer_id\n" +
            "         JOIN cart_detail cd ON c.cart_id = cd.cart_id\n" +
            "         JOIN medicine m ON cd.medicine_id = m.medicine_id\n" +
            "WHERE po.payment_id LIKE concat('%',:payment_id,'%')\n" +
            "  AND c2.customer_name LIKE concat('%',:customer_name,'%')\n" +
            "GROUP BY c.cart_id",
            countQuery = "SELECT DATE(time_create)              AS dateCreate,\n" +
                    "       TIME(time_create)              AS timeCreate,\n" +
                    "       po.payment_id                  AS paymentId,\n" +
                    "       c2.customer_name               AS customerName,\n" +
                    "       po.note                        AS note,\n" +
                    "        (sum(m.medicine_import_price *\n" +
                    "           (1 + medicine_retail_sale_profit / 100) / m.medicine_conversion_rate\n" +
                    "           * cd.cart_detail_quantity) * (1 - d.discount_value)) AS totalPrice\n" +
                    "FROM payment_online po\n" +
                    "         JOIN cart c ON po.cart_id = c.cart_id\n" +
                    "          JOIN discount d ON c.discount_id = d.discount_id\n" +
                    "         JOIN customer c2 ON c.customer_id = c2.customer_id\n" +
                    "         JOIN cart_detail cd ON c.cart_id = cd.cart_id\n" +
                    "         JOIN medicine m ON cd.medicine_id = m.medicine_id\n" +
                    "WHERE po.payment_id LIKE concat('%',:payment_id,'%')\n" +
                    "  AND c2.customer_name LIKE concat('%',:customer_name,'%')\n" +
                    "GROUP BY c.cart_id", nativeQuery = true)
    Page<PaymentOnlineForLookup> findPaymentOnlineByIdAndCustomerName(@Param("payment_id") String paymentOnlineIdVal,
                                                                      @Param("customer_name") String customerNameVal,
                                                                      Pageable pageable);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database of customer have same name of parameter customer name
     *
     * @param customerNameVal
     * @param pageable
     * @return
     */
    @Query(value = "SELECT DATE(time_create)              AS dateCreate,\n" +
            "       TIME(time_create)              AS timeCreate,\n" +
            "       po.payment_id                  AS paymentId,\n" +
            "       c2.customer_name               AS customerName,\n" +
            "       po.note                        AS note,\n" +
            "       sum(m.medicine_import_price *\n" +
            "           (1 + medicine_retail_sale_profit / 100) / m.medicine_conversion_rate\n" +
            "           * cd.cart_detail_quantity) AS totalPrice\n" +
            "FROM payment_online po\n" +
            "         JOIN cart c ON po.cart_id = c.cart_id\n" +
            "         JOIN customer c2 ON c.customer_id = c2.customer_id\n" +
            "         JOIN cart_detail cd ON c.cart_id = cd.cart_id\n" +
            "         JOIN medicine m ON cd.medicine_id = m.medicine_id\n" +
            "WHERE c2.customer_name LIKE concat('%',:customer_name,'%')\n" +
            "GROUP BY c.cart_id",
            countQuery = "SELECT DATE(time_create)              AS dateCreate,\n" +
                    "       TIME(time_create)              AS timeCreate,\n" +
                    "       po.payment_id                  AS paymentId,\n" +
                    "       c2.customer_name               AS customerName,\n" +
                    "       po.note                        AS note,\n" +
                    "       sum(m.medicine_import_price *\n" +
                    "           (1 + medicine_retail_sale_profit / 100) / m.medicine_conversion_rate\n" +
                    "           * cd.cart_detail_quantity) AS totalPrice\n" +
                    "FROM payment_online po\n" +
                    "         JOIN cart c ON po.cart_id = c.cart_id\n" +
                    "         JOIN customer c2 ON c.customer_id = c2.customer_id\n" +
                    "         JOIN cart_detail cd ON c.cart_id = cd.cart_id\n" +
                    "         JOIN medicine m ON cd.medicine_id = m.medicine_id\n" +
                    "WHERE c2.customer_name LIKE concat('%',:customer_name,'%')\n" +
                    "GROUP BY c.cart_id",
            nativeQuery = true)
    Page<PaymentOnlineForLookup> findAllPaymentOnlineByCustomerName(@Param("customer_name") String customerNameVal, Pageable pageable);
}
