package com.challenge.testes;

import java.math.BigDecimal;
import java.util.stream.Stream;

import com.challenge.desafio.CalculadorDeClasses;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ReflectionTest {
    private static final String METHOD_SOMAR = "somar";
    private static final String METHOD_SUBTRAIR = "subtrair";
    private static final String METHOD_TOTALIZAR = "totalizar";
    private static final String CALCULADOR_DE_CLASSES_PATH = "com.challenge.desafio.CalculadorDeClasses";
    private static final String CALCULAVEL_PATH = "com.challenge.interfaces.Calculavel";

    public ReflectionTest() {
    }

    @Test
    public void whenAdd() {
        Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("somar", salario);
        assertEquals(result, new BigDecimal(40));
    }

    @Test
    public void whenAddWithouAnnotation() {
        AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("somar", salario);
        assertEquals(result, new BigDecimal(0));
    }

    @Test
    public void whenSubtract() {
        Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("subtrair", salario);
        assertEquals(result, new BigDecimal(15));

    }

    @Test
    public void whenSubtractAllWithouAnnotation() {
        AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("subtrair", salario);
        assertEquals(result, new BigDecimal(0));

    }

    private BigDecimal execute(String method, Object object) {
        try {
            Object obj = this.getCalculadorClassesClass().newInstance();
            return (BigDecimal)obj.getClass().getMethod(method, Object.class).invoke(obj, object);
        } catch (Exception var4) {
            new RuntimeException(var4);
            return null;
        }
    }

    @Test
    public void whenResult() {
        Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("totalizar", salario);
        assertEquals(result, new BigDecimal(25));

    }

    @Test
    public void whenResultWithoutAnnotation() {
        AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        BigDecimal result = this.execute("totalizar", salario);
        assertEquals(result, new BigDecimal(0));

    }

    @Test
    public void shouldImplementsCalculavel() {
        boolean isSameClass = Stream.of(this.getCalculadorClassesClass().getInterfaces()).anyMatch((i) -> {
            return i.equals(this.getCalculavelClass());
        });
        assertTrue(isSameClass);
    }

    @Test
    public void shouldHaveAddMethod() {
        boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch((m) -> {
            return m.getName().equals("somar");
        });
        assertTrue(temSoma);
    }

    private Class<?> getCalculavelClass() {
        try {
            return Class.forName("com.challenge.interfaces.Calculavel");
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }

    private Class<?> getCalculadorClassesClass() {
        try {
            return Class.forName("com.challenge.desafio.CalculadorDeClasses");
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }

    @Test
    public void shouldHaveSubtractMethod() {
        boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch((m) -> {
            return m.getName().equals("subtrair");
        });
        assertTrue(temSoma);
    }

    @Test
    public void shouldHaveResultMethod() {
        boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch((m) -> {
            return m.getName().equals("totalizar");
        });
        assertTrue(temSoma);
    }
}
