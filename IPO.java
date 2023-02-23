Question Link: https://leetcode.com/problems/ipo/


class Project {
    int profit;
    int capital;
    
    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class CapitalComparator implements Comparator<Project> {
    public int compare(Project p1, Project p2) {
        return p1.capital - p2.capital;
    }
}

class ProfitComparator implements Comparator<Project> {
    public int compare(Project p1, Project p2) {
        return p2.profit - p1.profit;
    }
}


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, new CapitalComparator());
        
        PriorityQueue<Project> pq = new PriorityQueue<>(new ProfitComparator());
        int i = 0;
        while (k > 0) {
            while (i < n && projects[i].capital <= w) {
                pq.offer(projects[i]);
                i++;
            }
            if (pq.isEmpty()) {
                break;
            }
            Project project = pq.poll();
            w += project.profit;
            k--;
        }
        return w;
    }
}


