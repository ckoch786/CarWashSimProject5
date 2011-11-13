package carwashsim.queue;
/**
 *QueueOverflowException.java 	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Just an Exception class
 *</p> 
 * @author Modified by Cory Koch
 */
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super();
	}
	/**
	 * 
	 * @param message Takes a custom message
	 */
	public QueueOverflowException(String message) {
		super(message);
	}
}
