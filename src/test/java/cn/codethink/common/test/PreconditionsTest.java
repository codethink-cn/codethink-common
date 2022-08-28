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
        Assertions.assertThrows(NullPointerException.class, () -> Preconditions.objectNonNull(null, "object"));
    
        // named message
        try {
            Preconditions.objectNonNull(null, "object");
        } catch (Exception e) {
            Assertions.assertEquals("object is null", e.getMessage());
        }
    }
}
