package com.lifesizedshents;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class LifeSizedShentsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LifeSizedShentsPlugin.class);
		RuneLite.main(args);
	}
}