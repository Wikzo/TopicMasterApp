package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;

public class Topic
{

	public String TopicText = "Topic Text Test";

	protected Topic _root;
	protected Topic _child;
	protected Topic _sibling;
	protected VoteContainer _voteContainer;

	public Topic(String topicText)
	{
		this.TopicText = topicText;
	}

	public void AssociateWithVotes(VoteContainer voteContainer)
	{
		this._voteContainer = voteContainer;
	}
}
