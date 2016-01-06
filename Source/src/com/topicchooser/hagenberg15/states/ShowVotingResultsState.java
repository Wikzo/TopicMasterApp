package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.NextCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowVotingResultsState implements IState
{

	public final String[] PossibleCommands =
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
		String results = EnterState(topicManager);
		
		System.out.println(results);
		
		InputHandler.DisplayPossibleCommands(PossibleCommands);
		return results;
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		String results = "\nVOTING HAS ENDED. Here are the results:\n";
		results += topicManager.DisplayCurrentVotes() + "\n";
		results += "\nUse the [next] command to get a new topic.\n";
		
		//System.out.println(results);

		//InputHandler.ClearConsole();
		
		return results;

	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "Show Voting state exit";

	}

}
