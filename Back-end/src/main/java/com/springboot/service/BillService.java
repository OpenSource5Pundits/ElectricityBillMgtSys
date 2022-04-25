package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.exception.BillNotFoundException;
import com.springboot.model.Bill;

@Service
public interface BillService {
	public Bill find(Long id);
	public List<Bill> findAll();
	public void save(Bill bill);
	public void delete(Long id) throws BillNotFoundException;
	public void update(Bill bill) throws BillNotFoundException;
	public List<Bill> getAllUnpaidBills();

}
