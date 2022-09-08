package com.c1221g1.pharmacy.repository.medicine;

import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedicineTypeRepository extends JpaRepository<MedicineType,Integer> {
    @Query(value = "SELECT * FROM medicine_type",nativeQuery = true)
    List<MedicineType> getAll();
}
