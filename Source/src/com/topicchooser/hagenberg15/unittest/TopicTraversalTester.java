package com.topicchooser.hagenberg15.unittest;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.topicchooser.hagenberg15.topics.Topic;

public class TopicTraversalTester
{

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
		
		// level 3
		BigDogs.SetParent(GermanSherpard);
		SmallDogs.SetParent(Puddle);

	}

	@Test
	public void TestSibling()
	{
		String expected = GermanSherpard.toString();
		String results = "";
		
		results = BigDogs.GetKid().toString();		
		
		Assert.assertEquals(expected, results);
	}

}
