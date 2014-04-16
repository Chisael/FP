package FP;

import java.awt.Color;

public class WaterCell extends GridCell{

	public WaterCell(){
		super();
		this.color = Color.blue;
	}
	
	public WaterCell(int x, int y) {
		super(x,y);
		this.color = Color.blue;
	}

	@Override
	public char getInitial() {
		return 'W';
	}

  @Override
  public boolean passableByHikers() {
    return false;
  }

  @Override
  public boolean passableByHelicopter() {
    return true;
  }

  @Override
  public boolean passableByDogs() {
    return false;
  }
}
