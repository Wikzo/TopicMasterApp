package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public interface IState
{
	IState HandleInput(ICommand input, TopicManager topicManager);

	void Update(TopicManager topicManager);

	void EnterState(TopicManager topicManager);

	void ExitState(TopicManager topicManager);
}
