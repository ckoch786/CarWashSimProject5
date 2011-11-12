//QueueInterface.java                 modified by Cory Koch 					Project 5
//
//Interface for a class that implements a queue of T.
//A queue is a "First in, first out" structure

package carwashsim.queue;

public interface QueueInterface<T> {
	
	T dequeue() throws QueueUnderFlowException;
	//Throws QueueUnderflowException if queue is empty
	//otherwise, removes front element from this queue and returns it.
	
	boolean isEmpty();
	//Returns true is this queue is empty; otherwise, returns false
	
}
