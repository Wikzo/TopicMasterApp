package com.topicchooser.hagenberg15.unittest;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.topicchooser.hagenberg15.topics.Topic;
import com.topicchooser.hagenberg15.topics.VoteContainer;

public class TopicTraversalTester
{

	VoteContainer VoteContainer;
	
	Topic RootTopic;

	Topic Cat;
	Topic Lion;
	Topic Tiger;
	Topic SnowTiger;
	Topic ChineseCat;

	Topic Dog;
	Topic BigDogs;
	Topic SmallDogs;
	Topic GermanSherpard;
	Topic Puddle;
	
	Topic Movies;
	Topic SciFi;
	Topic Fantasy;

	@Before
	public void SetupStuff()
	{
		RootTopic = new Topic("Root");
		
		Cat = new Topic("Cat");
		Lion = new Topic("Lion");
		Tiger = new Topic("Tiger");
		SnowTiger = new Topic("SnowTiger");
		ChineseCat = new Topic("Chinese Cats");

		Dog = new Topic("Dog");
		BigDogs = new Topic("Big Dogs");
		SmallDogs = new Topic("Small Dogs");
		GermanSherpard = new Topic("German Sherpard");
		Puddle = new Topic("Puddle");
		
		Movies = new Topic("Movies");
		SciFi = new Topic("Sci-fi");
		Fantasy = new Topic("Fantasy");
		
		// level 1
		RootTopic.SetParent(Cat);
		RootTopic.SetParent(Dog);
		RootTopic.SetParent(Movies);
		
		// level 2
		Cat.SetParent(Lion);
		Cat.SetParent(Tiger);
		Cat.SetParent(ChineseCat);
		Dog.SetParent(SmallDogs);
		Dog.SetParent(BigDogs);
		Movies.SetParent(SciFi);
		Movies.SetParent(Fantasy);
		
		// level 3
		BigDogs.SetParent(GermanSherpard);
		SmallDogs.SetParent(Puddle);

	}

	@Test
	public void TestSibling()
	{
		// Big Dogs have only one kid: German shepard
		
		String expected = GermanSherpard.toString();
		String results = "";
		
		results = BigDogs.GetKid().toString();		
		
		Assert.assertEquals(expected, results);
	}

	
	@Test
	public void TestSiblingWithNoKids()
	{
		// ChineseCat have no kids --> go up one level and pick a new one
		
		String[] expected = {ChineseCat.toString(), Lion.toString(), Tiger.toString()};
		String results = "";
		
		results = ChineseCat.GetKid().toString();
		
		boolean isCorrect = false;
		if (results.equalsIgnoreCase(ChineseCat.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(Lion.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(Tiger.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}
	
	@Test
	public void TestGetParentOneLevel()
	{	
		String expected = BigDogs.toString();
		String results = "";
		
		results = GermanSherpard.GetParent(1).toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestGetParentThreeLevels()
	{	
		String expected = RootTopic.toString();
		String results = "";
		
		results = GermanSherpard.GetParent(50).toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestMoodCalculatorWithNegativeVotes()
	{	
		VoteContainer voteContainer = new VoteContainer(BigDogs);
		
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
	
		String expected = BigDogs.GetParent(2).toString();
		String results = "";
		
		results = newTopic.toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestMoodCalculatorWithPositveVotes()
	{	
		SciFi.VisitTopic();
		//Fantasy.VisitTopic();
		
		VoteContainer voteContainer = new VoteContainer(SciFi);
		
		voteContainer.AddVote(2);
		voteContainer.AddVote(2);
		voteContainer.AddVote(3);

		Topic newTopic = voteContainer.GetNextTopic(3);
	
		String expected = Fantasy.toString();
		String results = "";
		
		results = newTopic.toString();		
		
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void TestGetParentWithZero()
	{
		String expected = GermanSherpard.Parent.toString();
		String results = GermanSherpard.GetParent(1).toString();
		
		Assert.assertEquals(expected, results);
		
	}
}
