package components;

public interface iPositionable extends iComponent {
	//x coordinate of object (left corner)
	int getX(); 
	void setX(int x); 
	int getSize(); //length of object
	boolean touches(int x); //does object hold the position x
}
