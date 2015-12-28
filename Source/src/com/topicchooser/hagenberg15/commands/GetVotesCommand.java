package com.topicchooser.hagenberg15.commands;

import java.util.Scanner;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class GetVotesCommand implements ICommand
{

	private int _previousVote; // TODO: this will not work, since it is not stored when a new command is made! Move it to TopicManager instead!
	
	public GetVotesCommand()
	{
	}

	@Override
	public void Execute(TopicManager t)
	{		
		for (int i = 0; i < t.GetPlayerCount(); i++)
		{
			String s = String.format("Player %s: please vote:", i+1);
			System.out.println(s);
			
			Scanner keyboard = new Scanner(System.in);
			int vote = 	keyboard.nextInt();
			
			t.AddVote(vote);
			_previousVote = vote;
		}
	}

	@Override
	public void Undo(TopicManager t)
	{
		System.out.println("\n[Undoing previous vote...]\n");
		t.AddVote(_previousVote);
	}

}
