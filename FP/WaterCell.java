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
}
