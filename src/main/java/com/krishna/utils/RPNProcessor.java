/**
 * 
 */
package com.krishna.utils;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to Evaluate Reverse Polish Notation
 * @author RK
 *
 */

public class RPNProcessor {

	private Stack<Integer> stack ; // to store the Integers
	private String delimiter;  // delimiter to split the Input String

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	
	/*
	 * Constructor for RPNProcessor
	 * 
	 */
	public RPNProcessor() {
		super();
		stack = new Stack<Integer>();
		delimiter = " ";
	}


	   /**
     * Method to verify a given operator is valid or not 
     * 
     * @param 
     * 
     * @return
     * 					: String - comma separated stack elements
     */
	public String getResult() {
		if(stack.size()>0)
			{	String output = stack.toString();
				return output.substring(1, output.length()-1);
			}
		else
		{
			return "";
		}
	}
	   
	/**
     * Method to process the Reverse Polish Notation 
     * 
     * @param element
     * 					: String - symbol representing operation/operand
     * 
     * @return
     * 					: boolean - valid operation or not
     * 
     * 
     * 			check if the element is a valid Integer
     * 				if Yes - pushes it into stack
     * 				else - checks if it is a valid operator
     * 						if Yes - checks if it has required number of elements in Stack
     * 										if Yes - perform Operation. if Exception occurs, change stack to previous state and print error message
     * 																		else update stack with operation output
     * 										else - print error message and continue
     * 						else - print error message, continue. 
     */
	public void process(String element) {

		try{
			int operand = Integer.parseInt(element);
			stack.push(operand);
		}
		catch(NumberFormatException ime)
		{
			if(isValidOperator(element))
			{
				if(stack.size()>1 ||  (stack.size()==1 && (element.equalsIgnoreCase("p")||element.equalsIgnoreCase("d"))))
				{
					int operand1 = stack.pop();
					int operand2;
					if(element.equalsIgnoreCase("p"))
					{
						System.out.println(operand1);
					}
					else if(element.equalsIgnoreCase("d"))
					{
						stack.push(operand1);
						stack.push(operand1);
					}
					else
					{
						operand2  = stack.pop();
						performOperation(operand1,operand2,element);
					}
				}
				else
				{
					System.err.println("Error: insufficient input for '"+element+"' operator");
				}
			}
			else
			{
				System.err.println("Error: Couldn't parse '"+element+"' as an integer or operator");
			}
		}
		catch(Exception e ){
			e.printStackTrace(System.err);
		}
	}

	
	/**
     * Method to perform operation depending on the operator 
     * 
     * @param operand1
     * 					: int - The first operand
     * @param operand2
     * 					: int - the Second operand
     * @param element 
     * 					: String - Symbol representing the operation
     * 
     * @return
     * 					: void
     */
	private void performOperation(int operand1, int operand2, String element) {
		try {
			if(element.equals("*"))
			{
				stack.push( Math.multiplyExact(operand2, operand1));
			}
			else if(element.equals("+"))
			{
				stack.push( Math.addExact(operand2, operand1));
			}
			else if(element.equals("-"))
			{
				stack.push( Math.subtractExact(operand2, operand1));
			}
			else if(element.equals("/"))
			{
				stack.push( operand2/operand1);
			}
			else if(element.equals("%"))
			{
				stack.push(Math.floorMod(operand2,operand1));
			}
		} 
		catch (ArithmeticException e) {
			System.err.println("Error : Arithmetic Exception  "+operand2+" "+element+" "+operand1);
			stack.push(operand2);
			stack.push(operand1);

		}		
	}

   /**
     * Method to verify a given operator is valid or not 
     * 
     * @param operator
     * 					: String - symbol representing operation
     * 
     * @return
     * 					: boolean - valid operation or not
     */
	
	private  boolean isValidOperator(String operator) {
		if(operator == null )
			return false;
		else if(operator.length()!=1)
		{
			return false;
		}
		else {
			String pattern = "(?i)[*+-/%pd]";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(operator);
			if (m.find( )) {
				return true;
			}else {
				return false;
			}
		}
	}

}
