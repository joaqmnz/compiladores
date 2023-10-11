package utils.Tipos.Molde;

import utils.Tipos.Tipos;

public class Objeto extends Tipos {
    private String id;
    private String retorno;
    private String valor;
    private String moldeResponsavel;

    public Objeto(String id, String molde, String moldeResponsavel)
    {
        this.id = id;
        this.retorno = molde;
        this.moldeResponsavel = moldeResponsavel;
    }

    public Objeto(String id, String moldeResponsavel)
    {
        this.id = id;
        this.moldeResponsavel = moldeResponsavel;
    }

    @Override
    public String obterMoldeResponsavel()
    {
        return this.moldeResponsavel;
    }

    @Override
    public void inserirMoldeResponsavel(String molde)
    {
        this.moldeResponsavel = molde;
    }

    @Override
    public String obterRetorno()
    {
        return this.retorno;
    }

    @Override
    public void inserirRetorno(String retorno)
    {
        this.retorno = retorno;
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

}
