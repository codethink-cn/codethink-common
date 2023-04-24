package cn.codethink.common.util.test;

import cn.codethink.common.util.Throwables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ThrowablesTest {
    
    @Test
    public void throwIOException() {
        Assertions.assertThrows(IOException.class, () -> Throwables.rethrow(new IOException()));
    }
}
