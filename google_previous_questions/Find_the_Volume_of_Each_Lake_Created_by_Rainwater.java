import java.util.*;

public class HelloWorld{
    private static int trapped(int[] height)
    {
	    if(height == null || height.length <= 0)
		    return 0;
		    
        int ret = 0;
        int size = height.length;
        
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        
        for (int i = 1; i < size - 1; i++) {
            ret += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        
        return ret;
    } 
    public static void main(String []args){
        int[] volume = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
        
        System.out.println(trapped(volume));
        
        int[] volume2 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapped(volume2));
    }
}
