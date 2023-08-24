# Timeout manager overview

A timeout manager stores a priority queue of timeout items, each a (callback method, callback time) pair. Each callback method is called approximately N milliseconds after the timeout is set, where N is the delay specified when adding the timeout item. Ex:

- At time t = 0, a 500 millisecond timeout is set for method A
- At time t = 100, a 3000 millisecond timeout is set for method B
- At time t = 2000, a 1000 millisecond timeout is set for method C

So the timeout manager should call the callbacks as follows:

- Call method A at time t = 0 + 500 = 500
- Call method C at time t = 2000 + 1000 = 3000
- Call method B at time t = 100 + 3000 = 3100

A timeout item with a callback time <= the current time is said to be "expired".

Millisecond-level callback precision is often unfeasible. So a timeout manager typically has an update method that is called by external code every so often, ex: every 100 milliseconds. The manager's update method calls each expired timeout's callback method.

# Step 1: Inspect TimeoutItem.java

Inspect the TimeoutItem class declaration in the read only TimeoutItem.java file. Access TimeoutItem.java by clicking on the orange arrow next to LabProgram.java at the top of the coding window. The `callbackTime` private field stores the time the item was added plus the item's delay. Ex: A TimeoutItem created at t=500 with a delay of 1000 has callbackTime = 500 + 1000 = 1500. The `callbackMethod` private field is the method to call after the timeout expires.

TimeoutItem implements the compareTo() method so that TimeoutItems can be put in a PriorityQueue that gives higher priority to lesser callbackTime values.

# Step 2: Inspect MillisecondClock.java and TestClock.java

MillisecondClock is an abstract base class for a clock. The getTime() method returns an integer indicating the clock's current time, in milliseconds. Inspect the class declarations in the read only TestClock.java file.

Times are simulated during grading using the TestClock class. TestClock extends MillisecondClock and allows the clock's time to be set via the setTime() method.

# Step 3: Implement TimeoutManager's addTimeout() and update() methods

Complete the TimeoutManager class implementation in TimeoutManager.java. addTimeout() must add a new TimeoutItem to the priority queue that expires `delayBeforeCallback` milliseconds after the current time. update() must dequeue and call the callback method for each expired timeout item. Use TimeoutManager's `clock` field to get the current time.
