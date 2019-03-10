class Solution {
public:
    int myAtoi(string str) {
        long output = 0;
        
        bool negative = false;
        
        str = ltrim(str);
        
        if (str[0] == '-' || str[0] == '+') {         
            if (str[0] == '-')
                negative = true;
            
            str = str.substr(1);
        }        
        
        if (str[0] < '0' || str[0] > '9')
            return 0;       
        
        int i = 0;
        while (str[i] >= '0' && str[i] <= '9') {
            ++i;
        }                            
        
        output = pureAtoi(str.substr(0, i), negative);        
        
        return output;
    }
    
    int pureAtoi(string str, bool is_negative) {
        int result = 0;
        int prev_result = 0;                
        
        for (int i = str.size() - 1, j = 0 ; i >= 0 ; --i, ++j) {
            prev_result = result;            
            
            result += (str[i] - '0') * pow(10, j);                                                  
            
            if (prev_result > result) {                
                if (is_negative)
                    return -2147483648;
                else
                    return 2147483647;
            }
                
        }       
        
        return is_negative ? result * (-1) : result;
    }
    
    string ltrim(string str) {
        for (int i = 0 ; i < str.size() ; ++i) {
            if (str[i] != ' ')
                return str.substr(i);
        }
        
        return string();
    }
};
