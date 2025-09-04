package com.example;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import org.example.XiaozhiApp;
import org.example.assistant.Assistant;
import org.example.assistant.MemoryChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = XiaozhiApp.class)
public class ChatMemoryTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory() {
        //创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        //创建AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();
        //调用service的接口
        String answer1 = assistant.chat("我是李白");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory2() {
        String answer1 = memoryChatAssistant.chat("我是李大白");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer2);
    }
}
