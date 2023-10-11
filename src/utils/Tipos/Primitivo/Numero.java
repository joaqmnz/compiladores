package utils.Tipos.Primitivo;

import utils.Tipos.Tipos;

public class Numero extends Tipos {
    private int valor;
    private String id;
    
    public Numero(){}

    public Numero(String id)
    {
        this.id = id;
    }

    public Numero(int valor)
    {
        this.valor = valor;
    }

    @Override
    public String obterRetorno()
    {
        return "Numero";
    }

    @Override
    public String obterValor()
    {
        return Integer.toString(this.valor);
    }

    @Override
    public void inserirValor(String valor)
    {
        this.valor = Integer.parseInt(valor);
    }

    @Override
    public String obterId()
    {
        return this.id;
    }

    @Override
    public void inserirId(String id)
    {
        this.id = id;
    }
}
