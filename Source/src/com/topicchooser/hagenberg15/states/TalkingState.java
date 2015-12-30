package com.topicchooser.hagenberg15.states;


public class TalkingState implements State {
	TopicMachine topicMachine;
 
	public TalkingState(TopicMachine topicMachine) {
		this.topicMachine = topicMachine;
	}
  
	public void talking() {
		System.out.println("You are not allowed to choose another topic");
	}
 
	public void voting() {
		System.out.println("Topic returned");
		topicMachine.setState(topicMachine.getvotingState());
	}
 
	public void update() {
		System.out.println("You requested a new topic");

	}

    public void result() {
        System.out.println("New topic");
    }
 
	public String toString() {
		return "waiting for new topic request";
	}
}
