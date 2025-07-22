package com.eci.ARSW.DinamicBoard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodeGeneratorTest {

    @Test
    public void testGenerateCodeLength() {
        String code = CodeGenerator.generateCode(6);
        assertNotNull(code);
        assertEquals(6, code.length());
    }

    @Test
    public void testGenerateCodeIsAlphanumeric() {
        String code = CodeGenerator.generateCode(10);
        assertTrue(code.matches("[A-Z0-9]+"));
    }
}
