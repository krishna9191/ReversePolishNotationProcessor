/**
 * 
 */
package com.krishna.utils.tests;

import org.junit.Test;

import com.krishna.utils.RPNProcessor;

import junit.framework.TestCase;

/**
 * @author RK
 *
 */
public class RPNProcessorTests extends TestCase {

	
	@Test
	public void testAddOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "2 3 +";
		String expected = "5";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	
	@Test
	public void testAddOperationOverFlow()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = Integer.MAX_VALUE+" 3 +";
		String expected = Integer.MAX_VALUE+", 3";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	
	
	@Test
	public void testSubtractOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "2 3 -";
		String expected = "-1";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testSubtractOperationOverFlow()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = Integer.MIN_VALUE+" 3 -";
		String expected = Integer.MIN_VALUE+", 3";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testMultiplicationOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "2 3 *";
		String expected = "6";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testMultiplicationOperationOverFlow()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = Integer.MAX_VALUE+" 3 *";
		String expected = Integer.MAX_VALUE+", 3";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	
	@Test
	public void testDivideOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "6 3 /";
		String expected = "2";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testDivideOperation_IntegerDivision()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 /";
		String expected = "2";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testDivideOperationOverFlow()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = Integer.MIN_VALUE+" 0 /";
		String expected = Integer.MIN_VALUE+", 0";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	
	@Test
	public void testModulusOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 %";
		String expected = "1";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testModulusOperation_negativeNumbers()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "-7 3 %";
		String expected = "2";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testModulusOperation_zero()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 0 %";
		String expected = "7, 0";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	

	@Test
	public void testDuplicateOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 d";
		String expected = "7, 3, 3";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	@Test
	public void testDuplicateOperation_caseInsensitive()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 D";
		String expected = "7, 3, 3";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testPrintOperation_caseInsensitive()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 P";
		String expected = "7";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	@Test
	public void testPrintOperation()
	{
		RPNProcessor processor = new RPNProcessor();
		String input = "7 3 p";
		String expected = "7";
		for(String element : input.split(processor.getDelimiter()))
		{
			processor.process(element);
		}
		assertEquals(expected, processor.getResult());
	}
	
	
}
