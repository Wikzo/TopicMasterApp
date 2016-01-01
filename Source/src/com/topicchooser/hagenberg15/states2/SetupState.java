package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.GetVotesCommand;
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
		if (input instanceof GetVotesCommand)
		{
			input.Execute(topicManager);
			return new VotingState();
		
		}
		
		if (input instanceof ExitCommand)
		{
			input.Execute(topicManager);
			return new QuitState();
		}
		
		return this;
	}

	@Override
	public void Update(TopicManager topicManager)
	{
		
		
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		System.out.println("Hello and welcome to TOPIC CHOOSER. Before we begin, we need some basic information about you...");
		
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		
		
	}

}
