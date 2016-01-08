package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class TravellingTopics implements ITopicContainer
{
	// TRAVELLING LEVEL 1 X
	public Topic Travelling;

	// TRAVELLING LEVEL 2
	public Topic Summer;
	public Topic Winter;
	public Topic Bigcities;
	public Topic TravellingNature;
	public Topic Smallbudget;

	// TRAVELLING LEVEL 3
	public Topic Swimming;
	public Topic Skiandsnowboard;
	public Topic Shopping;
	public Topic Hiking;
	public Topic Couchsurfing;
	public Topic Rockclimbing;
	public Topic Iceskating;
	public Topic Museums;
	public Topic Biking;
	public Topic Backpacking;

	@Override
	public Topic GetRootTopic()
	{
		return Travelling;
	}

	@Override
	public void InitializeTopics()
	{
		// TRAVELLING LEVEL 1
		Travelling = new Topic("Travelling");

		// TRAVELLING LEVEL 2
		Summer = new Topic("Travelling Summer");
		Winter = new Topic("Travelling Winter");
		Bigcities = new Topic("Travelling Big Cities");
		TravellingNature = new Topic("Travelling Nature");
		Smallbudget = new Topic("Travelling on a small budget");

		// TRAVELLING LEVEL 3
		Swimming = new Topic("Swimming");
		Skiandsnowboard = new Topic("Ski and Snowboard");
		Shopping = new Topic("Shopping - Travelling");
		Hiking = new Topic("Hiking - Travelling");
		Couchsurfing = new Topic("Couch surfing");

		Rockclimbing = new Topic("Rock climbing");
		Iceskating = new Topic("Ice skating");
		Museums = new Topic("Museums - Travelling");
		Biking = new Topic("Biking - Travelling");
		Backpacking = new Topic("Backpacking");

	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// TRAVELLING
		Travelling.SetParent(Summer);
		Travelling.SetParent(Winter);
		Travelling.SetParent(Bigcities);
		Travelling.SetParent(TravellingNature);
		Travelling.SetParent(Smallbudget);

		Summer.SetParent(Swimming);
		Summer.SetParent(Rockclimbing);

		Winter.SetParent(Skiandsnowboard);
		Winter.SetParent(Iceskating);

		Bigcities.SetParent(Shopping);
		Bigcities.SetParent(Museums);

		TravellingNature.SetParent(Hiking);
		TravellingNature.SetParent(Biking);

		Smallbudget.SetParent(Couchsurfing);
		Smallbudget.SetParent(Backpacking);

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
