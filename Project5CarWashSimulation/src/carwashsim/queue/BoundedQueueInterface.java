//BoundedQueueInterface.java 			Modified by Cory Koch			Project5
//
//Interface for a class that implements a queue of T with a bound
// on the size of the queue. A queue is a "First in, first out" structure.

package carwashsim.queue;

public interface BoundedQueueInterface<T> extends QueueInterface<T> {
	void enqueue(T element) throws QueueOverflowException;
	//Throws QueueOverflowException if this queue is fill;
	// otherwise, adds element to the rear of this queue.
	
	boolean isFull();
	// Returns true is this queue is full; otherwise, returns false.
}
