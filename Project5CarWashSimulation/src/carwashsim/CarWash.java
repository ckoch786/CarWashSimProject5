package carwashsim;

import java.util.Random;

public class CarWash {
   private int numberOfHours;
   private int numberOfMinutes;
   private int customerCount;
   private int totalCustomers;
   private int maxWaitTime;
   Random rand = new Random(); 
   
   public CarWash( ){
	   
   }

public int generateCustomerArrivalTime(){
	int arrivalTime;
	arrivalTime = rand.nextInt(7) + 1;
	
	return arrivalTime;
}
public int generateCustomerServiceTime(){
	int serviceTime;
	
	 
	serviceTime = rand.nextInt(3) + 2;
	return serviceTime;
}
public int calculateShiftTime(){
	int shiftTimeInMin;
	
	shiftTimeInMin = getNumberOfHours() * 60 + getNumberOfMinutes();
	
	return shiftTimeInMin;
}

public void setNumberOfHours(int numberOfHours)     { this.numberOfHours = numberOfHours; }
public void setNumberOfMinutes(int numberOfMinutes) { this.numberOfMinutes = numberOfMinutes; }
public void setCustomerCount(int customerCount)     { this.customerCount = customerCount; }
public void setTotalCustomers(int totalCustomers)   { this.totalCustomers = totalCustomers; }
public void setMaxWaitTime(int maxWaitTime)         { this.maxWaitTime = maxWaitTime; }

public int getMaxWaitTime()     { return maxWaitTime; }
public int getNumberOfHours()   { return numberOfHours;}
public int getNumberOfMinutes() { return numberOfMinutes; }
public int getCustomerCount()   { return customerCount; }
public int getTotalCustomers()  { return totalCustomers; }

}
