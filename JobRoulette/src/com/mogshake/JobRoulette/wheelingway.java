package com.mogshake.JobRoulette;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;

//Coded by Brandon (Mogshake)
//Date: 2/21/23 (dd/mm/yy)
//Picks a random job from the Critically Acclaimed MMORPG Final Fantasy XIV.
//All of this is stolen from my currently two year old project Duty Roulette since I nuked my main drive and yeeted the src of my old job roulette.


public class wheelingway {
	
	//Global Declarations
	private JFrame frame;
	private JLabel chosenJobText;
	int buttonUsed = 0;
	private JButton tankButton;
	private JButton healerButton;
	private JButton dpsButton;
	private JButton anyJobButton;

	
	//Arrays
	
	String tankJobs[] = {"Paladin", "Warrior", "Dark Knight", "Gunbreaker"};
	
	String healerJobs[] = {"White Mage", "Scholar", "Astro", "Sage"};
	
	String dpsJobs[] = {"Monk", "Dragoon", "Ninja", "Samurai", "Reaper", "Bard", "Machinist", "Dancer", "Black Mage", "Summoner", "Red Mage"};

	
	
	wheelingway() {
		
		//Declarations
		frame = new JFrame();
		chosenJobText = new JLabel("<Job Name Here>");
		tankButton = new JButton("Tank");
		healerButton = new JButton("Healer");
		dpsButton = new JButton("DPS");
		anyJobButton = new JButton("Anything");
		
		//Listeners
		tankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 1;
				randomize();
			}
		});//end dungeonButton action listener
		
		healerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 2;
				randomize();
			}
		});//end trialButton action listener
		
		dpsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 3;
				randomize();
			}
		});//end raidButton action listener
		
		anyJobButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 4;
				randomize();
			}
		});//end anyJobButton action listener

		//Set the size of stuff (x, y, width, height)
		chosenJobText.setBounds(210, 20, 250, 50);
		tankButton.setBounds(90, 65, 100, 25);
		healerButton.setBounds(200, 65, 100, 25);
		dpsButton.setBounds(310, 65, 100, 25);
		anyJobButton.setBounds(200, 100, 100, 25);
		
		//Adjust colors
		chosenJobText.setForeground(Color.WHITE);
		
		//Add stuff to the frame
		frame.add(chosenJobText);
		frame.add(tankButton);
		frame.add(healerButton);
		frame.add(dpsButton);
		frame.add(anyJobButton);
		
		//Fancy frame stuff
		frame.setSize(525, 250); //width, height
		frame.setLayout(null); 
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Job Roulette");
		frame.setVisible(true);
	}//End of DowntimeTracker constructor

	public static void main(String[] args) {
		
		new wheelingway();

	}//End of Main Method
	
//-----------------------------------------------------------------------
	
	public void randomize() {
		
		switch (buttonUsed) {
		
		case 1:  pickJob();
				 break;
			
		case 2:  pickJob();
				 break;
			
		case 3:  pickJob();
				 break;
				 
		case 4: pickJob();
			
		default: break;
		
		}//end switch for buttonUsed
	
	}//end randomize

//-----------------------------------------------------------------------
	
	public void pickJob() {
		
		int pickedJob = 0;
		String randomlyPicked;
		
		if (buttonUsed == 1) {
			//This picks a Tank Job
			pickedJob = ThreadLocalRandom.current().nextInt(0, tankJobs.length);
			randomlyPicked = tankJobs[pickedJob];
			chosenJobText.setText(randomlyPicked);
		}//end if 1
		
		if (buttonUsed == 2) {
			//This picks a Healer Job
			pickedJob = ThreadLocalRandom.current().nextInt(0, healerJobs.length);
			randomlyPicked = healerJobs[pickedJob];
			chosenJobText.setText(randomlyPicked);
		}//end if 2
		
		if (buttonUsed == 3) {
			//This picks a DPS Job
			pickedJob = ThreadLocalRandom.current().nextInt(0, dpsJobs.length);
			randomlyPicked = dpsJobs[pickedJob];
			chosenJobText.setText(randomlyPicked);
		}//end if 3
		
		if (buttonUsed == 4) {
			//This picks anything
			buttonUsed = ThreadLocalRandom.current().nextInt(0, 3 + 1);
			pickJob();
		}//end if 4

		
	}//end pickJob
	
//-----------------------------------------------------------------------
	
}//End of class wheelingway