//UnboundedQueueInterface.java 			Modified by Cory Koch				Project5

//Interface for a class that implements a queue of T with no bound
// on the size of the queue. A queue is a "First in, first out" structure.


package carwashsim;

public interface UnboundedQueueInterface<T> extends QueueInterface<T> {
	void enqueue(T element);
	// Adds element to the rear of this queue.

}
