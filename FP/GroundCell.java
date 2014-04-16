package FP;

import java.awt.Color;

public class GroundCell  extends GridCell{

	public GroundCell(){
		super();
		this.color = Color.orange;
	}
	
	public GroundCell(int x, int y) {
		super(x,y);
		this.color = Color.orange;
	}

	@Override
	public char getInitial() {
		return 'G';
	}
	
	@Override
	public boolean passableByHikers() {
	  return true;
	}

  @Override
  public boolean passableByHelicopter() {
    return true;
  }

  @Override
  public boolean passableByDogs() {
    return true;
  }

}
