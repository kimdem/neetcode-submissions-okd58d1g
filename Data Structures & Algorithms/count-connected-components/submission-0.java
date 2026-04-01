class Solution {
    List<Integer>[] node;
    boolean[] visit;
    public int countComponents(int n, int[][] edges) {
        node = new ArrayList[n];
        for(int i=0; i<n; i++) node[i]=new ArrayList<>();

        for(int i=0; i<edges.length; i++) {
            node[edges[i][0]].add(edges[i][1]);
            node[edges[i][1]].add(edges[i][0]);
        }

        visit = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                ans++;
                bfs(i);
            }   
        }
        return ans;
    }

    private void bfs(int i) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(i);
        visit[i]=true;
        while(!qu.isEmpty()) {
            List<Integer> li = node[qu.poll()];
            for(int n : li) {
                if(!visit[n]) {
                    visit[n]=true;
                    qu.offer(n);
                }
            }
        }
    }
}
