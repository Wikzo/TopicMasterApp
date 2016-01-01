package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;

public class Topic
{
	
	public String TopicText = "Topic Text Test";
	
	protected int _moreLikeThis;
	protected int _somethingDifferent;
	protected int _keyWordSearch;

	protected Topic _root;
	protected Topic _child;
	protected Topic _sibling;
	
	public Topic(String topicText)
	{
		this.TopicText = topicText;
	}

	void AddVotesToTopic(Vote vote)
	{
		_moreLikeThis = vote.MoreLikeThisVotes;
		_somethingDifferent = vote.SomethingDifferentVotes;
		_keyWordSearch = vote.KeywordSearchVotes;
	}
}
