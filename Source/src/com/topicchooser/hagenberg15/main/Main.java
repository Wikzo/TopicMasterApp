package com.topicchooser.hagenberg15.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class Main
{

	final static boolean UseDummyPlayers = true;
	
	public static void main(String[] args) throws IOException
	{
		
		PlayerManager playerManager = new PlayerManager();
		TopicManager topicManager = new TopicManager(playerManager, UseDummyPlayers);
		ICommand command = null;
		
		boolean exit = false;
		while (!exit)
		{
			topicManager.Update();
			
			command = InputHandler.HandleInput(topicManager);
			if (command != null)	
				topicManager.HandleInputAndState(command);
		}

	}

}
