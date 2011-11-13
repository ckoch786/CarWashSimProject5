package carwashsim.queue;
/**
 *BoundedQueueInterface.java  	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Interface for a class that implements a queue of T with a bound.
 *on the size of the queue. A queue is a "First in, first out" structure
 *</p> 
 * @author Modified by Cory Koch
 *
 * @param <T>
 */
public interface BoundedQueueInterface<T> extends QueueInterface<T> {
	/**
	 * 
	 * @param element
	 * @throws QueueOverflowException if this queue is fill;
	 * otherwise, adds element to the rear of this queue.
	 */
	void enqueue(T element) throws QueueOverflowException;
	
	/**
	 * 
	 * @return true if this queue is full; otherwise, returns false.
	 */
	boolean isFull();
}
