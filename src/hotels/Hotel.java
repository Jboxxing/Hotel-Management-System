package hotels;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// https://medium.com/@datamateuaecrescent/features-of-hotel-management-software-41a9d19a0ae
// https://www.altexsoft.com/blog/travel/hotel-property-management-systems-products-and-features/

public class Hotel
{
	private ArrayList<Room> rooms;
	
	// Creates a Hotel containing the number of rooms specified.
	// Each floor assumes an equal number of rooms (whenever applicable).
	// The system will attempt to ensure that previous floor levels are filled with rooms to maximum capacity 
	// before being added to the next floor level.
	public Hotel(int floors, int numberOfRooms)
	{
		int roomsPerFloor = numberOfRooms / floors;
		rooms = new ArrayList<Room>(0);
		for (int count = 0, num = 1, floor = 100; count < numberOfRooms; count++, num++)
		{
			rooms.add(new Room(floor + num));
			if (num == roomsPerFloor)
			{
				floor = floor + 100;
				num = 0;
			}
		}
	}
	
	public Room nextAvailableRoom()
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			if (rooms.get(i).getAvailability())
				return rooms.get(i);
		}
		return null;
	}
	
	// Searches the list of rooms at the hotel for a matching room number and returns that room if a match 
	// is found.
	public Room getRoom(int roomNumber)
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			if (rooms.get(i).getRoomNumber() == roomNumber)
			{
				return rooms.get(i);
			}
		}
		return null;
	}
	
	// Searches the list of rooms at the hotel for a matching room number and returns that room if it is 
	// available.
	public Room getAvailableRoom(int roomNumber)
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			if (rooms.get(i).getRoomNumber() == roomNumber)
			{
				if (rooms.get(i).getAvailability())
					return rooms.get(i);
			}
		}
		return null;
	}
	
	// Returns a list of all room numbers in the hotel as a String
	public String listRooms()
	{
		ArrayList<Integer> r = new ArrayList<Integer>(0);
		
		for (int i = 0; i < rooms.size(); i++)
		{
			r.add(rooms.get(i).getRoomNumber());
		}
		
		return r.toString();
	}
	
	// Returns a list of available room numbers in the hotel as a String
	public String listAvailableRooms()
	{
		ArrayList<Integer> availableRooms = new ArrayList<Integer>(0);
		
		for (int i = 0; i < rooms.size(); i++)
		{
			if (rooms.get(i).getAvailability())
			{
				availableRooms.add(rooms.get(i).getRoomNumber());
			}
		}
		
		return availableRooms.toString();
	}
	
	public static void main(String[] args)
	{
		// Creates a new hotel with a total of 20 rooms, divided equally on (ideally, if possible) 3 floors.
		// Available room numbers are printed to the console.
		Hotel h1 = new Hotel(3, 20);
		System.out.println("Welcome to Hotel h1!");
		Scanner keyboard;
		System.out.println();
		int input = 0;
		while (input != 1 && input != 2 && input != 3)
		{
			System.out.print("Are you here to (1) book a new room, (2) modify/cancel an existing booking, or (3) exit the application?: ");
			try
			{
				keyboard = new Scanner(System.in);
				input = keyboard.nextInt();
				if (input == 1)
				{
					System.out.println();
					System.out.println("Available rooms: " + h1.listAvailableRooms());
					System.out.println();
					Room room = null;
					int roomNumber = 0;
					while (room == null)
					{
						System.out.print("Enter the room number you would like to book: ");
						roomNumber = keyboard.nextInt();
						System.out.println();
						room = h1.getAvailableRoom(roomNumber);
						if (room == null)
						{
							System.out.println("Room " + roomNumber + " is currently not available or does not exist.");
							System.out.println();
						}
					}
					Booking b1 = null;
					while (b1 == null)
					{
						System.out.print("How many people will be staying here? (Maximum of " + room.getCapacity() + "): ");
						int numberOfPeople = keyboard.nextInt();
						System.out.println();
						if (numberOfPeople > room.getCapacity())
						{
							System.out.println("Cannot reserve room " + roomNumber + ". Only " + room.getCapacity() + " people allowed per room.");
							System.out.println();
						}
						else if (numberOfPeople < 1)
						{
							System.out.println("Cannot reserve room " + roomNumber + " for " + numberOfPeople + " people.");
							System.out.println("Please ensure that the number of people to occupy the room is between 1 and 5.");
							System.out.println();
						}
						else
						{
							b1 = new Booking(room, numberOfPeople);
							System.out.println("You have booked room " + roomNumber + " at h1 Hotel.");
							System.out.println("The total cost of your stay here is " + b1.calculateCost(room) + ".");
							System.out.print("Would you like to confirm payment? (Enter 1): ");
							int confirmPayment = keyboard.nextInt();
							System.out.println();
							if (confirmPayment == 1)
							{
								
							}
							else
							{
								b1 = null;
							}
						}
					}
				}
				else if (input == 2)
				{
					System.out.println("2 is chosen");
				}
				else if (input == 3)
				{
					System.out.println("Exiting application...");
					System.out.println("Have a nice day!");
					System.exit(0);
				}
			}
			// After the user is welcomed to the hotel, they are prompted for input at various points in the 
			// application. If the data type of an input does not match the expected type, any potential 
			// changes made to bookings may not be saved, and the user is redirected to the main menu.
			catch (InputMismatchException e)
			{
				System.out.println("Invalid input");
				System.out.println("Any addition, modification, or cancellation of a booking may not have been saved.");
				System.out.println("Returning to main menu...");
				System.out.println();
				input = 0;
			}
		}
	}
}
