package com.topicchooser.hagenberg15.unittest;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.topicchooser.hagenberg15.topics.Topic;
import com.topicchooser.hagenberg15.topics.TopicContainer;
import com.topicchooser.hagenberg15.topics.VoteContainer;

public class TopicTraversalTester
{

	VoteContainer VoteContainer;
	TopicContainer TopicContainer;


	@Before
	public void SetupStuff()
	{
		TopicContainer = new TopicContainer();
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
		String[] expected = {TopicContainer.Cats.toString(), TopicContainer.Dogs.toString()};
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
		VoteContainer voteContainer = new VoteContainer(TopicContainer.Denmark);
		
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
		//Fantasy.VisitTopic();
		
		VoteContainer voteContainer = new VoteContainer(TopicContainer.Scifi);
		
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
}
