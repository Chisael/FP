package FP;
public class GroundTeam extends SearchTeam{

	public GroundTeam(){
		super();
	}
	
	public GroundTeam(int startX, int startY) {
		super(startX, startY);
	}
	
	@Override
	public boolean canSearchForest() {
		return true;
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
		return false;
	}
}
