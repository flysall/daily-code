package com.flysall.springtutorial.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.soap.Text;

public class TextEditorApp {
    public static void main(String[] args) {
        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();
        */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TextEditor te = ctx.getBean(TextEditor.class);
        te.spellCheck();
    }
}
