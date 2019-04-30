class Solution {
    public int compareVersion(String version1, String version2) {
        // \\. is important since . is special character
        String[] version1Splitted = version1.split("\\.");
        String[] version2Splitted = version2.split("\\.");
        
        int length = Math.min(version1Splitted.length, version2Splitted.length);
        for(int i = 0; i < length; i++) {
            int ver1 = Integer.parseInt(version1Splitted[i]);
            int ver2 = Integer.parseInt(version2Splitted[i]);
            if(ver1 > ver2) return 1;
            else if(ver1 < ver2) return -1;
        }
        int version1Last = Integer.parseInt(version1Splitted[version1Splitted.length - 1]);
        int version2Last = Integer.parseInt(version2Splitted[version2Splitted.length - 1]);
        
        if(version1Splitted.length > length && version1Last != 0) return 1;
        if(version2Splitted.length > length && version2Last != 0) return -1;
        return 0;
    }
}
