package com.topicchooser.hagenberg15.unittest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topicchooser.hagenberg15.commands.VoteCommand;
import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;
import com.topicchooser.hagenberg15.topics.TopicContainer;
import com.topicchooser.hagenberg15.topics.VoteCounter;
import com.topicchooser.hagenberg15.topics.topiccontainers.BiologyTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.CountryTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.HistoryTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.MovieTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.PoliticsTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.TechnologyTopics;
import com.topicchooser.hagenberg15.topics.topiccontainers.TravellingTopics;

public class TopicChooserTester
{
	VoteCounter VoteContainer;
	TopicContainer TopicContainer;

	@Before
	public void Setup()
	{
		TopicContainer = new TopicContainer();

		TopicContainer.AddTopic(new MovieTopics()).AddTopic(new BiologyTopics()).AddTopic(new TechnologyTopics())
				.AddTopic(new TravellingTopics()).AddTopic(new CountryTopics()).AddTopic(new PoliticsTopics())
				.AddTopic(new HistoryTopics());

		TopicContainer.CreateTopics();
	}

	@Test
	public void TestKidWithNoSibling()
	{

		String expected = TopicContainer.GetTopicContainer(BiologyTopics.class).ChineseDogs.toString();
		String results = "";

		results = TopicContainer.GetTopicContainer(BiologyTopics.class).Dogs.GetKid().toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestGettingEmptyKid()
	{
		String[] expected =
		{ TopicContainer.GetTopicContainer(BiologyTopics.class).Cats.toString(),
				TopicContainer.GetTopicContainer(BiologyTopics.class).Dogs.toString() };
		String results = "";

		results = TopicContainer.GetTopicContainer(BiologyTopics.class).Cats.GetKid().toString();

		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.GetTopicContainer(BiologyTopics.class).Cats.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.GetTopicContainer(BiologyTopics.class).Dogs.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}

	@Test
	public void TestGetParentOneLevel()
	{
		String expected = TopicContainer.GetTopicContainer(BiologyTopics.class).Dogs.toString();
		String results = "";

		results = TopicContainer.GetTopicContainer(BiologyTopics.class).ChineseDogs.GetParent(1).toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestGetParentThreeLevels()
	{
		String expected = TopicContainer.GetTopicContainer(BiologyTopics.class).GetClassName();
		String results = "";

		results = TopicContainer.GetTopicContainer(BiologyTopics.class).ChineseDogs.GetParent(3).toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestMoodCalculatorWithNegativeVotes()
	{
		VoteCounter voteContainer = new VoteCounter(TopicContainer.GetTopicContainer(CountryTopics.class).Denmark);

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

		String expected = TopicContainer.GetTopicContainer(CountryTopics.class).Denmark.GetParent(2).toString();
		String results = "";

		results = newTopic.toString();

		Assert.assertEquals(expected, results);
	}

	@Test
	public void TestMoodCalculatorWithPositiveVotes()
	{
		TopicContainer.GetTopicContainer(MovieTopics.class).Scifi.VisitTopic();

		VoteCounter voteContainer = new VoteCounter(TopicContainer.GetTopicContainer(MovieTopics.class).Scifi);

		voteContainer.AddVote(2);
		voteContainer.AddVote(2);
		voteContainer.AddVote(3);

		Topic newTopic = voteContainer.GetNextTopic(3);
		String results = newTopic.toString();

		boolean isCorrect = false;
		if (results.equalsIgnoreCase(TopicContainer.GetTopicContainer(MovieTopics.class).StarWars.toString()))
			isCorrect = true;
		if (results.equalsIgnoreCase(TopicContainer.GetTopicContainer(MovieTopics.class).Gravity.toString()))
			isCorrect = true;

		Assert.assertTrue(isCorrect);
	}

	@Test
	public void TestGetParentRecursionWithOneLevel()
	{
		String expected = TopicContainer.GetTopicContainer(BiologyTopics.class).ChineseDogs.Parent.toString();
		String results = TopicContainer.GetTopicContainer(BiologyTopics.class).ChineseDogs.GetParent(1).toString();

		Assert.assertEquals(expected, results);

	}

	@Test
	public void TestRandomStartingTopic()
	{
		Topic startTopic = TopicContainer.GetStartingTopic();
		String results = startTopic.toString();

		Assert.assertTrue(TopicContainer.SuperRootTopic.Kids.contains(startTopic));

	}

	@Test
	public void TestGettingTopicContainers()
	{
		TopicContainer _topicContainerBase = new TopicContainer();

		_topicContainerBase.AddTopic(new MovieTopics()).AddTopic(new BiologyTopics()).AddTopic(new TechnologyTopics())
				.AddTopic(new TravellingTopics()).AddTopic(new CountryTopics()).AddTopic(new PoliticsTopics())
				.AddTopic(new HistoryTopics());

		_topicContainerBase.CreateTopics();

		Topic t = _topicContainerBase.GetTopicContainer(PoliticsTopics.class).Communism;

		Assert.assertNotNull(t);
	}

	@Test
	public void TestIfAllTopicsHaveBeenInitialized() throws IllegalArgumentException, IllegalAccessException
	{
		List<Field> invalidTopics = new ArrayList<>();

		for (ITopicContainer topicContainer : TopicContainer.GetTopicContainers())
		{
			Field[] fooFields = topicContainer.getClass().getDeclaredFields();

			for (Field fooField : fooFields)
			{
				if (fooField.get(topicContainer) == null)
					invalidTopics.add(fooField);
			}
		}

		int expected = 0;
		int results = invalidTopics.size();

		if (results > 0)
		{
			System.out.println("These topics have not been initialized:");
			for (Field f : invalidTopics)
				System.out.println(f);
		}

		Assert.assertEquals("Expect zero uninitialized topics", expected, results);

	}

}
