package com.gnomechildify;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GnomeChildifyPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GnomeChildifyPlugin.class);
		RuneLite.main(args);
	}
}