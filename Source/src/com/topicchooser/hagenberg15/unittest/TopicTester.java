package com.topicchooser.hagenberg15.unittest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.main.TopicChooserFacade;
import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.states.SetupState;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class TopicTester
{

	TopicChooserFacade facade;

	public static String[] StoredInput()
	{
		String line1 = "vote\n";
		String line2 = "1\n1";
		String line3 = "2\n";
		String line4 = "2\n";
		String line5 = "exit\n";
		String line6 = "y\n";

		String[] lines =
		{ line1, line2, line3, line4, line5, line6 };

		return lines;
	}

	@Before
	public void Setup() throws IOException
	{
		facade = new TopicChooserFacade(StoredInput());

		// facade.Run();
	}

	@Test
	public void TestPlayerNames()
	{
		String expected = "";
		expected += "\n----------\n";
		expected += "These are the players:\n";

		for (Player p : facade.PlayerManager.Players)
			expected += p.toString() + "\n";

		expected += "----------";

		Assert.assertEquals(expected, facade.PlayerManager.DisplayCurrentPlayers());
	}

}
