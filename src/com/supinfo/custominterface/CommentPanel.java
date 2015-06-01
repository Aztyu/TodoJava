/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.custominterface;

import com.supinfo.entities.Comment;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aztyu
 */
public class CommentPanel extends JPanel{
    private final Comment comment;
    
    public CommentPanel(Comment c){
        super();
        this.comment = c;
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(540, 80));
        this.setMaximumSize(new Dimension(540, 2000));
        
        Timestamp date = comment.getComment_date();
        String date_s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
        
        JLabel title = new JLabel("- " + comment.getEmployee_name() + " | " + date_s);
        Dimension t_title = title.getPreferredSize();
        t_title.width = 500;
        title.setPreferredSize(t_title);
        this.add(title);
        
        JLabel text = new JLabel(this.comment.getText());
        Dimension t_text = text.getPreferredSize();
        t_text.width = 480;
        text.setPreferredSize(t_text);
        this.add(text);
        
        this.setPreferredSize(new Dimension(500, 10+title.getPreferredSize().height + text.getPreferredSize().height));
    }
    
    
    
}
