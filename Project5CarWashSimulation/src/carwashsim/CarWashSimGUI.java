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
		      if (event.getActionCommand().equals("Evaluate")) { 
		         int result        = 0;
				 String errMessage = null;
		         try {
		            result = InFixEvaluator.evaluate(expressionText.getText());
		            statusTextArea.append("Expression = " + expressionText.getText() +
		            		                       "\n" + "Result = " + result + "\n");
				}catch (InFixException error) {        
		             errMessage = error.getMessage();
		             statusTextArea.setText("Result = " + errMessage); 
				}
		      } else if (event.getActionCommand().equals("Clear")) { 
		            statusTextArea.setText("");
		            expressionText.setText("");
		        }
		 }
	}
	 public static void main(String args[]) throws IOException {
	   JFrame displayFrame = new JFrame();
	   displayFrame.setTitle("InFix Expression Evaluator Program");
	   displayFrame.setSize(200,600);
	   displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	   expressionText = new JTextField("Infix expression goes here", 60);
	   statusTextArea = new JTextArea("status", 20,60); 
	   scrollBar      = new JScrollPane();
	   statusTextArea.setBorder(new LineBorder(Color.red,3));

	   JButton       evaluate = new JButton("Evaluate");         
	   JButton       clear    = new JButton("Clear");	       
	   ActionHandler action   = new ActionHandler();
	 
	   evaluate.addActionListener(action);
	   clear.addActionListener(action);

	   Container contentPane     = displayFrame.getContentPane();
	   JPanel    expressionPanel = new JPanel();
	   JPanel    statusPanel     = new JPanel();
	   JPanel    buttonPanel     = new JPanel();
	 
	   expressionPanel.setLayout(new FlowLayout());
	   expressionPanel.add(expressionText);
	   statusPanel.add(statusTextArea);

	   buttonPanel.setLayout(new FlowLayout());
	   buttonPanel.add(evaluate);
	   buttonPanel.add(clear);

	   contentPane.add(expressionPanel, "North");
	   contentPane.add(statusPanel,     "Center");   
	   contentPane.add(buttonPanel,     "South");
	 
	   displayFrame.pack();
	   displayFrame.setVisible(true);
	  }
}
	

