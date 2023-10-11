import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;
import utils.Tipos.Tipos;
import utils.Tipos.Abstrato.Molde;
import utils.Tipos.Molde.*;
import utils.Tipos.Primitivo.*;
import utils.Arvore.ArvoreFamilia;

public class Semantico_2 extends DepthFirstAdapter
{
    private boolean inserirEmMoldes;
    private String ultimaFuncaoAdicionada;
    private int escoposAteMolde; // quantidade de escopos criados apos o molde atual
    private boolean criarNovoEscopo;
    private String moldeAtual;
    private Stack<Hashtable<String, Tipos>> tabelaSimbolos;
    private ArvoreFamilia familias;
    private Stack<Molde> moldes;
    private Stack<Tipos> pilhaEstruturas;

    public Semantico_2()
    {
        this.inserirEmMoldes = true;
        this.ultimaFuncaoAdicionada = "";
        this.escoposAteMolde = 0;
        this.criarNovoEscopo = false;
        this.moldeAtual = "";
        this.tabelaSimbolos = new Stack<Hashtable<String, Tipos>>();
        this.moldes = new Stack<Molde>();
        this.pilhaEstruturas = new Stack<Tipos>();
    }

    private void inserirParametroPilha(String id, String tipo)
    {
        if(tipo.intern() == "Numero".intern()) this.pilhaEstruturas.push(new Numero(id));
        else
        {
            if(tipo.intern() == "Texto".intern()) this.pilhaEstruturas.push(new Texto(id));
            else
            {
                if(tipo.intern() == "Bool") this.pilhaEstruturas.push(new Bool(id));
                else
                {
                    if(this.familias.existeMolde(tipo)) this.pilhaEstruturas.push(new MoldeP(tipo));
                    else throw new RuntimeException("[ERRO] Molde '" + tipo + "' não declarado!");
                }
            }
        }
    }

    private boolean analisarElemento(Tipos elemento, String tipo)
    {
        boolean tudoOK = false;
        if(elemento instanceof Constante)
        {
            if(elemento.foiAtribuida())
            {
                if(elemento.obterRetorno().intern() == tipo.intern()) tudoOK = true;
                else throw new RuntimeException("[ERRO] Constante '" + elemento.obterId() + "' é do tipo '" + elemento.obterRetorno() + "', mas espera-se '" + tipo + "'!");
            }
            else throw new RuntimeException("[ERRO] Constante '" + elemento.obterId() + "' não possui valor!");
        }
        else
        {
            if(elemento.obterRetorno().intern() == tipo.intern()) tudoOK = true;
            else throw new RuntimeException("[ERRO] Elemento '" + elemento.obterId() + "' é do tipo '" + elemento.obterRetorno() + "', mas espera-se '" + tipo + "'!");
        }

        return tudoOK;
    }

    private Tipos obterAtributo(String id)
    {
        Tipos resultado = null;
        Stack<Hashtable<String, Tipos>> aux = new Stack<Hashtable<String, Tipos>>();
        for(int i = 0; i < this.escoposAteMolde; i++)
        {
            Hashtable<String, Tipos> escopoAtual = this.tabelaSimbolos.peek();
            if(escopoAtual.containsKey(id))
            {
                resultado = escopoAtual.get(id);
                break;
            }
            aux.push(this.tabelaSimbolos.pop());
        }
        if(aux.size() > 0) for(int i = 0; i < aux.size(); i++) this.tabelaSimbolos.push(aux.pop());

        return resultado;
    }

    private Tipos obterAtributoExterno(String id, String molde)
    {
        Tipos resultado = null;
        Stack<Molde> aux = new Stack<Molde>();
        for(int i = 0; i < this.moldes.size(); i++)
        {
            Molde moldeAtual = this.moldes.peek();
            if(moldeAtual.obterId().intern() == molde.intern())
            {
                if(moldeAtual.existeChave(id))
                {
                    resultado = moldeAtual.obterInformacao(id);
                    break;
                }
                else break;
            }
            aux.push(this.moldes.pop());
        }
        if(aux.size() > 0) for(int i = 0; i < aux.size(); i++) this.moldes.push(aux.pop());

        return resultado;
    }

