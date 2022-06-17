package banks;

import java.util.ArrayList;

public class Bank
{
	// A bank will have a name and a list of its clients.
	private String name;
	private ArrayList<Person> clients;
	private ArrayList<Integer> codes = new ArrayList<Integer>(0);
	
	public Bank(String name)
	{
		this.name = name;
		clients = new ArrayList<Person>(0);
	}
	
	public String getName()
	{
		return name;
	}
	
	// The client is assigned a randomly generated code to be used for user verification purposes.
	public void addClient(Person p)
	{
		if (p.getCode() < 0)
		{
			p.setCode(generateRandomCode());
			clients.add(p);
		}
	}
	
	public Person getClient(String firstName, String lastName)
	{
		for (int i = 0; i < clients.size(); i++)
		{
			if (clients.get(i).getFirstName() == firstName)
			{
				
			}
		}
		return null;
	}
	
	// An integer code is formed by concatenating 6 randomly generated numbers between 0 and 9.
	public int generateRandomCode()
	{
		String code = "";
		int count = 0;
		while (count < 6)
		{
			int num = (int) Math.floor(Math.random() * 10);
			code += Integer.toString(num);
			count++;
		}
		int c = Integer.parseInt(code);
		return checkUniqueCode(c);
	}

	// Once the integer code has been formed, it is checked here for uniqueness.
	// In other words, it cannot be identical to another client's code at the same bank.
	public int checkUniqueCode(int code)
	{
		if (!codes.contains(code))
		{
			codes.add(code);
			return code;
		}
		return generateRandomCode();
	}
	
	// If the client's code matches one found in the bank's array list of existing codes, then a new code is 
	// generated for that client and their old one is removed from the bank.
	public int changeCode(Person p)
	{
		for (int i = 0; i < codes.size(); i++)
		{
			if (codes.get(i) == p.getCode())
			{
				p.setCode(generateRandomCode());
				codes.remove(i);
				return 1;
			}
		}
		System.out.println("Sorry, an error occured in an attempt to change your code.");
		return 0;
	}
}
