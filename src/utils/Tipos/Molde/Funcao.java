package utils.Tipos.Molde;

import java.util.*;

import utils.Tipos.Tipos;

public class Funcao extends Tipos {
    private String id;
    private String retorno;
    private String retornoFuncao;
    private Stack<String[]> parametros;
    private boolean aceitaParametros;
    private int vezesChamada;
    private String moldeResponsavel;

    public Funcao(String id, String retorno)
    {
        this.id = id;
        this.retorno = retorno;
        this.retornoFuncao = "";
        this.aceitaParametros = false;
        this.parametros = new Stack<String[]>();
        this.vezesChamada = 0;
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
    public boolean existeParametro(String id)
    {
        Stack<String[]> aux = new Stack<String[]>();
        int size = this.parametros.size();
        boolean existe = false;
        for(int i = 0; i < size; i++)
        {
            String parametroAtual[] = this.parametros.peek();
            if(parametroAtual[0].intern() == id.intern())
            {
                existe = true;
                break;
            }
            aux.push(this.parametros.pop());
        }

        size = aux.size();
        if(size > 0) for(int i = 0; i < size; i++) this.parametros.push(aux.pop());

        return existe;
    }

    @Override
    public void inserirParametro(String id, String retorno)
    {
        if(!this.existeParametro(id))
        {
            String novoParametro[] = new String[2];
            novoParametro[0] = id;
            novoParametro[1] = retorno;
            this.parametros.push(novoParametro);
        }
        else throw new RuntimeException("[ERRO] Parâmetro '" + id + "' já declarado!");
    }

    @Override
    public String[] obterParametro(String id)
    {
        Stack<String[]> aux = new Stack<String[]>();
        int size = this.parametros.size();
        String retorno[] = null;
        for(int i = 0; i < size; i++)
        {
            String parametroAtual[] = this.parametros.peek();
            if(parametroAtual[0].intern() == id.intern())
            {
                retorno = parametroAtual;
                break;
            }
            aux.push(this.parametros.pop());
        }
        size = aux.size();
        for(int i = 0; i < size; i++) this.parametros.push(aux.pop());

        if(retorno == null) throw new RuntimeException("[ERRO] Parâmetro '" + id + "' não declarado"); 

        return retorno;
    }

    @Override
    public void inverterParametros()
    {
        Stack<String[]> aux = new Stack<String[]>();
        Stack<String[]> aux2 = new Stack<String[]>();
        int size = this.parametros.size();
        for(int i = 0; i < size; i++) aux.push(this.parametros.pop());
        for(int i = 0; i < size; i++) aux2.push(aux.pop());
        for(int i = 0; i < size; i++) this.parametros.push(aux2.pop());
    }

    @Override
    public void aceitarParametros()
    {
        this.aceitaParametros = true;
    }

    @Override
    public void checarParametros(Tipos parametros[])
    {
        this.inverterParametros();
        int size = parametros.length;
        if(size == this.parametros.size())
        {
            Stack<String[]> aux = new Stack<String[]>();
            for(int i = 0; i < size; i++)
            {
                String parametroAtual[] = this.parametros.pop();
                if(!(parametroAtual[1].intern() == parametros[i].obterRetorno().intern())) throw new RuntimeException("[ERRO] Tipo de parâmetro inesperado. Espera-se '" + parametroAtual[1] + "', mas foi passado do tipo '" + parametros[i].obterRetorno() + "'!");
                aux.push(parametroAtual);
            }
            for(int i = 0; i < size; i++) this.parametros.push(aux.pop());
        }
        else throw new RuntimeException("[ERRO] Espera-se " + this.parametros.size() + " parâmetros, mas " + size + " foram passados!");
    }

    @Override
    public String obterRetorno()
    {
        return this.retorno;
    }

    @Override
    public boolean aceitaParametros()
    {
        return this.aceitaParametros;
    }

    @Override
    public String obterId()
    {
        return this.id;
    }

    @Override
    public void incrementarChamadas()
    {
        this.vezesChamada++;
    }

    @Override
    public int obterVezesChamada()
    {
        return this.vezesChamada;
    }

    @Override
    public String retornoFuncao()
    {
        return this.retornoFuncao;
    }
    
    @Override
    public void inserirRetornoFuncao(String retorno)
    {
        this.retornoFuncao = retorno;
    }

}
