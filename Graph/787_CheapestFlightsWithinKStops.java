class Solution {

    class Pair {
        int stops;
        int node;
        int cost;

        Pair(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n,
                                 int[][] flights,
                                 int src,
                                 int dst,
                                 int k) {

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(
                new int[]{flight[1], flight[2]}
            );
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;

            if (stops > k) {
                continue;
            }

            for (int[] nbr : graph[node]) {

                int adjNode = nbr[0];
                int edgeWt = nbr[1];

                if (cost + edgeWt < dist[adjNode]
                    && stops <= k) {

                    dist[adjNode] = cost + edgeWt;

                    q.offer(new Pair(
                        stops + 1,
                        adjNode,
                        dist[adjNode]
                    ));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}