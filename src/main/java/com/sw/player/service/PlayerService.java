package com.sw.player.service;

import java.util.List;

import com.sw.player.entity.Player;


public interface PlayerService {

		public abstract Player findPlayerById(String id);
		
		public abstract List<Player> getPlayers();
		
		public abstract void removePlayer(String id);
		
		public abstract Player addPlayer(Player player);
		
		public abstract Player editPlayer(Player player);
	}
	

