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
		String line5 = "next\n";
		String line6 = "exit\n";
		String line7 = "y\n";

		String[] lines =
		{ line1, line2, line3, line4, line5, line6, line7 };

		return lines;
	}

	@Before
	public void Setup() throws IOException
	{
		facade = new TopicChooserFacade(StoredInput());
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
	
	@Test
	public void UpdateWithStoredInputs() throws IOException
	{
		String expected = "";
		String results = "";
		
		// voting on topics
		expected = "Voting has now ended. Here are the results:\n";
		expected += "More like this: 1\n";
		expected += "Something different: 2\n";
		expected += "Keyword search: 0";
		results = facade.UpdateNextStep();
		Assert.assertEquals(expected, results);
		
		// getting next topic
		results = facade.UpdateNextStep();
		results = facade.UpdateNextStep();
	}

}
