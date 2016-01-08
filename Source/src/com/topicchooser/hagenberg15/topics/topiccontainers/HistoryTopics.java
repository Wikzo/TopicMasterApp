package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class HistoryTopics implements ITopicContainer
{
	// HISTORY LEVEL 1
	public Topic History;

	// HISTORY LEVEL 2
	public Topic AncientGreek;
	public Topic Archaeology;
	public Topic PrehistoricPast;
	public Topic MilitaryHistory;
	public Topic EconomicHistory;

	// HISTORY LEVEL 3
	public Topic Aristotle;
	public Topic Dinosaurs;
	public Topic StoneAge;
	public Topic BowAndArrow;
	public Topic WallStreetCrack;

	public Topic HomericHymns;
	public Topic Neanderthal;
	public Topic BronzeAge;
	public Topic AtomBomb;
	public Topic TheFinancialCrisis;

	@Override
	public Topic GetRootTopic()
	{
		return History;
	}

	@Override
	public void InitializeTopics()
	{
		// HISTORY LEVEL 1
		History = new Topic("History");

		// HISTORY LEVEL 2
		AncientGreek = new Topic("Ancient Greek History");
		Archaeology = new Topic("Archaeology");
		PrehistoricPast = new Topic("Prehistoric Past");
		MilitaryHistory = new Topic("Military History");
		EconomicHistory = new Topic("Economic History");

		// HISTORY LEVEL 3
		Aristotle = new Topic("Aristotle");
		Dinosaurs = new Topic("Dinosaurs");
		StoneAge = new Topic("Stone Age");
		BowAndArrow = new Topic("Bow And Arrow [Military History]");
		WallStreetCrack = new Topic("Wall Street Crack");

		HomericHymns = new Topic("Homeric Hymns");
		Neanderthal = new Topic("Neanderthal");
		BronzeAge = new Topic("Bronze Age");
		AtomBomb = new Topic("Atom Bomb");
		TheFinancialCrisis = new Topic("The Financial Crisis");
	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// HISTORY

		History.SetParent(AncientGreek);
		History.SetParent(Archaeology);
		History.SetParent(PrehistoricPast);
		History.SetParent(MilitaryHistory);
		History.SetParent(EconomicHistory);

		AncientGreek.SetParent(Aristotle);
		AncientGreek.SetParent(HomericHymns);

		Archaeology.SetParent(Dinosaurs);
		Archaeology.SetParent(Neanderthal);

		PrehistoricPast.SetParent(StoneAge);
		PrehistoricPast.SetParent(BronzeAge);

		MilitaryHistory.SetParent(BowAndArrow);
		MilitaryHistory.SetParent(AtomBomb);

		EconomicHistory.SetParent(WallStreetCrack);
		EconomicHistory.SetParent(TheFinancialCrisis);

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
