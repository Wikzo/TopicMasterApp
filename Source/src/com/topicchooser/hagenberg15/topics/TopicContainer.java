package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;

public class TopicContainer
{
	public Topic SuperRootTopic;

	private List<ITopicContainer> _topicContainers;
	private boolean _hasBeenCreated;

	public TopicContainer()
	{
		_topicContainers = new ArrayList<>();
	}

	public TopicContainer AddTopic(ITopicContainer topicContainer)
	{
		if (GetTopicContainerInternalLookup(topicContainer.getClass()) != null)
			throw new RuntimeException(
					"ERROR - cannot add " + topicContainer.getClass().getSimpleName() + " multiple times!");
		else
			_topicContainers.add(topicContainer);

		return this;
	}

	public <T extends ITopicContainer> T GetTopicContainerInternalLookup(Class<T> clazz)
	{
		for (int i = 0; i < _topicContainers.size(); i++)
		{
			if (clazz.isAssignableFrom(_topicContainers.get(i).getClass()))
			{
				return clazz.cast(_topicContainers.get(i));
			}
		}

		return null;
	}

	public <T extends ITopicContainer> T GetTopicContainer(Class<T> clazz)
	{
		for (int i = 0; i < _topicContainers.size(); i++)
		{
			if (clazz.isAssignableFrom(_topicContainers.get(i).getClass()))
			{
				return clazz.cast(_topicContainers.get(i));
			}
		}

		throw new RuntimeException("ERROR - could not find " + clazz.getSimpleName());
	}

	public void CreateTopics()
	{
		SuperRootTopic = new Topic("Super Root");

		for (ITopicContainer topicContainer : _topicContainers)
		{
			topicContainer.InitializeTopics();
			SuperRootTopic.SetParent(topicContainer.GetRootTopic());
			topicContainer.SetParentRelationship(SuperRootTopic);
		}

		_hasBeenCreated = true;

	}

	public Topic GetStartingTopic()
	{
		if (!_hasBeenCreated)
			throw new RuntimeException("ERROR - topics need to be created first with CreateTopics()!");

		return SuperRootTopic.GetRandomKid();
	}

	public List<ITopicContainer> GetTopicContainers()
	{
		return _topicContainers;
	}

}
