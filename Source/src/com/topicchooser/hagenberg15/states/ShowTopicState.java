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
		String currentTopic = "\nCURRENT TOPIC: " + topicManager.DisplayCurrentTopic() + "\n";
		
		System.out.println(currentTopic);
		
		InputHandler.DisplayPossibleCommands(_commands);
		
		return currentTopic;
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		InputHandler.ClearConsole();
		String enter = "ShowTopic state enter";
		System.out.println(enter);
		
		//Update(topicManager);
		return enter;
	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "ShowTopic state exit";
	}

}
