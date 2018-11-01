/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Earl_iu
 * BFS/DFS
 */
public class NumberOfIsland_200 {
    public static void main(String agrs[]){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int num = numIslands(grid);
        System.out.println(num);
    }
    
    public static int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public static void dfs(char[][] grid,int i,int j){
        grid[i][j] = '2';
        if(i>grid.length-1 && j>grid[0].length-1 ){
            return;
        }
        if(j<grid[0].length-1 && grid[i][j+1] == '1'){      // 向右
            dfs(grid,i,j+1);
        }
        if(i<grid.length-1 && grid[i+1][j] == '1'){     // 向下
            dfs(grid,i+1,j);
        }
        if(i>0 && grid[i-1][j] == '1'){
            dfs(grid,i-1,j);
        }
        if(j>0 && grid[i][j-1]=='1'){
            dfs(grid,i,j-1);
        }
    }
    
    public static void bfs(char[][] grid,int x,int y){
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        grid[x][y] = '2';
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x,y));
        while(q.size()>0){
            int size = q.size();
            Point p = q.poll();
            for(int i=0;i<size;i++){
                for(int[] dir:dirs){
                    int x1 = p.x+dir[0];
                    int y1 = p.y+dir[1];
                    if(x1>=0 && y1>=0 && x1< grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
                        grid[x1][y1] = '2';
                        q.offer(new Point(x1,y1));
                    }
                }
            }
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
