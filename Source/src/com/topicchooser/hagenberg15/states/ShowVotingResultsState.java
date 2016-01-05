package com.topicchooser.hagenberg15.states;

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
	public IState HandleInput(ICommand input, TopicManager topicManager)
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
	public void Update(TopicManager topicManager)
	{
		InputHandler.DisplayPossibleCommands(_commands);
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		System.out.println("Voting has ended. Here are the results:\n");
		System.out.println(topicManager.DisplayCurrentVotes());

		InputHandler.ClearConsole();

	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		// System.out.println("Exiting VOTING state");

	}

}
