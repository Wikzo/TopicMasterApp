package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.ShowResultsCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowTopicState implements IState
{

	public final String[] PossibleCommands =
	{ VoteCommand.ShowCommandToUser(), ShowResultsCommand.ShowCommandToUser(), ExitCommand.ShowCommandToUser() };

	public final String EnterString = "";

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager) throws IOException
	{
		if (input instanceof ExitCommand)
			input.Execute(topicManager);

		if (input instanceof VoteCommand)
		{
			input.Execute(topicManager);
			return new ShowVotingResultsState();
		}

		if (input instanceof ShowResultsCommand)
			input.Execute(topicManager);

		return this;
	}

	@Override
	public String Update(TopicManager topicManager)
	{
		String currentTopic = "CURRENT TOPIC: " + topicManager.DisplayCurrentTopic() + "\n";
		System.out.println(currentTopic);
		InputHandler.DisplayPossibleCommands(PossibleCommands);

		return currentTopic;
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		InputHandler.ClearConsole();
		System.out.println(EnterString);

		return EnterString;
	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "ShowTopic state exit";
	}

}
