package components;

public class _OneDimPositionbale implements iPositionable {

	protected int x;
	protected int size;
	
	public _OneDimPositionbale(int size) {
		this.size = size;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getSize() {
		return size;
	}
	public boolean touches(int x) {
		return (x > this.x) && (x < (this.x + size));
	}

	@Override
	public String myName() {
		return "Positionbale";
	}

}
