package com.example.carrentalservicee.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicle_id;
	@Column
	private int vehicle_seating_capacity;
	@Column
	private double vehicle_price_per_km;
	@Column
	private String vehicle_name;
	@Column
	private String vehicle_brand_name;
	@Column
	private String vehicle_type;
	@Column
	private String vehicle_fuel_type;
	
	public Vehicle(int vehicle_seating_capacity, double vehicle_price_per_km, String vehicle_name,
			String vehicle_brand_name, String vehicle_type, String vehicle_fuel_type) {
		this.vehicle_seating_capacity = vehicle_seating_capacity;
		this.vehicle_price_per_km = vehicle_price_per_km;
		this.vehicle_name = vehicle_name;
		this.vehicle_brand_name = vehicle_brand_name;
		this.vehicle_type = vehicle_type;
		this.vehicle_fuel_type = vehicle_fuel_type;
	}
	
	public Vehicle(int vehicle_id, int vehicle_seating_capacity, double vehicle_price_per_km, String vehicle_name,
			String vehicle_brand_name, String vehicle_type, String vehicle_fuel_type) {
		this.vehicle_id = vehicle_id;
		this.vehicle_seating_capacity = vehicle_seating_capacity;
		this.vehicle_price_per_km = vehicle_price_per_km;
		this.vehicle_name = vehicle_name;
		this.vehicle_brand_name = vehicle_brand_name;
		this.vehicle_type = vehicle_type;
		this.vehicle_fuel_type = vehicle_fuel_type;
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public int getVehicle_seating_capacity() {
		return vehicle_seating_capacity;
	}
	public void setVehicle_seating_capacity(int vehicle_seating_capacity) {
		this.vehicle_seating_capacity = vehicle_seating_capacity;
	}
	public double getVehicle_price_per_km() {
		return vehicle_price_per_km;
	}
	public void setVehicle_price_per_km(double vehicle_price_per_km) {
		this.vehicle_price_per_km = vehicle_price_per_km;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getVehicle_brand_name() {
		return vehicle_brand_name;
	}
	public void setVehicle_brand_name(String vehicle_brand_name) {
		this.vehicle_brand_name = vehicle_brand_name;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getVehicle_fuel_type() {
		return vehicle_fuel_type;
	}
	public void setVehicle_fuel_type(String vehicle_fuel_type) {
		this.vehicle_fuel_type = vehicle_fuel_type;
	}
} //End of Class Vehicle