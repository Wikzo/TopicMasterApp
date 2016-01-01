package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.GetVotesCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowTopic implements IState
{

	public ShowTopic()
	{
	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager)
	{
		//if (input instanceof GetVotesCommand)
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
		System.out.println("Entering SHOW TOPIC state");
		
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		System.out.println("Exiting SHOW TOPIC state");
	}

}
