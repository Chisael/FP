package FP;
public class AirTeam extends SearchTeam{

	
	public AirTeam(){
		super();
	}
	
	public AirTeam(int startX, int startY){
		super(startX, startY);
	}
	
	@Override
	public boolean canSearchForest() {
		return false;
	}
	
	@Override
	public boolean canSearchGround() {
		return true;
	}
	
	@Override
	public boolean canSearchMountain() {
		return true;
	}

	@Override
	public boolean canSearchWater() {
		return true;
	}

}
