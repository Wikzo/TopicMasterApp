package com.topicchooser.hagenberg15.unittest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.states.SetupState;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class TopicTester
{

	PlayerManager playerManager;
	TopicManager topicManager;
	ICommand command;

	Player player1 = new Player(1);
	Player player2 = new Player(2);
	Player player3 = new Player(3);

	@Before
	public void Setup()
	{
		playerManager = new PlayerManager();
		Player[] dummies = InitializeDummyPlayers();
		playerManager.SetupPlayersUsingDummies(dummies);

		topicManager = new TopicManager(playerManager, true);
		command = null;
	}

	private Player[] InitializeDummyPlayers()
	{
		player1.Name = "John";
		player2.Name = "Joe";
		player3.Name = "Jane";

		player1.Age = 20;
		player2.Age = 18;
		player3.Age = 23;

		player1.Gender = 'M';
		player2.Gender = 'M';
		player3.Gender = 'F';

		return new Player[]
		{ player1, player2, player3 };
	}

	@Test
	public void TestDummyPlayerNames()
	{
		String expected = "";
		expected += "\n----------\n";
		expected +=  "These are the players:\n" + player1.toString() + "\n" + player2.toString() + "\n"
				+ player3.toString();
		expected += "\n----------";

		Assert.assertEquals(expected, playerManager.DisplayCurrentPlayers());
	}

}
