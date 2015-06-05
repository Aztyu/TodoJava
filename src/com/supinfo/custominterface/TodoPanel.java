/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.custominterface;

import com.supinfo.database.DbManager;
import com.supinfo.database.RequestGenerator;
import com.supinfo.entities.Comment;
import com.supinfo.grapicalinterface.MainFrame;
import com.supinfo.grapicalinterface.ManagerFrame;
import com.supinfo.utilities.ProjectUtils;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;

import static javax.swing.text.DefaultCaret.ALWAYS_UPDATE;

/**
 *
 * @author Aztyu
 */
public class TodoPanel extends JPanel{
    private final int todo_id;
    private final int user_id;
    private final String todo_text;
    private final Timestamp todo_date;

    public TodoPanel(int todo_id, String todo_text, int user_id, Timestamp todo_date) {
        super();
        this.todo_id = todo_id;
        this.todo_text = todo_text;
        this.user_id = user_id;
        this.todo_date = todo_date;
        initComponents();
    }
    
    private void initComponents(){
        SpringLayout sl = new SpringLayout();
        
        JLabel title = new JLabel("Ticket number " + todo_id + " created on " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(todo_date));
        title.setPreferredSize(new Dimension(540, 40));
        title.setMaximumSize(new Dimension(540, 200));
        this.add(title);
        
        sl.putConstraint(SpringLayout.WEST, title, title.getPreferredSize().height+5, SpringLayout.WEST, this);
        
        JLabel text = new JLabel();
        text.setText(todo_text);
        Dimension t = text.getPreferredSize();
        text.setPreferredSize(t);
        this.add(text);
        
        sl.putConstraint(SpringLayout.NORTH, text, 40, SpringLayout.NORTH, title);
        
        this.setPreferredSize(new Dimension(540, 250+t.height));
        
        Component last_component = text;
        
        List<Comment> comments = DbManager.querySelectComment(RequestGenerator.getCommentsByTodoId(todo_id));
        if(!comments.isEmpty()){
            JLabel comment_title = new JLabel("<html><u>Comments</u></html>");
            comment_title.setPreferredSize(new Dimension(500, 40));
            this.add(comment_title);
            
            sl.putConstraint(SpringLayout.NORTH, comment_title, 10 + text.getPreferredSize().height, SpringLayout.NORTH, text);
            last_component = comment_title;
            
            for(Comment c : comments){
                CommentPanel cp = new CommentPanel(c);
                sl.putConstraint(SpringLayout.NORTH, cp, comment_title.getPreferredSize().height, SpringLayout.NORTH, last_component);
                last_component = cp;
                this.add(cp);
            }
        }
        
        JCheckBox check = new JCheckBox("Mark as done", false);
        Dimension d_check = check.getPreferredSize();
        d_check.width = 500;
        check.setPreferredSize(d_check);
        this.add(check);
        
        sl.putConstraint(SpringLayout.NORTH, check, 10+last_component.getPreferredSize().height, SpringLayout.NORTH, last_component);
        
        
        JTextArea comment = new JTextArea(16, 58);
        JScrollPane scroll = new JScrollPane(comment);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        comment.setPreferredSize(new Dimension(500, 80));
        comment.setMaximumSize(new Dimension(500, 800));
        comment.setLineWrap(true);
        comment.setWrapStyleWord(true);
        
        comment.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCaret();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCaret();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCaret();
            }
            
            public void updateCaret(){
                comment.setCaretPosition(comment.getDocument().getLength());
            }
        });
        
        DefaultCaret caret = (DefaultCaret) comment.getCaret();
        caret.setUpdatePolicy(ALWAYS_UPDATE);
        
        scroll.setPreferredSize(new Dimension(500, 100));
        this.add(scroll);
        
        sl.putConstraint(SpringLayout.NORTH, scroll, 10+check.getPreferredSize().height, SpringLayout.NORTH, check);
        
        JButton send = new JButton("Send");
        send.setPreferredSize(new Dimension(100, 30));
        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                
                if(source == send){
                    if(comment.getText().equals("")){
                        if(check.isSelected()){
                            JOptionPane.showMessageDialog(null, "It is not allowed to mark a task done with an empty message", "Warning", JOptionPane.WARNING_MESSAGE, null);
                        }else{
                            JOptionPane.showMessageDialog(null, "It is not allowed to post empty comments", "Warning", JOptionPane.WARNING_MESSAGE, null);
                        }
                    }else{
                        if(check.isSelected()){
                            DbManager.createPrepared(RequestGenerator.createComment(ProjectUtils.textToHtml(comment.getText()), user_id, todo_id));
                            removeAll();
                            initComponents();
                            revalidate();
                            DbManager.queryUID(RequestGenerator.updateTodo(todo_id, true));
                            JFrame mf = null;
                            Container c = SwingUtilities.getAncestorOfClass(JFrame.class, getThis());
                            if(c.getClass() == MainFrame.class){
                                mf = new MainFrame(user_id);
                            }else{
                                mf = new ManagerFrame(user_id);
                            }
                            c.setVisible(false);
                        }else{
                            DbManager.createPrepared(RequestGenerator.createComment(ProjectUtils.textToHtml(comment.getText()), user_id, todo_id));
                            removeAll();
                            initComponents();
                            revalidate();
                        } 
                    }
                }
            }
        });
        this.add(send);
        
        sl.putConstraint(SpringLayout.NORTH, send, 10+scroll.getPreferredSize().height, SpringLayout.NORTH, scroll);
        sl.putConstraint(SpringLayout.EAST, send, 0, SpringLayout.EAST, check);
        
        int total_height = 80;
        
        for(Component c : this.getComponents()){
            total_height += c.getPreferredSize().height;
        }
        
        this.setPreferredSize(new Dimension(540, total_height));
        this.setMaximumSize(new Dimension(540, 2000));
        
        this.setLayout(sl);
    }
    
    public TodoPanel getThis(){
        return this;
    }
}
