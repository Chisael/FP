package FP;
import java.awt.Color;

public abstract class GridCell {
	private int xPos, yPos;
	private boolean searched;
	protected Color color;
	
	public final int GRID_LENGTH = 10;
	
	public GridCell() {
		this.xPos = 0;
		this.yPos = 0;
		this.searched = false;
	}
	
	public GridCell(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.searched = false;
	}
	public abstract boolean passableByHikers();
	
	public abstract boolean passableByHelicopter();
	
	public abstract boolean passableByDogs();
	
	public abstract char getInitial();
	

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public boolean isSearched() {
		return searched;
	}

	public void setSearched(boolean searched) {
		this.searched = searched;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	


}
