class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        vector<vector<char>> array;
        
        int i = 0;
        int x= 0, y = 0;
        bool direction_down = 1;
        
        addString(array, numRows);
        
        while (i < s.size()) {            
            if (direction_down) {                                
                array[x][y++] = s[i];                
            } else {                
                addString(array, numRows);
                array[++x][--y] = s[i];                
            }
            
            if (y == 0 || y == numRows) {                
                direction_down = !direction_down;
                
                if (y == numRows)
                    y--;
                else
                    y++;
            }          
            
            ++i;
        }
        
        string result;        
        for (int i = 0 ; i < numRows ; ++i) {
            for (int j = 0 ; j < array.size() ; ++j) {
                if (array[j][i] != NULL)
                    result.push_back(array[j][i]);                
            }            
        }
        
        return result;
    }
    
    void addString (vector<vector<char>>& array, int numRows) {
        vector<char> string;
        string.resize(numRows);
        array.push_back(string);
    }
};
