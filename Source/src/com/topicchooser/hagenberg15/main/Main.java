package com.topicchooser.hagenberg15.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import com.topicchooser.hagenberg15.commands.ICommand;
import com.topicchooser.hagenberg15.commands.InputHandler;
import com.topicchooser.hagenberg15.players.PlayerManager;
import com.topicchooser.hagenberg15.topics.TopicManager;

public class Main
{
	private final static boolean _useStoredInput = true;

	public static void main(String[] args) throws IOException
	{
		TopicChooserFacade facade;

		if (_useStoredInput)
			facade = new TopicChooserFacade(StoredInput());
		else
			facade = new TopicChooserFacade(null);
		
		facade.Run();
	}

	public static String[] StoredInput()
	{
		String line1 = "vote\n";
		String line2 = "1\n1";
		String line3 = "2\n";
		String line4 = "2\n";
		String line5 = "next\n";
		String line6 = "exit\n";
		String line7 = "n\n";

		String[] lines =
		{ line1, line2, line3, line4, line5, line6, line7 };

		return lines;
	}

}
