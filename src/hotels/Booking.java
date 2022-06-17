package hotels;

import banks.Bank;

public class Booking
{
	private Room room;
	private int numberOfPeople;
	
	public Booking(Room room, int numberOfPeople)
	{
		this.room = room;
		this.numberOfPeople = numberOfPeople;
	}
	
	public double calculateCost(Room room)
	{
		return room.getCost() * numberOfPeople;
	}
	
	// After successful payment for a room, that room's availability becomes false.
	public void receivePayment(Bank bank, int code, double amount)
	{
		//...
		room.setAvailability(false);
	}
}
