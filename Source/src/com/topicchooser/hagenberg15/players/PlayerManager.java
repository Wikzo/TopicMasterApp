package com.topicchooser.hagenberg15.players;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.topicchooser.hagenberg15.commands.InputHandler;

public class PlayerManager
{
	public static List<Player> Players;

	public String SetupPlayers(boolean useDummyPlayers) throws IOException
	{
		if (useDummyPlayers)
		{
			Player[] dummies = CreateDummyPlayers();
			Players = new ArrayList<>(dummies.length);

			for (int i = 0; i < dummies.length; i++)
				Players.add(dummies[i]);

		}
		else
		{
			System.out.println("How many players are you?");
			int numberOfPlayers = InputHandler.GetPositiveNumber();
			numberOfPlayers = ValidatePlayerNumber(numberOfPlayers);

			System.out.println("OK, so you are " + numberOfPlayers + " players.");

			Players = new ArrayList<>(numberOfPlayers);
			AddPlayers(numberOfPlayers);
		}

		String playerInfo = DisplayCurrentPlayers();
		//System.out.println(playerInfo);
		return playerInfo;
	}

	public String DisplayCurrentPlayers()
	{
		StringBuffer s = new StringBuffer();

		s.append("\n----------\nThese are the players:\n");

		for (Player p : Players)
			s.append(p.toString() + "\n");

		s.append("----------");

		return s.toString();
	}

	private void AddPlayers(int number) throws IOException
	{
		for (int i = 0; i < number; i++)
		{
			Player p = new Player(i + 1);
			p.Initializeplayer();
			Players.add(p);
		}
	}

	private int ValidatePlayerNumber(int number) throws IOException
	{
		while (number <= 1)
		{
			System.out
					.println("You need at least two players for this. You don't want just to talk to yourself, right?");
			System.out.println("How many players are you?");
			number = InputHandler.GetPositiveNumber();
		}
		return number;
	}


	public int GetNumberOfPlayers()
	{
		return Players.size();
	}
	
	public Player[] CreateDummyPlayers()
	{
		Player[] dummies;
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Player player3 = new Player(3);

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
}
