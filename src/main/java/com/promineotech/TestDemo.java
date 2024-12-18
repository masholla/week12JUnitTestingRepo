package com.promineotech;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class TestDemo 
{
	public int addPositive(int a, int b)
	{
		try
		{
			//if both numbers re positive it returns the sum
			if(a >= 0 && b >= 0)
			{
				return a + b;
			}
			//if either int is negative it throws this
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		//then catches here
		catch(IllegalArgumentException e)
		{
			//prints the error message
			System.out.println("Exception caught: " + e.getMessage());
			
			//then throws inside the catch to complete it
			throw e;
		}
	}
	
	public List<Integer> multiplesOfSeventeen(int howMany)
	{
		List<Integer> multiples = new ArrayList<Integer>();
		
		if(howMany == 0)
		{
			multiples.add(0);
		}
		else if(howMany < 0)
		{
			for(int i = howMany; i <= -1; i++)
			{
				multiples.add(i * 17);
			}
			multiples = listSwapper(multiples);
		}
		else
		{
			for(int i = 1; i <= howMany; i++)
			{
				multiples.add(i * 17);
			}
		}
		return multiples;
	}
	
	public List<Integer> listSwapper(List<Integer> prior)
	{
		Collections.reverse(prior);
		
		return prior;
	}

	public int randomNumberSquared()
	{
		int a = getRandomInt();
		return a * a;
	}

	public int getRandomInt() 
	{
		Random r = new Random();
		
		return r.nextInt(10 + 1);
	}

}
