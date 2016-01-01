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

}
