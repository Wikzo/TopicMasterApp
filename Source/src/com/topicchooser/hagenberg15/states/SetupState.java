package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class SetupState implements IState
{

	private boolean _useDummyPlayers = false;

	public SetupState(boolean useDummyPlayers)
	{
		this._useDummyPlayers = useDummyPlayers;
	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager) throws IOException
	{
		if (input instanceof ExitCommand)
			input.Execute(topicManager);

		return this;
	}

	@Override
	public String Update(TopicManager topicManager)
	{
		return "Setup state update";
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		String hello = "Hello and welcome to TOPIC CHOOSER. Before we begin, we need some basic information about you...";
		System.out.println(hello);

		try
		{
			topicManager.PlayerManager.SetupPlayers(_useDummyPlayers);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hello;
	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		System.out.println(topicManager.PlayerManager.DisplayCurrentPlayers());
		return topicManager.PlayerManager.DisplayCurrentPlayers();
	}

}
