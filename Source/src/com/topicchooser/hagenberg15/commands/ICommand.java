package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.TopicManager;

public interface ICommand
{
	void Execute(TopicManager topicManager);
	void Undo(TopicManager topicManager); // undo is indepedent of the current state in TopicManager!
}
