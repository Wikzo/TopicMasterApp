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
	private boolean _useStoredInput = false;
	private String[] _storedInput;

	public PlayerManager PlayerManager;
	public TopicManager TopicManager;
	public ICommand Command;
	
	public String UpdateString = "";
	public String StateString = "";

	public TopicChooserFacade(String[] storedInputs)
	{
		boolean useStoredInputsAndDummyData = (storedInputs == null) ? false : true;

		if (useStoredInputsAndDummyData)
		{
			_useStoredInput = true;
			_storedInput = storedInputs;
			InputHandler.SetStoredInputs(_storedInput);
		}

		PlayerManager = new PlayerManager();
		TopicManager = new TopicManager(PlayerManager, _useStoredInput);
		Command = null;
	}

	public void Run() throws IOException
	{
		boolean exit = false;
		while (!exit)
		{
			UpdateNextStep();
		}
	}

	public void UpdateNextStep() throws IOException
	{
		UpdateString ="";
		StateString ="";
		
		UpdateString = TopicManager.Update();

		Command = InputHandler.HandleInput(TopicManager);
		if (Command != null)
			StateString = TopicManager.HandleInputAndState(Command);

	}

}
