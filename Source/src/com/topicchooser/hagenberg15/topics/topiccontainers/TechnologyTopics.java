package com.topicchooser.hagenberg15.topics.topiccontainers;

import com.topicchooser.hagenberg15.topics.ITopicContainer;
import com.topicchooser.hagenberg15.topics.Topic;

public class TechnologyTopics implements ITopicContainer
{

	// TECHNOLOGY LEVEL 1 X
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

	@Override
	public Topic GetRootTopic()
	{
		return Technology;
	}

	@Override
	public void InitializeTopics()
	{
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

	}

	@Override
	public void SetParentRelationship(Topic superRootTopic)
	{
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

	}
	
	@Override
	public String GetClassName()
	{
		return GetRootTopic().toString();
	}

}
