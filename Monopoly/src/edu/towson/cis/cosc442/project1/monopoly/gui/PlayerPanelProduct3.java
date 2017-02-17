package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JButton;
import java.io.Serializable;

public class PlayerPanelProduct3 implements Serializable {
	private JButton btnBuyHouse;

	public JButton getBtnBuyHouse() {
		return btnBuyHouse;
	}

	public void setBtnBuyHouse(JButton btnBuyHouse) {
		this.btnBuyHouse = btnBuyHouse;
	}

	public boolean isBuyHouseButtonEnabled() {
		return btnBuyHouse.isEnabled();
	}

	public void setBuyHouseEnabled(boolean b) {
		btnBuyHouse.setEnabled(b);
	}
}