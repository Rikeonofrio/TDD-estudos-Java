package main.java.br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {


    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },

    SATISFATORIO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    EXPLENDIDO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };


    public abstract BigDecimal percentualReajuste();

}
