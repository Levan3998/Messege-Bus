package bgu.spl.mics;

import java.util.HashMap;

/**
 * The {@link MessageBusImpl class is the implementation of the MessageBus interface.
 * Write your implementation here!
 * Only private fields and methods can be added to this class.
 */
public class MessageBusImpl implements MessageBus {

	private HashMap EventMap;
	private HashMap BroadcastMap;
	private HashMap MicroServices;
	private HashMap FutureMap;
	int round_robin = 0;

	public HashMap getEventTypes(){
		return EventMap;
	}
	public HashMap getBroadCastTypes(){
		return BroadcastMap;
	}

	public HashMap getMicroServices(){
		return MicroServices;
	}
	public HashMap getFutureMap(){
		return FutureMap;
	}


	/**
	 * Subscribes {@code m} to receive {@link Event}s of type {@code type}.
	 * <p>
	 * @param <T>  The type of the result expected by the completed event.
	 * @param type The type to subscribe to,
	 * @param m    The subscribing micro-service.
	 * @pre none
	 * @post m in EventMap.get(type)
	 */
	@Override
	public <T> void subscribeEvent(Class<? extends Event<T>> type, MicroService m) {
		// TODO Auto-generated method stub

	}
	/**
	 * Subscribes {@code m} to receive {@link Broadcast}s of type {@code type}.
	 * <p>
	 * @param type 	The type to subscribe to.
	 * @param m    	The subscribing micro-service.
	 * @ pre 	none
	 * @ post 	m in BroadCastMap.get(type)
	 */
	@Override
	public void subscribeBroadcast(Class<? extends Broadcast> type, MicroService m) {
		// TODO Auto-generated method stub

	}
	/**
	 * Notifies the MessageBus that the event {@code e} is completed and its
	 * result was {@code result}.
	 * When this method is called, the message-bus will resolve the {@link Future}
	 * object associated with {@link Event} {@code e}.
	 * <p>
	 * @param <T>    The type of the result expected by the completed event.
	 * @param e      The completed event.
	 * @param result The resolved result of the completed event.
	 *
	 * @ pre  	FutureMap.get(e) != null
	 * @ post  	FutureMap.get(e).isDone()
	 */
	@Override
	public <T> void complete(Event<T> e, T result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds the {@link Broadcast} {@code b} to the message queues of all the
	 * micro-services subscribed to {@code b.getClass()}.
	 * <p>
	 * @param b 	The message to added to the queues.
	 *
	 * @ pre  	b != null
	 * @ post   b in MicroServices.get(ms).getMessageQueue() | ms in self.getBroadCastMap().get(b.getClass())
	 */
	@Override
	public void sendBroadcast(Broadcast b) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds the {@link Event} {@code e} to the message queue of one of the
	 * micro-services subscribed to {@code e.getClass()} in a round-robin
	 * fashion. This method should be non-blocking.
	 * <p>
	 * @param <T>    	The type of the result expected by the event and its corresponding future object.
	 * @param e     	The event to add to the queue.
	 * @return {@link Future<T>} object to be resolved once the processing is complete,
	 * 	       null in case no micro-service has subscribed to {@code e.getClass()}.
	 * @ pre 	e != null
	 * @ post 	this.getEventTypes().get(e.getClass())[@pre this.round_robin]
	 * @ post 	@pre (this.round_robin + 1) % size_of_list = this.round_robin
	 */
	
	@Override
	public <T> Future<T> sendEvent(Event<T> e) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Allocates a message-queue for the {@link MicroService} {@code m}.
	 * <p>
	 * @param m the micro-service to create a queue for.
	 *
	 * @ pre 	m != null
	 * @ pre	self.MicroServices.get(m) == null
	 *
	 * @ post 	self.MicroServices.get(m) != null
	 */

	@Override
	public void register(MicroService m) {
		// TODO Auto-generated method stub


	}

	/**
	 * Removes the message queue allocated to {@code m} via the call to
	 * {@link #register(bgu.spl.mics.MicroService)} and cleans all references
	 * related to {@code m} in this message-bus. If {@code m} was not
	 * registered, nothing should happen.
	 * <p>
	 * @param m the micro-service to unregister.
	 *
	 * @ pre 	m != null
	 * @ post  	this.getMicroServices().get(m.name) == null
	 *
	 */

	@Override
	public void unregister(MicroService m) {
		// TODO Auto-generated method stub

	}

	/**
	 * Using this method, a <b>registered</b> micro-service can take message
	 * from its allocated queue.
	 * This method is blocking meaning that if no messages
	 * are available in the micro-service queue it
	 * should wait until a message becomes available.
	 * The method should throw the {@link IllegalStateException} in the case
	 * where {@code m} was never registered.
	 * <p>
	 * @param m The micro-service requesting to take a message from its message
	 *          queue.
	 * @return The next message in the {@code m}'s queue (blocking).
	 * @throws InterruptedException if interrupted while waiting for a message
	 *                              to became available.
	 *
	 * @ pre 	m != null
	 * @ pre 	this.getMicroServices().get(m) != null
	 * @ inv 	this.getMicroServices().get(m).size() == 0 && m.State == WAITING
	 * @ post 	@return == @Pre this.getMicroServices().get(m).get(0)
	 *
	 */


	@Override
	public Message awaitMessage(MicroService m) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
