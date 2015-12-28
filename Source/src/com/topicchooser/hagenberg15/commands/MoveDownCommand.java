package com.topicchooser.hagenberg15.commands;

import com.topicchooser.hagenberg15.topics.TopicManager;

public class MoveDownCommand implements ICommand
{

	public MoveDownCommand()
	{
	}

	
	@Override
	public void Execute(TopicManager t)
	{
		t.MoveVertical(1);
	}

	@Override
	public void Undo(TopicManager t)
	{
		System.out.println("\n[Undid moved down]\n");
		t.MoveVertical(-1);
	}
}
