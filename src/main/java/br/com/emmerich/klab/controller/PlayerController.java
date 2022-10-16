package br.com.emmerich.klab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmerich.klab.model.Player;
import br.com.emmerich.klab.response.MatchResult;
import br.com.emmerich.klab.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostMapping("/winner")
	public MatchResult getWinner(@RequestBody List<Player> players) {
		return playerService.getWinnerPlayer(players);
	}
}
