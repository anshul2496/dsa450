package b9_lld_elevator;

public class Request {
	private final int sourceFloor;
    private final int destinationFloor;

    public Request(int sourceFloor, int destinationFloor) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

	@Override
	public String toString() {
		return "Request [sourceFloor=" + sourceFloor + ", destinationFloor=" + destinationFloor + "]";
	}
}
