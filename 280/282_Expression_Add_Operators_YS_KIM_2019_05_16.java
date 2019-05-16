class Solution {    
    private Set<List<String>> createNumSet(String num) {
        Set<List<String>> ret = new HashSet<>();
        if(num.length() <= 0) return ret;
        if(num.length() <= 1) {
            List<String> arr = new ArrayList<>();
            arr.add(num);
            ret.add(arr);
            return ret;
        }
        // ex num = "123", substr = "12", target = '3'
        String substr = num.substring(0, num.length() - 1);
        char target = num.charAt(num.length() - 1);
        Set<List<String>> prev = createNumSet(substr);
        // this will be [1, 2], [12]
        for(List<String> li : prev) {
            List<String> arr1 = new ArrayList<>(li);
            arr1.add("" + target);
            // arr1 will be [1, 2, 3], [12, 3]
            ret.add(arr1);
            
            List<String> arr2 = new ArrayList<>(li);
            String t = arr2.get(arr2.size() - 1);
            // arr2 will be [1, 23], [123]
            t += target;
            arr2.set(arr2.size() - 1, t);
            ret.add(arr2);
        }
        
        return ret;
    }
    
    // reuse 227. Basic Calculator II
    private int calculate(String s) {
        List<Integer> calcQueue = new LinkedList<>();
        // the reason why using queue is want to calc it in in-order.
        
        int fromNum = 0;
        char prev = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                String numCandidate = s.substring(fromNum, i).trim();
                if(numCandidate.length() > 0) {
                    if(prev == '*') {
                        int num1 = calcQueue.get(calcQueue.size() - 1);
                        calcQueue.set(calcQueue.size() - 1, num1 * Integer.parseInt(numCandidate));
                    } else if(prev == '/') {
                        int num1 = calcQueue.get(calcQueue.size() - 1);
                        calcQueue.set(calcQueue.size() - 1, num1 / Integer.parseInt(numCandidate));
                    } else if(prev == '-') {
                        calcQueue.add(Integer.parseInt(numCandidate.trim()) * -1);
                    } else if(prev == '+') {
                        calcQueue.add(Integer.parseInt(numCandidate.trim()));
                    }
                }
                prev = c;
                fromNum = i + 1;
            }
        }
        
        if(fromNum < s.length()) {
            String numCandidate = s.substring(fromNum, s.length()).trim();
            if(numCandidate.length() > 0) {
                if(prev == '*') {
                    int num1 = calcQueue.get(calcQueue.size() - 1);
                    calcQueue.set(calcQueue.size() - 1, num1 * Integer.parseInt(numCandidate));   
                } else if(prev == '/') {
                    int num1 = calcQueue.get(calcQueue.size() - 1);
                    calcQueue.set(calcQueue.size() - 1, num1 / Integer.parseInt(numCandidate));
                } else if(prev == '-') {
                    calcQueue.add(Integer.parseInt(numCandidate.trim()) * -1);
                } else if(prev == '+') {
                    calcQueue.add(Integer.parseInt(numCandidate.trim()));
                }
            }
        }
                                  
        int ret = 0;
        for(int item : calcQueue) {
            ret += item;
        }
        
        return ret;      
    }
    
    private boolean isValidNum(String num) {
        if(num.length() > 1 && num.charAt(0) == '0') return false;
        return true;
    }
    
    private List<String> calculateList(List<String> list, int index, int target, String prev) {
        List<String> ret = new ArrayList<>();
        // after iterate all
        if(index >= list.size()) {
//            System.out.println(prev);
            int num = calculate(prev);
            if(num == target) {
                ret.add(prev);
                return ret;
            } else {
                return ret;
            }
        }
        
        String num = list.get(index);
        if(!isValidNum(num)) return ret;
        List<String> plusCalc = calculateList(list, index + 1, target, prev + "+" + num);
        List<String> minusCalc = calculateList(list, index + 1, target, prev + "-" + num);
        List<String> multipyCalc = calculateList(list, index + 1, target, prev + "*" + num);
        ret.addAll(plusCalc);
        ret.addAll(minusCalc);
        ret.addAll(multipyCalc);
        
        return ret;
    }
    
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num.length() <= 0) return ret;
        if(isValidNum(num) && Long.parseLong(num) == target) {
            ret.add(num);
            return ret;
        }
        // create num set.
        // ex) when num == "123",
        // [1,2,3], [12, 3], [1,23], [123]
        Set<List<String>> numSet = createNumSet(num);
        
        // based on the set, make formular
        for(List<String> li : numSet) {
//            for(String s : li) System.out.print(s + ", ");
//            System.out.println("");
            if(li.size() > 1 && isValidNum(li.get(0))) {
                // insert li.get(0) as starting string and index is now from 1.
                List<String> res = calculateList(li, 1, target, li.get(0));
                ret.addAll(res);
            } else {
                String item = li.get(0);
                if(isValidNum(item) && Long.parseLong(item) == target) {
                    ret.add(item);
                }            
            }
        }
        
        return ret;
    }
}
