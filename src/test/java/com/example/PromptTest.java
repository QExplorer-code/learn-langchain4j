package com.example;

import org.example.ChatApp;
import org.example.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ChatApp.class)
public class PromptTest {

    // 系统提示词
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testSystemMessage() {
        String answer1 = separateChatAssistant.chat(3,"你好，我是李大白");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(3,"今天几号");
        System.out.println(answer2);
    }

    @Test
    public void testSystemMessage2() {
        String answer1 = separateChatAssistant.chat2(4,"你好，我是李小白");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(4,"今天几号");
        System.out.println(answer2);
    }

    @Test
    public void testUserMessage() {
        String answer = separateChatAssistant.chat3("我是赵德柱");
        System.out.println(answer);
    }

    @Test
    public void testSystemMessage3() {
        String answer = separateChatAssistant.chat4(5, "我是谁，我多大了", "翠花", 18);
        System.out.println(answer);
    }
}
