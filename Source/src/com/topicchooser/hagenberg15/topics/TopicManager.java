package com.topicchooser.hagenberg15.topics;

import java.util.ArrayList;
import java.util.List;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.states2.IState;
import com.topicchooser.hagenberg15.states2.SetupState;
import com.topicchooser.hagenberg15.states2.VotingState;

public class TopicManager
{
	public int VotesCountedSoFar = 0;

	private int _voteScores = 0;

	private Topic _currentTopic;

	private List<Topic> _topics;
	private List<Player> _players;
	private IState _state;

	public TopicManager(int numberOfPlayers)
	{
		_topics = new ArrayList<>();
		_players = new ArrayList<>(numberOfPlayers);
		_state = new SetupState();
		_state.EnterState(this);

		for (int i = 0; i < numberOfPlayers; i++)
			_players.add(new Player('M', 21));
	}

	public void Update()
	{
		if (_state != null)
		{
			_state.Update(this);
			System.out.println("Current state: " + _state.getClass().getSimpleName());
		}
	}

	public void HandleInput(ICommand command)
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

	public String DisplayTopic()
	{
		return _currentTopic.TopicText;
	}

	public void AddVote(int vote)
	{
		VotesCountedSoFar += (int) Math.signum(vote);
		_voteScores += vote;

		if (VotesCountedSoFar >= GetPlayerCount())
			CalculateNextTopic();
	}

	private void CalculateNextTopic()
	{
		System.out.println("\n[Calculating next topic...]\n");
		float avg = _voteScores / GetPlayerCount();
	}

	public void MoveHorizontal(int direction)
	{
		if (direction > 0)
			System.out.println("\n[Moving to the right...]\n");
		else if (direction < 0)
			System.out.println("\n[Moving to the left...]\n");
	}

	public void MoveVertical(int direction)
	{
		if (direction > 0)
			System.out.println("\n[Moving one level down...]\n");
		else if (direction < 0)
			System.out.println("\n[Moving one level up...]\n");
	}

	public int GetPlayerCount()
	{
		return _players.size();
	}

	public void Exit()
	{
		System.out.println("Are you really sure you want to exit?\nY / N");

		boolean exit = InputHandler.GetYesOrNo();

		if (exit)
		{

			//System.out.println("[Displaying statistical information about this round]");
			System.out.println("Shutting down. Good bye...");
			System.exit(0);
		}
	}

}
