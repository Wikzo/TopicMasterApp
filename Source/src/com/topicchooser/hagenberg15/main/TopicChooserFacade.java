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

public class TopicChooserFacade
{
	private final static boolean _useStoredInput = true;
	
	PlayerManager playerManager;
	TopicManager topicManager;
	ICommand command;
	
	public TopicChooserFacade(boolean useStoredInputs, String[] storedInputs)
	{
		if (useStoredInputs && storedInputs == null)
			throw new RuntimeException("Error! Need to assign the stored inputs!");
		
		if (useStoredInputs)
			InputHandler.SetStoredInputs(storedInputs);
		
		 playerManager = new PlayerManager();
		 topicManager = new TopicManager(playerManager, _useStoredInput);
		 command = null;
	}
	
	public void Start() throws IOException
	{
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
