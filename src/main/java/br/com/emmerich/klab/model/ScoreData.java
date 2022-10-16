package br.com.emmerich.klab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE")
public class ScoreData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCORE_ID")
	private Long id;

	@Column(name = "PLAYER_NAME")
	private String playerName;

	@Column(name = "SCORE")
	private Integer playerScore;

	@Column(name = "SCORE_DATE")
	private Date scoreDate;

	public ScoreData() {
	}

	public ScoreData(Long id, String playerName, Integer playerScore, Date scoreDate) {
		this.id = id;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.scoreDate = scoreDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(Integer playerScore) {
		this.playerScore = playerScore;
	}

	public Date getScoreDate() {
		return scoreDate;
	}

	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}

}
