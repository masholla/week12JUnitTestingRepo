package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest 
{
	private TestDemo testDemo;
	private TestDemo mockDemo;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testDemo = new TestDemo();
		mockDemo = spy(testDemo);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) 
	{
		if(!expectException) 
		{
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else
		{
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		//fail("Not yet implemented");
	}
	
	static Stream<Arguments> argumentsForAddPositive()
	{
		
		//@formatter:off
		return Stream.of(
				arguments(10, 15, 25, false),
				arguments(-1, 20, 19, true),
				arguments(0, 0, 0, false),
				arguments(310, -42, 268, true)
				//arguments(null, null, null, true)
				);
		//@formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly()
	{
		//given- two integers to be added together and the expected results
		int a = 52;
		int b = 48;
		int expected = 100;
		
		//when- the method that checks if either is negative then adds them is called
		int actual = testDemo.addPositive(a, b);
		
		//then- the numbers are compared to ensure method function
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectlyAgain()
	{
		//given- two integers to be added together and the expected results
		int a = 0;
		int b = 60;
		int expected = 60;
		
		//when- the method that checks if either is negative then adds them is called
		int actual = testDemo.addPositive(a, b);
		
		//then- the numbers are compared to ensure method function
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForSeventeensTester")
	void assertThatAllListedNumbersWillBeMultiplesOfSeventeen(int a, List<Integer> expected)
	{
		assertThat(testDemo.multiplesOfSeventeen(a)).isEqualTo(expected);
	}
	
	static Stream<Arguments> argumentsForSeventeensTester()
	{
		//@formatter:off
		return Stream.of(
				arguments(5, List.of(17, 34, 51, 68, 85)),
				arguments(-5, List.of(-17, -34, -51, -68, -85)),
				arguments(0, List.of(0)),
				arguments(10, List.of(17, 34, 51, 68, 85, 102, 119, 136, 153, 170))
				//arguments(null, null, null, true)
				);
		//@formatter:on
	}

	@Test
	void assertThatNumberSquaredIsCorrect()
	{
		//forces getRandomInt to return 5 for the test
		doReturn(5).when(mockDemo).getRandomInt();
		
		//creates an int with value that calls the method to be tested
		int fiveS = mockDemo.randomNumberSquared();
		
		//asserts that the forced value of 5 is equal to 25 when squared
		assertThat(fiveS).isEqualTo(25);
		
		//Three additional tests for curiosity sake
		doReturn(3).when(mockDemo).getRandomInt();
		int threeS = mockDemo.randomNumberSquared();
		assertThat(threeS).isEqualTo(9);
		
		doReturn(9).when(mockDemo).getRandomInt();
		int nineS = mockDemo.randomNumberSquared();
		assertThat(nineS).isEqualTo(81);
		
		doReturn(7).when(mockDemo).getRandomInt();
		int sevenS = mockDemo.randomNumberSquared();
		assertThat(sevenS).isEqualTo(49);
		//Several can be called together without it breaking
	}
}