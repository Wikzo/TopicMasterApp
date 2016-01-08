package com.topicchooser.hagenberg15.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

import com.topicchooser.hagenberg15.main.Main;
import com.topicchooser.hagenberg15.topics.TopicManager;

// "Invoker"

public class InputHandler
{

	public static final String UndoCommandString = "[u]ndo";
	private static boolean _useStoredInput = false;
	private static int _storedInputIndex;
	private static String[] _storedDummyInputs;
	private static ICommand _previousCommand = null;

	public static void SetStoredInputs(String[] storedInputs)
	{
		_useStoredInput = true;
		_storedDummyInputs = storedInputs;
		_storedInputIndex = 0;
	}

	public static BufferedReader GetNextAvailableInput()
	{
		if (_useStoredInput && _storedInputIndex + 1 <= _storedDummyInputs.length)
			return new BufferedReader(new StringReader(_storedDummyInputs[_storedInputIndex++]));
		else
			return new BufferedReader(new InputStreamReader(System.in));
	}

	static String GetNextInput() throws IOException
	{
		// input handling inspired by
		// https://stackoverflow.com/questions/4230402/testing-console-based-applications-programs-java

		BufferedReader reader = GetNextAvailableInput();
		String input = reader.readLine().toLowerCase();

		if (_useStoredInput)
			System.out.println("\n>>> INPUT: " + input);

		return input;
	}

	public static String DisplayPossibleCommands(String[] strings)
	{
		StringBuffer s = new StringBuffer();
		s.append("--- Possible commands: ");
		for (int i = 0; i < strings.length; i++)
		{
			s.append(strings[i]);

			if (i + 1 < strings.length)
				s.append(", ");
		}
		s.append(" ---\n");

		System.out.println(s.toString());

		return s.toString();
	}

	public static ICommand HandleInput(TopicManager topicManager) throws IOException
	{
		String input = GetNextInput();

		ICommand command = null;

		if (Arrays.asList(VoteCommand.ValidCommands()).contains(input))
			command = new VoteCommand();
		else if (Arrays.asList(NextCommand.ValidCommands()).contains(input))
			command = new NextCommand();
		else if ((input.equals("u") || input.equals("undo"))  && _previousCommand != null)
			_previousCommand.Undo(topicManager);
		else if (Arrays.asList(ExitCommand.ValidCommands()).contains(input))
			command = new ExitCommand();
		else
			System.out.println("ERROR: invalid input command. Please try again!\n\n");

		_previousCommand = command;

		System.out.println();
		
		if (command != null)
			ClearConsole();

		return command;
	}

	public static boolean GetYesOrNo() throws IOException
	{
		// Scanner keyboard = new Scanner(System.in);
		// String input = keyboard.nextLine().toLowerCase();

		String input = GetNextInput();

		if (input.equals("y"))
			return true;
		else
			return false;
	}

	public static int GetPositiveNumber() throws IOException
	{	
		System.out.println("Enter a number:");
		String input = GetNextInput();
		
		Integer number = null;
		number = TryParse(input);
		
		while (number == null || number <= 0)
		{
			System.out.println("That's not a valid input. Please enter a positive integer:");
			input = GetNextInput();
			number = TryParse(input);
		}
		
		return number;
	}


	public static Integer TryParse(String text)
	{
		try
		{
			return Integer.parseInt(text);
		} catch (NumberFormatException e)
		{
			return null;
		}
	}

	public static String GetNextString() throws IOException
	{
		String input = GetNextInput();
		return input;
	}

	public static char GetGenderChar()
	{
		Scanner sc = new Scanner(System.in);

		boolean correct = false;
		char gender = '-';

		while (!correct)
		{
			System.out.println("[M]ale / [F]emale / [O]ther:");
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
