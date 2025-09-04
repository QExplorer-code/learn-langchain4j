package com.example;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.example.XiaozhiApp;
import org.example.assistant.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = XiaozhiApp.class)
public class AIServiceTest {
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {
        //创建AIService
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        //调用service的接口
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }


    @Autowired
    private Assistant assistant;
    @Test
    public void testAssistant() {
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }
}
