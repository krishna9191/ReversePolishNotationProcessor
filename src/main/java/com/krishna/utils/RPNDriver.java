package com.krishna.utils;

import java.util.Scanner;

/**
 * Driver code for RPNProcessor
 * @author RK
 *
 */


public class RPNDriver {


	public static void main(String[] args) {

		int mode ;
		Scanner in = new Scanner(System.in);
		if(args.length!=1||(!args[0].equals("1") && !args[0].equals("2")))
		{
			System.out.println("please enter the mode of operation");

			while(true)
			{	
				
				try{
					System.out.println("1 - Line Processing");
					System.out.println("2 - Stream Processing");
					System.out.println("3 - To exit");
					int inputMode = Integer.parseInt(in.nextLine());
					if(inputMode==1 || inputMode ==2)
					{
						mode =inputMode;
						break;
					}
					else if(inputMode ==3)
					{
						System.out.println("Exiting the RPNProcessor");
						in.close();
						return;
					}
					else
					{
						System.out.println("Please enter a number from the following options");
					}
				}

				catch(NumberFormatException nfe)
				{	
					System.out.println("Error : invalid data format");
					System.out.println("Please enter a number from the following options");

				}
				catch(Exception e)
				{
					e.printStackTrace(System.err);
					System.out.println("Exiting the RPNProcessor");
				}
		
			}
		}
			else
				mode = Integer.parseInt(args[0]);

			RPNProcessor processor = new RPNProcessor();
			if(mode ==1)
			{	
				System.out.println("Enter the input String :");
				String inputLine ="";
				while(in.hasNext())
				{
					 inputLine = in.nextLine();
					 break;
				}
				if(inputLine !=null)
				{
					String[] elements = inputLine.split(processor.getDelimiter());
					for(String element : elements)
					{
						processor.process(element);
					}
				}
			}
			else
			{
				System.out.println("Enter the input as Stream (EOF to stop) :");
				while(in.hasNext())
				{
					String inputLine = in.nextLine();
					if(inputLine !=null)
					{
						processor.process(inputLine);

					}
				}
			}
			System.out.println(processor.getResult());
			in.close();

		
	}


}
