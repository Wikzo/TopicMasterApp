package com.topicchooser.hagenberg15.states;

public class TopicMachine {
 
	State votingState;
	State talkingState;

 
	State state;
	int count;
 
	public TopicMachine(int nTopics) {

		votingState = new VotingState(this);
		talkingState = new TalkingState(this);

		this.count = nTopics;
 		if (nTopics > 0) {
			state = votingState;
		} 
	}
 
	public void talking() { state.talking(); }
	public void voting() { state.voting(); }
	public void update() { state.update(); state.result(); }

	void setState(State state) {
		this.state = state;
	}
 
 
	public int getCount() { return count; }
 

    public State getState() {
        return state;
    }
    
	public State getvotingState() { return votingState; }
	public State gettalkingState() { return talkingState; }

	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Topic Machine: " + count + " topic");
		if (count != 1) result.append("s");
		result.append("\nMachine is " + state);
		result.append("\n______________________________\n");
		return result.toString();
	}
}
