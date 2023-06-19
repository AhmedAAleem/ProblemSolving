package com.sales.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sales.jdbc.service.InvoiceServiceJDBC;
import com.sales.jdbc.model.*;

@RestController
@RequestMapping("/v1/student")
public class InoiceController {
	
	@Autowired
	private InvoiceServiceJDBC invoiceServiceJDBC;

	@PostMapping("/hello")
	public String greetings() {
		return "Hello";
	}

	@PostMapping("/")
	public List<Student> getAllStudents() throws Exception {
		try {
			return invoiceServiceJDBC.getStudents();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") int id) throws Exception {
		try {
			return invoiceServiceJDBC.getStudent(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/{id}")
	public Student updateStudent( @RequestBody Student student ,@PathVariable("id") int id ) throws Exception {
		try {
			 return invoiceServiceJDBC.updateStudent(student,id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	 		return null;
	}

	@PostMapping("/insert")
	public Student insertStudent( @RequestBody Student student) throws Exception {
		try {
			return invoiceServiceJDBC.insertStudent(student);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id) throws Exception {
		try {
			 invoiceServiceJDBC.deleteStudent(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
