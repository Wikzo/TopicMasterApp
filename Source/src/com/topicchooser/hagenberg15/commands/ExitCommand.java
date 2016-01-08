package com.topicchooser.hagenberg15.commands;

import java.io.IOException;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class ExitCommand implements ICommand
{
	@Override
	public void Execute(TopicManager topicManager) throws IOException
	{
		topicManager.Exit();
	}

	@Override
	public void Undo(TopicManager topicManager)
	{

	}

	public static String ShowCommandToUser()
	{
		return "[e]xit";
	}

	public static String[] ValidCommands()
	{
		return new String[]
		{ "exit", "e" };
	}

}
