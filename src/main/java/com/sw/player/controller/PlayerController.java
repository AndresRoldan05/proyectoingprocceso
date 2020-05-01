package com.sw.player.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sw.player.entity.Player;
import com.sw.player.service.PlayerService;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/player")
public class PlayerController {
	
	Logger logger;
	
	public PlayerController() {
		logger = Logger.getLogger(PlayerController.class);
		//PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	
	@Autowired
	@Qualifier("playerServiceImpl")
	private PlayerService playerService;
		
	
	@GetMapping("/getplayer/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable("id") String id){
		Player player = playerService.findPlayerById(id);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	@GetMapping("/getplayers")
	public ResponseEntity<List<Player>> getPlayers(){
		List<Player> players = playerService.getPlayers();		
		logger.info("Entro al getplayer");
		return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeplayer/{id}")
	public void getPlayers(@PathVariable("id") String id){
		playerService.removePlayer(id);
		//return new ResponseEntity<String>(resultado, HttpStatus.OK);
	}
	
	
	@PostMapping("/addplayer")
	public Player addPlayer(@RequestBody Player player) {		
		return playerService.addPlayer(player);		
	}
	
	@PutMapping("/editplayer/{id}") // no necesito el id lo dejo para mirar ejemplo 
	public Player editPlayer(@RequestBody Player player, @PathVariable("id") String id ) {	
		// no se debe eliminar ya que el id es autogenerado y cambia si se elimina el registro
		return playerService.addPlayer(player);		
	}
	




}
