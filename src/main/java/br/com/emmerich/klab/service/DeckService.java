package br.com.emmerich.klab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.emmerich.klab.model.Card;
import br.com.emmerich.klab.model.Deck;

@Service
public class DeckService {

	private static final Logger LOG = LoggerFactory.getLogger(DeckService.class);
	private static final String DECK_URL = "https://deckofcardsapi.com/api/deck/";
	private final RestTemplate restTemplate = new RestTemplate();

	public DeckService(/* RestTemplate restTemplate */) {
		// this.restTemplate = restTemplate;
	}

	public Deck getShuffledDeck() {
		Deck newDeck = restTemplate.getForObject(DECK_URL + "new/shuffle/?deck_count=1", Deck.class);

		return newDeck;
	}

	public Deck drawOneCard(String deckId) {
		String URL = DECK_URL + deckId + "/draw/?count=1";
		LOG.info("URL: " + URL);
		Deck deck = restTemplate.getForObject(URL, Deck.class);

		return deck;
	}
}
