package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.Card;
import com.sp.model.CardFormDTO;

@Controller 
public class RequestCrt {
	
	@Value("${welcome.message}")
	private String message;
	@Autowired
    CardDao cardDao;
	
	private static String messageLocal="<center>Bienvenue sur notre site de creation de cartes en ligne, "
			+ "ici vous allez pouvoir créer vos propores cartes afin de les utiliser plus tard dans le jeu. "
			+ "<br>Nous esperons que notre site vous plaira et que vous vous y amuserez!!</center>";
	
			
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("messageLocal", messageLocal);
		return "index";
	}
	
	@RequestMapping(value = { "/getCard"}, method = RequestMethod.GET)
    public String getCard(Model model) {
		
		try 
		{
			Card carte = cardDao.getRandomCard();  
			model.addAttribute("myCard", carte);
			
		}
		catch ( Exception e)
		{
			System.out.println("\n\n\n  TENTATIVE DE PICK RANDOM CARD ON NULL !!! \n\n\n");
		}
		
		return "cardView";
	}
	
	@RequestMapping(value = { "/addCard"}, method = RequestMethod.GET)
    public String addcard(Model model) {
		CardFormDTO cardForm = new CardFormDTO();
    	model.addAttribute("cardForm", cardForm);
    	return "cardForm";
    }

	@RequestMapping(value = { "/addCard"}, method = RequestMethod.POST)
    public String viewNewCard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm) {
	  Card p=cardDao.addCard(cardForm.getName(),cardForm.getDescription(), cardForm.getFamily(),cardForm.getAffinity(),cardForm.getImgUrl(),cardForm.getDefense(),cardForm.getEnergy(),cardForm.getHp(),cardForm.getAttack());
      model.addAttribute("myCard",p );
      return "cardView";
  	}
	
	@RequestMapping(value = { "/getAll"}, method = RequestMethod.GET)
    public String getAll(Model model) {
  	  model.addAttribute("cardList",cardDao.getCardList() );
  	  return "cardViewList";
    }
}