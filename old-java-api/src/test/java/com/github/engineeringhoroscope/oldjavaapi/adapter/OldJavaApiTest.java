package com.github.engineeringhoroscope.oldjavaapi.adapter;

import com.github.engineeringhoroscope.bl.ports.OldApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OldJavaApiTest {
    @Test
    public void testOldApi() {
        OldApi oldApi = new OldJavaApi();
        assertTrue(oldApi.isTrue("true"));
        assertFalse(oldApi.isTrue("false"));
        assertFalse(oldApi.isTrue("something else"));
        assertFalse(oldApi.isTrue(1));
        assertFalse(oldApi.isTrue(0));
    }
}
