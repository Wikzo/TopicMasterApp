package com.topicchooser.hagenberg15.commands;

import java.util.Scanner;

import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.topics.TopicManager;
import com.topicchooser.hagenberg15.topics.Vote;

public class VoteCommand implements ICommand
{

	private Vote _previousVotes;

	public VoteCommand()
	{
	}

	@Override
	public void Execute(TopicManager topicManager)
	{
		_previousVotes = topicManager.CurrentVotes;
		Vote newVotes = new Vote();

		for (Player p : topicManager.PlayerManager.Players)
			CastVote(newVotes, p, topicManager);

		topicManager.CurrentVotes = newVotes;
	}

	private void CastVote(Vote newVotes, Player p, TopicManager topicManager)
	{
		System.out.println("CURRENT TOPIC: " + topicManager.CurrentTopic.TopicText + "\n");

		System.out.println(p.Name + ", please vote:");
		System.out.println(ShowVotingOptions());

		int vote = -1;
		while (vote != 1 && vote != 2 && vote != 3)
			vote = InputHandler.GetPositiveNumber();

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
		System.out.println("\n[Undoing previous vote...]\n");
		topicManager.CurrentVotes = _previousVotes;
	}

}
