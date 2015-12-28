package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class MoveSidewaysCommand implements ICommand
{

	public MoveSidewaysCommand()
	{
		
	}
	
	@Override
	public void Execute(TopicManager t)
	{
		t.MoveHorizontal(1);
	}

	@Override
	public void Undo(TopicManager t)
	{
		System.out.println("\n[Undid moved sideways]\n");
		t.MoveHorizontal(-1); // TODO: not correct (needs to be chosen randomly)
	}

}
