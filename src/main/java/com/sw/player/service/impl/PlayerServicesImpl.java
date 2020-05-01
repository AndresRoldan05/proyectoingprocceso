package com.sw.player.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sw.player.entity.Player;
import com.sw.player.repository.PlayerRepository;
import com.sw.player.service.PlayerService;

@Service("playerServiceImpl")
public class PlayerServicesImpl implements PlayerService {

	@Autowired
	@Qualifier("playerRepository")
	private PlayerRepository playerRepository;
	
	
	public Player findPlayerById(String id) {
		// TODO Auto-generated method stub
		return playerRepository.findPlayerById(id);
	}
	
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return playerRepository.findAll();
	}

	public void removePlayer(String id) {
		// TODO Auto-generated method stub
		Player player = playerRepository.findPlayerById(id);
		if(player != null) {
			playerRepository.delete(player); 
			//return "Se eliminó correctamente";
		}
		//return "No se cencontró el jugador";
	}

	public Player addPlayer(Player player) {
		// TODO Auto-generated method stub
		return playerRepository.save(player);
	}

	public Player editPlayer(Player player) {
		// TODO Auto-generated method stub
		return playerRepository.save(player);
	}
	

}
