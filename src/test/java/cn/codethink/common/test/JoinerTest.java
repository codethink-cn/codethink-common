package cn.codethink.common.test;

import cn.codethink.common.util.Joiner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JoinerTest {
    
    @Test
    void testJoin() {
        final List<Integer> integers = Arrays.asList(1, 2, 3);
    
        final String join = Joiner.builder()
            .prefix("[")
            .suffix("]")
            .build()
            .withAll(integers)
            .join();
    
        Assertions.assertEquals("[1, 2, 3]", join);
    }
}
