class Cell {
  private int val = 0;
  private boolean isOpen = false;
  
  public Cell(int val) {
    this.val = val;
  }
  
  public int getVal() { return val; }
  public boolean isOpen() { return isOpen; }
  public void setVal(int val) { this.val = val; }
  public void setOpen(boolean isOpen) { this.isOpen = isOpen; }
}

class Game {
  private int gameSize = 0;
  private Matrix<Cell> matrix = null;
  
  public Game(int gameSize) {
    this.gameSize = gameSize;
	this.matrix = new Matrix<Cell>(gameSize, gameSize);
  }
  
  public boolean onClick(int x, int y) {
    // let's assume that matrix.at is well designed so if it over boundary, it returns null;
    Cell trgt = matrix.at(x, y);
	if(trgt == null) return false;
	if(trgt.val >= 0) return false;
	
	trgt.setOpen(true);
	// should make open true around me
	// and also traverse each other
	Cell up = matrix.at(x, y - 1);
	if(up != null) {
	  up.setOpen(true);
	  onClick(x, y - 1);
	}
	Cell left = matrix.at(x - 1, y);
	if(left != null) {
	  left.setOpen(true);
	  onClick(x - 1, y);
	}
	
	Cell right = matrix.at(x + 1, y);
	if(right != null) {
	  right.setOpen(true);
	  onClick(x + 1, y);
	}
	
	Cell down = matrix.at(x, y + 1);
	if(down != null) {
	  down.setOpen(true);
	  onClick(x, y + 1);
	}
	
	Cell upleft = matrix.at(x - 1, y - 1);
	if(upleft != null) {
	  upleft.setOpen(true);
	  onClick(x - 1, y - 1);
	}
	
	Cell upright = matrix.at(x + 1, y - 1);
	if(upright != null) {
	  upright.setOpen(true);
	  onClick(x + 1, y - 1);
	}
	
	Cell downleft = matrix(x - 1, y + 1);
	if(downleft != null) {
	  downleft.setOpen(true);
	  onClick(x - 1, y + 1);
	}
	
	Cell downright = matrix(x + 1, y + 1);
	if(downright != null) {
	  downright.setOpen(true);
	  onClick(x + 1, y + 1);
	}
	
	
	return true;
  }
}
