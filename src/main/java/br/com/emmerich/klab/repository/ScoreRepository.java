package br.com.emmerich.klab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emmerich.klab.model.Player;
import br.com.emmerich.klab.model.ScoreData;

public interface ScoreRepository extends JpaRepository<ScoreData, Long> {

}
