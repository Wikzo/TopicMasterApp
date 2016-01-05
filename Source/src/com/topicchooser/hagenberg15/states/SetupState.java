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
	public void Update(TopicManager topicManager)
	{

	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		System.out.println(
				"Hello and welcome to TOPIC CHOOSER. Before we begin, we need some basic information about you...");

		try
		{
			topicManager.PlayerManager.SetupPlayers(_useDummyPlayers);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{

	}

}
