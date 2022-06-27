package models;

import java.util.ArrayList;
import java.util.List;

public class Truck {  
private int id, destiny;
private String model,driver,totalKm,currentLocation;  

//constructor


public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	this.driver = driver;
}

public String getTotalKm() {
	return totalKm;
}

public void setTotalKm(String totalKm) {
	this.totalKm = totalKm;
}

public String getCurrentLocation() {
	return currentLocation;
}

public void setCurrentLocation(String currentLocation) {
	this.currentLocation = currentLocation;
}

public int getDestiny() {
	return destiny;
}

public void setDestiny(int destiny) {
	this.destiny = destiny;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}  
  
}  