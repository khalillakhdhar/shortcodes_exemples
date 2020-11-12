package com.j3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.j3.exception.ResourceNotFoundException;
import com.j3.model.Admin;
import com.j3.model.repository.AdminRepository;

@RestController
public class AdminController {

	@Autowired
	AdminRepository adminRepository;
	@GetMapping("admins")
	public List<Admin> getAllAdmins()
	{
		return (List<Admin>) adminRepository.findAll();
		
		
	}
	@PostMapping("admins")
	public Admin addAdmin(@Valid @RequestBody Admin admin)
	{
		
		return adminRepository.save(admin);
		
	}
	// Get a Single Utilisateur
	@GetMapping("/admins/{id}")
	public Admin getAdminById(@PathVariable(value = "id") Long adminId) {
	    return adminRepository.findById(adminId)
	            .orElseThrow(() -> new ResourceNotFoundException("admin", "id", adminId));
	}
	  
	// Delete a Utilisateur
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId) {
	    Admin admin = adminRepository.findById(adminId)
	            .orElseThrow(() -> new ResourceNotFoundException("admin", "id", adminId));

	    adminRepository.delete(admin);

	    return ResponseEntity.ok().build();
	}
	
	
}
