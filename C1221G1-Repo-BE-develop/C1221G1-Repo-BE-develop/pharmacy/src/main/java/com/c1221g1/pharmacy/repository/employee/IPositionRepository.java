package com.c1221g1.pharmacy.repository.employee;


import com.c1221g1.pharmacy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IPositionRepository extends JpaRepository<Position,Integer> {
    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:30 29/06/2022
     */
    @Query(value = "select position_id,position_name from position",nativeQuery=true)
    List<Position> getAllPosition();
    @Override
    List<Position> findAll();
}
