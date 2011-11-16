package carwashsim;
import java.awt.*;            
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
public class CarWashSimGUI {
	
		
	
	   private static JTextField    hours;  
	   private static JTextField 	minutes;
	   private static JTextArea     statusTextArea; 
	   private static JScrollPane   scrollBar;

	   private static class ActionHandler implements ActionListener {
	      public void actionPerformed(ActionEvent event) {
		      /*if (event.getActionCommand().equals("Simulate")) { 
		         int result        = 0;
				 String errMessage = null;
		         try {
		            result = InFixEvaluator.evaluate(hours.getText());
		            statusTextArea.append("Expression = " + hours.getText() +
		            		                       "\n" + "Result = " + result + "\n");
				}catch (InFixException error) {        
		             errMessage = error.getMessage();
		             statusTextArea.setText("Result = " + errMessage); 
				}
				*/
		       if (event.getActionCommand().equals("Clear")) { 
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
	}
	

