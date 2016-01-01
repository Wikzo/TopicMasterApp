package com.topicchooser.hagenberg15.topics;

public class Vote
{

	public int MoreLikeThisVotes;
	public int SomethingDifferentVotes;
	public int KeywordSearchVotes;

	public Vote()
	{
		ResetAllVotes();
	}

	public void ResetAllVotes()
	{
		MoreLikeThisVotes = 0;
		SomethingDifferentVotes = 0;
		KeywordSearchVotes = 0;
	}

	public void AddVote(int vote)
	{
		if (vote == 1)
			MoreLikeThisVotes++;
		else if (vote == 2)
			SomethingDifferentVotes++;
		else if (vote == 3)
			KeywordSearchVotes++;
	}

	@Override
	public String toString()
	{
		return "More like this: " + MoreLikeThisVotes + "\nSomething different: " + SomethingDifferentVotes
				+ "\nKeyword search: " + KeywordSearchVotes;
	}
}