    @Override //OK
    public void inAPrograma(APrograma node)
    {

        System.out.println("---------------------------------------");
        System.out.println("Início da Análise Semântica");
        System.out.println("---------------------------------------");

        this.familias = new ArvoreFamilia("Todos");
        this.familias.inserir("Comunicacao");

        Molde comunicacao = new Molde("Comunicacao");

        Funcao leiaNumero = new Funcao("leiaNumero", "Numero");
        leiaNumero.inserirMoldeResponsavel("Comunicacao");
        Funcao leiaTexto = new Funcao("leiaTexto", "Texto");
        leiaTexto.inserirMoldeResponsavel("Comunicacao");
        Funcao leiaBool = new Funcao("leiaBool", "Bool");
        leiaBool.inserirMoldeResponsavel("Comunicacao");
        Funcao screen = new Funcao("screen", "Nulo");
        screen.inserirMoldeResponsavel("Comunicacao");
        screen.aceitarParametros();

        comunicacao.inserirInformacao(leiaBool);
        comunicacao.inserirInformacao(leiaTexto);
        comunicacao.inserirInformacao(leiaNumero);
        comunicacao.inserirInformacao(screen);

        this.moldes.push(comunicacao);
    }

    @Override
    public void outAPrograma(APrograma node)
    {
        System.out.println("---------------------------------------");
        System.out.println("Fim da Análise Semântica");
        System.out.println("---------------------------------------");
    }

    @Override //OK
    public void outARelacao(ARelacao node)
    {
        String esquerdo = node.getEsquerdo().toString().trim();
        String direito = node.getDireito().toString().trim();

        if(!this.familias.existeMolde(direito))
        {
            this.familias.inserir(direito);
            this.familias.inserirFilho(direito, esquerdo);
        }
        else this.familias.inserirFilho(direito, esquerdo);
    }

    @Override //OK
    public void inADefMolde(ADefMolde node)
    {
        String molde = node.getIdMolde().toString().trim();
        this.tabelaSimbolos.push(new Hashtable<String, Tipos>());
        this.moldes.push(new Molde(molde));
        this.moldeAtual = molde;
        this.escoposAteMolde++;
    }

    @Override
    public void outADefMolde(ADefMolde node)
    {
        // this.tabelaSimbolos.pop();
        // System.out.println();
        // int size = this.moldes.size();
        // Stack<Molde> aux = new Stack<Molde>();
        // for(int i = 0; i < size; i++)
        // {
        //     Molde molde = this.moldes.pop();
        //     System.out.println();
        //     molde.mostrar();
        //     System.out.println();
        //     aux.push(molde);
        // }
        // for(int i = 0; i < size; i++) this.moldes.push(aux.pop());
        // System.out.println();
    }

    @Override //OK
    public void outAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        String retorno = node.getTipoPrimitivo().toString().trim();
        String id = node.getId().toString().trim();
        Hashtable<String, Tipos> escopoAtual = this.tabelaSimbolos.pop();

