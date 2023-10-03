import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;

public class Semantico extends DepthFirstAdapter
{
    private Stack<Hashtable<String, String>> tabela_simbolos;
    
    public Semantico()
    {
        this.tabela_simbolos = new Stack<Hashtable<String, String>>();
        this.tabela_simbolos.push(new Hashtable<String, String>());
    }

    private boolean existe(String key)
    {
        Stack<Hashtable<String, String>> aux = new Stack<Hashtable<String, String>>();
        boolean existe = false;
        int size = this.tabela_simbolos.size();

        for(int i = 0; i < size; i++)
        {
            Hashtable<String, String> escopo_atual = this.tabela_simbolos.peek();

            if(escopo_atual.containsKey(key))
            {
                existe = true;
                break;
            }
            
            aux.push(this.tabela_simbolos.pop());
        }

        if(aux.size() > 0)
        {
            for(int i = 0; i < aux.size(); i++)
            {
                this.tabela_simbolos.push(aux.pop());
            }
        }

        return existe;
    }

    @Override
    public void inAPrograma(APrograma node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        System.out.println("Adicionando Comunicacao como filha de Todos");
        escopo_atual.put("Comunicacao ", "Todos");

        System.out.println("Adicionando função: Primitivo -> escreva");
        escopo_atual.put("escreva ", "primitivo");

        System.out.println("Adicionando função: Texto -> leiaTexto");
        escopo_atual.put("leiaTexto ", "Texto");

        System.out.println("Adicionando função:  Numero -> leiaNumero");
        escopo_atual.put("leiaNumero ", "Numero");

        System.out.println("Adicionando função: Bool -> leiaBool");
        escopo_atual.put("leiaBool ", "Bool");

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inARelacao(ARelacao node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        TIdMolde esquerdo = node.getEsquerdo();
        TIdMolde direito = node.getDireito();

        if(!escopo_atual.containsKey(direito.toString()))
        {
            System.out.println("Adicionando " + direito.toString() + "como filha de Todos");
            escopo_atual.put(direito.toString(), "Todos");
        }

        if(!escopo_atual.containsKey(esquerdo.toString()))
        {
            System.out.println("Adicionando " + esquerdo.toString() + "como filha de " + direito.toString());
            escopo_atual.put(esquerdo.toString(), direito.toString());
        }
        else
        {
            throw new RuntimeException("Molde " + esquerdo.toString() + "já declarado");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inADefMolde(ADefMolde node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        TIdMolde molde = node.getIdMolde();

        if(!escopo_atual.containsKey(molde.toString()))
        {
            System.out.println("Adicionando " + molde.toString() + "como filha de Todos");
            escopo_atual.put(molde.toString(), "Todos");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        Hashtable<String, String> novo_escopo = new Hashtable<String, String>();

        PTipo retorno_funcao = node.getTipo();
        TId nome_funcao = node.getId();

        if(!this.existe(nome_funcao.toString()))
        {
            System.out.println("Adicionando função: " + retorno_funcao.toString() + "-> " + nome_funcao.toString());
            novo_escopo.put(nome_funcao.toString(), retorno_funcao.toString());

            this.tabela_simbolos.push(novo_escopo);
        }
        else
        {
            throw new RuntimeException("Função " + nome_funcao.toString() + "já declarada");
        }
    }

    @Override
    public void outAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        TId funcao = node.getId();

        System.out.println("Removendo escopo da função " + funcao.toString());
        this.tabela_simbolos.pop();
    }

    @Override
    public void inAIdParametro(AIdParametro node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipo tipo = node.getTipo();
        TId id = node.getId();

        System.out.println("Adicionando parâmetro: " + tipo.toString() + "-> " + id.toString());
        
        escopo_atual.put(id.toString(), tipo.toString());

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipoPrimitivo tipo = node.getTipoPrimitivo();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            System.out.println("Adicionando constante: " + tipo.toString() + "-> " + id.toString());
            escopo_atual.put(id.toString(), tipo.toString());
        }
        else
        {
            throw new RuntimeException("Constante " + id.toString() + "já declarada");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipoMolde molde = node.getTipoMolde();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            if(escopo_atual.containsKey(molde.toString()))
            {
                System.out.println("Adicionando objeto: " + molde.toString() + "-> " + id.toString());
                escopo_atual.put(id.toString(), molde.toString());
            }
            else
            {
                throw new RuntimeException("Tipo molde " + molde.toString() + "não declarado");
            }
        }
        else
        {
            throw new RuntimeException("Id " + id.toString() + "já existente");
        }
    }

    @Override
    public void inADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        PIdOuAttr id_ou_attr = node.getIdOuAttr();
        PExp exp = node.getExp();

        if(this.existe(id_ou_attr.toString()))
        {
            if(this.existe(exp.toString()))
            {
                System.out.println("Atribuindo: " + id_ou_attr.toString() + "-> " + exp.toString());
            }
            else
            {
                throw new RuntimeException("Função " + exp.toString() + "não existente");
            }
        }
        else
        {
            throw new RuntimeException("Variável " + id_ou_attr.toString() + "não existente");
        }
    }

}
