package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Estacionamento {
    private List<Carro> carrosEstacionados = new ArrayList<>();

    public List<Carro> getCarrosEstacionados() {
        return carrosEstacionados;
    }

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) throw new EstacionamentoException("Não pode carro autônomo");
        Motorista motorista = carro.getMotorista();

        if (motorista.getIdade() < 18) throw new EstacionamentoException("Motorista menor de idade!");
        if (motorista.getPontos() > 20) throw new EstacionamentoException("Motorista com habilitação suspensa");

        if (this.carrosEstacionados() < 10) {
            this.getCarrosEstacionados().add(carro);
        } else {
            for (int i = 0; i < 10; i++) {
                Carro carroJaEstacionado = this.getCarrosEstacionados().get(i);

                if (carroJaEstacionado.getMotorista().getIdade() < 55) {
                    this.getCarrosEstacionados().remove(i);
                    this.getCarrosEstacionados().add(carro);
                }
            }
            if (!this.getCarrosEstacionados().contains(carro)) throw new EstacionamentoException("Estacionamento cheio!");
        }
      
    }

    public int carrosEstacionados() {
        return this.getCarrosEstacionados().size();
    }

    public boolean carroEstacionado(Carro carro) {
        return this.getCarrosEstacionados().contains(carro);
    }
}
