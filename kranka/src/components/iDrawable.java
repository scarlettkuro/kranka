package components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public interface iDrawable extends iComponent {
	Array<TextureRegion> getFrame(); //текстура для отрисовки; переключает на новый кадр
	Array<TextureRegion> getFrame(boolean change); //текстура для отрисовки; параметр - переключать ли кадр
	Array<TextureRegion> getFrame(int frame); //текстура для отрисовки; возвращает конкретный кадр
	Array<TextureRegion> getFrame(float delta); //текстура для отрисовки; параметр - время, по которому её запрашивают
	void setDuration(float duration);
	int getHeight();
    int getWidth();
   // int GetAngle();
}
