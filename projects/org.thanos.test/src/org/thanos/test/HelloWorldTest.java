package org.thanos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void test() {
        try (Context context = Context.newBuilder().build()) {

            Value value = context.eval("thanos", "foo");

            assertTrue(value.fitsInInt());
            assertEquals(1, value.asInt());
        }
    }
}
