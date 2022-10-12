package br.com.emmerich.klab.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Card {
	private String code;
	private String image;
	
	@JsonIgnore
	private List<String> images;
	private String value;
	private String suit;

	public Card() {
	}

	public Card(String code, String image, List<String> images, String value, String suit) {
		this.code = code;
		this.image = image;
		this.images = images;
		this.value = value;
		this.suit = suit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@JsonIgnore
	public Integer getValueInteger() {
		String realValue = "";
		switch (value) {
		case "A":
			realValue = "1";
			break;
		case "J":
			realValue = "11";
			break;
		case "K":
			realValue = "13";
			break;
		case "Q":
			realValue = "12";
			break;
		default:
			realValue = value;
		}

		return this.value != null ? Integer.parseInt(realValue) : null;
	}

	@Override
	public String toString() {
		return "Card: " + this.getCode() + " " + this.getValue() + " " + this.getSuit();
	}
}
