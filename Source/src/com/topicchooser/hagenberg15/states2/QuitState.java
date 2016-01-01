package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class QuitState implements IState
{

	public QuitState()
	{
		
	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager)
	{
		return this;
	}

	@Override
	public void Update(TopicManager topicManager)
	{
		
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		
	}

}
