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

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerPanel.
 */
public class PlayerPanel extends JPanel {

    /** The player panel product 7. */
    private PlayerPanelProduct7 playerPanelProduct7 = new PlayerPanelProduct7();
	
	/** The player panel product 6. */
	private PlayerPanelProduct6 playerPanelProduct6 = new PlayerPanelProduct6();
	
	/** The player panel product 5. */
	private PlayerPanelProduct5 playerPanelProduct5 = new PlayerPanelProduct5();
	
	/** The player panel product 4. */
	private PlayerPanelProduct4 playerPanelProduct4 = new PlayerPanelProduct4();
	
	/** The player panel product 3. */
	private PlayerPanelProduct3 playerPanelProduct3 = new PlayerPanelProduct3();
	
	/** The player panel product 2. */
	private PlayerPanelProduct2 playerPanelProduct2 = new PlayerPanelProduct2();
	
	/** The player panel product. */
	private PlayerPanelProduct playerPanelProduct = new PlayerPanelProduct();
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The lbl money. */
	private JLabel lblMoney;
    
    /** The lbl name. */
    private JLabel lblName;
    
    /** The player. */
    private Player player;
    
    /** The txt property. */
    private JTextArea txtProperty;

    /**
     * Instantiates a new player panel.
     *
     * @param player the player
     */
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

    /**
     * Display info.
     */
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
    
    /**
     * Checks if is buy house button enabled.
     *
     * @return true, if is buy house button enabled
     */
    public boolean isBuyHouseButtonEnabled() {
        return playerPanelProduct3.isBuyHouseButtonEnabled();
    }

    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled() {
        return playerPanelProduct7.isDrawCardButtonEnabled();
    }

    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled() {
        return playerPanelProduct2.isEndTurnButtonEnabled();
    }
    
    /**
     * Checks if is gets the out of jail button enabled.
     *
     * @return true, if is gets the out of jail button enabled
     */
    public boolean isGetOutOfJailButtonEnabled() {
        return playerPanelProduct4.isGetOutOfJailButtonEnabled();
    }
    
    /**
     * Checks if is purchase property button enabled.
     *
     * @return true, if is purchase property button enabled
     */
    public boolean isPurchasePropertyButtonEnabled() {
        return playerPanelProduct5.isPurchasePropertyButtonEnabled();
    }
    
    /**
     * Checks if is roll dice button enabled.
     *
     * @return true, if is roll dice button enabled
     */
    public boolean isRollDiceButtonEnabled() {
        return playerPanelProduct6.isRollDiceButtonEnabled();
    }

    /**
     * Checks if is trade button enabled.
     *
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled() {
        return playerPanelProduct.isTradeButtonEnabled();
    }

    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b) {
        playerPanelProduct3.setBuyHouseEnabled(b);
    }

    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b) {
        playerPanelProduct7.setDrawCardEnabled(b);
    }

    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        playerPanelProduct2.setEndTurnEnabled(enabled);
    }

    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
        playerPanelProduct4.setGetOutOfJailEnabled(b);
    }

    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        playerPanelProduct5.setPurchasePropertyEnabled(enabled);
    }

    /**
     * Sets the roll dice enabled.
     *
     * @param enabled the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean enabled) {
        playerPanelProduct6.setRollDiceEnabled(enabled);
    }

    /**
     * Sets the trade enabled.
     *
     * @param b the new trade enabled
     */
    public void setTradeEnabled(boolean b) {
        playerPanelProduct.setTradeEnabled(b);
    }
}