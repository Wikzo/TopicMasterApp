package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class SetupState implements IState
{

	public SetupState()
	{

	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager)
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
		topicManager.PlayerManager.SetupPlayers();
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{

	}

}
