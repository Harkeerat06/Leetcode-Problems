class Solution {
    public int minimumPushes(String word) {
        int n= word.length();
        int fact= n/8;
        int rem= n%8;
        
        int push= 8 * fact * (fact+1) / 2 + rem * (fact+1);
        return push;
    }
}