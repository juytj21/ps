import java.util.*;

class Job {
    int request;
    int lead;
        
    Job(int request, int lead) {
        this.request = request;
        this.lead = lead;
    }
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.lead == o2.lead) {
            return o1.request - o2.request;
        } else {
            return o1.lead - o2.lead;
        }
    }
}

class Solution {    
    PriorityQueue <Job> q = new PriorityQueue<>(1, new JobComparator());
        
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        int time = -1;
        boolean working = false;
        Job work = null;
        
        while(i < jobs.length || working || !q.isEmpty()) {
            time++;            
            
            while (i < jobs.length && time == jobs[i][0]) {
                q.offer(new Job(jobs[i][0], jobs[i][1]));
                i++;
            }
            
            if (!working && !q.isEmpty()) {
                work = q.poll();
                working = true;
            } 
            
            if (working) {
                work.lead--;
                if (work.lead == 0) {
                    answer += (time + 1) - work.request;
                    working = false;
                }
            }
        }
        
        return answer /= jobs.length;
    }
}