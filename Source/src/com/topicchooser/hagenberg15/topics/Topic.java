package com.topicchooser.hagenberg15.topics;

public class Topic
{

	// TODO: make some kind of mecanism that can randomly choose topics inside a category (maybe use enums?)
	
	public String TopicText = "Topic Text Test";
	public float AverageRating;
	
	protected Topic _root;
	protected Topic _child;
	protected Topic _sibling;
	
	public Topic()
	{
		
	}

	
	// this is just temporary; we need to figoure out a way to "quantify" our answers!
	public static int MoreLikeThis() { return 2;}
	public static int SomethingDifferent() { return 1;}
	public static int KeywordSearch() { return 0;}
}
