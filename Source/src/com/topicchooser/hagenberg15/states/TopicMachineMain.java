package com.topicchooser.hagenberg15.states;

public class TopicMachineMain {

	public static void main(String[] args) {
		TopicMachine topicMachine = new TopicMachine(20);
		
		System.out.println(topicMachine);
		topicMachine.talking();
		topicMachine.update();
		topicMachine.talking();
		topicMachine.update();

	}
}
