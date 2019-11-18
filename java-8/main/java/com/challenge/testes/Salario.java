//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.challenge.testes;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import java.math.BigDecimal;

public class Salario {
    @Somar
    private BigDecimal salarioBruto;
    @Subtrair
    private BigDecimal inss;
    @Subtrair
    private BigDecimal planoSaude;
    @Somar
    private BigDecimal valeRefeicao;

    public Salario() {
    }

    public BigDecimal getSalarioBruto() {
        return this.salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public BigDecimal getInss() {
        return this.inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getPlanoSaude() {
        return this.planoSaude;
    }

    public void setPlanoSaude(BigDecimal planoSaude) {
        this.planoSaude = planoSaude;
    }

    public BigDecimal getValeRefeicao() {
        return this.valeRefeicao;
    }

    public void setValeRefeicao(BigDecimal valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }
}
