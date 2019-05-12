class Solution {
    public int calculate(String s) {
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
                                  
        /*
        System.out.println("inside Queue");
        for(int item : calcQueue) {
            System.out.print(item + ",");
        }
        System.out.println("");
        */
        int ret = 0;
        for(int item : calcQueue) {
            ret += item;
        }
        
        return ret;      
    }
}
