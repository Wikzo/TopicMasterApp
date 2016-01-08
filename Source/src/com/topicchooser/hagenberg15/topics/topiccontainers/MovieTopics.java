package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class MovieTopics implements ITopicContainer
{
	// LEVEL 1 MOVIES
	public Topic Movies;

	// LEVEL 2 MOVIES
	public Topic Scifi;
	public Topic Fantasy;
	public Topic Action;
	public Topic Thriller;
	public Topic Western;
	public Topic War;
	public Topic Sport;
	public Topic Romance;
	public Topic Horror;
	public Topic Family;
	public Topic Animation;

	// LEVEL 3 MOVIES
	public Topic StarWars;
	public Topic HungerGames;
	public Topic TheDarkKnight;
	public Topic Deadpool;
	public Topic Thegoodthebadandtheugly;
	public Topic IngloriousBasterds;
	public Topic Rocky;
	public Topic FiftyShadesofGrey;
	public Topic Krampus;
	public Topic HarryPotter;
	public Topic Minions;
	public Topic Gravity;
	public Topic LordoftheRings;
	public Topic Inception;
	public Topic ThePhantomoftheOpera;
	public Topic DjangoUnchained;
	public Topic AmericanSniper;
	public Topic Rush;
	public Topic ForrestGump;
	public Topic Psycho;
	public Topic HomeAlone;
	public Topic InsideOut;

	@Override
	public Topic GetRootTopic()
	{
		return Movies;
	}

	@Override
	public void InitializeTopics()
	{
		// MOVIES LEVEL 1
		Movies = new Topic("Movies");

		// MOVIES LEVEL 2
		Scifi = new Topic("Sci-fi Movies");
		Fantasy = new Topic("Fantasy Movies");
		Action = new Topic("Action Movies");
		Thriller = new Topic("Thriller Movies");
		Western = new Topic("Western Movies");
		War = new Topic("War Movies");
		Sport = new Topic("Sport Movies");
		Romance = new Topic("Romance Movies");
		Horror = new Topic("Horror Movies");
		Family = new Topic("Family Movies");
		Animation = new Topic("Animation Movies");

		// MOVIES LEVEL 3
		StarWars = new Topic("Star Wars");
		Gravity = new Topic("Gravity");
		HungerGames = new Topic("Hunger Games");
		TheDarkKnight = new Topic("Batman: The Dark Knight");
		Deadpool = new Topic("Deadpool");
		Thegoodthebadandtheugly = new Topic("The Good, The Bad and The Ugly");
		IngloriousBasterds = new Topic("Inglorious Basterds");
		Rocky = new Topic("Rocky");
		FiftyShadesofGrey = new Topic("Fifty Shades of Grey [movie]");
		Krampus = new Topic("Krampus: The Movie");
		HarryPotter = new Topic("Harry Potter [movie]");
		Minions = new Topic("Minions");
		LordoftheRings = new Topic("The Lord of the Rings [movie]");
		Inception = new Topic("Inception");
		ThePhantomoftheOpera = new Topic("The Phantom of the Opera [movie]");
		DjangoUnchained = new Topic("Django Unchained");
		AmericanSniper = new Topic("American Sniper");
		Rush = new Topic("Rush [movie]");
		ForrestGump = new Topic("Forrest Gump");
		Psycho = new Topic("Hitchcock's Psycho");
		HomeAlone = new Topic("Home Alone");
		InsideOut = new Topic("Inside Out");

	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
		// MOVIES
		Movies.SetParent(Scifi);
		Movies.SetParent(Fantasy);
		Movies.SetParent(Action);
		Movies.SetParent(Thriller);
		Movies.SetParent(Western);
		Movies.SetParent(War);
		Movies.SetParent(Sport);
		Movies.SetParent(Romance);
		Movies.SetParent(Horror);
		Movies.SetParent(Family);
		Movies.SetParent(Animation);

		Scifi.SetParent(StarWars);
		Scifi.SetParent(Gravity);

		Fantasy.SetParent(HungerGames);
		Fantasy.SetParent(LordoftheRings);

		Action.SetParent(TheDarkKnight);
		Action.SetParent(Inception);

		Thriller.SetParent(Deadpool);
		Thriller.SetParent(ThePhantomoftheOpera);

		Western.SetParent(Thegoodthebadandtheugly);
		Western.SetParent(DjangoUnchained);

		War.SetParent(IngloriousBasterds);
		War.SetParent(AmericanSniper);

		Sport.SetParent(Rocky);
		Sport.SetParent(Rush);

		Romance.SetParent(FiftyShadesofGrey);
		Romance.SetParent(ForrestGump);

		Horror.SetParent(Krampus);
		Horror.SetParent(Psycho);

		Family.SetParent(HarryPotter);
		Family.SetParent(HomeAlone);

		Animation.SetParent(Minions);
		Animation.SetParent(InsideOut);

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}
}
