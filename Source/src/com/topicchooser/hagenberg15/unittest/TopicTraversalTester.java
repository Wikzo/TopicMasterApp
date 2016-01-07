package com.topicchooser.hagenberg15.unittest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.topicchooser.hagenberg15.topics.Topic;
import com.topicchooser.hagenberg15.topics.TopicContainer;
import com.topicchooser.hagenberg15.topics.VoteCounter;

public class TopicTraversalTester
{

	VoteCounter VoteContainer;
	TopicContainer TopicContainer;

	@Before
	public void SetupStuff()
	{
		TopicContainer = new TopicContainer();
		TopicContainer.CreateTopics();
	}

	
	
	@Test
	public void TestKidWithNoSibling()
	{

		String expected = TopicContainer.ChineseDogs.toString();
		String results = "";

		results = TopicContainer.Dogs.GetKid().toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestGettingEmptyKid()
	{
		String[] expected =
		{ TopicContainer.Cats.toString(), TopicContainer.Dogs.toString() };
		String results = "";

		results = TopicContainer.Cats.GetKid().toString();

		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.Cats.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Dogs.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}

	@Test
	public void TestGetParentOneLevel()
	{
		String expected = TopicContainer.Dogs.toString();
		String results = "";

		results = TopicContainer.ChineseDogs.GetParent(1).toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestGetParentThreeLevels()
	{
		String expected = TopicContainer.Biology.toString();
		String results = "";

		results = TopicContainer.ChineseDogs.GetParent(3).toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestMoodCalculatorWithNegativeVotes()
	{
		VoteCounter voteContainer = new VoteCounter(TopicContainer.Denmark);

		voteContainer.AddVote(1);
		voteContainer.AddVote(1);
		voteContainer.AddVote(1);
		voteContainer.AddVote(1);
		voteContainer.AddVote(1);
		voteContainer.AddVote(1);

		voteContainer.AddVote(2);
		voteContainer.AddVote(2);

		voteContainer.AddVote(3);

		Topic newTopic = voteContainer.GetNextTopic(9);

		String expected = TopicContainer.Denmark.GetParent(2).toString();
		String results = "";

		results = newTopic.toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestMoodCalculatorWithPositiveVotes()
	{
		TopicContainer.Scifi.VisitTopic();
		// Fantasy.VisitTopic();

		VoteCounter voteContainer = new VoteCounter(TopicContainer.Scifi);

		voteContainer.AddVote(2);
		voteContainer.AddVote(2);
		voteContainer.AddVote(3);

		Topic newTopic = voteContainer.GetNextTopic(3);
		String results = newTopic.toString();

		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.StarWars.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Gravity.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}

	@Test
	public void TestGetParentRecursionWithOneLevel()
	{
		String expected = TopicContainer.ChineseDogs.Parent.toString();
		String results = TopicContainer.ChineseDogs.GetParent(1).toString();

		Assert.assertEquals(expected, results);

	}
	
	@Test
	public void TestRandomStartingTopic()
	{
		Topic startTopic = TopicContainer.GetStartingTopic();
		String results = startTopic.toString();

		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.Movies.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Biology.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Technology.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Travelling.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Countries.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Politics.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.History.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Religion.toString()))
			isCorrect = true;
		
		Assert.assertTrue(isCorrect);
		
	}
	

}
