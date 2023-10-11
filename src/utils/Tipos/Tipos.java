package utils.Tipos;

public abstract class Tipos  {
    public Tipos(){}

    public String obterValor()
    {
        return "";
    }
    public void inserirValor(String valor){}
    public String obterRetorno()
    {
        return "";
    }
    public void inserirRetorno(String valor){}
    public String obterId()
    {
        return "";
    }
    public void inserirId(String id){}

    public String obterMoldeResponsavel()
    {
        return "";
    }

    public void inserirMoldeResponsavel(String molde){}

    // Métodos de função
    public boolean existeParametro(String id)
    {
        return false;
    }
    public void inserirParametro(String id, String retorno){}
    public String[] obterParametro(String id)
    {
        return null;
    }
    public void inverterParametros(){}
    public void aceitarParametros(){}
    public void checarParametros(Tipos parametros[]){}
    public boolean aceitaParametros()
    {
        return false;
    }
    public void incrementarChamadas(){}
    public int obterVezesChamada()
    {
        return 0;
    }
    public String retornoFuncao()
    {
        return "";
    }
    public void inserirRetornoFuncao(String retorno){}

    // Métodos de constante
    public boolean foiAtribuida()
    {
        return false;
    }
    public void atribuir(){}


}
