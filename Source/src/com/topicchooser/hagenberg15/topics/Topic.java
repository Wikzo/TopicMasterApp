package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.Parent;

public class Topic
{

	public String TopicText = "[unitialized topic]";

	protected VoteCounter _voteCounter;

	protected boolean _hasBeenVisited;
	public Topic Parent;
	public List<Topic> _kids;

	public static List<Topic> AllTopics = new ArrayList<>();
	static int _visitedTopicsCounter;

	public Topic GetKid()
	{
		if (_kids.isEmpty())
			return GetSibling();

		return GetRandomKid();
	}

	protected Topic GetSibling()
	{
		boolean valid = false;
		int levels = 0;
		
		//valid = ValidateTopic(this.GetParent(levels).GetRandomKid());

		return Parent.GetRandomKid();
	}

	protected Topic GetRandomKid()
	{
		boolean valid = false;
		int tries = 0;
		int index = 0;

		while (!valid && tries < AllTopics.size())
		{
			Random random = new Random();
			index = random.nextInt(_kids.size());
			
			valid = ValidateTopic(_kids.get(index));
			tries++;
		}
		
		if (!valid)
			return GetRandomTopic();

		return _kids.get(index);
	}

	protected Topic GetRandomTopic()
	{
		//System.out.println("Getting RANDOM TOPIC!");
		Random random = new Random();
		int index = random.nextInt(AllTopics.size());
		return AllTopics.get(index);
	}

	public Topic GetParent(int levelsToGoUp)
	{
		if (levelsToGoUp > 0)
		{
			if (Parent.Parent != null)
				return Parent.GetParent(levelsToGoUp - 1);

			boolean valid = ValidateTopic(Parent);

			if (!valid)
				return GetRandomTopic();

			return Parent;
		}

		return this;
	}

	protected boolean ValidateTopic(Topic topic)
	{
		if (_visitedTopicsCounter + 1 > AllTopics.size())
			return false;

		if (topic._hasBeenVisited)
			return false;

		VisitTopic();
		return true;
	}

	public void SetParent(Topic kid)
	{
		kid.Parent = this;
		_kids.add(kid);
	}

	public void VisitTopic()
	{
		_hasBeenVisited = true;
		_visitedTopicsCounter++;
	}

	public Topic(String topicText)
	{
		this.TopicText = topicText;
		this._kids = new ArrayList<>();

		AllTopics.add(this);
	}

	// TODO: do we need this link? (memory considerations)
	public void AssociateWithVotes(VoteCounter voteContainer)
	{
		this._voteCounter = voteContainer;
	}

	@Override
	public String toString()
	{
		return TopicText;// + "(" + TagText + ")";
	}
}
