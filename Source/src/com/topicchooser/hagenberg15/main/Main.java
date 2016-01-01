package com.topicchooser.hagenberg15.main;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class Main
{

	public Main() {	}

	public static void main(String[] args)
	{
		PlayerManager playerManager = new PlayerManager();
		TopicManager topicManager = new TopicManager(playerManager);
		ICommand command = null;
		
		boolean exit = false;
		while (!exit)
		{
			
			topicManager.Update();
			
			command = InputHandler.HandleInput(topicManager);
			if (command != null)	
				topicManager.HandleInput(command);
		}

	}

}
