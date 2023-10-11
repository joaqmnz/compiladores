package utils.Tipos.Primitivo;

import utils.Tipos.Tipos;

public class Texto extends Tipos {
    private String valor;
    private String id;
    
    public Texto(){}

    public Texto(String id)
    {
        this.id = id;
    }

    @Override
    public String obterRetorno()
    {
        return "Texto";
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
