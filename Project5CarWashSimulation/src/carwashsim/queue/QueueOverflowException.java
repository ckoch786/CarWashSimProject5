//QueueOverflowException.java 		Modified by Cory Koch			Project5
//
//Just an Exception class

package carwashsim.queue;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super();
	}
	public QueueOverflowException(String message) {
		super(message);
	}
}
