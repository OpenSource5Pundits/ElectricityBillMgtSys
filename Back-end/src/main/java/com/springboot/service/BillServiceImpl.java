package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.BillNotFoundException;
import com.springboot.model.Bill;
import com.springboot.repository.BillRepository;
@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillRepository repository;
	
	
	@Override
	public Bill find(Long id) {
		Optional<Bill> o=repository.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		return null;
	}

	@Override
	public List<Bill> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Bill bill) {
		repository.save(bill);
		
	}

	@Override
	public void delete(Long id) throws BillNotFoundException {
Optional<Bill> o=repository.findById(id);
		
		if(o.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new BillNotFoundException("meterNo: " + id);
		}
		
		
	}

	@Override
	public void update(Bill bill) throws BillNotFoundException {
		System.out.println("In service, from browser: "+bill);
		Optional<Bill> o=repository.findById(bill.getMeterNo());
		System.out.println("In service, from db: "+o.get());
		
		if(o.isPresent()) {
			repository.save(bill);
		} else {
			throw new BillNotFoundException("meterNo: " +bill.getMeterNo());
		}
		
	}

	@Override
	public List<Bill> getAllUnpaidBills() {
		return repository.findByPaid();
	}

}
