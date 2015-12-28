package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class ExitCommand implements ICommand
{

	public ExitCommand()
	{
		
	}

	@Override
	public void Execute(TopicManager t)
	{
		
		System.out.println("\n[Exit]\n");
	}

	@Override
	public void Undo(TopicManager t)
	{
		
		
	}

}
