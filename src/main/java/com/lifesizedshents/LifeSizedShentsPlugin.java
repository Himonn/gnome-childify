package com.lifesizedshents;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
		name = "Life Sized Shents",
		description = "Accurate shents representation"
)
@Slf4j
public class LifeSizedShentsPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private LifeSizedShentsConfig config;

	@Provides
	LifeSizedShentsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LifeSizedShentsConfig.class);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (config.menuEntries()
				&& client.isKeyPressed(KeyCode.KC_SHIFT)
				&& event.getType() == MenuAction.PLAYER_THIRD_OPTION.getId())
		{
			client.createMenuEntry(-1)
					.setOption(ColorUtil.prependColorTag("Shentsify", Color.ORANGE))
					.setTarget(event.getTarget())
					.setIdentifier(event.getIdentifier())
					.setType(MenuAction.RUNELITE_PLAYER);
		}
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() == MenuAction.RUNELITE_PLAYER
				&& event.getMenuOption().contains("Shentsify"))
		{
			final int id = event.getId();
			final Player[] cachedPlayers = client.getCachedPlayers();
			final Player player = cachedPlayers[id];

			if (player == null || player.getName() == null)
			{
				return;
			}

			PlayerComposition pc = player.getPlayerComposition();

			pc.setTransformedNpcId(NpcID.GNOME_CHILD);
		}
	}

	@Subscribe
	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();

		if (player.getName() != null
				&& player.getName().equalsIgnoreCase(config.rsn()))
		{
			PlayerComposition pc = player.getPlayerComposition();

			pc.setTransformedNpcId(NpcID.GNOME_CHILD);
		}
	}
}
