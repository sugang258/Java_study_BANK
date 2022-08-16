package com.gang.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Car {
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;

	public Engine getEngine() {
		return engine;
	}

	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	 //멤버변수 초기화
	   // 1. private Engine engine = new Engine();
	   
	   // Car car = new Car();
	   
	   
	   
	   
	   
	   //3. public Car(){
	   //      this.engine=engine;
	   //}
	   
	   
	   public Car( Wheel leftWheel, Wheel rightWheel) {
		    //this.engine=engine;
		    this.leftWheel= leftWheel;
		    this.rightWheel=rightWheel;
		     
	   }
	   
	//   Engine engine = new Engine();
	//	 Car car = new Car(engine);

	

	
	
	

}
