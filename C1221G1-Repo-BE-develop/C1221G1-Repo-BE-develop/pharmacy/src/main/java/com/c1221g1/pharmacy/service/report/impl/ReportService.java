package com.c1221g1.pharmacy.service.report.impl;

import com.c1221g1.pharmacy.dto.report.*;
import com.c1221g1.pharmacy.repository.report.IReportRepository;
import com.c1221g1.pharmacy.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IReportRepository iReportRepository;

    /**
     * this method to get revenue and profit in period of time that you input
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @Override
    public List<Revenue> getRevenue(String startTime, String endTime) {
        return this.iReportRepository.getRevenue(startTime, endTime);
    }

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<Revenue> getRevenueByEmployee(String startTime, String endTime) {
        return this.iReportRepository.getRevenueByEmployee(startTime, endTime);
    }

    /**
     * this method to get list of supplier that have receivable or payable
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<SupplierHaveReceivable> getSupplierHaveReceivable() {
        return this.iReportRepository.getSupplierHaveReceivable();
    }

    /**
     * this method to get list medicine to be out of stock
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<MedicineNeedToImport> getMedicineNeedToImport() {
        return this.iReportRepository.getMedicineNeedToImport();
    }

    /**
     * this method to get list medicine to be about out of date
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<MedicineBeAboutExpired> getMedicineBeAboutExpired() {
        return this.iReportRepository.getMedicineBeAboutExpired();
    }

    /**
     * this method to get list 100 medicine that have best sold-out
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<TopMedicine> getTopMedicine() {
        return this.iReportRepository.getTopMedicine();
    }

    /**
     * this method to get list revenue and profit to show static on angular
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<Static> getStatic(String year) {
        List<Static> statics = new ArrayList<Static>();
        statics.add(this.iReportRepository.getMonth1(year));
        statics.add(this.iReportRepository.getMonth2(year));
        statics.add(this.iReportRepository.getMonth3(year));
        statics.add(this.iReportRepository.getMonth4(year));
        statics.add(this.iReportRepository.getMonth5(year));
        statics.add(this.iReportRepository.getMonth6(year));
        statics.add(this.iReportRepository.getMonth7(year));
        statics.add(this.iReportRepository.getMonth8(year));
        statics.add(this.iReportRepository.getMonth9(year));
        statics.add(this.iReportRepository.getMonth10(year));
        statics.add(this.iReportRepository.getMonth11(year));
        statics.add(this.iReportRepository.getMonth12(year));
        return statics;
    }

    /**
     * this method to get list revenue and profit to show static on angular (by month)
     *
     * @author DinhH
     * @Time 20:30 05/07/2022
     */
    @Override
    public List<StacticByMonth> getStaticByMonth(String month, String year) {
        List<StacticByMonth> statics = new ArrayList<StacticByMonth>();
        statics.add(this.iReportRepository.getDay1(month, year));
        statics.add(this.iReportRepository.getDay2(month, year));
        statics.add(this.iReportRepository.getDay3(month, year));
        statics.add(this.iReportRepository.getDay4(month, year));
        statics.add(this.iReportRepository.getDay5(month, year));
        statics.add(this.iReportRepository.getDay6(month, year));
        statics.add(this.iReportRepository.getDay7(month, year));
        statics.add(this.iReportRepository.getDay8(month, year));
        statics.add(this.iReportRepository.getDay9(month, year));
        statics.add(this.iReportRepository.getDay10(month, year));
        statics.add(this.iReportRepository.getDay11(month, year));
        statics.add(this.iReportRepository.getDay12(month, year));
        statics.add(this.iReportRepository.getDay13(month, year));
        statics.add(this.iReportRepository.getDay14(month, year));
        statics.add(this.iReportRepository.getDay15(month, year));
        statics.add(this.iReportRepository.getDay16(month, year));
        statics.add(this.iReportRepository.getDay17(month, year));
        statics.add(this.iReportRepository.getDay18(month, year));
        statics.add(this.iReportRepository.getDay19(month, year));
        statics.add(this.iReportRepository.getDay20(month, year));
        statics.add(this.iReportRepository.getDay21(month, year));
        statics.add(this.iReportRepository.getDay22(month, year));
        statics.add(this.iReportRepository.getDay23(month, year));
        statics.add(this.iReportRepository.getDay24(month, year));
        statics.add(this.iReportRepository.getDay25(month, year));
        statics.add(this.iReportRepository.getDay26(month, year));
        statics.add(this.iReportRepository.getDay27(month, year));
        statics.add(this.iReportRepository.getDay28(month, year));
        statics.add(this.iReportRepository.getDay29(month, year));
        statics.add(this.iReportRepository.getDay30(month, year));
        statics.add(this.iReportRepository.getDay31(month, year));
        return statics;
    }
}
