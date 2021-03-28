package com.taylormuhrline.ninjagold.controllers;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String gold(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("messages") == null) {
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
		}
	    return "gold.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/farm")
	public String farm(HttpSession session) {
		Random rand1 = new Random();
		Integer roll = rand1.nextInt(10) + 10;
		Integer gold = (Integer) session.getAttribute("gold");
		Integer newTotal = gold + roll;
		session.setAttribute("gold", newTotal);
		LocalDateTime timeStamp = LocalDateTime.now();
		String message = "You entered the farm and found " + roll + " gold ("+timeStamp+")";
		
		
		ArrayList<String> oldMessages = (ArrayList<String>) session.getAttribute("messages");
		oldMessages.add(message);
		session.setAttribute("messages", oldMessages);
		return "redirect:/";
	}
	
	@PostMapping(value="/cave")
	public String cave(HttpSession session) {
		Random rand1 = new Random();
		Integer roll = rand1.nextInt(5) + 5;
		Integer gold = (Integer) session.getAttribute("gold");
		Integer newTotal = gold + roll;
		session.setAttribute("gold", newTotal);
		LocalDateTime timeStamp = LocalDateTime.now();
		String message = "You entered the cave and found " + roll + " gold ("+timeStamp+")";
		ArrayList<String> oldMessages = (ArrayList<String>) session.getAttribute("messages");
		oldMessages.add(message);
		session.setAttribute("messages", oldMessages);
		return "redirect:/";
	}
	
	@PostMapping(value="/house")
	public String house(HttpSession session) {
		Random rand1 = new Random();
		Integer roll = rand1.nextInt(3) + 2;
		Integer gold = (Integer) session.getAttribute("gold");
		Integer newTotal = gold + roll;
		session.setAttribute("gold", newTotal);
		LocalDateTime timeStamp = LocalDateTime.now();
		String message = "You entered the house and found " + roll + " gold (" +timeStamp+ ")";
		ArrayList<String> oldMessages = (ArrayList<String>) session.getAttribute("messages");
		oldMessages.add(message);
		session.setAttribute("messages", oldMessages);
		return "redirect:/";
	}
	
	@PostMapping(value="/casino")
	public String casino(HttpSession session) {
		Random rand1 = new Random();
		Integer gainLose = rand1.nextInt(2);
		Integer roll = rand1.nextInt(50);
		Integer gold = (Integer) session.getAttribute("gold");
		if(gainLose == 1) {
			System.out.println("gainLose = 1");
			System.out.println(gainLose);
			Integer newTotal = gold - roll;
			session.setAttribute("gold", newTotal);
			LocalDateTime timeStamp = LocalDateTime.now();
			String message = "You entered the casino and lost " + roll + " gold (" + timeStamp + ")";
			ArrayList<String> oldMessages = (ArrayList<String>) session.getAttribute("messages");
			oldMessages.add(message);
			session.setAttribute("messages", oldMessages);
		}
		else if(gainLose == 0) {
			System.out.println("gainLose = 0");
			System.out.println(gainLose);
			Integer newTotal = gold + roll;
			session.setAttribute("gold", newTotal);
			LocalDateTime timeStamp = LocalDateTime.now();
			String message = "You entered the casino and won " + roll + " gold (" + timeStamp + ")";
			ArrayList<String> oldMessages = (ArrayList<String>) session.getAttribute("messages");
			oldMessages.add(message);
			session.setAttribute("messages", oldMessages);
		}
		System.out.println(gainLose);
		return "redirect:/";
	}
}
