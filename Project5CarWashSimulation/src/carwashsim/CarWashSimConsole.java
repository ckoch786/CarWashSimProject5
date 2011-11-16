package carwashsim;
import java.util.Scanner;
import carwashsim.queue.ArrayUnbndQueue;
import carwashsim.queue.QueueUnderFlowException;


public class CarWashSimConsole {
	public static boolean carWashIsFree() {
		
		if() return true;
		
		else
			return false;
	}
	
	
	public static void main (String[] args) throws QueueUnderFlowException{
		ArrayUnbndQueue<Integer> serviceLine = new ArrayUnbndQueue<Integer>();
		CarWash shift = new CarWash();
		Scanner stdin = new Scanner(System.in);
		int numberOfHours;
		int numberOfMinutes;
		int customerCount; 
		int arrivalTime;
		int serviceTime;
		int lengthOfShiftInMin;
		
	
		
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
		customerCount = 0;
		
	
		/**
		 * Generate the next customer's service time
		 */
		serviceTime = shift.generateCustomerServiceTime();
		
		/**
		 * Generate a random number from 1 to 8 to determine
		 * the minute the first customer will arrive. The customer's car
		 * wash will begin immediately, that is upon arrival.
		 */
		arrivalTime = shift.generateCustomerArrivalTime();
		
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
			
			System.out.println("The shift has begun!");//TODO remove
			if(i == arrivalTime) {
				System.out.print("A customers has arrived.");
				customerCount++;
				shift.setCustomerCount(customerCount);
				serviceLine.enqueue(arrivalTime);
				arrivalTime = shift.generateCustomerArrivalTime();
			}else if(carWashIsFree()){
				System.out.print("Customer has started service.");
				if(serviceLine.isEmpty()) throw new QueueUnderFlowException("There are no customers.");
				else 					  serviceLine.dequeue();
				//TODO Calculate the customer's wait time?
				serviceTime = shift.generateCustomerServiceTime();
				//TODO calculate the next time the wash will be free 
				
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
		
		System.out.println("Number of customers served: " + customerCount);
		System.out.println("Number of customers still waiting: ");//TODO
		System.out.println("Average wait time: ");//TODO
		System.out.println("Maximum number in line at one time: ");
		
	}

}
