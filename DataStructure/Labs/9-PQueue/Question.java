import java.util.*;

public class TimeoutManager {
   // Priority queue for timeout items. The timeout item with the lowest
   // callback time is the first to be dequeued.
	protected PriorityQueue<TimeoutItem> pq = new PriorityQueue<TimeoutItem>();
	
	// A clock used to get the current time in the addTimeout() and
   // update() method.
	protected MillisecondClock clock;

	public TimeoutManager(MillisecondClock clock) {
		this.clock = clock;
	}

   // Returns a reference to this timeout manager's internal priority queue.
   // Used only for grading purposes.
	public PriorityQueue<TimeoutItem> getPriorityQueue() {
		return pq;
	}
   
   // Adds a timeout item, given a callback method and delay time as
   // parameters. The added timeout expires at:
   // (clock's current time when this method is called) + (delay time)
	public void addTimeout(CallbackMethod callback, int delayBeforeCallback) {
		// Your code here
	}
   
   // Dequeues each expired timeout item from the priority queue and calls each
   // expired item's callback method.
	public void update() {
		// Your code here
	}
}

public abstract class MillisecondClock {
	abstract int getTime();
}

public class TestClock extends MillisecondClock {
	private int currentTime;

	public TestClock() {
		currentTime = 0;
	}

	@Override
	public int getTime() {
		return currentTime;
	}

	// Sets this clock's current time, provided the new time is greater than the
	// previously set time.
	public boolean setTime(int newTime) {
		// Only allow time to move forward
		if (newTime > currentTime) {
			currentTime = newTime;
			return true;
		}
		return false;
	}
}

import java.util.*;

public class TimeoutManager {
   // Priority queue for timeout items. The timeout item with the lowest
   // callback time is the first to be dequeued.
	protected PriorityQueue<TimeoutItem> pq = new PriorityQueue<TimeoutItem>();
	
	// A clock used to get the current time in the addTimeout() and
   // update() method.
	protected MillisecondClock clock;

	public TimeoutManager(MillisecondClock clock) {
		this.clock = clock;
	}

   // Returns a reference to this timeout manager's internal priority queue.
   // Used only for grading purposes.
	public PriorityQueue<TimeoutItem> getPriorityQueue() {
		return pq;
	}
   
   // Adds a timeout item, given a callback method and delay time as
   // parameters. The added timeout expires at:
   // (clock's current time when this method is called) + (delay time)
	public void addTimeout(CallbackMethod callback, int delayBeforeCallback) {
		// Your code here
	}
   
   // Dequeues each expired timeout item from the priority queue and calls each
   // expired item's callback method.
	public void update() {
		// Your code here
	}
}
