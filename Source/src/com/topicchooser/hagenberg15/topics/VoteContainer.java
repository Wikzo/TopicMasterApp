package com.topicchooser.hagenberg15.topics;

public class VoteContainer
{

	public int HateVotes;
	public int OkayVotes;
	public int LoveVotes;
	
	private int _numberOfVotes;

	protected Topic _topic;

	public VoteContainer(Topic topic)
	{
		ResetAllVotes();

		_topic = topic;
		_topic.AssociateWithVotes(this);

	}

	public void ResetAllVotes()
	{
		HateVotes = 0;
		OkayVotes = 0;
		LoveVotes = 0;
	}

	
	public void AddVote(int vote)
	{
		if (vote != 1 && vote != 2 && vote != 3)
			throw new RuntimeException("ERROR: votes can only be 1, 2, or 3!");
		
		_numberOfVotes++;
		
		if (vote == 1)
			HateVotes++;
		else if (vote == 2)
			OkayVotes++;
		else if (vote == 3)
			LoveVotes++;
	}

	public Topic GetNextTopic(int numberOfPlayers)
	{
		if (_numberOfVotes != numberOfPlayers)
			throw new RuntimeException("ERROR: number of players are not correct!");
		
		float numerator = (HateVotes * 0) + (OkayVotes * 50) + (LoveVotes * 100);
		float denominator = numberOfPlayers;

		float avgMean = numerator / denominator;

		return MoodCalculator(avgMean);
	}
	
	private Topic MoodCalculator(float mood)
	{
		System.out.println("Mood: " + mood + "%");
		
		if (mood > 50)
			return _topic.GetKid();
		else if (mood > 25)
			return _topic.GetParent(1);
		else
			return _topic.GetParent(2);
	}

	@Override
	public String toString()
	{
		return "More like this: " + HateVotes + "\nSomething different: " + OkayVotes + "\nKeyword search: "
				+ LoveVotes;
	}
}
