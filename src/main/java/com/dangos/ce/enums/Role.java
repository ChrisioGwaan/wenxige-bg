package com.dangos.ce.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum Role implements IEnum<String> {

    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
