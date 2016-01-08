package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class PoliticsTopics implements ITopicContainer
{

	// POLITICS LEVEL 1
	public Topic Politics;

	// POLITICS LEVEL 2
	public Topic Laws;
	public Topic Companies;
	public Topic PoliticalSystems;
	public Topic Warfare;
	public Topic PoliticalValues;

	// POLITICS LEVEL 3
	public Topic Copyright;
	public Topic Taxes;
	public Topic Liberalism;
	public Topic Negotiation;
	public Topic LeftWing;

	public Topic Surveillance;
	public Topic PoliticalCorruption;
	public Topic Communism;
	public Topic ThirdWorldWar;
	public Topic RightWing;

	@Override
	public Topic GetRootTopic()
	{
		return Politics;
	}

	@Override
	public void InitializeTopics()
	{
		// POLITICS LEVEL 1
		Politics = new Topic("Politics");

		// POLITICS LEVEL 2
		Laws = new Topic("Laws");
		Companies = new Topic("Companies");
		PoliticalSystems = new Topic("Political Systems");
		Warfare = new Topic("Warfare");
		PoliticalValues = new Topic("Political Values");

		// POLITICS LEVEL 3
		Copyright = new Topic("Copyright");
		Taxes = new Topic("Taxes");
		Liberalism = new Topic("Liberalism");
		Negotiation = new Topic("Negotiation");
		LeftWing = new Topic("Left Wing [politics]");

		Surveillance = new Topic("Surveillance");
		PoliticalCorruption = new Topic("Political Corruption");
		Communism = new Topic("Communism");
		ThirdWorldWar = new Topic("Third World War");
		RightWing = new Topic("Right Wing [politics]");

	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// POLITICS
		Politics.SetParent(Laws);
		Politics.SetParent(Companies);
		Politics.SetParent(PoliticalSystems);
		Politics.SetParent(Warfare);
		Politics.SetParent(PoliticalValues);

		Laws.SetParent(Copyright);
		Laws.SetParent(Surveillance);

		Companies.SetParent(Taxes);
		Companies.SetParent(PoliticalCorruption);

		PoliticalSystems.SetParent(Liberalism);
		PoliticalSystems.SetParent(Communism);

		Warfare.SetParent(Negotiation);
		Warfare.SetParent(ThirdWorldWar);

		PoliticalValues.SetParent(LeftWing);
		PoliticalValues.SetParent(RightWing);

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
