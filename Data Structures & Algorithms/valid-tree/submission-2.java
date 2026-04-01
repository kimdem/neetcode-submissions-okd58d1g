class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return true;
        List<Integer>[] node = new ArrayList[n];
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++) {
            node[i] = new ArrayList<>();
        }

        for(int[] arr : edges) {
            node[arr[0]].add(arr[1]);
            node[arr[1]].add(arr[0]);
        }

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{edges[0][0],-1});
        visit[edges[0][0]] = true;
        while(!qu.isEmpty()) {
            int[] arr= qu.poll();
            List<Integer> li = node[arr[0]];
            for(int l : li) {
                if(arr[1]==l) continue;
                if(!visit[l]) {
                    visit[l] = true;
                    qu.offer(new int[]{l, arr[0]});
                } else {
                    return false;
                }
            }
        }
        for(boolean b : visit) {
            if(!b) return false;
        }
        return true;
    }
}

