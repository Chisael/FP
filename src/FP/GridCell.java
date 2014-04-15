package FP;
import java.awt.Color;

public abstract class GridCell {
	private int xPos, yPos;
	private boolean searched;
	private String terrainType;
	private Color color;
	
	public final int GRID_LENGTH = 10;
	
	public GridCell(){
		
	}
	
	public Boolean passableByHikers(){
		return false;
	}
	
	public Boolean passableByHelicopter(){
		return false;
	}
	
	public Boolean passableByDogs(){
		return false;
	}
	
	
	

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

	public String getTerrainType() {
		return terrainType;
	}

	public void setTerrainType(String terrainType) {
		this.terrainType = terrainType;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	


}
