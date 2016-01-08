package com.topicchooser.hagenberg15.commands;

import java.io.IOException;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowResultsCommand implements ICommand
{

	@Override
	public void Execute(TopicManager topicManager) throws IOException
	{
		System.out.println(topicManager.CurrentVoteCounter.toString());
	}

	@Override
	public void Undo(TopicManager topicManager)
	{
		
	}

	public static String ShowCommandToUser()
	{
		return "[r]esults";
	}

	public static String[] ValidCommands()
	{
		return new String[]{"results", "r"};
	}



}
