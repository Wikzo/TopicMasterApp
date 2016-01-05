package com.topicchooser.hagenberg15.topics;

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
import com.topicchooser.hagenberg15.states.VotingState;

public class TopicManager
{
	public PlayerManager PlayerManager;
	public Vote CurrentVotes;
	public Topic CurrentTopic;

	private List<Topic> _topicPool;
	private IState _state;

	public TopicManager(PlayerManager playerManager, boolean useDummyPlayers)
	{
		this.PlayerManager = playerManager;
		CurrentVotes = new Vote();

		CurrentTopic = new Topic("Cats");

		_topicPool = new ArrayList<>();

		for (int i = 0; i < 5; i++)
		{
			_topicPool.add(new Topic("Topic " + Integer.toString(i)));
		}

		_state = new SetupState(useDummyPlayers);
		_state.EnterState(this);

		_state = new ShowTopicState();
		_state.EnterState(this);
	}

	public void Update()
	{
		if (_state != null)
		{
			_state.Update(this);
			System.out.println("\n***Current state: " + _state.getClass().getSimpleName() + "(debug)**");
		}
	}

	public void HandleInputAndState(ICommand command)
	{
		IState temp = _state.HandleInput(command, this);

		if (temp != _state)
		{
			_state.ExitState(this);
			_state = null;
			_state = temp;
			_state.EnterState(this);
		}
	}

	public String DisplayCurrentTopic()
	{
		return CurrentTopic.TopicText;
	}

	public String DisplayCurrentVotes()
	{
		return CurrentVotes.toString();
	}

	public void CalculateNextTopic()
	{
		Random random = new Random();

		int next = 0;
		next = random.nextInt(_topicPool.size());
		CurrentTopic = _topicPool.get(next);
	}

	public void Exit()
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
