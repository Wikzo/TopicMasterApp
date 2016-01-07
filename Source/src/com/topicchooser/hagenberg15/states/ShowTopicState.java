package com.topicchooser.hagenberg15.states;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.NextCommand;
import com.topicchooser.hagenberg15.commands.ShowResultsCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class ShowTopicState implements IState
{

	public final String[] PossibleCommands =
	{ VoteCommand.ShowCommandToUser(), ShowResultsCommand.ShowCommandToUser(), ExitCommand.ShowCommandToUser() };

	public final String EnterString = "Calculating a new topic...";

	@Override
	public IState HandleInput(ICommand input, TopicManager topicManager) throws IOException
	{

		if (input instanceof ExitCommand)
			input.Execute(topicManager);

		if (input instanceof VoteCommand) // and when time has passed...
		{
			input.Execute(topicManager); // TODO: needs to return bool
			return new ShowVotingResultsState();
		}

		if (input instanceof ShowResultsCommand)
			input.Execute(topicManager);

		return this;
	}

	@Override
	public String Update(TopicManager topicManager)
	{
		String currentTopic = "\nCURRENT TOPIC: " + topicManager.DisplayCurrentTopic() + "\n";

		System.out.println(currentTopic);

		InputHandler.DisplayPossibleCommands(PossibleCommands);

		return currentTopic;
	}

	@Override
	public String EnterState(TopicManager topicManager)
	{
		InputHandler.ClearConsole();
		System.out.println(EnterString);

		// Update(topicManager);

		// System.out.println(topicManager.GetCurrentState());

		// TODO: TopicManager.CalculateNewTopic()

		return EnterString;
	}

	@Override
	public String ExitState(TopicManager topicManager)
	{
		return "ShowTopic state exit";
	}

}
