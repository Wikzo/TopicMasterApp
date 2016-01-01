package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class ExitCommand implements ICommand
{

	public ExitCommand()
	{
		
	}

	@Override
	public void Execute(TopicManager topicManager)
	{
		topicManager.Exit();
	}

	@Override
	public void Undo(TopicManager topicManager)
	{
		
		
	}

}
