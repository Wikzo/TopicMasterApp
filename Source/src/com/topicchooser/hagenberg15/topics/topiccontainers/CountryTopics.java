package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class CountryTopics implements ITopicContainer
{
	// COUNTRIES LEVEL 1 X
	public Topic Countries;

	// COUNTRIES LEVEL 2
	public Topic Europe;
	public Topic Asia;
	public Topic Africa;
	public Topic NorthAmerica;
	public Topic SouthAmerica;
	public Topic Oceania;

	// COUNTRIES LEVEL 3
	public Topic Denmark;
	public Topic Austria;
	public Topic India;
	public Topic Japan;
	public Topic Egypt;
	public Topic Congo;
	public Topic Canada;
	public Topic USA;
	public Topic Brazil;
	public Topic Paraguay;
	public Topic Australia;
	public Topic NewZealand;

	@Override
	public Topic GetRootTopic()
	{
		return Countries;
	}

	@Override
	public void InitializeTopics()
	{
		// COUNTRIES LEVEL 1
		Countries = new Topic("Countries");

		// COUNTRIES LEVEL 2
		Europe = new Topic("Europe");
		Asia = new Topic("Asia");
		Africa = new Topic("Africa");
		NorthAmerica = new Topic("North America");
		SouthAmerica = new Topic("South America");
		Oceania = new Topic("Oceania");

		// COUNTRIES LEVEL 3
		Denmark = new Topic("Denmark");
		Austria = new Topic("Austria");
		India = new Topic("India");
		Japan = new Topic("Japan");
		Egypt = new Topic("Egypt");
		Congo = new Topic("Congo");
		Canada = new Topic("Canada");
		USA = new Topic("USA");
		Brazil = new Topic("Brazil");
		Paraguay = new Topic("Paraguay");
		Australia = new Topic("Australia");
		NewZealand = new Topic("New Zealand");

	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// COUNTRIES
		Countries.SetParent(Europe);
		Countries.SetParent(Asia);
		Countries.SetParent(Africa);
		Countries.SetParent(NorthAmerica);
		Countries.SetParent(SouthAmerica);
		Countries.SetParent(Oceania);

		Europe.SetParent(Denmark);
		Europe.SetParent(Austria);

		Asia.SetParent(India);
		Asia.SetParent(Japan);

		Africa.SetParent(Egypt);
		Africa.SetParent(Congo);

		NorthAmerica.SetParent(USA);
		NorthAmerica.SetParent(Canada);

		SouthAmerica.SetParent(Brazil);
		SouthAmerica.SetParent(Paraguay);

		Oceania.SetParent(Australia);
		Oceania.SetParent(NewZealand);

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
