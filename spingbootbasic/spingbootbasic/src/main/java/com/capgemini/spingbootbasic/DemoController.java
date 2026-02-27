package com.capgemini.spingbootbasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;

@RestController 
public class DemoController {
	
	//reference for jpa repository
	@Autowired
	CarJpaRepository carjpa;
	
	
	
	//@GetMapping("/a")
	//@ResponseBody
	@PostMapping("/a")
	public List<String> hello() {
		return List.of("Miller","Brevis","Saavi");
	} 
	
	//send cricket object
	@PostMapping("/add") 
	public String createPlayer(@RequestBody Cricketer c) {
		System.out.println(c);
		return c.toString(); 
		
	}
	
	@PostMapping("/car")
	public String createCar(@RequestBody Car c1) {
		//System.out.println(c1);
		Car car = carjpa.save(c1); 
		return car.toString();
	}
	
	@PostMapping("/person")
	public String createItem(@RequestBody Person i) {
		System.out.println(i);
		return i.toString();
	}
	
	@PostMapping("/student")
	public String createStudent(@RequestBody College c2) {
		System.out.println(c2);
		return c2.toString();
		
	}
	
	//CRUD OPERATIONS 
	
//	@GetMapping("/find-id")
//	//http://localhost:8080/find-id/?id=1
//	public String getById(@RequestParam int id) {
//		Optional<Car> option = carjpa.findById(id);
//		return option.isPresent()?option.get().toString():"Data Not Exist"; 
//	}
	
	@GetMapping("/find-id")
	//http://localhost:8080/find-id/?id=1
	public Car getById(@RequestParam int id) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car c = option.get();
			return c;
			
		} else {
			throw new DataNotExist();
		}
		 
	} 
	
	
	@DeleteMapping("/delete-id/{id}") 
	//http://localhost:8080/delete-id/1
	public boolean deleteCar(@PathVariable int id) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			carjpa.delete(option.get());
			return true;
		} else {
			return false;
		}
	}
	
	
	//http://localhost:8080/update-car/1
	//{
    //"brand":"BMW",
    //"price":80000
    //}
	@PutMapping("/update-car/{id}")
	public boolean updateCar(@PathVariable int id,  @RequestBody Car c) { 
		
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car car = option.get();
			car.setBrand(c.getBrand());
			car.setPrice(c.getPrice()); 
			carjpa.save(car);
			return true;
		} else {
			return false;
		}
		
	}
	
	//put mapping  we use to update both brand and price
	//use patch mapping  for updating only one either price or brand
	
	
	//http://localhost:8080/update-car/2
	//{
    //"brand":"Alto",
    //"price":60000
     //} 
	@PatchMapping("/update-car/{id}")
	public boolean updateCarData(@PathVariable int id,  @RequestBody Car c) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car car = option.get();
			if(c.getBrand() != null) {
				car.setBrand(c.getBrand());
			} else if(c.getPrice() != 0.0) {
				car.setPrice(c.getPrice());
			}
			carjpa.save(car);
			return true;
			
		} else {
			return false;
		}
		
	}
	
	//by car price not by primary key
	//http://localhost:8080/find-price/60000
	//{
    //"brand":"Alto",
    //"price":60000 
     //}
	//output
	/*{
	    "brand": "Alto",
	    "price": 60000.0,
	    "engine": null
	}*/
	@GetMapping("/find-price/{price}")
	public Car getCarByPrice(@PathVariable double price) {
		return carjpa.getByPrice(price);
		
	}
	
	@DeleteMapping("/delete-brand/{brand}") 
	//http://localhost:8080/delete-id/1
	public boolean deleteCar(@PathVariable String brand) {
		int count = carjpa.deleteByBrand(brand); 
		return count > 0;
	
	}
	
	

}
