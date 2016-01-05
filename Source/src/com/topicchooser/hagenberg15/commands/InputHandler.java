package com.topicchooser.hagenberg15.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import com.topicchooser.hagenberg15.topics.TopicManager;

// "Invoker"

public class InputHandler
{

	// TODO: only show POSSIBLE commands (depending on the current state)
	private final static String _possibleCommands = "\nCommands:\n[vote], [next], [undo], [exit]\n";

	public final static String VoteCommandString = "[vote]";
	public final static String NextCommandString = "[next]";
	public final static String UndoCommandString = "[undo]";
	public final static String ExitCommandString = "[exit]";

	public static String DisplayPossibleCommands(String[] strings)
	{
		StringBuffer s = new StringBuffer();
		s.append("Possible commands: ");
		for (int i = 0; i < strings.length; i++)
		{
			s.append(strings[i]);

			if (i + 1 < strings.length)
				s.append(", ");
		}
		s.append("\n");

		System.out.println(s.toString());

		return s.toString();
	}

	static int index = 0;
	
	static String line1 = "2\n";
	static String line2 = "gustav\n";
	static String line3 = "20\n";
	static String line4 = "m\n";
	static String line5 = "mathias0\n";
	
	static String[] lines = {line1, line2, line3, line4, line5};
	
	private static ICommand _previousCommand = null;
	public static ICommand HandleInput(TopicManager topicManager) throws IOException
	{
		// System.out.println(_possibleCommands);

		//Scanner keyboard = new Scanner(System.in);
		//String input = keyboard.nextLine().toLowerCase();
		
		BufferedReader in_old = new BufferedReader(new InputStreamReader(System.in));
		String input = in_old.readLine().toLowerCase();

		/*
		 BufferedReader in = new BufferedReader(new StringReader(
				 lines[index++]
		     ));
		 
		String input = in.readLine().toLowerCase();
		
		System.out.println("input: " + input);*/
		
		ICommand command = null;

		if (input.equals("vote"))
			command = new VoteCommand();
		else if (input.equals("next"))
			command = new NextCommand();
		else if (input.equals("undo") && _previousCommand != null)
			_previousCommand.Undo(topicManager);
		else if (input.equals("exit"))
			command = new ExitCommand();
		else
			System.out.println("ERROR: invalid input command. Please try again!\n\n");

		_previousCommand = command;

		System.out.println();

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
			System.out.println("Enter a number:");
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

	public final static void ClearConsole()
	{
		// https://stackoverflow.com/questions/2979383/java-clear-the-console#17015039
		// this will show some strange symbols in Eclipse's built-in console
		// but it works with cmd in Windows

		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
