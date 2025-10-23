package c3_hotel_booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import c3_hotel_booking.enums.RoomState;
import c3_hotel_booking.enums.RoomStyle;
import c3_hotel_booking.enums.RoomType;
import c3_hotel_booking.model.Room;

public class RoomService {
	private final List<Room> rooms = new ArrayList<>();

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public List<Room> findRooms(RoomType type, RoomStyle style) {
		return rooms.stream().filter(
				room -> (room.getState() == RoomState.AVAILABLE && room.getStyle() == style && room.getType() == type))
				.collect(Collectors.toList());
	}

	public Room findRoomByNumber(String roomNumber) {
		return rooms.stream().filter(r -> r.getRoomNumber().equals(roomNumber)).findFirst().orElse(null);
	}
}