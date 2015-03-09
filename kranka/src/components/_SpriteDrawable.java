package components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class _SpriteDrawable implements Drawable {
	
	//� �������� ����� �������� ����������� ���� ��������
	//� ������� ����� ����������� ��������
	protected int FRAME_COLS = 0;  //��������
    protected int FRAME_ROWS = 0;  //������
    
    protected int height = 0; //������ ������ �����
    protected int width = 0; //������ �����

    protected Texture         spriteSheet;     //��������-����� (�������)
    protected TextureRegion[] spriteFrames;    //����� ������ �� ������
    
    protected int frame = 0; //current frame
    protected float time = 0; //time (for setting new frame)
    protected float duration = 0; //duration of a single frame
    
    //single object for output
    protected Array<TextureRegion> output = new Array<TextureRegion>();
    
    protected void init(String path, int cols, int rows)
    {    	    	
    	FRAME_COLS = cols;
        FRAME_ROWS = rows;
        
    	spriteSheet = new Texture(Gdx.files.internal(path)); //�������� ������� (������)
    	
    	spriteSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	
    	//���������� �������� �����
        width = spriteSheet.getWidth() / FRAME_COLS; 
        height = spriteSheet.getHeight() / FRAME_ROWS;
        
        //��������� ������� �� �����
        TextureRegion tmp[][] = TextureRegion.split(spriteSheet, width, height); 
        spriteFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        
        //���������� ������� � �������
        for (int i = 0; i < FRAME_ROWS; i++)
            for (int j = 0; j < FRAME_COLS; j++)
                spriteFrames[index++] = tmp[i][j];
        
    }
    
    public _SpriteDrawable(String path, int cols, int rows) {
    	init(path, cols, rows);
    }
    
    public _SpriteDrawable(String path, int cols, int rows, float duration) {
    	init(path, cols, rows);
    	this.duration = duration;
    }
    
	public Array<TextureRegion> getFrame() {
		output.clear(); output.add(spriteFrames[frame]); 
		return output;
	}


	public Array<TextureRegion> getFrame(boolean change) {
		if (change) 
			frame = (frame + 1 )% FRAME_COLS * FRAME_ROWS;
		return getFrame();
	}


	public Array<TextureRegion> getFrame(int frame) {
		output.clear(); output.add(spriteFrames[frame]);
		return output;
	}


	public Array<TextureRegion> getFrame(float delta) {
		time += delta;
		frame = (frame + (int)(time / duration) ) % (FRAME_COLS * FRAME_ROWS);
		time = time % duration;
		return getFrame();
	}

    public int getHeight() {
    	return height;
    }
    
    public int getWidth() {
    	return width;
    }

    public void setDuration(float duration) {
		this.duration = duration;
	}

}
