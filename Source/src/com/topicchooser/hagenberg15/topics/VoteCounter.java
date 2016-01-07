package com.topicchooser.hagenberg15.topics;

public class VoteCounter
{

	public int DidNotLikeIt;
	public int OkayVotes;
	public int LikedIt;

	private int _numberOfVotes;

	protected Topic _topic;

	public VoteCounter(Topic topic)
	{
		ResetAllVotes();

		_topic = topic;
		_topic.AssociateWithVotes(this);

	}

	public void ResetAllVotes()
	{
		DidNotLikeIt = 0;
		OkayVotes = 0;
		LikedIt = 0;
	}

	public void AddVote(int vote)
	{
		if (vote != 1 && vote != 2 && vote != 3)
			throw new RuntimeException("ERROR: votes can only be 1, 2, or 3!");

		_numberOfVotes++;

		if (vote == 1)
			DidNotLikeIt++;
		else if (vote == 2)
			OkayVotes++;
		else if (vote == 3)
			LikedIt++;
	}

	public Topic GetNextTopic(int numberOfPlayers)
	{
		float avgMean = CalculateMood(numberOfPlayers);

		return MoodAnalyzer(avgMean);
	}

	public float CalculateMood(int numberOfPlayers)
	{
		if (_numberOfVotes != numberOfPlayers)
			throw new RuntimeException("ERROR: number of players are not correct!");

		float numerator = (DidNotLikeIt * 0) + (OkayVotes * 50) + (LikedIt * 100);
		float denominator = numberOfPlayers;

		float avgMean = numerator / denominator;
		return avgMean;
	}
	

	private Topic MoodAnalyzer(float mood)
	{
		//System.out.println("Mood: " + mood + "%");

		if (mood >= 50) // positive
			return _topic.GetKid();
		else if (mood >= 25) // a little negative
			return _topic.GetParent(1);
		else // very negative
			return _topic.GetParent(2);
	}

	@Override
	public String toString()
	{
		return "Did not like it: " + DidNotLikeIt + "\nWas okay: " + OkayVotes + "\nLiked it a lot: "
				+ LikedIt;
	}
}
