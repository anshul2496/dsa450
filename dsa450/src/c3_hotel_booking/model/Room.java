package c3_hotel_booking.model;

import c3_hotel_booking.enums.RoomState;
import c3_hotel_booking.enums.RoomStyle;
import c3_hotel_booking.enums.RoomType;

public class Room {
	private final String roomNumber;
	private final RoomType type;
	private final RoomStyle style;
	private final double price;
	private RoomState state;

	public Room(String roomNumber, RoomType type, RoomStyle style, double price) {
		this.roomNumber = roomNumber;
		this.type = type;
		this.style = style;
		this.price = price;
		this.state = RoomState.AVAILABLE; // Initial state
	}

	public void setState(RoomState state) {
		this.state = state;
	}

	public void book() {
		this.setState(RoomState.BOOKED);
	}

	public void checkIn() {
		this.setState(RoomState.OCCUPIED);
	}

	public void checkOut() {
		this.setState(RoomState.AVAILABLE);
	}

	public void markForMaintenance() {
		this.setState(RoomState.MAINTAINENCE);
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public RoomType getType() {
		return type;
	}

	public RoomStyle getStyle() {
		return style;
	}

	public double getPrice() {
		return price;
	}

	public RoomState getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Room [Number=" + roomNumber + ", Type=" + type + ", Style=" + style + ", Price=$" + price + ", State="
				+ state.name() + "]";
	}
}