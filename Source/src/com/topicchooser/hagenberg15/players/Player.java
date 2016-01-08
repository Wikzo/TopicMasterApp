package com.topicchooser.hagenberg15.players;

import java.io.IOException;

import com.topicchooser.hagenberg15.commands.InputHandler;

public class Player
{

	public int PlayerID;
	public String Name;
	public char Gender;
	public int Age;

	public Player(int playerID)
	{
		this.PlayerID = playerID;
	}

	public void Initializeplayer() throws IOException
	{
		System.out.println("\nPlease tell me the name of player " + PlayerID + ":");
		Name = InputHandler.GetNextString().toUpperCase();

		System.out.println("\nHi there, " + Name + ". Please tell me your age:");
		Age = InputHandler.GetPositiveNumber();

		System.out.println("\nOh, and " + Name + ", would you mind telling me your gender as well:");
		Gender = InputHandler.GetGenderChar();
	}


	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer();

		s.append("Player " + Name);
		s.append(" (age: " + Age + "; ");
		s.append("gender: " + Gender + ")");

		return s.toString();

	}

}
