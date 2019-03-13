class Solution {
public:
    int maxArea(vector<int>& height) {
        int largest = 0;
        
        for (int i = 0 ; i < height.size() - 1 ; ++i) {
            for (int j = i + 1 ; j < height.size() ; ++j) {
                int result = calcAmount(height, i, j);
                
                if (result > largest)
                    largest = result;
            }
        }
        
        return largest;
    }
    
    int calcAmount(vector<int>& height, int i, int j) {
        int max_height, width;
        
        max_height = min(height[i], height[j]);
        width = j - i;
        
        return max_height * width; 
    }
};
