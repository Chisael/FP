package FP;
public class DogTeam extends SearchTeam{
	
	public DogTeam(){
		super();
	}
	
	public DogTeam(int startX, int startY) {
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
		return false;
	}

	@Override
	public boolean canSearchWater() {
		return false;
	}
}
