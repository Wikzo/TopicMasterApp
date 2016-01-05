package com.topicchooser.hagenberg15.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class Main
{

	final static boolean UseDummyPlayers = false;

	static String line1 = "vote\n";
	static String line2 = "1\n";
	static String line3 = "2\n";
	static String line4 = "2\n";
	static String line5 = "exit\n";
	static String line6 = "y\n";
	static int index = 0;

	static String[] lines =
	{ line1, line2, line3, line4, line5, line6 };

	public static void main(String[] args) throws IOException
	{

		PlayerManager playerManager = new PlayerManager();
		TopicManager topicManager = new TopicManager(playerManager, UseDummyPlayers);
		ICommand command = null;

		boolean exit = false;
		while (!exit && index < 6)
		{
			topicManager.Update();

			

			command = InputHandler.HandleInput(topicManager);
			if (command != null)
				topicManager.HandleInputAndState(command);
		}

	}

	public static BufferedReader NextInput()
	{
		if (UseDummyPlayers && index + 1 <= lines.length)
			return new BufferedReader(new StringReader(lines[index++]));
		else
			return new BufferedReader(new InputStreamReader(System.in));

	}

}
