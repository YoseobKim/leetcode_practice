class Solution {
    private final int GO_UP = 0;
    private final int GO_LEFT = 1;
    private final int GO_DOWN = 2;
    private final int GO_RIGHT = 3;
    
    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3) return false;
        int xPos = 0;
        int yPos = 0;
        Set<String> memo = new HashSet<>();
        memo.add(xPos + ":" + yPos);
        for(int i = 0; i < x.length; i++) {
            int direction = i % 4;
            int item = x[i];
//            System.out.println(direction + " : " + item);
            if(direction == GO_UP) {
                for(int y = yPos + 1; y <= yPos + item; y++) {
                    String xy = xPos + ":" + y;
                    if(!memo.add(xy)) return true;
                }
                yPos += item;
            } else if(direction == GO_LEFT) {
                for(int x_ = xPos - 1; x_ >= xPos - item; x_--) {
                    String xy = x_ + ":" + yPos;
                    if(!memo.add(xy)) return true;
                }
                xPos -= item;
            } else if(direction == GO_DOWN) {
                for(int y = yPos - 1; y >= yPos - item; y--) {
                    String xy = xPos + ":" + y;
                    if(!memo.add(xy)) return true;
                }
                yPos -= item;
            } else if(direction == GO_RIGHT) {
                for(int x_ = xPos + 1; x_ <= xPos + item; x_++) {
                    String xy = x_ + ":" + yPos;
                    if(!memo.add(xy)) return true;
                }
                xPos += item;
            }
        }
        
        return false;
    }
}
