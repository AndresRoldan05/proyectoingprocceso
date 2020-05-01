package com.sw.player.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sw.player.entity.Player;


@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Serializable> {

	public abstract Player findPlayerById(String id);

}
