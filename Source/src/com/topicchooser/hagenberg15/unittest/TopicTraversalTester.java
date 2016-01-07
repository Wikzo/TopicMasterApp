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
	public void TestSibling()
	{
		// Big Dogs have only one kid: German shepard
		
		String expected = TopicContainer.GermanSherpard.toString();
		String results = "";
		
		results = TopicContainer.BigDogs.GetKid().toString();		
		
		Assert.assertEquals(expected, results);
	}

	
	@Test
	public void TestSiblingWithNoKids()
	{
		// ChineseCat have no kids --> go up one level and pick a new one
		
		String[] expected = {TopicContainer.ChineseCat.toString(), TopicContainer.Lion.toString(), TopicContainer.Tiger.toString()};
		String results = "";
		
		results = TopicContainer.ChineseCat.GetKid().toString();
		
		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.ChineseCat.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Lion.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.Tiger.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}
	
	@Test
	public void TestGetParentOneLevel()
	{	
		String expected = TopicContainer.BigDogs.toString();
		String results = "";
		
		results = TopicContainer.GermanSherpard.GetParent(1).toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestGetParentThreeLevels()
	{	
		String expected = TopicContainer.RootTopic.toString();
		String results = "";
		
		results = TopicContainer.GermanSherpard.GetParent(50).toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestMoodCalculatorWithNegativeVotes()
	{	
		VoteContainer voteContainer = new VoteContainer(TopicContainer.BigDogs);
		
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
	
		String expected = TopicContainer.BigDogs.GetParent(2).toString();
		String results = "";
		
		results = newTopic.toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestMoodCalculatorWithPositveVotes()
	{	
		TopicContainer.SciFi.VisitTopic();
		//Fantasy.VisitTopic();
		
		VoteContainer voteContainer = new VoteContainer(TopicContainer.SciFi);
		
		voteContainer.AddVote(2);
		voteContainer.AddVote(2);
		voteContainer.AddVote(3);

		Topic newTopic = voteContainer.GetNextTopic(3);
	
		String expected = TopicContainer.Fantasy.toString();
		String results = "";
		
		results = newTopic.toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestGetParentWithZero()
	{
		String expected = TopicContainer.GermanSherpard.Parent.toString();
		String results = TopicContainer.GermanSherpard.GetParent(1).toString();
		
		Assert.assertEquals(expected, results);
		
	}
}
