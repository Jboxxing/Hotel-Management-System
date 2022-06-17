package banks;

import java.util.ArrayList;

public class Person
{
	private static ArrayList<Integer> codes = new ArrayList<Integer>(0);
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	private enum Gender
	{
		MALE,
		FEMALE,
		OTHER
	};
	private int code = -1;
	private double amount;
	
	// Initializes the first and last name, age, and gender of a person.
	public Person(String firstName, String lastName, int age, String gender)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		if (gender.contentEquals(Gender.MALE.toString()))
		{
			this.gender = Gender.MALE;
		}
		else if (gender.contentEquals(Gender.FEMALE.toString()))
		{
			this.gender = Gender.FEMALE;
		}
		else if (gender.contentEquals(Gender.OTHER.toString()))
		{
			this.gender = Gender.OTHER;
		}
		amount = 500;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getGender()
	{
		return gender.toString();
	}
	
	public int getCode()
	{
		return code;
	}
	
	public void setCode(int code)
	{
		this.code = code;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
}
