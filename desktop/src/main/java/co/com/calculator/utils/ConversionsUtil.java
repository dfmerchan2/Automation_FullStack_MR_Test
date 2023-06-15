package co.com.calculator.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversionsUtil {

    public static String getResult(String value){
        return value.replace("La pantalla muestra ", "");
    }

}
