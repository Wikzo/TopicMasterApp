package com.topicchooser.hagenberg15.unittest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;
import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.main.Main;
import com.topicchooser.hagenberg15.main.TopicChooserFacade;
import com.topicchooser.hagenberg15.players.Player;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.states.SetupState;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class MainTester
{

	TopicChooserFacade facade;

	public static String[] StoredInput()
	{
		return Main.StoredInput();
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
		expected += "\nCURRENT TOPIC: Cats\n";
		expected += "\nVOTING HAS ENDED. Here are the results:\n";
		expected += "More like this: 1\n";
		expected += "Something different: 2\n";
		expected += "Keyword search: 0\n";
		expected += "\nUse the [next] command to get a new topic.\n";
		facade.UpdateNextStep();
		results = facade.UpdateString + facade.StateString;
		
		Assert.assertEquals(expected, results);//
		
	}
	
	@Test
	public void CheckFalseTopic() throws IOException
	{
		String expected = "";
		String results = "";
		
		// Comparing different topic value
		expected += "\nCURRENT TOPIC: Dogs\n";
		expected += "\nVOTING HAS ENDED. Here are the results:\n";
		expected += "More like this: 1\n";
		expected += "Something different: 2\n";
		expected += "Keyword search: 0\n";
		expected += "\nUse the [next] command to get a new topic.\n";
		facade.UpdateNextStep();
		results = facade.UpdateString + facade.StateString;
		
		//Assert.assertEquals(expected, results); // old way
		Assert.assertFalse(expected.equalsIgnoreCase(results));
		
	}

}
