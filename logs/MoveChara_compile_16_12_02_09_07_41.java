import javafx.scene.image.Image;

public class MoveChara {
    public static final int TYPE_DOWN  = 0;
    public static final int TYPE_LEFT  = 1;
    public static final int TYPE_RIGHT = 2;
    public static final int TYPE_UP    = 3;

    private int posX;
    private int posY;

    private MapData mapData;
    
    private Image[] charaImage;
    private int count   = 0;
    private int diffx   = 1;
    private int charaDir;
    
    MoveChara(int startX, int startY, MapData mapData){
	this.mapData = mapData;
	charaImage = new Image[12];
	charaImage[0 * 3 + 0] = new Image("nekod1.png");
	charaImage[0 * 3 + 1] = new Image("nekod2.png");
	charaImage[0 * 3 + 2] = new Image("nekod3.png");
	charaImage[1 * 3 + 0] = new Image("nekol1.png");
	charaImage[1 * 3 + 1] = new Image("nekol2.png");
	charaImage[1 * 3 + 2] = new Image("nekol3.png");
	charaImage[2 * 3 + 0] = new Image("nekor1.png");
	charaImage[2 * 3 + 1] = new Image("nekor2.png");
	charaImage[2 * 3 + 2] = new Image("nekor3.png");
	charaImage[3 * 3 + 0] = new Image("nekou1.png");
	charaImage[3 * 3 + 1] = new Image("nekou2.png");
	charaImage[3 * 3 + 2] = new Image("nekou3.png");

	posX = startX;
	posY = startY;

	charaDir = TYPE_DOWN;
    }

    public int getIndex(){
	return charaDir * 3 + count;
    }
    
    public void changeCount(){
	count = count + diffx;
	if (count > 2) {
	    count = 1;
	    diffx = -1;
	} else if (count < 0){
	    count = 1;
	    diffx = 1;
	}
    }

    public int getPosX(){
	return posX;
    }

    public int getPosY(){
	return posY;
    }

    public void setCharaDir(int cd){
	charaDir = cd;
    }

    public boolean canMove(int dx, int dy){
	if (mapData.getMap(posX+dx, posY+dy) == MapData.TYPE_WALL){
	    return false;
	} else if (mapData.getMap(posX+dx, posY+dy) == MapData.TYPE_NONE){
	    return true;
	}
	return false;
    }

    public boolean move(int dx, int dy){
	if (canMove(dx,dy)){
	    posX += dx;
	    posY += dy;
	    return true;
	}else {
	    return false;
	}
    }

    public Image getImage(){
	changeCount();
	return charaImage[getIndex()];
    }
}

