package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class ReligionTopics implements ITopicContainer
{
	// RELIGION LEVEL 1 X
	public Topic Religion;

	// RELIGION LEVEL 2
	public Topic Christianity;
	public Topic Buddhism;
	public Topic Islam;
	public Topic Hinduism;
	public Topic Folkreligion;

	// RELIGION LEVEL 3
	public Topic Jesus;
	public Topic Meditation;
	public Topic ProphetMuhammad;
	public Topic Reincarnation;
	public Topic ChineseFolkReligion;

	public Topic Trinity;
	public Topic TheFourNobleTruths;
	public Topic Quran;
	public Topic Karma;
	public Topic AfricanTraditionalReligion;

	@Override
	public Topic GetRootTopic()
	{
		return Religion;
	}

	@Override
	public void InitializeTopics()
	{
		// Religion l1
		Religion = new Topic("Religion");

		// Religion l2
		Christianity = new Topic("Christianity");
		Buddhism = new Topic("Buddhism");
		Islam = new Topic("Islam");
		Hinduism = new Topic("Hinduism");
		Folkreligion = new Topic("Folk Religion");

		// Religion l3
		Jesus = new Topic("Jesus");
		Meditation = new Topic("Meditation");
		ProphetMuhammad = new Topic("Prophet Muhammad");
		Reincarnation = new Topic("Reincarnation");
		ChineseFolkReligion = new Topic("Chinese Folk Religion");

		Trinity = new Topic("Christian Trinity");
		TheFourNobleTruths = new Topic("The Four Noble Truths");
		Quran = new Topic("Quran");
		Karma = new Topic("Karma");
		AfricanTraditionalReligion = new Topic("African Traditional Religion");
	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// Religion

		Religion.SetParent(Christianity);
		Religion.SetParent(Buddhism);
		Religion.SetParent(Islam);
		Religion.SetParent(Hinduism);
		Religion.SetParent(Folkreligion);

		Christianity.SetParent(Jesus);
		Christianity.SetParent(Trinity);

		Buddhism.SetParent(Meditation);
		Buddhism.SetParent(TheFourNobleTruths);

		Islam.SetParent(ProphetMuhammad);
		Islam.SetParent(Quran);

		Hinduism.SetParent(Reincarnation);
		Hinduism.SetParent(Karma);

		Folkreligion.SetParent(ChineseFolkReligion);
		Folkreligion.SetParent(AfricanTraditionalReligion);
	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
