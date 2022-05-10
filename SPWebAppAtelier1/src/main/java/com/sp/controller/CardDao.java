package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sp.model.Card;

@Service
public class CardDao {
	private List<Card> myCardList;
	private Random randomGenerator;

	public CardDao() {
		myCardList=new ArrayList<>();
		randomGenerator = new Random();
//		createPoneyList();
	}

	public List<Card> getCardList() {
		return this.myCardList;
	}
	public Card getCardByName(String name){
		for (Card poneyBean : myCardList) {
			if(poneyBean.getName().equals(name)){
				return poneyBean;
			}
		}
		return null;
	}
	public Card getRandomCard(){
		int index=randomGenerator.nextInt(this.myCardList.size());
		return this.myCardList.get(index);
	}

	public Card addCard(String name,String description,String family, String affinity, String imgUrl, int defense, int energy, int hp, int attack) {
		Card p=new Card(name, description, family, affinity, imgUrl, defense,energy,hp,attack);
		this.myCardList.add(p);
		return p;
	}
}
