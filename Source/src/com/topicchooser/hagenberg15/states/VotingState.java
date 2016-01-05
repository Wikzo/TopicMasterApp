package com.topicchooser.hagenberg15.states;

import com.topicchooser.hagenberg15.commands.ExitCommand;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.commands.NextCommand;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class VotingState implements IState
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
		System.out.println("Voting has ended. Here are the results:\n");
		System.out.println(topicManager.DisplayCurrentVotes());

		System.out.println("\nUse the [next] command to get a new topic!\n");

		InputHandler.DisplayPossibleCommands(_commands);
	}

	@Override
	public void EnterState(TopicManager topicManager)
	{
		// System.out.println("Entering VOTING state");

		InputHandler.ClearConsole();

	}

	@Override
	public void ExitState(TopicManager topicManager)
	{
		// System.out.println("Exiting VOTING state");

	}

}
