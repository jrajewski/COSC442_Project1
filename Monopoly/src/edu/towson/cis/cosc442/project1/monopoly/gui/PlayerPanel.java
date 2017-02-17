package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

public class PlayerPanel extends JPanel {

    private PlayerPanelProduct7 playerPanelProduct7 = new PlayerPanelProduct7();
	private PlayerPanelProduct6 playerPanelProduct6 = new PlayerPanelProduct6();
	private PlayerPanelProduct5 playerPanelProduct5 = new PlayerPanelProduct5();
	private PlayerPanelProduct4 playerPanelProduct4 = new PlayerPanelProduct4();
	private PlayerPanelProduct3 playerPanelProduct3 = new PlayerPanelProduct3();
	private PlayerPanelProduct2 playerPanelProduct2 = new PlayerPanelProduct2();
	private PlayerPanelProduct playerPanelProduct = new PlayerPanelProduct();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMoney;
    private JLabel lblName;
    
    private Player player;
    
    private JTextArea txtProperty;

    public PlayerPanel(Player player) {
        JPanel pnlAction = new JPanel();
        JPanel pnlInfo = new JPanel();
        playerPanelProduct6.setBtnRollDice(new JButton("Roll Dice"));
        playerPanelProduct5.setBtnPurchaseProperty(new JButton("Purchase Property"));
        playerPanelProduct2.setBtnEndTurn(new JButton("End Turn"));
        playerPanelProduct3.setBtnBuyHouse(new JButton("Buy House"));
        playerPanelProduct4.setBtnGetOutOfJail(new JButton("Get Out of Jail"));
        playerPanelProduct7.setBtnDrawCard(new JButton("Draw Card"));
        playerPanelProduct.setBtnTrade(new JButton("Trade"));
        this.player = player;
        lblName = new JLabel();
        lblMoney = new JLabel();
        txtProperty = new JTextArea(30, 70);

        txtProperty.setEnabled(false);

        JPanel pnlName = new JPanel();
        JPanel pnlProperties = new JPanel();

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.add(pnlName, BorderLayout.NORTH);
        pnlInfo.add(pnlProperties, BorderLayout.CENTER);

        pnlProperties.setLayout(new OverlayLayout(pnlProperties));

        pnlName.add(lblName);
        pnlName.add(lblMoney);
        pnlProperties.add(txtProperty);

        pnlAction.setLayout(new GridLayout(3, 3));
        pnlAction.add(playerPanelProduct3.getBtnBuyHouse());
        pnlAction.add(playerPanelProduct6.getBtnRollDice());
        pnlAction.add(playerPanelProduct5.getBtnPurchaseProperty());
        pnlAction.add(playerPanelProduct4.getBtnGetOutOfJail());
        pnlAction.add(playerPanelProduct2.getBtnEndTurn());
        pnlAction.add(playerPanelProduct7.getBtnDrawCard());
        pnlAction.add(playerPanelProduct.getBtnTrade());

        pnlAction.doLayout();
        pnlInfo.doLayout();
        pnlName.doLayout();
        pnlProperties.doLayout();
        this.doLayout();

        setLayout(new BorderLayout());
        add(pnlInfo, BorderLayout.CENTER);
        add(pnlAction, BorderLayout.SOUTH);

        playerPanelProduct6.getBtnRollDice().setEnabled(false);
        playerPanelProduct5.getBtnPurchaseProperty().setEnabled(false);
        playerPanelProduct2.getBtnEndTurn().setEnabled(false);
        playerPanelProduct3.getBtnBuyHouse().setEnabled(false);
        playerPanelProduct4.getBtnGetOutOfJail().setEnabled(false);
        playerPanelProduct7.getBtnDrawCard().setEnabled(false);
        playerPanelProduct.getBtnTrade().setEnabled(false);

        setBorder(new BevelBorder(BevelBorder.RAISED));

        playerPanelProduct6.getBtnRollDice().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnRollDiceClicked();
            }
        });

        playerPanelProduct2.getBtnEndTurn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnEndTurnClicked();
            }
        });

        playerPanelProduct5.getBtnPurchaseProperty().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnPurchasePropertyClicked();
            }
        });

        playerPanelProduct3.getBtnBuyHouse().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnBuyHouseClicked();
            }
        });

        playerPanelProduct4.getBtnGetOutOfJail().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnGetOutOfJailClicked();
            }
        });

        playerPanelProduct7.getBtnDrawCard().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card card = GameMaster.instance().btnDrawCardClicked();
                JOptionPane
                        .showMessageDialog(PlayerPanel.this, card.getLabel());
                displayInfo();
            }
        });

        playerPanelProduct.getBtnTrade().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnTradeClicked();
            }
        });
    }

    public void displayInfo() {
        lblName.setText(player.getName());
        lblMoney.setText("$ " + player.getMoney());
        StringBuffer buf = new StringBuffer();
        IOwnable[] cells = player.getAllProperties();
        for (int i = 0; i < cells.length; i++) {
            buf.append(cells[i] + "\n");
        }
        txtProperty.setText(buf.toString());
    }
    
    public boolean isBuyHouseButtonEnabled() {
        return playerPanelProduct3.isBuyHouseButtonEnabled();
    }

    public boolean isDrawCardButtonEnabled() {
        return playerPanelProduct7.isDrawCardButtonEnabled();
    }

    public boolean isEndTurnButtonEnabled() {
        return playerPanelProduct2.isEndTurnButtonEnabled();
    }
    
    public boolean isGetOutOfJailButtonEnabled() {
        return playerPanelProduct4.isGetOutOfJailButtonEnabled();
    }
    
    public boolean isPurchasePropertyButtonEnabled() {
        return playerPanelProduct5.isPurchasePropertyButtonEnabled();
    }
    
    public boolean isRollDiceButtonEnabled() {
        return playerPanelProduct6.isRollDiceButtonEnabled();
    }

    public boolean isTradeButtonEnabled() {
        return playerPanelProduct.isTradeButtonEnabled();
    }

    public void setBuyHouseEnabled(boolean b) {
        playerPanelProduct3.setBuyHouseEnabled(b);
    }

    public void setDrawCardEnabled(boolean b) {
        playerPanelProduct7.setDrawCardEnabled(b);
    }

    public void setEndTurnEnabled(boolean enabled) {
        playerPanelProduct2.setEndTurnEnabled(enabled);
    }

    public void setGetOutOfJailEnabled(boolean b) {
        playerPanelProduct4.setGetOutOfJailEnabled(b);
    }

    public void setPurchasePropertyEnabled(boolean enabled) {
        playerPanelProduct5.setPurchasePropertyEnabled(enabled);
    }

    public void setRollDiceEnabled(boolean enabled) {
        playerPanelProduct6.setRollDiceEnabled(enabled);
    }

    public void setTradeEnabled(boolean b) {
        playerPanelProduct.setTradeEnabled(b);
    }
}