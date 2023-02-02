package com.lifesizedshents;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("lifesizedshents")
public interface LifeSizedShentsConfig extends Config
{
	@ConfigItem(
			keyName = "rsn",
			name = "RSN",
			description = "RSN of account to shents-ify on spawn",
			position = 10
	)
	default String rsn()
	{
		return "shents";
	}

	@ConfigItem(
			name = "Show Menu Entries",
			description = "Show shift right click menu options to Shents-ify a player",
			position = 20,
			keyName = "menuEntries"
	)
	default boolean menuEntries() { return true; }
}
