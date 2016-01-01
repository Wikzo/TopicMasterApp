package com.topicchooser.hagenberg15.players;

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
	
	public void InitializePlayer()
	{
		System.out.println("\nPlease tell me the name of player " + PlayerID + ":");
		Name = InputHandler.GetNextString();
		
		System.out.println("\nHowdy, " + Name + ". Please tell me your age:");
		Age = InputHandler.GetPositiveNumber();
		
		System.out.println("\nOh, and " + Name + ", would you mind telling me your gender as well:");
		Gender = InputHandler.GetGenderChar();
	}
	
	public void InitializePlayerPredefined()
	{
		Name = "TestName_" + PlayerID;
		Age = PlayerID;
		Gender = 'M';
	}
	
	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		
		s.append("Player " + Name);
		s.append("(age: " + Age + "; ");
		s.append("gender: " + Gender + ")");
		
		return s.toString();
		
	}

}
