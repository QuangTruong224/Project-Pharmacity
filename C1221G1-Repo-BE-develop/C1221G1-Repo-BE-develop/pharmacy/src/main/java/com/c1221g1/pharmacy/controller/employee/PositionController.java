package com.c1221g1.pharmacy.controller.employee;

import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/manager-position/positions")
public class PositionController {
    @Autowired
    private IPositionService iPositionService;
    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:30 29/06/2022
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positionList = this.iPositionService.getAllPosition();
        if(positionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positionList,HttpStatus.OK);
    }
}
