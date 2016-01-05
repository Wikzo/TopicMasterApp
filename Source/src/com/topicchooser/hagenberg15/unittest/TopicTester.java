package com.topicchooser.hagenberg15.unittest;

import java.io.IOException;

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

	@Before
	public void Setup() throws IOException
	{
		playerManager = new PlayerManager();
		playerManager.SetupPlayers(true);

		topicManager = new TopicManager(playerManager, true);
		command = null;
	}

	@Test
	public void TestPlayerNames()
	{
		String expected = "";
		expected += "\n----------\n";
		expected +=  "These are the players:\n";

		for (Player p : playerManager.Players)
			expected += p.toString() + "\n";
		
		expected += "----------";

		Assert.assertEquals(expected, playerManager.DisplayCurrentPlayers());
	}

}
