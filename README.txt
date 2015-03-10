===we are using component inheritance pattern===
Example:

class Hero implements Drawable, Positionable {
	Drawable drawable = new _SpriteDrawable();
	Positionable positionable = new _RowPositionbale();
	
	//call the Drawable methods from drawable object
	//like:
	Array<TextureRegion> getFrame(float delta) {
		drawable.getFrame(float delta);
	}
	
	...
	
	//call the Positionable methods from positionable object
	
	...
	
}

================================================
What is done for now

Intefaces:

Drawable (interface allow to get textures of objects)
Positionable (interface allow to set location of the objects in one-dimesional space, collision detection)
Speakable (dialog interface)

Components: 

_SpriteDrawable implements Drawable (sprite animation class)
_OneDimPositionbale implements Positionable 
_NPCSpeakable implements Speakable (n-variant simple dialog with linking next phrase)


Command system and controls

Command interfaces: 
GameCommander (game proccess)

CommandProccessors: input -> command

_GameCommandProccessor (game proccess)
