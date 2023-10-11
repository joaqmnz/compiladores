package utils.Tipos.Primitivo;

import utils.Tipos.Tipos;

public class Bool extends Tipos {
    private String valor;
    private String id;
    
    public Bool(){}

    public Bool(String id)
    {
        this.id = id;
    }

    public Bool(boolean valor)
    {
        if(valor) this.valor = "Verdade";
        else this.valor = "Falso";
    }

    @Override
    public String obterRetorno()
    {
        return "Bool";
    }

    @Override
    public String obterValor()
    {
        return this.valor;
    }

    @Override
    public void inserirValor(String valor)
    {
        this.valor = valor;
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
