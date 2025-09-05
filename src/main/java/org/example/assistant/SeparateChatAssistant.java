package org.example.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools" //配置tools
)
public interface SeparateChatAssistant {
    /**
     * 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息
     * @return
     */
    @SystemMessage("今天是{{current_date}}")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat2(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}") //{{it}}表示这里唯一的参数的占位符
    String chat3(String userMessage);

    @SystemMessage(fromResource = "my-prompt-template2.txt") //{{it}}表示这里唯一的参数的占位符
    String chat4(@MemoryId int memoryId,
                 @UserMessage String userMessage,
                 @V("username") String username,
                 @V("age") int age
    );
}

