package com.cluedropsound;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ClueDropSoundTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ClueDropSoundPlugin.class);
		RuneLite.main(args);
	}
}