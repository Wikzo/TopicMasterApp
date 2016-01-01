package com.topicchooser.hagenberg15.states2;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.NextCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowTopicState implements IState
{
	
	private final String[] _commands = {InputHandler.VoteCommandString, InputHandler.ExitCommandString};

	public ShowTopicState()
	{
	}

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager)
	{

		if (input instanceof ExitCommand)
			input.Execute(topicManager);
		
		
		if (input instanceof VoteCommand) // and when time has passed...
		{
			input.Execute(topicManager);
			return new VotingState();
		}

		return this;
	}

	@Override
	public void Update(TopicManager topicManager)
	{
		System.out.println("CURRENT TOPIC: " + topicManager.DisplayCurrentTopic() + "\n");
		
		InputHandler.DisplayPossibleCommands(_commands);
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		InputHandler.ClearConsole();
	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		//System.out.println("Exiting SHOW TOPIC state");
	}

}
