package com.topicchooser.hagenberg15.players;

import java.util.ArrayList;
import java.util.List;

import com.topicchooser.hagenberg15.commands.InputHandler;

public class PlayerManager
{
	public static List<Player> Players;

	public String SetupPlayers(boolean useDummyPlayers)
	{
		Players = new ArrayList<>();
		
		int number = 0;
		if (useDummyPlayers)
		{
			number = 3;

		} 
		else
		{
			System.out.println("How many players are you?");

			number = InputHandler.GetPositiveNumber();

			number = CheckPlayerCount(number);

			System.out.println("OK, so you are " + number + " players.");
		}

		AddPlayers(number, useDummyPlayers);

		String playerInfo = DisplayCurrentPlayers();
		System.out.println(playerInfo);
		return playerInfo;
	}

	private String DisplayCurrentPlayers()
	{
		StringBuffer s = new StringBuffer();

		s.append("\n----------\nThese are the players:\n");

		for (Player p : Players)
			s.append(p.toString() + "\n");

		s.append("----------");

		return s.toString();
	}

	private void AddPlayers(int number, boolean useDummyPlayers)
	{
		for (int i = 0; i < number; i++)
		{
			Player p = new Player(i + 1);
			p.Initializeplayer(useDummyPlayers);
			Players.add(p);
		}
	}
	

	private int CheckPlayerCount(int number)
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

	public static int GetPlayerCount()
	{
		return Players.size();
	}
}