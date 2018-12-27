package com.example.springstudy.demo5_spel.spel.basic;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public class EvaluationContextTest {

    public static void main(String[] args) {

        Person person = new Person("Careey");
        System.out.println("Init name => " + person.getName());
        EvaluationContext simpleContext = new StandardEvaluationContext(person);
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("name").setValue(simpleContext, "Peter");

        System.out.println("Parse name => " + person.getName());

        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(simpleContext);

        // true로 평가된다
        boolean trueValue = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);

        // false로 평가된다
        boolean falseValue = parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);

        // true로 평가된다
        trueValue = parser.parseExpression("22 eq 22").getValue(Boolean.class);

        // false로 평가된다
        falseValue = parser.parseExpression("'test' ne 'test!'").getValue(Boolean.class);
    }

}
