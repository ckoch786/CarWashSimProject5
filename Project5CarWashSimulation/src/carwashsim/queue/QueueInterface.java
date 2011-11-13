package carwashsim.queue;
/**
 *QueueInterface.java  	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Interface for a class that implements a queue of T.
 *A queue is a "First in, first out" structure
 *</p> 
 * @author Modified by Cory Koch
 *
 * @param <T>
 */
public interface QueueInterface<T> {
	
	/**
	 * 
	 * @return
	 * @throws QueueUnderFlowException if queue is empty
	 * otherwise, removes front element from this queue and returns it.
	 */
	T dequeue() throws QueueUnderFlowException;
	/**
	 * 
	 * @return true if this queue is empty; otherwise, returns false
	 */
	boolean isEmpty();

}
