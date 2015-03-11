package components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public interface iDrawable extends iComponent {
	Array<TextureRegion> getFrame(); //�������� ��� ���������; ����������� �� ����� ����
	Array<TextureRegion> getFrame(boolean change); //�������� ��� ���������; �������� - ����������� �� ����
	Array<TextureRegion> getFrame(int frame); //�������� ��� ���������; ���������� ���������� ����
	Array<TextureRegion> getFrame(float delta); //�������� ��� ���������; �������� - �����, �� �������� � �����������
	void setDuration(float duration);
	int getHeight();
    int getWidth();
   // int GetAngle();
}
