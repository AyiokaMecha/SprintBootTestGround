package com.danmecha.dependencyInjection.data;

public record OrderRecord(
        String name,
        String productName,
        int quantity
) {
}