        if(!escopoAtual.containsKey(id))
        {
            System.out.println("[INSERÇÃO] Constante '" + id + "' -> " + retorno);
            Constante c = new Constante(id, retorno, this.moldeAtual);
            escopoAtual.put(id, c);
            this.tabelaSimbolos.push(escopoAtual);

            if(this.inserirEmMoldes)
            {
                Molde moldeAtual = this.moldes.pop();
                moldeAtual.inserirInformacao(c);
                this.moldes.push(moldeAtual);
            }
        }
        else throw new RuntimeException("[ERRO] Constante '" + id + "' já declarada!");
    }

    @Override //OK
    public void outAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        String id = node.getId().toString().trim();
        String retorno = node.getTipoMolde().toString().trim();
        Hashtable<String, Tipos> escopoAtual = this.tabelaSimbolos.pop();
        if(!escopoAtual.containsKey(id))
        {
            if(this.familias.existeMolde(retorno))
            {
                System.out.println("[INSERÇÃO] Objeto '" + id + "' -> " + retorno);
                Objeto o = new Objeto(id, retorno, this.moldeAtual);
                escopoAtual.put(id, o);
                this.tabelaSimbolos.push(escopoAtual);
                if(this.inserirEmMoldes)
                {
                    Molde moldeAtual = this.moldes.pop();
                    moldeAtual.inserirInformacao(o);
                    this.moldes.push(moldeAtual);
                }
            }
            else throw new RuntimeException("[ERRO] Molde '" + retorno + "' não declarado!");
        }
        else throw new RuntimeException("[ERRO] Objeto '" + id + "' já declarado!");
    }

    @Override //OK
    public void inAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        Hashtable<String, Tipos> novoEscopo = new Hashtable<String, Tipos>();
        String retorno = node.getTipo().toString().trim();
        String id = node.getId().toString().trim();
        Funcao f = new Funcao(id, retorno);
        f.inserirMoldeResponsavel(this.moldeAtual);
        this.ultimaFuncaoAdicionada = id;
        novoEscopo.put(id, f);
        this.tabelaSimbolos.push(novoEscopo);
        this.inserirEmMoldes = false;
        this.escoposAteMolde++;
    }

    @Override
    public void outAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        this.inserirEmMoldes = true;
        this.tabelaSimbolos.pop();

        Tipos valor = this.pilhaEstruturas.pop();
        Molde moldeAtual = this.moldes.pop();
        Tipos f = moldeAtual.obterInformacao(this.ultimaFuncaoAdicionada);
        if(f.obterRetorno().intern() == valor.obterRetorno().intern())
        {
            System.out.println("[RETORNO] Função '" + f.obterId() + "' -> " + valor.obterValor());
            f.inserirRetornoFuncao(valor.obterValor());
            moldeAtual.atualizarInformacao(this.ultimaFuncaoAdicionada, f);
            this.moldes.push(moldeAtual);
        }
        else throw new RuntimeException("[ERRO] Função '" + f.obterId() + "' deve retornar '" + f.obterRetorno() + "', mas '" + valor.obterRetorno() + "' foi retornado!");

    }

    @Override //OK
    public void outAIdParametro(AIdParametro node)
    {
        String id = node.getId().toString().trim();
        String retorno = node.getTipo().toString().trim();
        this.inserirParametroPilha(id, retorno);
    }

    @Override //OK
    public void outATipoParametroAssinatura(ATipoParametroAssinatura node)
    {
        String tipo = node.getTipo().toString().trim();
        this.inserirParametroPilha("", tipo);
    }

    @Override //OK
    public void outAParametrosAssinatura(AParametrosAssinatura node)
    {
        int numParametros = node.getDireito().size() + 1;
        this.pilhaEstruturas.push(new Numero(numParametros));
    }

    @Override //OK
    public void outAVazioParametrosAssinatura(AVazioParametrosAssinatura node)
    {
        this.pilhaEstruturas.push(new Numero(0));
    }

    @Override //OK
    public void outAAssinatura(AAssinatura node)
    {
        int numParametros = Integer.parseInt(this.pilhaEstruturas.pop().obterValor());
        String id = node.getId().toString().trim();
        String retorno = node.getTipo().toString().trim();
        Funcao f = new Funcao(id, retorno);
        f.inserirMoldeResponsavel(this.moldeAtual);
        if(numParametros > 0) f.aceitarParametros();
        for(int i = 0; i < numParametros; i++)
        {
            Tipos elemento = this.pilhaEstruturas.pop();
            f.inserirParametro(Integer.toString(i), elemento.obterRetorno());
        }
        this.pilhaEstruturas.push(f);
    }

    @Override //OK
    public void outAParametros(AParametros node)
    {
        Hashtable<String, Tipos> escopoAtual = this.tabelaSimbolos.pop();
        int numParametros = node.getDireito().size() + 1;
        Tipos funcao = escopoAtual.remove(this.ultimaFuncaoAdicionada);
        for(int i = 0; i < numParametros; i++)
        {
            Tipos elemento = this.pilhaEstruturas.pop();
            System.out.println("[INSERÇÃO] Parâmetro '" + elemento.obterId() + "' -> " + elemento.obterRetorno());
            funcao.inserirParametro(elemento.obterId(), elemento.obterRetorno());
            if(!escopoAtual.containsKey(elemento.obterId())) escopoAtual.put(elemento.obterId(), elemento);
            else throw new RuntimeException("[ERRO] Parâmetro '" + elemento.obterId() + "' já declarado!");
        }
        if(numParametros > 0) funcao.aceitarParametros();
        escopoAtual.put(this.ultimaFuncaoAdicionada, funcao);
        Molde moldeAtual = this.moldes.pop();
        moldeAtual.inserirInformacao(funcao);
        this.moldes.push(moldeAtual);
        this.tabelaSimbolos.push(escopoAtual);
    }

    @Override //OK
    public void outAIdFecho(AIdFecho node)
    {
        String id = node.getId().toString().trim();
        this.pilhaEstruturas.push(new Objeto(id, this.moldeAtual));
    }

    @Override //OK
    public void outAAtributoIdOuAttr(AAtributoIdOuAttr node)
    {
        String id = node.getId().toString().trim();
        int numIdfecho = node.getIdFecho().size();
        Stack<Tipos> ids = new Stack<Tipos>();
        for(int i = 0; i < numIdfecho; i++) ids.push(this.pilhaEstruturas.pop());
        Tipos retorno = this.obterAtributo(id);

        if(retorno != null)
        {
            Tipos objeto;
            while(!ids.isEmpty())
            {
                if(retorno instanceof Objeto)
                {
                    objeto = ids.pop();
                    retorno = this.obterAtributo(objeto.obterId());
                    if(retorno == null) throw new RuntimeException("[ERRO] Atributo '" + objeto.obterId() + "' não existe!");
                }
                else throw new RuntimeException("[ERRO] Variável '" + retorno.obterId() + "' não é um objeto!");
            }
            this.pilhaEstruturas.push(retorno);
        }
        else throw new RuntimeException("[ERRO] Objeto '" + id + "' não declarado!");
    }

    @Override //OK
    public void outAIdIdOuAttr(AIdIdOuAttr node)
    {
        String id = node.getId().toString().trim();
        Tipos retorno = this.obterAtributo(id);
        if(retorno != null) this.pilhaEstruturas.push(retorno);
        else throw new RuntimeException("[ERRO] Variável '" + id + "' não declarada!");
    }

    @Override //OK
    public void outANumeroExp(ANumeroExp node)
    {
        int valor = Integer.parseInt(node.getNumero().toString().trim());
        this.pilhaEstruturas.push(new Numero(valor));
    }

    @Override //OK
    public void outAVerdadeExp(AVerdadeExp node)
    {
        this.pilhaEstruturas.push(new Bool(true));
    }

    @Override //OK
    public void outAFalsoExp(AFalsoExp node)
    {
        this.pilhaEstruturas.push(new Bool(false));
    }

    @Override //OK
    public void outATextoExp(ATextoExp node)
    {
        Texto t = new Texto();
        t.inserirValor(node.getTexto().toString().trim());
        this.pilhaEstruturas.push(t);
    }

    @Override //OK
    public void outAStringExp(AStringExp node)
    {
        Texto s = new Texto();
        s.inserirValor(node.getString().toString().trim());
        this.pilhaEstruturas.push(s);
    }

    @Override //OK
    public void outASomaExp(ASomaExp node)
    {
        Tipos esquerdo = this.pilhaEstruturas.pop();
        Tipos direito = this.pilhaEstruturas.pop();

        if(this.analisarElemento(esquerdo, "Numero"))
        {
            if(this.analisarElemento(direito, "Numero"))
            {
                int elemento1 = Integer.parseInt(esquerdo.obterValor());
                int elemento2 = Integer.parseInt(direito.obterValor());
                this.pilhaEstruturas.push(new Numero(elemento1 + elemento2));
            }
        }
    }

    @Override //OK
    public void outASubtracaoExp(ASubtracaoExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(esquerdo, "Numero"))
        {
            if(this.analisarElemento(direito, "Numero"))
            {
                int elemento1 = Integer.parseInt(esquerdo.obterValor());
                int elemento2 = Integer.parseInt(direito.obterValor());
                this.pilhaEstruturas.push(new Numero(elemento1 - elemento2));
            }
        }
    }

    @Override //OK
    public void outAMultiplicacaoExp(AMultiplicacaoExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(esquerdo, "Numero"))
        {
            if(this.analisarElemento(direito, "Numero"))
            {
                int elemento1 = Integer.parseInt(esquerdo.obterValor());
                int elemento2 = Integer.parseInt(direito.obterValor());
                this.pilhaEstruturas.push(new Numero(elemento1 * elemento2));
            }
        }
    }

    @Override //OK
    public void outADivisaoExp(ADivisaoExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(direito, "Numero"))
        {
            if(this.analisarElemento(esquerdo, "Numero"))
            {
                int elemento1 = Integer.parseInt(esquerdo.obterValor());
                int elemento2 = Integer.parseInt(direito.obterValor());
                if(elemento2 == 0) throw new RuntimeException("[ERRO] Divisão por zero!");
                this.pilhaEstruturas.push(new Numero(elemento1 / elemento2));
            }
        }
    }

    @Override //OK
    public void outAModuloExp(AModuloExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(esquerdo, "Numero"))
        {
            if(this.analisarElemento(direito, "Numero"))
            {
                int elemento1 = Integer.parseInt(esquerdo.obterValor());
                int elemento2 = Integer.parseInt(direito.obterValor());
                this.pilhaEstruturas.push(new Numero(elemento1 % elemento2));
            }
        }
    }

    @Override //OK
    public void outAComparacaoExp(AComparacaoExp node)
    {
        Tipos esquerdo = this.pilhaEstruturas.pop();
        Tipos direito = this.pilhaEstruturas.pop();

        if(esquerdo.obterRetorno().intern() == direito.obterRetorno().intern())
        {
            if(esquerdo.obterValor().intern() == direito.obterValor().intern()) this.pilhaEstruturas.push(new Bool(true));
            else this.pilhaEstruturas.push(new Bool(false));
        }
        else throw new RuntimeException("[ERRO] Impossível comparar '" + esquerdo.obterRetorno() + "' com '" + direito.obterRetorno() + "'!");
    }

    @Override //OK
    public void outAMenorQueExp(AMenorQueExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(direito, "Numero"))
        {
            if(this.analisarElemento(esquerdo, "Numero"))
            {
                if((Integer.parseInt(esquerdo.obterValor())) < Integer.parseInt(direito.obterValor())) this.pilhaEstruturas.push(new Bool(true));
                else this.pilhaEstruturas.push(new Bool(false));
            }
        }
    }

    @Override //OK
    public void outAMenorIgualExp(AMenorIgualExp node)
    {
        Tipos esquerdo = this.pilhaEstruturas.pop();
        Tipos direito = this.pilhaEstruturas.pop();

        if(this.analisarElemento(direito, "Numero"))
        {
            if(this.analisarElemento(esquerdo, "Numero"))
            {
                if((Integer.parseInt(esquerdo.obterValor())) <= Integer.parseInt(direito.obterValor())) this.pilhaEstruturas.push(new Bool(true));
                else this.pilhaEstruturas.push(new Bool(false));
            }
        }
    }

    @Override //OK
    public void outAEExp(AEExp node)
    {
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(this.analisarElemento(direito, "Bool"))
        {
            if(this.analisarElemento(esquerdo, "Bool"))
            {
                if((Boolean.parseBoolean(esquerdo.obterValor())) && Boolean.parseBoolean(direito.obterValor())) this.pilhaEstruturas.push(new Bool(true));
                else this.pilhaEstruturas.push(new Bool(false));
            }
        }
    }

    @Override //OK
    public void outAOuExp(AOuExp node)
    {
        Tipos esquerdo = this.pilhaEstruturas.pop();
        Tipos direito = this.pilhaEstruturas.pop();

        if(this.analisarElemento(direito, "Bool"))
        {
            if(this.analisarElemento(esquerdo, "Bool"))
            {
                if((Boolean.parseBoolean(esquerdo.obterValor())) || Boolean.parseBoolean(direito.obterValor())) this.pilhaEstruturas.push(new Bool(true));
                else this.pilhaEstruturas.push(new Bool(false));
            }
        }
    }

    @Override //OK
    public void outAVazioListaExp(AVazioListaExp node)
    {
        this.pilhaEstruturas.push(new Numero(0));
    }

    @Override //OK
    public void outAIdExp(AIdExp node)
    {
        String id =  node.getId().toString().trim();
        Tipos retorno = this.obterAtributo(id);
        if(retorno != null) this.pilhaEstruturas.push(retorno);
        else throw new RuntimeException("[ERRO] Variável '" + id + "' não declarada!");
    }
    
    @Override //OK
    public void outAListaExp(AListaExp node)
    {
        int tamanhoLista = node.getDireito().size() + 1;
        this.pilhaEstruturas.push(new Numero(tamanhoLista));
    }

    @Override //OK
    public void outAChamadaExp(AChamadaExp node)
    {
        String id = node.getId().toString().trim();
        int numIdfecho = node.getIdFecho().size();
        Stack<Tipos> idFecho = new Stack<Tipos>();
        Tipos listaExp = this.pilhaEstruturas.pop();
        int numParametros = Integer.parseInt(listaExp.obterValor());
        Stack<Tipos> parametros = new Stack<Tipos>();
        for(int i = 0; i < numParametros; i++) parametros.push(this.pilhaEstruturas.pop());
        for(int i = 0; i < numIdfecho; i++) idFecho.push(this.pilhaEstruturas.pop());
        Tipos retorno = this.obterAtributo(id);

        if(retorno == null) retorno = this.obterAtributoExterno(id, "Comunicacao");

        if(retorno != null)
        {
            if(retorno instanceof Funcao)
            {
                if(retorno.aceitaParametros())
                {
                    if(numParametros > 0)
                    {
                        Tipos verificarParametros[] = new Tipos[numParametros];
                        for(int i = 0; i < numParametros; i++) verificarParametros[i] = parametros.pop();
                        retorno.checarParametros(verificarParametros);
                    }
                    if(retorno.obterRetorno() == "Numero") this.pilhaEstruturas.push(new Numero(Integer.parseInt(retorno.retornoFuncao())));
                    else
                    {
                        if(retorno.obterRetorno() == "Texto") this.pilhaEstruturas.push(new Texto(retorno.retornoFuncao()));
                        else
                        {
                            if(retorno.obterRetorno() == "Bool") this.pilhaEstruturas.push(new Bool(retorno.retornoFuncao()));
                            else
                            {
                                Objeto o = new Objeto(retorno.obterRetorno(), retorno.obterMoldeResponsavel());
                                o.inserirValor(retorno.retornoFuncao());
                                this.pilhaEstruturas.push(o);
                            }
                        }
                    }
                }
                else
                {
                    if(numParametros == 0)
                    {
                        if(retorno.obterRetorno() == "Numero") this.pilhaEstruturas.push(new Numero(Integer.parseInt(retorno.retornoFuncao())));
                        else
                        {
                            if(retorno.obterRetorno() == "Texto") this.pilhaEstruturas.push(new Texto(retorno.retornoFuncao()));
                            else
                            {
                                if(retorno.obterRetorno() == "Bool") this.pilhaEstruturas.push(new Bool(retorno.retornoFuncao()));
                                else
                                {
                                    Objeto o = new Objeto(retorno.obterRetorno(), retorno.obterMoldeResponsavel());
                                    o.inserirValor(retorno.retornoFuncao());
                                    this.pilhaEstruturas.push(o);
                                }
                            }
                        }
                    }
                    else throw new RuntimeException("[ERRO] Função '" + retorno.obterId() + "' não aceita parâmetros, mas " + numParametros + " foram passados!");
                }
            }
            else
            {
                if(retorno instanceof Objeto)
                {
                    Tipos objeto;
                    while(!idFecho.isEmpty())
                    {
                        if(retorno instanceof Objeto)
                        {
                            objeto = idFecho.pop();
                            retorno = this.obterAtributoExterno(objeto.obterId(), retorno.obterRetorno());
                            if(retorno == null) throw new RuntimeException("[ERRO] Atributo '" + objeto.obterId() + "' não existe!");
                        }
                        else throw new RuntimeException("[ERRO] Variável '" + retorno.obterId() + "' não é um objeto e sim '" + retorno.getClass() + "'!");
                    }
                    if(retorno instanceof Funcao)
                    {
                        if(retorno.aceitaParametros())
                        {
                            if(numParametros > 0)
                            {
                                Tipos verificarParametros[] = new Tipos[numParametros];
                                for(int i = 0; i < numParametros; i++) verificarParametros[i] = parametros.pop();
                                retorno.checarParametros(verificarParametros);
                            }
                            if(retorno.obterRetorno() == "Numero") this.pilhaEstruturas.push(new Numero(Integer.parseInt(retorno.retornoFuncao())));
                            else
                            {
                                if(retorno.obterRetorno() == "Texto") this.pilhaEstruturas.push(new Texto(retorno.retornoFuncao()));
                                else
                                {
                                    if(retorno.obterRetorno() == "Bool") this.pilhaEstruturas.push(new Bool(retorno.retornoFuncao()));
                                    else
                                    {
                                        Objeto o = new Objeto(retorno.obterRetorno(), retorno.obterMoldeResponsavel());
                                        o.inserirValor(retorno.retornoFuncao());
                                        this.pilhaEstruturas.push(o);
                                    }
                                }
                            }
                        }
                        else
                        {
                            if(numParametros == 0)
                            {
                                if(retorno.obterRetorno() == "Numero") this.pilhaEstruturas.push(new Numero(Integer.parseInt(retorno.retornoFuncao())));
                                else
                                {
                                    if(retorno.obterRetorno() == "Texto") this.pilhaEstruturas.push(new Texto(retorno.retornoFuncao()));
                                    else
                                    {
                                        if(retorno.obterRetorno() == "Bool") this.pilhaEstruturas.push(new Bool(retorno.retornoFuncao()));
                                        else
                                        {
                                            Objeto o = new Objeto(retorno.obterRetorno(), retorno.obterMoldeResponsavel());
                                            o.inserirValor(retorno.retornoFuncao());
                                            this.pilhaEstruturas.push(o);
                                        }
                                    }
                                }
                            }
                            else throw new RuntimeException("[ERRO] Função '" + retorno.obterId() + "' não aceita parâmetros, mas " + numParametros + " foram passados!");
                        }
                    }
                    else throw new RuntimeException("[ERRO] Variável '" + retorno.obterId() + "' não é uma função!");
                }
                else throw new RuntimeException("[ERRO] Lado direito da atribuição precisa ser uma Função ou Objeto, mas é do tipo '" + retorno.getClass() + "'!");
            }
        }
        else throw new RuntimeException("[ERRO] Variável '" + id + "' não foi declarada");
    }

    @Override //OK
    public void outADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        Tipos chamada = this.pilhaEstruturas.pop();
        Tipos id = this.pilhaEstruturas.pop();

        if(id.obterRetorno().intern() == chamada.obterRetorno().intern())
        {
            if(id instanceof Constante)
            {
                if(!id.foiAtribuida())
                {
                    System.out.println("[ATRIBUIÇÃO] " + id.obterId() + " = " + chamada.obterValor());
                    Hashtable<String, Tipos> escopoAtual = this.tabelaSimbolos.pop();
                    if(escopoAtual.containsKey(id.obterId()))
                    {
                        Tipos valor = escopoAtual.remove(id.obterId());
                        valor.inserirValor(chamada.obterValor());
                        escopoAtual.put(id.obterId(), valor);
                        this.tabelaSimbolos.push(escopoAtual);
                    }
                    else
                    {
                        Stack<Molde> aux = new Stack<Molde>();
                        int size = this.moldes.size();
                        for(int i = 0; i < size; i++)
                        {
                            Molde moldeAtual = this.moldes.pop();
                            if(moldeAtual.existeChave(id.obterId()))
                            {
                                Tipos valor = moldeAtual.obterInformacao(id.obterId());
                                valor.inserirValor(chamada.obterValor());
                                moldeAtual.atualizarInformacao(valor.obterId(), valor);
                                this.moldes.push(moldeAtual);
                                break;
                            }
                            aux.push(moldeAtual);
                        }
                        size = aux.size();
                        if(size > 0) for(int i = 0; i < size; i++) this.moldes.push(aux.pop());
                    }
                }
                else throw new RuntimeException("[ERRO] Constante '" + id.obterId() + "' já foi inicializada!");
            }
            else System.out.println("[ATRIBUIÇÃO] " + id.obterId() + " = " + chamada.obterValor());
        }
        else throw new RuntimeException("[ERRO] Impossível atribuir '" + chamada.obterRetorno() + "' a '" + id.obterRetorno() + "'!");
    }

    @Override //OK
    public void outATernarioExp(ATernarioExp node)
    {
        this.criarNovoEscopo = false;
        Tipos direito = this.pilhaEstruturas.pop();
        Tipos centro = this.pilhaEstruturas.pop();
        Tipos esquerdo = this.pilhaEstruturas.pop();

        if(esquerdo.obterValor().intern() == "Verdade".intern()) this.pilhaEstruturas.push(centro);
        else this.pilhaEstruturas.push(direito);
    }

    @Override //OK
    public void inATernarioExp(ATernarioExp node)
    {
        this.criarNovoEscopo = true;
    }

    @Override //OK
    public void inABlocoExp(ABlocoExp node)
    {
        if(this.criarNovoEscopo)
        {
            this.tabelaSimbolos.push(new Hashtable<String, Tipos>());
            this.escoposAteMolde++;
        }
    }

    @Override //OK
    public void outABlocoExp(ABlocoExp node)
    {
        if(this.criarNovoEscopo)
        {
            this.tabelaSimbolos.pop();
            this.escoposAteMolde--;
        }
    }
}