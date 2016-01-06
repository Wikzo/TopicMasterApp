package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.Parent;

public class Topic
{

	public String TopicText = "Star Wars";
	public String TagText = "Darth Vader";

	protected Topic _root;
	protected Topic _child;
	protected Topic _sibling;
	protected VoteContainer _voteContainer;

	protected boolean _hasBeenVisited;
	protected Topic _parent;
	public List<Topic> _kids;

	public Topic GetKid()
	{
		if (_kids.isEmpty())
			return GetSibling();

		return GetRandomKid();
	}

	protected Topic GetSibling()
	{
		return _parent.GetRandomKid();
	}

	protected Topic GetRandomKid()
	{
		Random random = new Random();
		int index = random.nextInt(_kids.size());

		return _kids.get(index);
	}

	public Topic GetParent(int levelsToGoUp)
	{
		// TODO: recursive is dangerous!

		if (levelsToGoUp > 0)
			return _parent.GetParent(levelsToGoUp - 1);

		return this;
	}
	
	public void SetParent(Topic kid)
	{
		kid._parent = this;
		_kids.add(kid);
	}
	
	public void VisitTopic()
	{
		_hasBeenVisited = true;
	}

	public Topic(String topicText)
	{
		this.TopicText = topicText;
		this._kids = new ArrayList<>();
	}

	public void AssociateWithVotes(VoteContainer voteContainer)
	{
		this._voteContainer = voteContainer;
	}
	
	@Override
	public String toString()
	{
		return TopicText;// + "(" + TagText + ")";
	}
}
