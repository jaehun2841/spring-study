package com.example.springstudy.demo5_spel.spel.basic;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionTest {

    public static void main(String[] args) {

        String message = parseExpression("\"Hello World\".concat('!')", String.class);
        System.out.println(message);

        byte[] bytes = parseExpression("\"Hello World\".bytes", byte[].class);
        System.out.println(bytes);

        String name = parseExpression("name", new Person("Carrey"), String.class);
        System.out.println(name);

        boolean isCarrey = parseExpression("name == 'Carrey'", new Person("Carrey"), Boolean.class);
        System.out.println("isCarrey > " + isCarrey);

    }



    public static <T> T parseExpression(String expression, Class<T> clazz) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);
        return exp.getValue(clazz);
    }

    public static <T> T parseExpression(String expression, Object context, Class<T> clazz) {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);
        return exp.getValue(context, clazz);
    }
}
