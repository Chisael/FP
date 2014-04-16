package FP;

import java.awt.Color;

public class MountainCell extends GridCell{

	public MountainCell(){
		super();
		this.color = Color.gray;
	}
	
	public MountainCell(int x, int y) {
		super(x,y);
		this.color = Color.gray;
	}

	@Override
	public char getInitial() {
		return 'M';
	}

  @Override
  public boolean passableByHikers() {
    return true;
  }

  @Override
  public boolean passableByHelicopter() {
    return false;
  }

  @Override
  public boolean passableByDogs() {
    return true;
  }
}
