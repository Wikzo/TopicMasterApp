package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.NextCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowVotingResultsState implements IState
{

	private final String[] _commands =
	{ InputHandler.NextCommandString, InputHandler.ExitCommandString, InputHandler.UndoCommandString};

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager) throws IOException
	{
		if (input instanceof ExitCommand)
			input.Execute(topicManager);

		if (input instanceof NextCommand)
		{
			input.Execute(topicManager);
			return new ShowTopicState();
		}

		return this;
	}

	@Override
	public String Update(TopicManager topicManager)
	{
		InputHandler.DisplayPossibleCommands(_commands);
		
		return "Show Voting state update";
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		String results = "Voting has now ended. Here are the results:\n";
		results += topicManager.DisplayCurrentVotes();
		
		System.out.println(results);

		InputHandler.ClearConsole();
		
		return results;

	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "Show Voting state exit";

	}

}
