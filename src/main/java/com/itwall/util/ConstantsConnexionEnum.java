package com.itwall.util;

import lombok.Getter;

@Getter
public enum ConstantsConnexionEnum {
    DRIVER("com.mysql.jdbc.Driver"),
    URL("jdbc:mysql://192.168.0.45/"),
    BD("itwall"),
    USER("root"),
    PASSWORD("admin123");

    private final String constResponse;


    ConstantsConnexionEnum(String constResponse) {
        this.constResponse = constResponse;
    }
}
