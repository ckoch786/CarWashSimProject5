//QueueUnderFlow.java			modified by Cory Koch			Project5
//
//Just an Exception class

package carwashsim.queue;

public class QueueUnderFlowException extends Exception {
	QueueUnderFlowException(){
		super();
	}
	QueueUnderFlowException(String message){
		super(message);
	}

}
