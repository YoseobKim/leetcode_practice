class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> varMap = new HashMap<>();
        for(int i = 0; i < values.length; i++) {
            double value = values[i];
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            double aVal = 0.0;
            double bVal = 0.0;
            // 4 cases
            if(!varMap.containsKey(a) && !varMap.containsKey(b)) {
                // 1. a == null && b == null
                aVal = 1.0;
                bVal = aVal / value;
            } else if(varMap.containsKey(a) && !varMap.containsKey(b)) {
                // 2. a != null && b == null
                aVal = varMap.get(a);
                bVal = aVal / value;
            } else if(!varMap.containsKey(a) && varMap.containsKey(b)) {
                // 3. a == null && b != null
                bVal = varMap.get(b);
                aVal = bVal * value;
            } else {
                // 4. a != null && b != null
                continue;
            }
            
            varMap.put(a, aVal);
            varMap.put(b, bVal);
        }
        
        double[] ret = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            
            double calc = -1.0;
            
            if(varMap.containsKey(a) && varMap.containsKey(b)) {
                double aVal = varMap.get(a);
                double bVal = varMap.get(b);
                calc = aVal / bVal;
            }
            
            ret[i] = calc;
        }
        
        return ret;
    }
}
