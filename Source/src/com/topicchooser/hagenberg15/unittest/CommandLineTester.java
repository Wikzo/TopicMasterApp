package com.topicchooser.hagenberg15.unittest;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topicchooser.hagenberg15.main.Main;
import com.topicchooser.hagenberg15.main.TopicChooserFacade;
import com.topicchooser.hagenberg15.players.Player;

public class CommandLineTester
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
	public void TestInputCommands()
	{
		String[] commands = {"exit", "e"};
		String input = "e";
		
		boolean contains = false;
		
		if (Arrays.asList(commands).contains(input))
			contains = true;
		
		Assert.assertTrue(contains);
	}
	

}
