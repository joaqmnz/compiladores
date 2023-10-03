import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;

public class Semantico extends DepthFirstAdapter
{
    private Stack<Hashtable<String, String>> tabela_simbolos;
    private Stack<String[]> tabela_tipos;
    
    public Semantico()
    {
        this.tabela_simbolos = new Stack<Hashtable<String, String>>();
        this.tabela_simbolos.push(new Hashtable<String, String>());

        this.tabela_tipos = new Stack<String[]>();
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

    private String obter_valor_chave(String key)
    {
        Stack<Hashtable<String, String>> aux = new Stack<Hashtable<String, String>>();
        String valor_chave = "";
        int size = this.tabela_simbolos.size();

        for(int i = 0; i < size; i++)
        {
            Hashtable<String, String> escopo_atual = this.tabela_simbolos.peek();

            if(escopo_atual.containsKey(key))
            {
                valor_chave = escopo_atual.get(key);
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

        return valor_chave;
    }

    @Override
    public void inAPrograma(APrograma node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        System.out.println("Adicionando Comunicacao como filha de Todos");
        escopo_atual.put("Comunicacao ", "Todos");

        System.out.println("Adicionando função: escreva -> Primitivo");
        escopo_atual.put("escreva ", "primitivo");

        System.out.println("Adicionando função: leiaTexto -> Texto");
        escopo_atual.put("leiaTexto ", "Texto");

        System.out.println("Adicionando função:  leiaNumero -> Numero");
        escopo_atual.put("leiaNumero ", "Numero");

        System.out.println("Adicionando função: leiaBool -> Bool");
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
            System.out.println("Adicionando função: " + nome_funcao.toString() + "-> " + retorno_funcao.toString());
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

        System.out.println("Adicionando parâmetro: " + id.toString() + "-> " + tipo.toString());
        
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
            System.out.println("Adicionando constante: " + id.toString() + "-> " + tipo.toString());
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
                System.out.println("Adicionando objeto: " + id.toString() + "-> " + molde.toString());
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

    @Override
    public void outAIdExp(AIdExp node)
    {
        TId id = node.getId();

        if(this.existe(id.toString()))
        {
            String tipo_id = this.obter_valor_chave(id.toString());
            if(tipo_id.intern() == "Numero ")
            {
                String elemento[] = new String[2];
                elemento[0] = id.toString().replace(" ", "");
                elemento[1] = tipo_id;
                this.tabela_tipos.push(elemento);
            }
            else
                throw new RuntimeException("Tipo incorreto de " + id.toString() + "= " + tipo_id);
        }
        else
        {
            throw new RuntimeException("Variável " + id.toString() + "não declarada");
        }
    }

    @Override
    public void outANumeroExp(ANumeroExp node)
    {
        TNumero numero = node.getNumero();
        String elemento[] = new String[2];
        elemento[0] = numero.toString().replace(" ", "");
        elemento[1] = "Numero ";
        this.tabela_tipos.push(elemento);
    }

    @Override
    public void outASomaExp(ASomaExp node)
    {
        String elemento1[] = this.tabela_tipos.pop();
        String elemento2[] = this.tabela_tipos.pop();

        if(elemento1[1].intern() == "Numero ")
        {
            if(!(elemento2[1].intern() == "Numero "))
            {
                throw new RuntimeException("Impossível realizar soma entre Numero e " + elemento2[1]);
            }
            else
            {
                System.out.println("Soma: " + elemento1[0] + " + " + elemento2[0]);
                String elemento[] = new String[2];
                elemento[0] = "( " + elemento1[0] + " + " + elemento2[0] + " )";
                elemento[1] = "Numero ";
                this.tabela_tipos.push(elemento);
            }
        }
        else
        {
            throw new RuntimeException("Tipo " + elemento1[1] + " não pertence à uma soma");
        }
    }

    @Override
    public void outASubtracaoExp(ASubtracaoExp node)
    {
        String elemento1[] = this.tabela_tipos.pop();
        String elemento2[] = this.tabela_tipos.pop();

        if(elemento1[1].intern() == "Numero ")
        {
            if(!(elemento2[1].intern() == "Numero "))
            {
                throw new RuntimeException("Impossível realizar subtração entre Numero e " + elemento2[1]);
            }
            else
            {
                System.out.println("Subtração: " + elemento1[0] + " - " + elemento2[0]);
                String elemento[] = new String[2];
                elemento[0] = "( " + elemento1[0] + " - " + elemento2[0] + " )";
                elemento[1] = "Numero ";
                this.tabela_tipos.push(elemento);
            }
        }
        else
        {
            throw new RuntimeException("Tipo " + elemento1[1] + " não pertence à uma subtração");
        }
    }
}
