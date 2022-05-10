package com.sp.model;

public class Card  {
	private String name;
	private String description;
	private String family;
	private String affinity;
	private String imgUrl;
	private int defense;
	private int energy;
	private int hp;
	private int attack;
	
	public Card() {
		this.name = "";
		this.description = "";
		this.family = "";
		this.affinity = "";
		this.imgUrl="";
		this.defense = 0;
		this.energy = 0;
		this.hp = 0;
		this.attack = 0;
	}
	public Card(
			String name,
			String description,
			String family, 
			String affinity, 
			String imgUrl, 
			int defense, 
			int energy, 
			int hp, 
			int attack) 
	{
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl=imgUrl;
		this.defense = defense;
		this.energy = energy;
		this.hp = hp;
		this.attack = attack;
	}
	
	// GETTER AND SETTER
	
	public int getDefense() {
		return defense;
	}
	public int getEnergy() {
		return energy;
	}
	public int getHp() {
		return hp;
	}
	public int getAttack() {
		return attack;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getFamily() {
		return family;
	}
	public String getAffinity() {
		return affinity;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	
}
