package com.topicchooser.hagenberg15.commands;

import java.io.IOException;
import java.util.Scanner;

import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.states.ShowTopicState;
import com.topicchooser.hagenberg15.topics.TopicManager;
import com.topicchooser.hagenberg15.topics.VoteCounter;

public class VoteCommand implements ICommand
{
	private VoteCounter _previousVoteCounter;

	@Override
	public void Execute(TopicManager topicManager) throws IOException
	{
		_previousVoteCounter = topicManager.CurrentVoteCounter;
		
		VoteCounter newVoteCounter = new VoteCounter(topicManager.CurrentTopic);

		for (Player p : topicManager.PlayerManager.Players)
			CastVote(newVoteCounter, p, topicManager);

		topicManager.CurrentVoteCounter = newVoteCounter;
	}

	private void CastVote(VoteCounter newVoteCounter, Player p, TopicManager topicManager) throws IOException
	{
		int vote = -1;
		while (vote != 1 && vote != 2 && vote != 3)
		{
			System.out.println("CURRENT TOPIC: " + topicManager.CurrentTopic.TopicText + "\n");

			System.out.println(p.Name.toUpperCase() + ", please vote:");
			System.out.println(ShowVotingOptions());
			vote = InputHandler.GetPositiveNumber();
		}

		newVoteCounter.AddVote(vote);

		InputHandler.ClearConsole();
	}

	public String ShowVotingOptions()
	{
		return "1. I did not like this topic. Give me something different.\n2. The topic was okay. I am fine with more like this or something different.\n3. The topic was interesting. Give me something similar.";
	}

	@Override
	public void Undo(TopicManager topicManager)
	{
		if (_previousVoteCounter != null)
		{
			System.out.println("\n[Undoing previous vote...]\n");
			topicManager.CurrentVoteCounter = _previousVoteCounter;
			
			topicManager.ChangeState(topicManager.GetPreviousState());
		}
	}

	public static String ShowCommandToUser()
	{
		return "[v]ote";
	}

	public static String[] ValidCommands()
	{
		return new String[]{"vote", "v"};
	}

}
