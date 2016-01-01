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
		System.out.println("Please tell me the name of player " + PlayerID + ":");
		Name = InputHandler.GetNextString();
		
		System.out.println(Name + ", how old are you?");
		Age = InputHandler.GetPositiveNumber();
		
		System.out.println(Name + ", and what is your gender?");
		Gender = InputHandler.GetGenderChar();
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
