                                                                                                                                                                                                      /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.genericrpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JOptionPane;
/**
 *
 * @author L12Y07W07
 */
public class STARTFIGHT extends javax.swing.JFrame {

    private Player player;
    private Enemy enemy;
    private Timer timer;
    private Random random = new Random();
    
    
    public STARTFIGHT() {
        initComponents();
        initializeGame();
    }
    
    private void initializeGame() {
        // Initialize player
        player = new Player("Hero");
        playerLife.setMaximum(player.getHpMax());
        playerLife.setValue(player.getHp());
        lblPlayer.setText(player.getName() + " (HP: " + player.getHp() + "/" + player.getHpMax() + ")");

        // Initialize enemy
        enemy = getRandomEnemy();
        computerLife.setMaximum(enemy.getHpMax());
        computerLife.setValue(enemy.getHp());
        lblComputer.setText(enemy.getName() + " (HP: " + enemy.getHp() + "/" + enemy.getHpMax() + ")");

        ImageIcon defaultIcon = new ImageIcon("C:/Users/L12Y07W07/Documents/NetBeansProjects/GUI1/src/main/java/Images/Mark.png");
        lblPlayerChoice.setIcon(defaultIcon);
        lblComputerChoice.setIcon(defaultIcon);
        btnFight.setEnabled(false);
        updateSkillButtonNames();
    }
    
    private Enemy getRandomEnemy() {
        Enemy[] possibleEnemies = new Enemy[]{
                new Enemy("Goblin"),
                new Enemy("Orc", "Minion_Warrior"),
                new Enemy("Wildcat", "Minion_Wildcat", 1)
                // Add more enemies as needed
        };
        return possibleEnemies[random.nextInt(possibleEnemies.length)];
    }

    private void updateSkillButtonNames() {
        btnATK1.setText(player.getS1Name());
        btnATK2.setText(player.getS2Name());
        btnATK3.setText(player.getS3Name());
        btnATK4.setVisible(false); // Assuming player has only 3 skills for now
    }

    private void updateHealthDisplay() {
        playerLife.setValue(player.getHp());
        lblPlayer.setText(player.getName() + " (HP: " + player.getHp() + "/" + player.getHpMax() + ")");
        computerLife.setValue(enemy.getHp());
        lblComputer.setText(enemy.getName() + " (HP: " + enemy.getHp() + "/" + enemy.getHpMax() + ")");
    }

    private void handlePlayerAction(String actionName) {
        lblPlayerChoice.setText(actionName); // Simple text display for now
        btnFight.setEnabled(true);
    }

     private void performEnemyAction() {
        // Enemy logic to choose an action (simple attack for now)
        enemy.basicAttack(player); // Pass the player object directly
        lblComputerChoice.setText("Enemy Attack"); // Simple text display
    }

    private void checkBattleEnd() {
        if (!player.isAlive()) {
            JOptionPane.showMessageDialog(this, "Game Over! " + enemy.getName() + " wins!");
            initializeGame();
        } else if (!enemy.isAlive()) {
            JOptionPane.showMessageDialog(this, "Victory! " + player.getName() + " defeated " + enemy.getName() + "!");
            initializeGame();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerLife = new javax.swing.JProgressBar();
        computerLife = new javax.swing.JProgressBar();
        btnATK1 = new javax.swing.JButton();
        btnATK2 = new javax.swing.JButton();
        btnATK3 = new javax.swing.JButton();
        btnFight = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblPlayerChoice = new javax.swing.JLabel();
        lblComputerChoice = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblComputer = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        btnATK4 = new javax.swing.JButton();
        playerMana = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnATK1.setText("Basic");
        btnATK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATK1ActionPerformed(evt);
            }
        });

        btnATK2.setText("Skill 1");
        btnATK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATK2ActionPerformed(evt);
            }
        });

        btnATK3.setText("Skill 2");
        btnATK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATK3ActionPerformed(evt);
            }
        });

        btnFight.setText("FIGHT");
        btnFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFightActionPerformed(evt);
            }
        });

        btnReset.setText("ResetGame");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblPlayerChoice.setMaximumSize(new java.awt.Dimension(2, 2));
        lblPlayerChoice.setPreferredSize(new java.awt.Dimension(165, 165));

        lblPlayer.setText("Player");

        lblComputer.setText("Computer");

        lblTimer.setText("TIME!!!");

        btnATK4.setText("Skill 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPlayer)
                        .addGap(291, 291, 291)
                        .addComponent(lblTimer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(293, 293, 293)
                                .addComponent(btnReset))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnATK1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnATK2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnATK3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnATK4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPlayerChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(playerLife, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(playerMana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblComputer)
                                    .addComponent(lblComputerChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(computerLife, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayer)
                            .addComponent(lblComputer)
                            .addComponent(lblTimer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerLife, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(computerLife, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(playerMana, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblComputerChoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayerChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnATK2)
                    .addComponent(btnATK1)
                    .addComponent(btnATK3)
                    .addComponent(btnATK4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnFight))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnATK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATK1ActionPerformed
        handlePlayerAction(player.getS1Name());
    }//GEN-LAST:event_btnATK1ActionPerformed

    private void btnATK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATK2ActionPerformed
        handlePlayerAction(player.getS2Name());
    }//GEN-LAST:event_btnATK2ActionPerformed

    private void btnATK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATK3ActionPerformed
        handlePlayerAction(player.getS3Name());
    }//GEN-LAST:event_btnATK3ActionPerformed

    private void btnFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFightActionPerformed
        String playerAction = lblPlayerChoice.getText();
        lblComputerChoice.setText("Enemy's Turn"); // Placeholder

        // Player performs action
        if (playerAction.equals(player.getS1Name())) {
            player.skill1(new Entity[]{enemy});
        } else if (playerAction.equals(player.getS2Name())) {
            player.skill2(new Entity[]{enemy});
        } else if (playerAction.equals(player.getS3Name())) {
            player.skill3(new Entity[]{enemy});
        } else if (playerAction.equals("Basic Attack")) { // Fallback to basic attack if no skill matched
            player.basicAttack(enemy);
        }

        updateHealthDisplay();
        checkBattleEnd();

        if (enemy.isAlive()) {
            // Enemy performs action
            performEnemyAction();
            updateHealthDisplay();
            checkBattleEnd();
        }

        btnFight.setEnabled(false);
        lblPlayerChoice.setText("");
        lblComputerChoice.setText("");
    }//GEN-LAST:event_btnFightActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        initializeGame();
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateHealthDisplay();
    }//GEN-LAST:event_formWindowOpened
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(STARTFIGHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STARTFIGHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STARTFIGHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STARTFIGHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STARTFIGHT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnATK1;
    private javax.swing.JButton btnATK2;
    private javax.swing.JButton btnATK3;
    private javax.swing.JButton btnATK4;
    private javax.swing.JButton btnFight;
    private javax.swing.JButton btnReset;
    private javax.swing.JProgressBar computerLife;
    private javax.swing.JLabel lblComputer;
    private javax.swing.JLabel lblComputerChoice;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerChoice;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JProgressBar playerLife;
    private javax.swing.JProgressBar playerMana;
    // End of variables declaration//GEN-END:variables
}
