package br.com.emmerich.klab.service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.emmerich.klab.model.Player;
import br.com.emmerich.klab.model.ScoreData;
import br.com.emmerich.klab.repository.ScoreRepository;
import br.com.emmerich.klab.response.MatchResult;

@Service
public class PlayerService {

	private static final Logger LOG = LoggerFactory.getLogger(PlayerService.class);
	private final ScoreRepository scoreRepository;

	public PlayerService(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}

	/**
	 * Searching for the winner, the method returns an array of players with 1 or n
	 * players
	 * 
	 * @param players
	 * @return
	 */
	public MatchResult getWinnerPlayer(List<Player> players) {
		Map<String, Integer> score = new HashMap<>();

		players.stream().forEach(player -> {
			score.put(player.getName(), player.deckSum());
		});

		LOG.info("MAP: " + score);

		Integer winner = getMaxScore(score);

		MatchResult result = new MatchResult("DRAW", players);

		if (winner > 0) {
			players = players.stream().filter(player -> player.deckSum().equals(winner)).collect(Collectors.toList());
			result.setResult("Winner: " + players.get(0).getName());
			result.setPlayers(players);

			persistPlayer(players.get(0));
		}

		return result;
	}

	/**
	 * Method search order and search for one winner, if there is more than 1 return
	 * null.
	 * 
	 * @param scoreMap
	 * @return
	 */
	private Integer getMaxScore(Map<String, Integer> scoreMap) {
		Entry<String, Integer> maxEntry = Collections.max(scoreMap.entrySet(),
				(Entry<String, Integer> entry1, Entry<String, Integer> entry2) -> {
					return entry1.getValue().compareTo(entry2.getValue());
				});

		return validateUniqueness(scoreMap, maxEntry) ? 0 : maxEntry.getValue();
	}

	/**
	 * Verify if there's more than one winner
	 * 
	 * @param scoreMap
	 * @param maxEntry
	 * @return
	 */
	private boolean validateUniqueness(Map<String, Integer> scoreMap, Entry<String, Integer> maxEntry) {
		AtomicInteger index = new AtomicInteger(0);
		scoreMap.entrySet().stream().allMatch(entry -> {
			index.getAndIncrement();
			return entry.getValue() == maxEntry.getValue();
		});

		return (index.get() > 1);
	}

	/**
	 * Persist the player who won to the database
	 * 
	 * @param winner
	 */
	private void persistPlayer(Player winner) {
		scoreRepository.save(new ScoreData(null, winner.getName(), winner.deckSum(), new Date()));
	}

	/**
	 * Searching for the winners stored on the database
	 * 
	 * @return
	 */
	public List<ScoreData> getAllWinners() {
		return scoreRepository.findAll();
	}
}
