package algorithm.queue;

import java.util.ArrayList;
import java.util.*;

import datastructure.queue.LinkedListQueue;

public class MazeBFS {
    static class Node {
        int x, y, prevIndex;

        public Node(int x, int y, int prevIndex) {
            this.x = x;
            this.y = y;
            this.prevIndex = prevIndex;
        }
    }

    static int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    static void printPath(List<Node> path) {
        List<Node> realPath = new ArrayList<>();
        Node curNode = path.get(path.size() - 1);

        while (curNode.prevIndex != -1) {
            realPath.add(curNode);
            curNode = path.get(curNode.prevIndex);
        }
        realPath.add(curNode);
        Collections.reverse(realPath);

        int i = 1;
        System.out.println("BFS searching path: ");
        for (Node node : realPath) {
            System.out.println(i + "th step: " + "(" + node.x + ", " + node.y + ")");
            i++;
        }
    }

    static boolean solveMaze(int startX, int startY, int endX, int endY) {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.offer(new Node(startX, startY, -1));
        List<Node> path = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            path.add(curNode);

            if (curNode.x == endX && curNode.y == endY) {
                printPath(path);
                return true;
            }

            for (int[] dir : dirs) {
                int nextX = curNode.x + dir[0];
                int nextY = curNode.y + dir[1];

                if (maze[nextX][nextY] == 0) {
                    queue.offer(new Node(nextX, nextY, path.size() - 1));
                    maze[nextX][nextY] = 2;
                }
            }
        }
        System.out.println("No path found.");
        return false;
    }

    public static void main(String[] args) {
        solveMaze(1, 1, 8, 8);
    }
}
