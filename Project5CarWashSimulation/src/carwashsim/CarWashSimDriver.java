package carwashsim;

import java.util.Scanner;

import carwashsim.queue.ArrayUnbndQueue;
import carwashsim.queue.QueueUnderFlowException;

public class CarWashSimDriver {
public void GUIDriver() throws QueueUnderFlowException{
	ArrayUnbndQueue<Integer> serviceLine = new ArrayUnbndQueue<Integer>();
	CarWash shift = new CarWash();
	Scanner stdin = new Scanner(System.in);
	int numberOfHours;
	int numberOfMinutes;
	int customerCount; 
	int arrivalTime;
	int serviceTime;
	int lengthOfShiftInMin;
	int carWashAvailable;
	int waitTime;
	
	int waitTotal;
	int irritatedCustomer;
	waitTotal = 0;
	irritatedCustomer = 0;
	

	
	/**
	 * Read in the number of hours and number of minutes for
	 * the car wash shift.
	 */
	System.out.print("Enter the shifts hours: ");
	numberOfHours = stdin.nextInt();
	shift.setNumberOfHours(numberOfHours);
	System.out.println("");
	System.out.print("Enter the shift minutes: ");
	numberOfMinutes = stdin.nextInt();
	shift.setNumberOfMinutes(numberOfMinutes);
	
	lengthOfShiftInMin = shift.calculateShiftTime();
	
	/**
	 *  Initialize any required counters.
	 */
	customerCount    = 0;
	serviceTime      = 0;
	arrivalTime      = 0;
	carWashAvailable = 0;
	waitTime         = 0;
	

	/**
	 * Generate the next customer's service time
	 */
	serviceTime = shift.generateCustomerServiceTime();
	System.out.println("The first service time is:  " + serviceTime); //TODO remove
	
	/**
	 * Generate a random number from 1 to 8 to determine
	 * the minute the first customer will arrive. The customer's car
	 * wash will begin immediately, that is upon arrival.
	 */
	arrivalTime = shift.generateCustomerArrivalTime();
	System.out.println("The first arrial time is:  " + arrivalTime); //TODO remove
	/**
	 * TODO 
	 *for each minute of the shift:
		if(the time matches the next customer's arrival time)
				print a message that a customer has arrived
				enqueue the customers arrival time
				Schedual the arrival time for the next customer(in the next 1)
				to 8 minutes.
				Customercount++
		if (The time is the next customer's service time (i.e. the
		car wash is free)
			print a message that a customer has started service
			dequeue the customer's arrival time
			Function():
				calculate the customer's wait time
			determine this customer's service time( 2 to 5 min) and
			Function():
				calculate the next time the wash will be free and
				thus a new customer can begin service
		
	 */
	//TODO remove
	System.out.println("Hours: "+shift.getNumberOfHours());
	System.out.println("Minutes: "+shift.getNumberOfMinutes());
	System.out.println("Shift time in Min: "+ lengthOfShiftInMin);
	
	for(int i = 1; i < lengthOfShiftInMin; i++ ) {
		
		//System.out.println("The shift has begun! The time is" + i);//TODO remove
		if(i == arrivalTime) {
			
			System.out.println("A customer[" +i +"] has arrived");
			customerCount++;
			shift.setCustomerCount(customerCount);
			serviceLine.enqueue(arrivalTime);
			arrivalTime = shift.generateCustomerArrivalTime() + arrivalTime;
		}else if(arrivalTime > serviceTime || waitTime > serviceTime){
			System.out.println("Customer has started service.");
			if(serviceLine.isEmpty()) throw new QueueUnderFlowException("Dequeue attempted on an empty queue, there are no customers.");
			else 					  serviceLine.dequeue();
			waitTime = calculateWaitTime(serviceTime, arrivalTime); //Calculate wait time
			irritatedCustomer++;
			waitTotal += waitTime; //Use for calculation of average wait time.
			serviceTime = shift.generateCustomerServiceTime() + arrivalTime;
			//carWashAvailable = //TODO calculate the next time the wash will be free 
		}	
		
	}
		
	/**
	 * TODO
	 * At the completion of the shift, report the following
	 * Total number of customers served
	 * Number of customers still waiting
	 * Average wait time
	 * Maximum number in line at one time
	 */
	System.out.println("");
	System.out.println("Number of customers served: " + customerCount);
	System.out.println("Number of customers still waiting: ");//TODO
	System.out.println("Average wait time: " + calculateAverageWaitTime(waitTotal, irritatedCustomer));//TODO
	System.out.println("Maximum number in line at one time: ");
	
}

private static int calculateWaitTime(int serviceTime, int arrivalTime) {
	int waitTime;
	
	waitTime = arrivalTime - serviceTime;
	System.out.println("Angery customer++ Time waited: " +waitTime );

	return waitTime;
}
private static int calculateAverageWaitTime(int waitTotal, int irritatedCustomer){
	int averageWaitTime;
	
	averageWaitTime = waitTotal / irritatedCustomer;
	
	return averageWaitTime;
}
}
