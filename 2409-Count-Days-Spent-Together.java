class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob)
    {
        int aliceArrive= Integer.parseInt(arriveAlice.substring(0,2)+ arriveAlice.substring(3,5));
        int aliceLeave= Integer.parseInt(leaveAlice.substring(0,2)+ leaveAlice.substring(3,5));

        int bobArrive= Integer.parseInt(arriveBob.substring(0,2)+ arriveBob.substring(3,5));
        int bobLeave= Integer.parseInt(leaveBob.substring(0,2)+ leaveBob.substring(3,5));

        if(aliceLeave < bobArrive || bobLeave < aliceArrive)
            return 0;
        
        int startDate= Math.max(aliceArrive, bobArrive);
        int endDate= Math.min(aliceLeave, bobLeave);

        // if months are same
        if(startDate/100 == endDate/100)
            return endDate%100 - startDate%100 + 1;
        
        int monthDays[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int count= monthDays[startDate/100 - 1] - startDate%100  + 1;
        count+= endDate%100;

        for(int i= startDate/100; i< endDate/100 - 1; i++)
            count+= monthDays[i];
        
        return count;
    }
}