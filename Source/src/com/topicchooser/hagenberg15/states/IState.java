package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public interface IState
{
	IState HandleInput(ICommand input, TopicManager topicManager) throws IOException;

	String Update(TopicManager topicManager);
	String EnterState(TopicManager topicManager);
	String ExitState(TopicManager topicManager);
}
