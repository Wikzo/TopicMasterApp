package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class VotingState implements IState
{

	public VotingState()
	{
		
	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager)
	{
		// if all inputs...
		
		return this;
	}

	@Override
	public void Update(TopicManager topicManager)
	{
		
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		System.out.println("Entering VOTING state");
		
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		System.out.println("Exiting VOTING state");
		
	}

}
