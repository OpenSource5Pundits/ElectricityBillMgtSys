package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Bill;
import com.springboot.service.BillService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  

@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService service;
	
	@PostMapping("/insert")
	public HttpStatus generateBill(@RequestBody Bill bill) {
		try {
			service.save(bill);
			return HttpStatus.CREATED;
		} catch (Exception e) {
			return HttpStatus.FOUND;
		}
	}
	
	@PutMapping("/update") 
	public HttpStatus update(@RequestBody Bill bill) {
		System.out.println(bill);
		
		try {
			service.update(bill);
			return HttpStatus.ACCEPTED;
		} catch (Exception e) {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@GetMapping("/findAll") 
	public List<Bill> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Object find(@PathVariable Long id) {
		try {
			Bill bill=service.find(id);
			return bill;
		} catch (Exception e) {
			return HttpStatus.NOT_FOUND;
		}
	}
	 
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return HttpStatus.OK;
		} catch(Exception e) {
			return HttpStatus.NOT_FOUND;
		}
	}

	@GetMapping("/findByP")
	public List<Bill> getAllUnpaidBills() {
		return service.getAllUnpaidBills();
	}
	

}
