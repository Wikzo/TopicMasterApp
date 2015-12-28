package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;

public class TopicManager
{
	public int VotesCountedSoFar = 0;

	private int _voteScores = 0;

	private Topic _currentTopic;

	private List<Topic> _topics;
	private List<Player> _players;

	public TopicManager(int numberOfPlayers)
	{
		_topics = new ArrayList<>();
		_players = new ArrayList<>(numberOfPlayers);
		
		for (int i = 0; i < numberOfPlayers; i++)
			_players.add(new Player('M', 21));
	}

	public String DisplayTopic()
	{
		return _currentTopic.TopicText;
	}

	public void AddVote(int vote)
	{
		VotesCountedSoFar += (int)Math.signum(vote);
		_voteScores += vote;

		if (VotesCountedSoFar >= GetPlayerCount())
			CalculateNextTopic();
	}

	private void CalculateNextTopic()
	{
		System.out.println("\n[Calculating next topic...]\n");
		float avg = _voteScores / GetPlayerCount();
	}

	public void MoveHorizontal(int direction)
	{
		if (direction > 0)
			System.out.println("\n[Moving to the right...]\n");
		else if (direction < 0)
			System.out.println("\n[Moving to the left...]\n");
	}
	
	public void MoveVertical(int direction)
	{
		if (direction > 0)
			System.out.println("\n[Moving one level down...]\n");
		else if (direction < 0)
			System.out.println("\n[Moving one level up...]\n");
	}
	

	public int GetPlayerCount()
	{
		return _players.size();
	}

}
