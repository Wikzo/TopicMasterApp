package com.topicchooser.hagenberg15.states;

import java.io.IOException;

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
	public IState HandleInput(ICommand input, TopicManager topicManager) throws IOException
	{

		if (input instanceof ExitCommand)
			input.Execute(topicManager);
		
		
		if (input instanceof VoteCommand) // and when time has passed...
		{
			input.Execute(topicManager);
			return new ShowVotingResultsState();
		}

		return this;
	}

	@Override
	public String Update(TopicManager topicManager)
	{
		String currentTopic = "CURRENT TOPIC: " + topicManager.DisplayCurrentTopic() + "\n";
		
		InputHandler.DisplayPossibleCommands(_commands);
		
		return currentTopic;
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		InputHandler.ClearConsole();
		
		return "ShowTopic state enter";
	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "ShowTopic state exit";
	}

}
