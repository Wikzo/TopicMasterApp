package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class BiologyTopics implements ITopicContainer
{

	public String hej;
	
	// BIOLOGY LEVEL 1
	public Topic Biology;

	// BIOLOGY LEVEL 2
	public Topic Animals;
	public Topic EnvironmentalIssues;
	public Topic Evolution;
	public Topic Bacteria;
	public Topic Nature;

	// BIOLOGY LEVEL 3
	public Topic Cats;
	public Topic Dogs;
	public Topic GlobalWarming;
	public Topic IceAge;
	public Topic Cells;
	public Topic Genes;
	public Topic AntibioticResistance;
	public Topic Mutations;
	public Topic Volcanos;
	public Topic Earthquakes;

	// BIOLOGY LEVEL 4
	public Topic ChineseDogs;

	@Override
	public Topic GetRootTopic()
	{
		return Biology;
	}

	@Override
	public void InitializeTopics()
	{
		// Biology l1
		Biology = new Topic("Biology");

		// Biology l2
		Animals = new Topic("Animals");
		EnvironmentalIssues = new Topic("Environmental Issues");
		Evolution = new Topic("Evolution");
		Bacteria = new Topic("Bacteria");
		Nature = new Topic("Nature");

		// Biology l3
		Cats = new Topic("Cats");
		Dogs = new Topic("Dogs");

		GlobalWarming = new Topic("Global Warming");
		IceAge = new Topic("The Ice Age era");

		Cells = new Topic("Cells");
		Genes = new Topic("Genes");

		AntibioticResistance = new Topic("Antibiotic Resistance");
		Mutations = new Topic("Mutations");

		Volcanos = new Topic("Volcanos");
		Earthquakes = new Topic("Earthquakes");

		// BIOLOGY LEVEL 4
		ChineseDogs = new Topic("Chinese Dogs");

	}

	public Topic hey;
	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// BIOLOGY
		Biology.SetParent(Animals);
		Biology.SetParent(EnvironmentalIssues);
		Biology.SetParent(Evolution);
		Biology.SetParent(Bacteria);
		Biology.SetParent(Nature);

		Animals.SetParent(Cats);
		Animals.SetParent(Dogs);

		Dogs.SetParent(ChineseDogs);

		EnvironmentalIssues.SetParent(GlobalWarming);
		EnvironmentalIssues.SetParent(IceAge);

		Evolution.SetParent(Cells);
		Evolution.SetParent(Genes);

		Bacteria.SetParent(AntibioticResistance);
		Bacteria.SetParent(Mutations);

		Nature.SetParent(Volcanos);
		Nature.SetParent(Earthquakes);

	}

	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
