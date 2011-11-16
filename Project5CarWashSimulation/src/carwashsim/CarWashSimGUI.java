package carwashsim;
import java.awt.*;            
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import carwashsim.queue.ArrayUnbndQueue;
import carwashsim.queue.QueueUnderFlowException;

import java.io.*;
import java.util.Scanner;
public class CarWashSimGUI {
	
		
	
	   private static JTextField    hours;  
	   private static JTextField 	minutes;
	   private static JTextArea     statusTextArea; 
	   private static JScrollPane   scrollBar;

	   private static class ActionHandler implements ActionListener  {
	      public void actionPerformed(ActionEvent event) {
		      if (event.getActionCommand().equals("Simulate")) { 
		    	    ArrayUnbndQueue<Integer> serviceLine = new ArrayUnbndQueue<Integer>();
		    		CarWash shift = new CarWash();
		    		
		    		int numberOfHours;
		    		int numberOfMinutes;
		    		int customerCount; 
		    		int arrivalTime;
		    		int serviceTime;
		    		int lengthOfShiftInMin;
		    		int carWashAvailable;
		    		int waitTime;
		    		
		    		String SnumberOfHours;
		    		String SnumberOfMinutes;
		    		
		    		
		    		
		    		
		    		int waitTotal;
		    		int irritatedCustomer;
		    		waitTotal = 0;
		    		irritatedCustomer = 0;
		      
		    		/**
		    		 * Read in the number of hours and number of minutes for
		    		 * the car wash shift.
		    		 */
		    	
		    		SnumberOfHours = hours.getText();
		    		numberOfHours = Integer.parseInt(SnumberOfHours);
		    		shift.setNumberOfHours(numberOfHours);
		    		
		    		SnumberOfMinutes = minutes.getText();
		    		numberOfMinutes = Integer.parseInt(SnumberOfMinutes);
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
		    				if(serviceLine.isEmpty())
								try {
									throw new QueueUnderFlowException("Dequeue attempted on an empty queue, there are no customers.");
								} catch (QueueUnderFlowException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							else
								try {
									serviceLine.dequeue();
								} catch (QueueUnderFlowException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
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
		    		statusTextArea.append("Number of customers served: " + customerCount + "\n");
		    		statusTextArea.append("Number of customers still waiting: " + "\n"); //TODO
		    		statusTextArea.append("Average wait time: " + calculateAverageWaitTime(waitTotal, irritatedCustomer)+ "\n");//TODO
		    		statusTextArea.append("Maximum number in line at one time: " + "\n"); //TODO
		    		
		    		
		    		
		    		
		    }else if (event.getActionCommand().equals("Clear")) { 
	            statusTextArea.setText("");
	            hours.setText("");
	            minutes.setText("");
		    }	      
		 
		}
				
	}
	
	 public static void main(String args[]) throws IOException {
	   JFrame displayFrame = new JFrame();
	   displayFrame.setTitle("Car Wash Simulation Program");
	   displayFrame.setSize(200,600);
	   displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	   hours          = new JTextField("hours: ", 5);
	   minutes        = new JTextField("minutes: ", 5); 
	   statusTextArea = new JTextArea("status", 20,60); 
	   scrollBar      = new JScrollPane();
	   statusTextArea.setBorder(new LineBorder(Color.red,3));

	   JButton       evaluate = new JButton("Simulate");         
	   JButton       clear    = new JButton("Clear");	       
	   ActionHandler action   = new ActionHandler();
	 
	   evaluate.addActionListener(action);
	   clear.addActionListener(action);

	   Container contentPane  = displayFrame.getContentPane();
	   JPanel    input        = new JPanel();
	   JPanel    activity     = new JPanel();
	   JPanel    buttonPanel  = new JPanel();
	 
	   input.setLayout(new FlowLayout());
	   input.add(hours);
	   input.add(minutes);
	   activity.add(statusTextArea);

	   buttonPanel.setLayout(new FlowLayout());
	   buttonPanel.add(evaluate);
	   buttonPanel.add(clear);

	   contentPane.add(input,       "North");
	   contentPane.add(activity,    "Center");   
	   contentPane.add(buttonPanel, "South");
	 
	   displayFrame.pack();
	   displayFrame.setVisible(true);
	  }
	 private static int calculateWaitTime(int serviceTime, int arrivalTime) {
 		int waitTime;
 		
 		waitTime = arrivalTime - serviceTime;
 		System.out.println("Angery customer++ Time waited: " +waitTime );//TODO remove

 		return waitTime;
 	}
 	private static int calculateAverageWaitTime(int waitTotal, int irritatedCustomer){
 		int averageWaitTime;
 		
 		averageWaitTime = waitTotal / irritatedCustomer;
 		
 		return averageWaitTime;
 	}
 	}
	

