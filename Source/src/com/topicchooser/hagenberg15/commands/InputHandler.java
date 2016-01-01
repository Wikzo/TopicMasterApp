package com.topicchooser.hagenberg15.commands;

import java.util.Scanner;

import com.topicchooser.hagenberg15.topics.TopicManager;

// "Invoker"

public class InputHandler
{

	private final static String _possibleCommands = "\nCommands:\n[vote], [moveup], [movedown], [undo], [exit]\n";
	private static ICommand _previousCommand = null;

	public static ICommand HandleInput(TopicManager topicManager)
	{		
		System.out.println(_possibleCommands);

		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine().toLowerCase();

		ICommand command = null;

		// TODO: some of these commands will not be exposed to the players
		// here, they are just temporary debug test stuff

		if (input.equals("vote"))
			command = new GetVotesCommand();
		else if (input.equals("moveup"))
			command = new MoveUpCommand();
		else if (input.equals("movedown"))
			command = new MoveDownCommand();
		else if (input.equals("undo") && _previousCommand != null)
			_previousCommand.Undo(topicManager);
		else if (input.equals("exit"))
			command = new ExitCommand();
		else
			System.out.println("ERROR: invalid input command. Please try again!\n\n");

		_previousCommand = command;

		return command;
	}

	public static boolean GetYesOrNo()
	{
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine().toLowerCase();

		if (input.equals("y"))
			return true;
		else
			return false;
	}

	public static int GetPositiveNumber()
	{
		Scanner sc = new Scanner(System.in);
		int number;
		do
		{
			System.out.println("Please enter a number:");
			while (!sc.hasNextInt())
			{
				System.out.println("That's not a number. Please enter again:");
				sc.next();
			}
			number = sc.nextInt();
		} while (number <= 0);

		return number;
	}

	public static String GetNextString()
	{
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static char GetGenderChar()
	{
		Scanner sc = new Scanner(System.in);

		boolean correct = false;
		char gender = '-';

		while (!correct)
		{
			System.out.println("Male / Female / Other:");
			String input = sc.nextLine().toLowerCase();

			if (input.equals("male") || input.equals("m"))
			{
				correct = true;
				gender = 'M';
			}

			else if (input.equals("female") || input.equals("f"))
			{
				correct = true;
				gender = 'F';
			}

			else if (input.equals("other") || input.equals("o"))
			{
				correct = true;
				gender = 'O';
			}
		}

		return gender;
	}

	public static void ClearConsole()
	{
		// Eclipse console
		/*for (int i = 0; i < 200; ++i)
			System.out.println();*/
		
		// Windows cmd
		/*final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();*/
	}

}
