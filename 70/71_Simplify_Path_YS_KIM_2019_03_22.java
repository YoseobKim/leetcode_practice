class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/"))
        {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop(); // if .. then pop from the stack
            else if (!skip.contains(dir)) stack.push(dir); // ignore ., "" and push dir
        }
        // build real path
        String res = "";
        for (String dir : stack) 
            res = res + "/" + dir;
        
        return res.isEmpty() ? "/" : res;
    }
}
