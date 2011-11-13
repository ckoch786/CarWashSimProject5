package carwashsim.queue;
/**
 *UnboundedQueueInterface.java 	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Interface for a class that implements a queue of T with no bound
 *on the size of the queue. A queue is a "First in, first out" structure.
 *</p> 
 * @author Modified by Cory Koch
 *
 * @param <T>
 */
public interface UnboundedQueueInterface<T> extends QueueInterface<T> {
	/**
	 * 
	 * @param element Adds element to the rear of this queue.
	 */
	void enqueue(T element);
}
