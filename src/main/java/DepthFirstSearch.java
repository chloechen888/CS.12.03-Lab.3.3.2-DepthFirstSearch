import java.util.Stack;

public class DepthFirstSearch {

    // Main method. Used for visualising and debugging purposes.
    public static void main(String[] args) {

        int[][] graph1 = {
                {6, 9},
                {11},
                {6, 7},
                {9},
                {5, 8},
                {4, 7},
                {0, 2, 11},
                {2, 5},
                {4, 10},
                {0, 3},
                {8},
                {1, 6}
        };

        int[][] graph2 = {
                {3, 6, 5, 9},
                {11},
                {7, 10},
                {0},
                {5},
                {0, 4, 7},
                {0, 11},
                {2, 5, 8},
                {7},
                {0},
                {2},
                {1, 6}
        };

        int[] path_graph_1 = depthFirstSearch(graph1);
        int[] path_graph_2 = depthFirstSearch(graph2);

        printPath(path_graph_1);
        printPath(path_graph_2);

    }

    public static int[] depthFirstSearch(int[][] graph) {
        int numNodes = graph.length;
        boolean[] visited = new boolean[numNodes];
        int[] path = new int[numNodes];
        int pathIndex = 0;

        Stack<Integer> stack = new Stack<>();
        int startingNode = 0; // Start the traversal at node 0
        stack.push(startingNode);
        visited[startingNode] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            path[pathIndex++] = currentNode;

            int[] neighbors = graph[currentNode];
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        // Trim the path array to remove unused elements
        int[] trimmedPath = new int[pathIndex];
        System.arraycopy(path, 0, trimmedPath, 0, pathIndex);

        return trimmedPath;
    }

    // A private helper method that prints the path. Used for visualization and debugging purposes.
    private static void printPath(int[] path) {
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
