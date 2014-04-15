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

}
