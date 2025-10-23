package c3_hotel_booking.factory;

import c3_hotel_booking.enums.RoomStyle;
import c3_hotel_booking.enums.RoomType;
import c3_hotel_booking.model.Room;

public class RoomFactory {
	public static Room createRoom(String roomNumber, String type, String style, double price) {
		RoomType roomType = RoomType.valueOf(type.toUpperCase());
		RoomStyle roomStyle = RoomStyle.valueOf(style.toUpperCase());
		return new Room(roomNumber, roomType, roomStyle, price);
	}
}