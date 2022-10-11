package br.com.emmerich.klab.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.emmerich.klab.model.Player;

@Service
public class PlayerService {

	private static final Logger LOG = LoggerFactory.getLogger(PlayerService.class);

	public List<Player> getWinnerPlayer(List<Player> players) {
		Map<String, Integer> score = new HashMap<>();

		players.stream().forEach(player -> {
			score.put(player.getName(), player.deckSum());
		});

		LOG.info("MAP: " + score);

		return players;
	}
}
