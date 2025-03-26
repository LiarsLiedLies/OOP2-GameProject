/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.genericrpg;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author L12Y07W07
 */
public class Game {
    private Player player;
    private Player computer;
    private int countdown = 10;
    private javax.swing.JProgressBar playerLifeBar;
    private javax.swing.JProgressBar computerLifeBar;
    private javax.swing.JLabel lblPlayerWins;
    private javax.swing.JLabel lblComputerWins;
    private javax.swing.JLabel lblPlayerChoice;
    private javax.swing.JLabel lblComputerChoice;
    private javax.swing.JLabel lblTimer;
    private Timer timer;

    //No idea WTF is this...
    public Game(javax.swing.JProgressBar playerLifeBar, javax.swing.JProgressBar computerLifeBar,
                        javax.swing.JLabel lblPlayerWins, javax.swing.JLabel lblComputerWins,
                        javax.swing.JLabel lblPlayerChoice, javax.swing.JLabel lblComputerChoice,
                        javax.swing.JLabel lblTimer) {
        this.player = new Player();
        this.computer = new Player();
        this.playerLifeBar = playerLifeBar;
        this.computerLifeBar = computerLifeBar;
        this.lblPlayerWins = lblPlayerWins;
        this.lblComputerWins = lblComputerWins;
        this.lblPlayerChoice = lblPlayerChoice;
        this.lblComputerChoice = lblComputerChoice;
        this.lblTimer = lblTimer;
    }


    public void startTimer() {
        countdown = 10;
        lblTimer.setText("Time: " + countdown);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public void resetGame() {
        player.resetPlayer();
        computer.resetPlayer();
        resetCountdown();

        playerLifeBar.setValue(player.getHealth());
        computerLifeBar.setValue(computer.getHealth());

        lblPlayerChoice.setIcon(new ImageIcon(getClass().getResource("/Images/Mark.png")));
        lblComputerChoice.setIcon(new ImageIcon(getClass().getResource("/Images/Mark.png")));

        lblPlayerWins.setText("Win: " + player.getWins());
        lblComputerWins.setText("Win: " + computer.getWins());

        lblTimer.setText("TIME!!!");
    }

    public String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    public void determineWinner() {
        String playerChoice = player.getChoice();
        String computerChoice = computer.getChoice();
        boolean gameOver = false; // Flag to track if game over message was shown

        if (playerChoice.equals(computerChoice)) {
            System.out.println("Tie!");
        } else if (
                (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            System.out.println("Player wins!");
            player.setWins(player.getWins() + 1);
            lblPlayerWins.setText("Win: " + player.getWins());
            computer.takeDamage(10);
        } else {
            System.out.println("Computer wins!");
            computer.setWins(computer.getWins() + 1);
            lblComputerWins.setText("Win: " + computer.getWins());
            player.takeDamage(10);
        }
        updateHealthBars();
        player.setChoice(""); // Reset player's choice for the next round
        computer.setChoice(""); // Reset computer's choice for the next round

        if (player.getHealth() <= 0 && !gameOver) {
            JOptionPane.showMessageDialog(null, "Player lost!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameOver = true;
        } else if (computer.getHealth() <= 0 && !gameOver) {
            JOptionPane.showMessageDialog(null, "Computer lost!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameOver = true;
        } else {
        }
    }

    private void updateHealthBars() {
        playerLifeBar.setValue(player.getHealth());
        computerLifeBar.setValue(computer.getHealth());
    }

    public void handleTimeOut() {
        if (player.getChoice().equals("")) {
            player.takeDamage(10);
        }
        determineWinner();
    }

    public int getCountdown() {
        return countdown;
    }

    public void decrementCountdown() {
        countdown--;
    }

    public boolean isTimeOut() {
        return countdown <= 0;
    }

    public void resetCountdown() {
        countdown = 10;
    }
}