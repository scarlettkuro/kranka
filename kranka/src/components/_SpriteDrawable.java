package components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class _SpriteDrawable implements Drawable {
	
	//в качестве листа спрайтов загружается одна картинка
	//в которой кадры расположены таблицей
	protected int FRAME_COLS = 0;  //столбики
    protected int FRAME_ROWS = 0;  //строки
    
    protected int height = 0; //высота одного кадра
    protected int width = 0; //высота кадра

    protected Texture         spriteSheet;     //текстура-атлас (таблица)
    protected TextureRegion[] spriteFrames;    //набор кадров из атласа
    
    protected int frame = 0; //current frame
    protected float time = 0; //time (for setting new frame)
    protected float duration = 0; //duration of a single frame
    
    //single object for output
    protected Array<TextureRegion> output = new Array<TextureRegion>();
    
    protected void init(String path, int cols, int rows)
    {    	    	
    	FRAME_COLS = cols;
        FRAME_ROWS = rows;
        
    	spriteSheet = new Texture(Gdx.files.internal(path)); //загрузка таблицы (атласа)
    	
    	spriteSheet.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	
    	//вычисление размеров кадра
        width = spriteSheet.getWidth() / FRAME_COLS; 
        height = spriteSheet.getHeight() / FRAME_ROWS;
        
        //разбиение таблицы на кадры
        TextureRegion tmp[][] = TextureRegion.split(spriteSheet, width, height); 
        spriteFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        
        //приведение матрицы к массиву
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
