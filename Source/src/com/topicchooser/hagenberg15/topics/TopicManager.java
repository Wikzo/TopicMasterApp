package com.topicchooser.hagenberg15.topics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.PrimitiveIterator.OfDouble;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.states.IState;
import com.topicchooser.hagenberg15.states.SetupState;
import com.topicchooser.hagenberg15.states.ShowTopicState;
import com.topicchooser.hagenberg15.states.ShowVotingResultsState;

public class TopicManager
{
	public PlayerManager PlayerManager;
	public VoteCounter CurrentVoteCounter;
	public Topic CurrentTopic;
	public TopicContainer TopicContainer;

	private IState _state;
	private IState _previousState;

	public TopicManager(PlayerManager playerManager, boolean useDummyPlayers)
	{
		TopicContainer = new TopicContainer();
		TopicContainer.CreateTopics();
		CurrentTopic = TopicContainer.GetStartingTopic();
		CurrentTopic.VisitTopic();
		
		this.PlayerManager = playerManager;

		CurrentVoteCounter = new VoteCounter(CurrentTopic);

		_state = new SetupState(useDummyPlayers);
		_state.EnterState(this);
		_state.ExitState(this);

		_state = new ShowTopicState();
		_state.EnterState(this);
	}

	public String Update()
	{
		String stateString = "";
		if (_state != null)
		{
			stateString = _state.Update(this);
			//System.out.println("(Current state: " + GetCurrentState() + " [debug])");
		}
		return stateString;
	}
	
	public String GetCurrentState()
	{
		return  _state.getClass().getSimpleName();
	}
	
	public IState GetPreviousState()
	{
		return _previousState;
	}

	public String HandleInputAndState(ICommand command) throws IOException
	{
		String stateString = "";
		IState temp = _state.HandleInput(command, this);

		if (temp != _state)	
			ChangeState(temp);
		
		stateString = _state.EnterState(this);

		return stateString;
	}
	
	public void ChangeState(IState state)
	{
		_previousState = _state;
		
		_state.ExitState(this);
		_state = state;
	}

	public String DisplayCurrentTopic()
	{
		return CurrentTopic.TopicText;
	}

	public String DisplayCurrentVotes()
	{
		String mood = Float.toString(CurrentVoteCounter.CalculateMood(PlayerManager.GetNumberOfPlayers()));
		String topicText = "Overall mood for " + CurrentTopic.toString();
		return topicText + " was " + mood + "%";
	}

	int nextTopicIndex = 0;
	public void CalculateNextTopic()
	{
		CurrentTopic = CurrentVoteCounter.GetNextTopic(PlayerManager.GetNumberOfPlayers());
		CurrentTopic.VisitTopic();
	}

	public void Exit() throws IOException
	{
		System.out.println("Are you really sure you want to exit?\nY / N");

		boolean exit = InputHandler.GetYesOrNo();

		if (exit)
		{
			// System.out.println("[Displaying statistical information about
			// this round]");
			System.out.println("Shutting down. Good-bye...");
			System.exit(0);
		}
	}

}
