package FP;

import java.awt.Color;

public class ForestCell  extends GridCell{

	public ForestCell(){
		super();
		this.color = Color.green;
	}
	
	public ForestCell(int x, int y) {
		super(x,y);
		this.color = Color.green;
	}

	@Override
	public char getInitial() {
		// TODO Auto-generated method stub
		return 'F';
	}

}
