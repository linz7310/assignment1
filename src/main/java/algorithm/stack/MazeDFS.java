package algorithm.stack;

import datastructure.stack.Mystack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MazeDFS {

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

    static int[][] dirs = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    static void printPath(Mystack<int[]> stack) {
        System.out.println("The BFS path is: ");
        ArrayList<int[]> res = new ArrayList<>();
        while(!stack.isEmpty()){
            int[] p = stack.pop();
            res.add(p);
        }
        Collections.reverse(res);
        int i = 1;
        for (int[] re : res) {
            System.out.println(i + "th step is: " + Arrays.toString(re));
            i++;
        }
    }

    static boolean mazePath(int x1, int y1, int x2, int y2) {
        Mystack<int[]> stack = new Mystack<>();
        stack.push(new int[]{x1, y1});
        while (!stack.isEmpty()) {
            int[] curNode = stack.peek();
            if (curNode[0] == x2 && curNode[1] == y2) {
                printPath(stack);
                return true;
            }
            boolean flag = false;
            for (int[] dir : dirs) {
                int nextX = curNode[0] + dir[0];
                int nextY = curNode[1] + dir[1];
                // 如果下一个点是可走的
                if (maze[nextX][nextY] == 0) {
                    stack.push(new int[]{nextX, nextY});
                    maze[nextX][nextY] = 2;
                    flag = true;
                    break;
                }
            }
            if (!flag) {  // if there is no way to go, pop it
                maze[curNode[0]][curNode[1]] = 2;
                stack.pop();
            }
        }
        System.out.println("there is no path");
        return false;
    }

    public static void main(String[] args) {
        int x1 = 1, y1 = 1, x2 = 8, y2 = 8;
        mazePath(x1, y1, x2, y2);
    }
}

