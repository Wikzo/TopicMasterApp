package com.topicchooser.hagenberg15.topics;

public interface ITopicContainer
{
	public Topic GetRootTopic();
	public void InitializeTopics();
	public void SetParentRelationship(Topic superRootTopic);
	public String GetClassName();
}
