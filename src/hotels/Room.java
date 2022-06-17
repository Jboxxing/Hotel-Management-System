package hotels;

public class Room
{
	private int number;
	private boolean available;
	private int capacity;
	private double cost;
	
	// Upon creation of a new Room with a specified room number, its availability is set to true by default, 
	// with a capacity of 5 people.
	public Room(int number)
	{
		this.number = number;
		available = true;
		capacity = 5;
		cost = 50.75;
	}
	
	public int getRoomNumber()
	{
		return number;
	}
	
	public void setAvailability(boolean available)
	{
		this.available = available;
	}
	
	public boolean getAvailability()
	{
		return available;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public double getCost()
	{
		return cost;
	}
}
