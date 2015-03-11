package members;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import components.iDrawable;
import components.iPositionable;
import components._OneDimPositionbale;
import components._SpriteDrawable;

public class Hero implements iDrawable,iPositionable {
	
	iDrawable drawable;	
	iPositionable positionable;
	
	public Hero() {
		drawable = new _SpriteDrawable("pic3.png", 2, 2, .5f);
		positionable = new _OneDimPositionbale(256);
	}
	@Override
	public Array<TextureRegion> getFrame() {
		return drawable.getFrame();
	}

	@Override
	public Array<TextureRegion> getFrame(boolean change) {
		return drawable.getFrame(change);
	}

	@Override
	public Array<TextureRegion> getFrame(int frame) {
		return drawable.getFrame(frame);
	}

	@Override
	public Array<TextureRegion> getFrame(float delta) {
		return drawable.getFrame(delta);
	}

	@Override
	public void setDuration(float duration) {
		drawable.setDuration(duration);
	}

	@Override
	public int getHeight() {
		return drawable.getHeight();
	}

	@Override
	public int getWidth() {
		return drawable.getWidth();
	}
//---positionable
	@Override
	public int getX() {
		return positionable.getX();
	}

	@Override
	public void setX(int x) {
		positionable.setX(x);
		
	}

	@Override
	public int getSize() {
		return positionable.getSize();
	}

	@Override
	public boolean touches(int x) {
		return positionable.touches(x);
	}

}
