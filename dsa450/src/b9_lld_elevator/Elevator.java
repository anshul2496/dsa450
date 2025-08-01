package b9_lld_elevator;

import java.util.LinkedList;

public class Elevator {
	private final int id;
	private final int capacity;
	private int currentFloor;
	private Direction direction;
	private final LinkedList<Request> requests;

	public Elevator(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.currentFloor = 0;
		this.direction = Direction.UP;
		this.requests = new LinkedList<>();
	}

	public synchronized void addRequest(Request request) {
		if (requests.size() < capacity) {
			requests.add(request);
			System.out.println("Elevator " + id + " added request: " + request);
			notifyAll();
		}
	}

	public synchronized Request getNextRequest() {
		while (requests.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return requests.removeFirst();
	}

	public synchronized void processRequests() {
		while (true) {
			while (!requests.isEmpty()) {
				Request request = getNextRequest();
				processRequest(request);
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processRequest(Request request) {
		int startFloor = currentFloor;
		int endFloor = request.getDestinationFloor();

		if (startFloor < endFloor) {
			direction = Direction.UP;
			for (int i = startFloor; i <= endFloor; i++) {
				currentFloor = i;
				System.out.println("Elevator " + id + " reached floor " + currentFloor);
				try {
					Thread.sleep(1000); // Simulating elevator movement
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else if (startFloor > endFloor) {
			direction = Direction.DOWN;
			for (int i = startFloor; i >= endFloor; i--) {
				currentFloor = i;
				System.out.println("Elevator " + id + " reached floor " + currentFloor);
				try {
					Thread.sleep(1000); // Simulating elevator movement
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {
		processRequests();
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}
}
