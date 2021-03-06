package FP;
public abstract class SearchTeam {
	private String teamName;
	private int xPos, yPos;
	private double xVelocity, yVelocity;
	private Direction direction;
	
	public enum Direction {
		NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST;
	}

	public SearchTeam(){
		this.xPos = 0;
		this.yPos = 0;
	}
	
	public SearchTeam(int startX, int startY) {
		this.xPos = startX;
		this.yPos = startY;
	}
	
	public void updateX(){
		
	}
	
	public void updateY(){
		
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public Direction getDirection() {
		return direction;
	}

	public boolean canSearchForest() {
		return false;
	}

	public boolean canSearchGround() {
		return false;
	}

	public boolean canSearchMountain() {
		return false;
	}

	public boolean canSearchWater() {
		return false;
	}

}
