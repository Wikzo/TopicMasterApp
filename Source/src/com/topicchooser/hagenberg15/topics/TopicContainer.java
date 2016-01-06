package com.topicchooser.hagenberg15.topics;

public class TopicContainer
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
	Topic Fantasy;

	public TopicContainer()
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

}
