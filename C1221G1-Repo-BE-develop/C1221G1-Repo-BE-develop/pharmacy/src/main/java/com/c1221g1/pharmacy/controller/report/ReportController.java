package com.c1221g1.pharmacy.controller.report;

import com.c1221g1.pharmacy.dto.report.*;
import com.c1221g1.pharmacy.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping(value = "/api/manager-report/report")
@RestController
public class ReportController {
    @Autowired
    private IReportService iReportService;

    /**
     * this method to get revenue in period of time that you input
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @GetMapping("/revenue")
    public ResponseEntity<List<Revenue>> getRevenue(@RequestParam Optional<String> startTime,
                                                    @RequestParam Optional<String> endTime) {
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal) || "".equals(endTimeVal)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenue(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }
    }

    /**
     * this method to get profit in period of time that you input
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @GetMapping("/profit")
    public ResponseEntity<List<Revenue>> getProfit(@RequestParam Optional<String> startTime,
                                                   @RequestParam Optional<String> endTime) {
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal) || "".equals(endTimeVal)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenue(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }

    }

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @GetMapping("/diary")
    public ResponseEntity<List<Revenue>> getRevenueByEmployee(@RequestParam Optional<String> startTime,
                                                              @RequestParam Optional<String> endTime) {
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal) || "".equals(endTimeVal)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenueByEmployee(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }
    }

    /**
     * this method to get list of supplier that have receivable or payable
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @GetMapping("/supplier")
    public ResponseEntity<List<SupplierHaveReceivable>> getSupplierHaveReceivable() {
        List<SupplierHaveReceivable> supplierHaveReceivableList = this.iReportService.getSupplierHaveReceivable();
        if (supplierHaveReceivableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierHaveReceivableList, HttpStatus.OK);
    }

    /**
     * this method to get list medicine to be out of stock
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @GetMapping("/medicineNeedToImport")
    public ResponseEntity<List<MedicineNeedToImport>> getMedicineNeedToImport() {
        List<MedicineNeedToImport> medicineNeedToImports = this.iReportService.getMedicineNeedToImport();
        if (medicineNeedToImports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineNeedToImports, HttpStatus.OK);
    }

    /**
     * this method to get list medicine to be about out of date
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @GetMapping("/medicineBeAboutExpired")
    public ResponseEntity<List<MedicineBeAboutExpired>> getMedicineBeAboutExpired() {
        List<MedicineBeAboutExpired> medicineBeAboutExpired = this.iReportService.getMedicineBeAboutExpired();
        if (medicineBeAboutExpired.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineBeAboutExpired, HttpStatus.OK);
    }

    /**
     * this method to get list 100 medicine that have best sold-out
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @GetMapping("/topMedicine")
    public ResponseEntity<List<TopMedicine>> getTopMedicine() {
        List<TopMedicine> topMedicines = this.iReportService.getTopMedicine();
        if (topMedicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(topMedicines, HttpStatus.OK);
    }

    /**
     * this method to get list revenue and profit to show static on angular
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @GetMapping("/static")
    public ResponseEntity<List<Static>> getStatic(@RequestParam Optional<String> year) {
        String yearVal = year.orElse("");
        List<Static> statics = this.iReportService.getStatic(yearVal);
        if (statics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statics, HttpStatus.OK);
    }

    /**
     * this method to get list revenue and profit to show static on angular (by month)
     *
     * @author DinhH
     * @Time 20:30 05/07/2022
     */
    @GetMapping("/staticByMonth")
    public ResponseEntity<List<StacticByMonth>> getStaticByMonth(@RequestParam Optional<String> month,
                                                                 @RequestParam Optional<String> year) {
        String monthVal = month.orElse("");
        String yearVal = year.orElse("");
        List<StacticByMonth> statics = this.iReportService.getStaticByMonth(monthVal,yearVal);
        if (statics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statics, HttpStatus.OK);
    }
}
