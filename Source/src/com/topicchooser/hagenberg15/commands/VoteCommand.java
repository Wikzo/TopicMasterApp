package com.topicchooser.hagenberg15.commands;

import java.io.IOException;
import java.util.Scanner;

import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.states.ShowTopicState;
import com.topicchooser.hagenberg15.topics.TopicManager;
import com.topicchooser.hagenberg15.topics.VoteContainer;

public class VoteCommand implements ICommand
{

	private VoteContainer _previousVotes;

	public VoteCommand()
	{
		
	}

	@Override
	public void Execute(TopicManager topicManager) throws IOException
	{
		_previousVotes = topicManager.CurrentVotes;
		VoteContainer newVotes = new VoteContainer(topicManager.CurrentTopic);

		for (Player p : topicManager.PlayerManager.Players)
			CastVote(newVotes, p, topicManager);

		topicManager.CurrentVotes = newVotes;
	}

	private void CastVote(VoteContainer newVotes, Player p, TopicManager topicManager) throws IOException
	{
		int vote = -1;
		while (vote != 1 && vote != 2 && vote != 3)
		{
			System.out.println("CURRENT TOPIC: " + topicManager.CurrentTopic.TopicText + "\n");

			System.out.println(p.Name.toUpperCase() + ", please vote:");
			System.out.println(ShowVotingOptions());
			vote = InputHandler.GetPositiveNumber();
		}

		newVotes.AddVote(vote);

		InputHandler.ClearConsole();
	}

	public String ShowVotingOptions()
	{
		return "1. I liked this topic; give me something similar.\n2. I did not like this topic; give me something completely different.\n3. Try keyword search.\n";
	}

	@Override
	public void Undo(TopicManager topicManager)
	{
		if (_previousVotes != null)
		{
			System.out.println("\n[Undoing previous vote...]\n");
			topicManager.CurrentVotes = _previousVotes;
			
			topicManager.ChangeState(topicManager.GetPreviousState());
		}
	}

}
