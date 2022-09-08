package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.repository.employee.IPositionRepository;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:30 29/06/2022
     */
    @Override
    public List<Position> getAllPosition() {
        return this.iPositionRepository.getAllPosition();
    }
}


