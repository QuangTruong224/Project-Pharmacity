package com.c1221g1.pharmacy.service.invoice.impl;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.medicine.MedicineStorage;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.repository.invoice.IInvoiceMedicineRepository;
import com.c1221g1.pharmacy.repository.medicine.IMedicineRepository;
import com.c1221g1.pharmacy.service.invoice.IInvoiceMedicineService;
import com.c1221g1.pharmacy.service.invoice.IInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceMedicineService implements IInvoiceMedicineService {

    @Autowired
    private IInvoiceMedicineRepository invoiceMedicineRepository;

    @Autowired
    private IInvoiceService iInvoiceService;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /*
     * Created by DaLQA
     * Time: 10:30 PM 29/06/2022
     * Function: function createInvoiceMedicine
     * */
    @Override
    public boolean saveInvoiceMedicine(InvoiceDto invoiceDto) throws Exception {
        List<InvoiceMedicineDto> invoiceMedicineList = invoiceDto.getInvoiceMedicineList();
        List<String> listErrorQuantity = new ArrayList<>();
        for (InvoiceMedicineDto item : invoiceMedicineList) {
            MedicineStorage medicineStorage = this.iMedicineStorageService
                    .getStorageByIdMedicine(item.getMedicineId()).orElse(null);
            Long quantityCurrentMedicine = medicineStorage.getMedicineQuantity();
            if (quantityCurrentMedicine - item.getQuantity() < 0) {
                listErrorQuantity.add(medicineStorage.getMedicine().getMedicineName());
            }
            medicineStorage.setMedicineQuantity(quantityCurrentMedicine - item.getQuantity());
        }
        if (!listErrorQuantity.isEmpty()) {
            throw new Exception(listErrorQuantity.toString());
        }
        invoiceDto.setTypeOfInvoiceId(1);
        Employee employee = this.iEmployeeRepository.findEmployeeById(invoiceDto.getEmployeeId());
        Customer customer = this.iCustomerRepository.findByCustomerId(invoiceDto.getCustomerId());
        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
        typeOfInvoice.setTypeOfInvoiceId(1);
        Invoice invoice = new Invoice();
        invoice.setEmployee(employee);
        invoice.setCustomer(customer);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        invoice.setTypeOfInvoice(typeOfInvoice);
        Invoice newInvoice = iInvoiceService.saveInvoice(invoice);

        for (InvoiceMedicineDto invoiceMedicineDto : invoiceMedicineList) {
            InvoiceMedicine invoiceMedicine = new InvoiceMedicine();
            Medicine medicine = iMedicineRepository.findById(invoiceMedicineDto.getMedicineId()).orElse(null);
            invoiceMedicine.setMedicine(medicine);
            invoiceMedicine.setInvoice(newInvoice);
            invoiceMedicine.setInvoiceMedicineQuantity(invoiceMedicineDto.getQuantity());
            this.invoiceMedicineRepository.save(invoiceMedicine);
        }
        if (newInvoice != null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Created by TrinhNN
     * Function: function find invoice by invoice id
     * */
    @Override
    public List<InvoiceMedicine> findByInvoiceId(String id) {
        return invoiceMedicineRepository.findByInvoiceId(id);
    }

    /*
     * Created by TrinhNN
     * Function: function create Wholesale Invoice Medicine
     * */
    @Override
    public boolean saveWholesaleInvoiceMedicine(InvoiceDto invoiceDto) throws Exception{
        List<InvoiceMedicineDto> invoiceMedicineList = invoiceDto.getInvoiceMedicineList();
        for (InvoiceMedicineDto item : invoiceMedicineList) {
            iMedicineStorageService.changeMedicineQuantity(item.getMedicineId(),Long.parseLong(item.getQuantity().toString()),0);
        }
        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
        typeOfInvoice.setTypeOfInvoiceId(2);
        Employee employee = this.iEmployeeRepository.findById(invoiceDto.getEmployeeId()).orElse(null);
        Customer customer = this.iCustomerRepository.findById(invoiceDto.getCustomerId()).orElse(null);
        Invoice invoice = new Invoice();
        invoice.setEmployee(employee);
        invoice.setCustomer(customer);
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        Invoice newInvoice = iInvoiceService.saveInvoice(invoice);

        for (InvoiceMedicineDto invoiceMedicineDto : invoiceMedicineList) {
            InvoiceMedicine invoiceMedicine = new InvoiceMedicine();
            Medicine medicine = iMedicineRepository.findById(invoiceMedicineDto.getMedicineId()).orElse(null);
            invoiceMedicine.setMedicine(medicine);
            invoiceMedicine.setInvoice(newInvoice);
            invoiceMedicine.setInvoiceMedicineQuantity(invoiceMedicineDto.getQuantity());
            this.invoiceMedicineRepository.save(invoiceMedicine);
        }
        if (newInvoice != null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Created by TrinhNN
     * Function: function create Refund Invoice Medicine
     * */
    @Override
    public boolean saveRefundInvoiceMedicine(InvoiceDto invoiceDto) {
        List<InvoiceMedicineDto> invoiceMedicineList = invoiceDto.getInvoiceMedicineList();
        for (InvoiceMedicineDto item : invoiceMedicineList) {
            iMedicineStorageService.changeMedicineQuantity(item.getMedicineId(),Long.parseLong(item.getQuantity().toString()),2);
        }
        TypeOfInvoice typeOfInvoice = new TypeOfInvoice();
        typeOfInvoice.setTypeOfInvoiceId(3);
        Employee employee = this.iEmployeeRepository.findById(invoiceDto.getEmployeeId()).orElse(null);
        Customer customer = this.iCustomerRepository.findById(invoiceDto.getCustomerId()).orElse(null);
        Invoice invoice = new Invoice();
        invoice.setEmployee(employee);
        invoice.setCustomer(customer);
        invoice.setTypeOfInvoice(typeOfInvoice);
        invoice.setInvoiceNote(invoiceDto.getInvoiceNote());
        Invoice newInvoice = iInvoiceService.saveInvoice(invoice);

        for (InvoiceMedicineDto invoiceMedicineDto : invoiceMedicineList) {
            InvoiceMedicine invoiceMedicine = new InvoiceMedicine();
            Medicine medicine = iMedicineRepository.findById(invoiceMedicineDto.getMedicineId()).orElse(null);
            invoiceMedicine.setMedicine(medicine);
            invoiceMedicine.setInvoice(newInvoice);
            invoiceMedicine.setInvoiceMedicineQuantity(invoiceMedicineDto.getQuantity());
            this.invoiceMedicineRepository.save(invoiceMedicine);
        }
        if (newInvoice != null) {
            return true;
        } else {
            return false;
        }
    }
}