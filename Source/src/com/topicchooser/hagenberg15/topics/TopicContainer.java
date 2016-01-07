package com.topicchooser.hagenberg15.topics;

import com.sun.corba.se.impl.oa.toa.TOAFactory;

import sun.net.www.content.text.plain;

public class TopicContainer
{
	// LEVEL 0
	public Topic RootTopic;

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

	// TECHNOLOGY LEVEL 1
	public Topic Technology;

	// TECHNOLOGY LEVEL 2
	public Topic Apple;
	public Topic SocialNetworking;
	public Topic Programming;
	public Topic Drones;
	public Topic VirtualReality;
	public Topic Selfdrivingcars;

	// TECHNOLOGY LEVEL 3
	public Topic AppleWatch;
	public Topic Twitter;
	public Topic Pairprogramming;
	public Topic Quadropcopterregulations;
	public Topic OculusRift;
	public Topic GoogleAI;
	public Topic Iphone;
	public Topic Facebook;
	public Topic Rubberduckdebugging;
	public Topic Shippingvithdrones;
	public Topic SamsungGear;
	public Topic MachineLearning;

	// TRAVELLING LEVEL 1
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

	// COUNTRIES LEVEL 1
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

	// RELIGION LEVEL 1
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
	
	public void CreateTopics()
	{
		InitializeTopics();
		SetParentRelationship();
	}
	
	public Topic GetStartingTopic()
	{
		return RootTopic.GetRandomKid();
	}

	private void SetParentRelationship()
	{
		RootTopic.SetParent(Movies);
		RootTopic.SetParent(Biology);
		RootTopic.SetParent(Technology);
		RootTopic.SetParent(Travelling);
		RootTopic.SetParent(Countries);
		RootTopic.SetParent(Politics);
		RootTopic.SetParent(History);
		RootTopic.SetParent(Religion);
		
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
		
		// TECHNOLOGY
		Technology.SetParent(Apple);
		Technology.SetParent(SocialNetworking);
		Technology.SetParent(Programming);
		Technology.SetParent(Drones);
		Technology.SetParent(VirtualReality);
		Technology.SetParent(Selfdrivingcars);
		
		Apple.SetParent(AppleWatch);
		Apple.SetParent(Iphone);

		SocialNetworking.SetParent(Twitter);
		SocialNetworking.SetParent(Facebook);
		
		Programming.SetParent(Pairprogramming);
		Programming.SetParent(Rubberduckdebugging);
		
		Drones.SetParent(Quadropcopterregulations);
		Drones.SetParent(Shippingvithdrones);
		
		VirtualReality.SetParent(OculusRift);
		VirtualReality.SetParent(SamsungGear);
		
		Selfdrivingcars.SetParent(GoogleAI);
		Selfdrivingcars.SetParent(MachineLearning);
		
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
		
		//HISTORY
		
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
		
		//Religion
		
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

	private void InitializeTopics()
	{
		RootTopic = new Topic("Root");

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

		// TECHNOLOGY l1
		Technology = new Topic("Technology");

		// TECHNOLOGY l2
		Apple = new Topic("Apple, Inc.");
		SocialNetworking = new Topic("Social Networking");
		Programming = new Topic("Programming");
		Drones = new Topic("Drones");
		VirtualReality = new Topic("Virtual Reality");
		Selfdrivingcars = new Topic("Self-Driving Cars");

		// TECHNOLOGY l3
		AppleWatch = new Topic("Apple Watch");
		Twitter = new Topic("Twitter");
		Pairprogramming = new Topic("Pair-Programming");
		Quadropcopterregulations = new Topic("Quadcopter Regulations");
		OculusRift = new Topic("Oculus Rift");
		GoogleAI = new Topic("Google AI");
		Iphone = new Topic("iPhone");
		Facebook = new Topic("Facebook");
		Rubberduckdebugging = new Topic("Rubber-Duck Debugging Technique");
		Shippingvithdrones = new Topic("Shipping With Drones");
		SamsungGear = new Topic("Samsung Gear");
		MachineLearning = new Topic("Self-driving cars & Machine Learning");

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

}
