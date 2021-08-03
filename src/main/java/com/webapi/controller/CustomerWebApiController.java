package com.webapi.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerWebApiController 
{
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customertransactions")
public String getCustomerTransactions() 
{
	File resource;
	try {
		resource = new ClassPathResource("data.json").getFile();
		String transactions = new String(Files.readAllBytes(resource.toPath()));
		return transactions;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "[]";
	}
	
  }
}
