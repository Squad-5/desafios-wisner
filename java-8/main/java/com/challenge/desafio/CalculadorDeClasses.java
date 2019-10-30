package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object classe) throws IllegalAccessException {
        return this.getResult(classe, true);
    }

    @Override
    public BigDecimal subtrair(Object classe) throws IllegalAccessException {
        return this.getResult(classe,false);
    }

    @Override
    public BigDecimal totalizar(Object classe) throws IllegalAccessException {
        return this.somar(classe).subtract(this.subtrair(classe));
    }

    private BigDecimal getResult(Object classe, boolean soma) throws IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;
        for (Field field : classe.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(soma ? Somar.class : Subtrair.class)) {
                field.setAccessible(true);
                result = result.add((BigDecimal) field.get(classe));
            }
        }
        return result;
    }
}
