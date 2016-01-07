package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.Topic;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class NextCommand implements ICommand
{

	Topic _previousTopic;

	@Override
	public void Execute(TopicManager topicManager)
	{
		_previousTopic = topicManager.CurrentTopic;
		topicManager.CalculateNextTopic();

	}

	@Override
	public void Undo(TopicManager topicManager)
	{
		topicManager.CurrentTopic = _previousTopic;
	}

	public static String ShowCommandToUser()
	{
		return "[n]ext";
	}

	public static String[] ValidCommands()
	{
		return new String[]{"next", "n"};
	}

}
