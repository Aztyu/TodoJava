/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.utilities;

/**
 *
 * @author Aztyu
 */
public class ProjectUtils {
    public static String textToHtml(String text){
        int char_count;
        boolean is_html = false;
        text = "<html>" + text + "</html>";
        String[] text_line = text.split("\n");
        for(int j = 0; j<text_line.length; j++){
            char_count = 0;
            for(int i=0; i<text_line[j].length(); i++){
                if(text_line[j].charAt(i) == '<'){
                    is_html = true;
                }else if(text_line[j].charAt(i) == '>'){
                    is_html = false;
                }else if(!is_html){
                    char_count++;
                    if(char_count > 90){
                        StringBuilder sb = new StringBuilder();
                        sb.append(text_line[j].substring(0, i));
                        sb.append("<br>");
                        sb.append(text_line[j].substring(i+1));
                        text_line[j] = sb.toString();
                        char_count = 0;
                    }
                }
            }
        }
        StringBuilder sb_final = new StringBuilder();
        for(String s : text_line){
            sb_final.append(s);
            sb_final.append("<br>");
        }
        return sb_final.toString();
    }
}
