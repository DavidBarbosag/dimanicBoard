package com.eci.ARSW.DinamicBoard;

import com.eci.ARSW.DinamicBoard.model.ChatMessage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatMessageTest {

    @Test
    public void testDefaultConstructorAndSetters() {
        ChatMessage message = new ChatMessage();
        message.setUser("Alice");
        message.setContent("Hello World");

        assertEquals("Alice", message.getUser());
        assertEquals("Hello World", message.getContent());
    }

    @Test
    public void testParameterizedConstructor() {
        ChatMessage message = new ChatMessage("Bob", "Hi there");

        assertEquals("Bob", message.getUser());
        assertEquals("Hi there", message.getContent());
    }

    @Test
    public void testUpdateFields() {
        ChatMessage message = new ChatMessage("User1", "Text1");
        message.setUser("User2");
        message.setContent("Text2");

        assertEquals("User2", message.getUser());
        assertEquals("Text2", message.getContent());
    }
}
