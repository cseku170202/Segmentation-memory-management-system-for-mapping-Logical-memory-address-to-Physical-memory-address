/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmentation_os;

import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author N.S
 */
public class Segmentation_OS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner rum = new Scanner(System.in);
        System.out.println("Enter the total number of segment : ");
        int n,i;
        n = rum.nextInt();
        int segment_no[] = new int[n];
        for(i=0;i<n;i++)
        {
            segment_no[i]=i;
        }
        int segment_size[] = new int[n];
       
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the size or limit of segment "+i+":");
            segment_size[i] = rum.nextInt();
        }
        
        JFrame frame = new JFrame("Segmentation");
        JLabel label = null;
        
        int p=100,q=50;
        int l=0;
        for(i=0;i<n;i++)
        {
            JButton logical_rect = new JButton("Segment No "+l);
            logical_rect.setBounds(p, q, 150, segment_size[l]);
            logical_rect.setBackground(Color.CYAN);
            frame.add(logical_rect);
            q = q + segment_size[l] + 10;
            l++;
        }
        
       
        int base_address[] = new int[n];
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the Base Address of segment "+i+":");
            base_address[i]=rum.nextInt();
        }
        
        int a=400;
        int b=50;
        int c=550;
        int d=50;
        int e=710;
        int f=50;
        for(i=0;i<n;i++)
        {
            JButton table_segment_no = new JButton("Segment No "+i);
            table_segment_no.setBounds(a, b, 150, 35);
            table_segment_no.setBackground(Color.PINK);
            frame.add(table_segment_no);
            b = b + 35;
            
            JButton table_base_address = new JButton("Base Address "+base_address[i]);
            table_base_address.setBounds(c, d, 160, 35);
            table_base_address.setBackground(Color.PINK);
            frame.add(table_base_address);
            d = d + 35;
            
            JButton table_limit = new JButton("Limit "+segment_size[i]);
            table_limit.setBounds(e, f, 100,35);
            table_limit.setBackground(Color.PINK);
            frame.add(table_limit);
            f = f + 35;
            
        }
        

       
        int sindex=0,j,t;
        for(i=0;i<n;i++)
        {
            sindex = i;
            for(j=sindex+1;j<n;j++)
            {
                if(base_address[j] < base_address[sindex])
                {
                    sindex = j;
                }
            }
            t = base_address[sindex];
            base_address[sindex]= base_address[i];
            base_address[i]=t;
            
            t = segment_size[sindex];
            segment_size[sindex]=segment_size[i];
            segment_size[i]=t;
            
            t = segment_no[sindex];
            segment_no[sindex]= segment_no[i];
            segment_no[i]=t;
        }

        int physical_memory_size;
        System.out.println("Enter the Physical Memory Size : ");
        physical_memory_size = rum.nextInt();
        
        int m = 1000;
        int g = 0;
        int empty_size = 0;
        int empty_size2 = 0;
        int last = 0;
        i=0;
        int h = 0;
        
        for(i=0;i<n;i++)
        {
            if(i==0 && base_address[i]>g && g<physical_memory_size)
            {
                int extra = base_address[i]-g;
                JButton button = new JButton();
                button.setBounds(m, g, 150,extra);
                button.setBackground(Color.BLUE);
                frame.add(button);
                g = g + extra;
                
                JLabel label1 = new JLabel(""+g);
                label1.setBounds(975, g, 25, 10);
                frame.add(label1);
                
                JButton button1 = new JButton("Segment No "+segment_no[i]);
                button1.setBounds(m, g, 150, segment_size[i]);
                frame.add(button1);
                g = g + segment_size[i];
                
                JLabel label2 = new JLabel(""+g);
                label2.setBounds(975, g, 25, 10);
                frame.add(label2);
            
            }  
            
            else if(i==0 && base_address[i]==g && g<physical_memory_size)
            {
                JLabel label3 = new JLabel(""+g);
                label3.setBounds(975, g, 25, 10);
                frame.add(label3);
                
                JButton button2 = new JButton("Segment No "+segment_no[i]);
                button2.setBounds(m, g, 150, segment_size[i]);
                frame.add(button2);
                g = g + segment_size[i];
                
                JLabel label4 = new JLabel(""+g);
                label4.setBounds(975, g, 25, 10);
                frame.add(label4);
            }
            
            else if(i>0 && base_address[i]>g && g<physical_memory_size)
            {
                int ex = base_address[i]-g;
                JButton button3 = new JButton();
                button3.setBounds(m, g, 150, ex);
                button3.setBackground(Color.BLUE);
                frame.add(button3);
                g = g + ex;
                
                JLabel label5 = new JLabel(""+g);
                label5.setBounds(975, g, 25, 10);
                frame.add(label5);
                
                JButton button4 = new JButton("segment No "+segment_no[i]);
                button4.setBounds(m, g, 150, segment_size[i]);
                frame.add(button4);
                g = g + segment_size[i];
                
                JLabel label6 = new JLabel(""+g);
                label6.setBounds(975, g, 25, 10);
                frame.add(label6);
            }
            
            else if(i>0 && base_address[i]==g && g<physical_memory_size)
            {
                JLabel label7 = new JLabel(""+g);
                label7.setBounds(975, g, 25, 10);
                frame.add(label7);
                
                JButton button5 = new JButton("Segment No "+segment_no[i]);
                button5.setBounds(m, g, 150, segment_size[i]);
                frame.add(button5);
                g = g + segment_size[i];
                
                JLabel label8 = new JLabel(""+g);
                label8.setBounds(975, g, 25, 10);
                frame.add(label8);
                
            }
            

                
        }
         
        if(g<=physical_memory_size)
        {
            int in = physical_memory_size - g;
            JButton button6 = new JButton();
            button6.setBounds(m, g, 150, in);
            button6.setBackground(Color.BLUE);
            frame.add(button6);
        }
      
        JLabel print1 = new JLabel("LOGICAL MEMORY SPACE");
        print1.setBounds(100, 20, 150, 30);
        frame.add(print1);
        
        JLabel print2 = new JLabel("SEGMENT  TABLE  INFORMATION");
        print2.setBounds(500, 20, 700, 30);
        frame.add(print2);
        
        JLabel print3 = new JLabel("PHYSICAL MEMORY SPACE");
        print3.setBounds(1000, physical_memory_size, 200, 50);
        frame.add(print3);
        
        System.out.println("Enter the Segment Number of a Logical Memory Address : ");
        int logical_memory_address = rum.nextInt();
        System.out.println("Enter the Offset : ");
        int offset = rum.nextInt();
        
        int result = 0;
        for(i=0;i<n;i++)
        {
            if(segment_no[i]==logical_memory_address)
            {
                if(offset<segment_size[i])
                {
                    result = base_address[i]+offset;
                }
            }
        }
        
        if(result!=0)
        {
            System.out.println("The Physical Memory : "+result);
        }
        else{
            System.out.println("Invalid Address");
        }
       
       
       
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
