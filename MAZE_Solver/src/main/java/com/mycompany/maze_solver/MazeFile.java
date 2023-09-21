/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.black;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author TA20384333
 */
public class MazeFile extends JFrame {
    
   int[][] maze = {
       {1,1,1,1,1,1,1,1,1,1,1,1,1},
       {1,0,1,0,1,0,1,0,0,0,0,0,1},
       {1,0,1,0,0,0,1,0,1,1,1,0,1},
       {1,0,1,1,1,1,1,0,0,0,0,0,1},
       {1,0,0,1,0,0,0,0,1,1,1,0,1},
       {1,0,1,0,1,1,1,0,1,0,0,0,1},
       {1,0,1,0,1,0,0,0,1,1,1,0,1},
       {1,0,1,0,1,1,1,0,1,0,0,0,1},
       {1,0,0,0,0,0,0,0,0,0,1,9,1},
       {1,1,1,1,1,1,1,1,1,1,1,1,1}
   };
            
    public List<Integer> path = new ArrayList<>();
    
    public MazeFile(){
        
        setSize(975, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boolean search = DepthFirstClass.search(maze, 1, 1, path);
        System.out.println(path);
    }
    
      
    @Override
    public void paint(Graphics g){
        
        
        Color brown = new Color(157, 79, 66);
            for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[0].length;j++){
            Color color;
            switch(maze[i][j]){
                case 1:color = Color.GRAY;break;
                case 9:color = brown;break;
                default:color = Color.WHITE;break;
                
            }
            
            g.setColor(color);
            g.fillRect(75*j, 75*i,75, 75);
            g.setColor(black);
            g.drawRect(75*j, 75*i, 75, 75);
            
            }
        }
            
                for(int i=0;i<path.size();i+=2){
        int px = path.get(i);
        int py = path.get(i+1);
        System.out.println("X coordinate " +px);
        System.out.println("Y coordinate "+py);
        Color green = new Color(125, 164, 120);
        g.setColor(green);
            g.fillRect(75*px, 75*py,75, 75);
            g.setColor(black);
            g.drawRect(75*px, 75*py, 75, 75);
            
        
}
    }
    

    
    public static void main(String[] args){
        MazeFile view = new MazeFile();
        view.setVisible(true);
    }
    
 }
