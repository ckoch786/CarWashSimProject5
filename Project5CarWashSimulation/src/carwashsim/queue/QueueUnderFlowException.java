package carwashsim.queue;
/**
 *QueueUnderFlow.java 	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Just an Exception class
 *</p> 
 * @author Modified by Cory Koch
 */
public class QueueUnderFlowException extends Exception {
	public QueueUnderFlowException(){
		super();
	}
	/**
	 * 
	 * @param message Takes a custom message
	 */
	public QueueUnderFlowException(String message){
		super(message);
	}

}
