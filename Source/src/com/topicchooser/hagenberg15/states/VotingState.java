package com.topicchooser.hagenberg15.states;

public class VotingState implements State
{
	TopicMachine topicMachine;

	public VotingState(TopicMachine topicMachine)
	{
		this.topicMachine = topicMachine;
	}

	public void talking()
	{
		System.out.println("You selected a topic");
		topicMachine.setState(topicMachine.gettalkingState());
	}

	public void voting()
	{
		System.out.println("You haven't selected a topic");
	}

	public void update()
	{
		System.out.println("You updated, but there's no topic");
	}

	public void result()
	{
		System.out.println("You need to add topics first");
	}

	public String toString()
	{
		return "waiting for topic";
	}
}
