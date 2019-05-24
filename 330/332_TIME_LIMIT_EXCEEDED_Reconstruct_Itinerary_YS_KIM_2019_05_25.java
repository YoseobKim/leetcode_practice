class Solution {  
    private Set<List<String>> traverseAll(Map<String, List<String>> map, String from, List<String> prev) {
        Set<List<String>> ret = new HashSet<>();

        prev.add(from);
//        System.out.println("from : " + from);
        List<String> adjs = map.get(from);
        if(adjs == null || adjs.size() == 0) {
            // traverse end
            ret.add(prev);
            return ret;
        }
        int len = 0;
        List<String> copy = new ArrayList<>(adjs);
        for(String candidate : copy) {
            map.get(from).remove(candidate);
//            System.out.println("to : " + candidate);
            ret.addAll(traverseAll(map, candidate, new ArrayList<>(prev)));
            map.get(from).add(candidate);
        }
        
        return ret;
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ret = new ArrayList<>();
        if(tickets.size() <= 0) return ret;
        // key : from, to : toList
        Map<String, List<String>> ticketsMap = new HashMap<>();
        
        for(int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            List<String> toList = ticketsMap.getOrDefault(from, new LinkedList<>());
            toList.add(to);
            ticketsMap.put(from, toList);
        }

        Set<List<String>> res = traverseAll(ticketsMap, "JFK", new ArrayList<>());
        
        int maxLen = 0;
        for(List<String> li : res) {    
            maxLen = Math.max(li.size(), maxLen);
        }
        
        List<String> resHelper = new ArrayList<>();
        for(List<String> li : res) {
            if(li.size() == maxLen) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < li.size(); i++) {
                    String comma = i == li.size() - 1 ? "" : ",";
//                    System.out.print(li.get(i) + comma);
                    sb.append(li.get(i) + comma);
                }
//                System.out.println("");
                resHelper.add(sb.toString());
            }
        }
        
        // for lexical order
        Collections.sort(resHelper);
//        System.out.println(resHelper.get(0));
        
        return Arrays.asList(resHelper.get(0).split(","));
    }
}
