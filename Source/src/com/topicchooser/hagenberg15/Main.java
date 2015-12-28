package com.topicchooser.hagenberg15;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class Main
{

	public Main() {	}

	public static void main(String[] args)
	{
		TopicManager topicManager = new TopicManager(2);
		ICommand command = null;
		
		boolean exit = false;
		while (!exit)
		{
			command = InputHandler.HandleInput(topicManager);
			
			if (command != null)
				command.Execute(topicManager);			
		}

	}

}
