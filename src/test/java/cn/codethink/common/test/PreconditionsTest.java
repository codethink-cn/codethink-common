package cn.codethink.common.test;

import cn.codethink.common.util.Preconditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreconditionsTest {
    
    @Test
    void testNonNull() {
        // non null
        Assertions.assertThrows(NullPointerException.class, () -> Preconditions.nonNull(null));
        Assertions.assertDoesNotThrow(() -> Preconditions.nonNull(this));
        
        // name non null
        Assertions.assertThrows(NullPointerException.class, () -> Preconditions.namedNonNull(null, "object"));
    
        // named message
        try {
            Preconditions.namedNonNull(null, "object");
        } catch (Exception e) {
            Assertions.assertEquals("object is null", e.getMessage());
        }
    }
    
    @Test
    void testArgument() {
        // argument
        Assertions.assertThrows(IllegalArgumentException.class, () -> Preconditions.argument(false));
        Assertions.assertDoesNotThrow(() -> Preconditions.argument(true));
        
        // named argument
        Assertions.assertThrows(IllegalArgumentException.class, () -> Preconditions.namedArgument(false, "argument"));
    
        // named message
        try {
            Preconditions.namedArgument(false, "object");
        } catch (Exception e) {
            Assertions.assertEquals("object is illegal", e.getMessage());
        }
    }
}
