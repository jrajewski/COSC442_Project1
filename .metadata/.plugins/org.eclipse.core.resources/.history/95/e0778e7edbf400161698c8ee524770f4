package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;

public class PlayerProduct2 {
	private PlayerProduct playerProduct = new PlayerProduct();
	private ArrayList<PropertyCell> properties = new ArrayList<PropertyCell>();
	private ArrayList<Cell> railroads = new ArrayList<Cell>();
	private ArrayList<Cell> utilities = new ArrayList<Cell>();

	public PlayerProduct getPlayerProduct() {
		return playerProduct;
	}

	public boolean canBuyHouse() {
		return (playerProduct.getMonopolies().length != 0);
	}

	public void buyProperty(Cell property, int amount, int thisMoney, Player player) {
		property.setTheOwner(player);
		if (property instanceof PropertyCell) {
			PropertyCell cell = (PropertyCell) property;
			properties.add(cell);
			playerProduct.getColorGroups().put(cell.getColorGroup(),
					new Integer(playerProduct.getPropertyNumberForColor(cell.getColorGroup()) + 1));
		}
		if (property instanceof RailRoadCell) {
			railroads.add(property);
			playerProduct.getColorGroups().put(RailRoadCell.COLOR_GROUP,
					new Integer(playerProduct.getPropertyNumberForColor(RailRoadCell.COLOR_GROUP) + 1));
		}
		if (property instanceof UtilityCell) {
			utilities.add(property);
			playerProduct.getColorGroups().put(UtilityCell.COLOR_GROUP,
					new Integer(playerProduct.getPropertyNumberForColor(UtilityCell.COLOR_GROUP) + 1));
		}
		player.setMoney(thisMoney - amount);
	}

	public void exchangeProperty(Player player) {
		for (int i = 0; i < getPropertyNumber(); i++) {
			PropertyCell cell = getProperty(i);
			cell.setTheOwner(player);
			if (player == null) {
				cell.setAvailable(true);
				cell.setNumHouses(0);
			} else {
				player.properties.add(cell);
				playerProduct.getColorGroups().put(cell.getColorGroup(),
						new Integer(playerProduct.getPropertyNumberForColor(cell.getColorGroup()) + 1));
			}
		}
		properties.clear();
	}

	public IOwnable[] getAllProperties() {
		ArrayList<Cell> list = new ArrayList<Cell>();
		list.addAll(properties);
		list.addAll(utilities);
		list.addAll(railroads);
		return (IOwnable[]) list.toArray(new Cell[list.size()]);
	}

	public void resetProperty() {
		properties = new ArrayList<PropertyCell>();
		railroads = new ArrayList<Cell>();
		utilities = new ArrayList<Cell>();
	}

	public void sellProperty(IOwnable property, int amount, int thisMoney, Player player) {
		property.setTheOwner(null);
		if (property instanceof PropertyCell) {
			properties.remove(property);
		}
		if (property instanceof RailRoadCell) {
			railroads.remove(property);
		}
		if (property instanceof UtilityCell) {
			utilities.remove(property);
		}
		player.setMoney(thisMoney + amount);
	}

	public boolean checkProperty(String property) {
		for (int i = 0; i < properties.size(); i++) {
			IOwnable cell = (IOwnable) properties.get(i);
			if (cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
	}

	public PropertyCell getProperty(int index) {
		return (PropertyCell) properties.get(index);
	}

	public int getPropertyNumber() {
		return properties.size();
	}
}