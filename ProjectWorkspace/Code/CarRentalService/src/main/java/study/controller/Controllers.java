package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.MyRepository;
import study.entity.Vehicle;

@RestController
@RequestMapping("controller")
public class Controllers {

	@Autowired
	MyRepository repo; 
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}

	@GetMapping("/getVehicleDetails")
	public List<Vehicle> getVehicleDetails() {
		List<Vehicle> list = repo.findAll();
		for (Vehicle vehicle : list) {
			System.out.print(vehicle);
		}
		return list;
	}
} //end of Class Controllers
