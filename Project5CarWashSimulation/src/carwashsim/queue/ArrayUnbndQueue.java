package carwashsim.queue;
/**
 *ArrayUnbndQueue.java 	&nbsp;&nbsp;&nbsp; Project5
 *<p>
 *Implements UnboundedQueueInterface with an array to hold queue elements.
 *</p> 
 *<p>
 *Two constructors are provided; one that creates a queue of a default
 *original capacity and one that allows the calling program to specify the
 *original capacity.
 *</p>
 *<p>
 *If an enqueue is attempted when there is no room available in the array, a
 *new array is created, with capacity incremented by the original capacity.
 *</p>
 * @author Modified by Cory Koch
 * @param <T>
 */
public class ArrayUnbndQueue<T> implements UnboundedQueueInterface<T>{
            	
   protected final int DEFCAP = 100; // default capacity
   protected T[] queue;              // array that holds queue elements
   protected int origCap;            // original capacity
   protected int numElements = 0;    // number of elements in the queue
   protected int front = 0;          // index of front of queue
   protected int rear;               // index of rear of queue

   public ArrayUnbndQueue() 
   {
     queue = (T[]) new Object[DEFCAP];
	 rear = DEFCAP - 1;
     origCap = DEFCAP;
   }

   public ArrayUnbndQueue(int origCap) 
   {
     queue = (T[]) new Object[origCap];
	 rear = origCap - 1;
	 this.origCap = origCap;
   }

   private void enlarge()
   // Increments the capacity of the queue by an amount 
   // equal to the original capacity.
   {
     // create the larger array
     T[] larger = (T[]) new Object[queue.length + origCap];

   // copy the contents from the smaller array into the larger array
   int currSmaller = front;
   for (int currLarger = 0; currLarger < numElements; currLarger++)
   {
     larger[currLarger] = queue[currSmaller];
     currSmaller = (currSmaller + 1) % queue.length;
   }

   // update instance variables
       queue = larger;
       front = 0;
       rear = numElements - 1;
   }
   public void enqueue(T element)
   // Adds element to the rear of this queue.
   {  
     if (numElements == queue.length) 
       enlarge();

     rear = (rear + 1) % queue.length;
     queue[rear] = element;
     numElements = numElements + 1;
   }

   public T dequeue() throws QueueUnderFlowException
   // Throws QueueUnderflowException if this queue is empty;
   // otherwise, removes front element from this queue and returns it.
   {       
     if (isEmpty())
       throw new QueueUnderFlowException("Dequeue attempted on empty queue.");
     else
     {
       T toReturn = queue[front];
       queue[front] = null;
       front = (front + 1) % queue.length;
       numElements = numElements - 1;
       return toReturn;
     }
   }

   public boolean isEmpty()
   // Returns true if this queue is empty; otherwise, returns false
   {              
     return (numElements == 0);
   }
}
