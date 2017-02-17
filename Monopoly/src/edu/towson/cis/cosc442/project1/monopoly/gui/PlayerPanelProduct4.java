package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JButton;
import java.io.Serializable;

public class PlayerPanelProduct4 implements Serializable {
	private JButton btnGetOutOfJail;

	public JButton getBtnGetOutOfJail() {
		return btnGetOutOfJail;
	}

	public void setBtnGetOutOfJail(JButton btnGetOutOfJail) {
		this.btnGetOutOfJail = btnGetOutOfJail;
	}

	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJail.isEnabled();
	}

	public void setGetOutOfJailEnabled(boolean b) {
		btnGetOutOfJail.setEnabled(b);
	}
}