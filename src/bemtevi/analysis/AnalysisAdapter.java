/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.analysis;

import java.util.*;
import bemtevi.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpInicio(AExpInicio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFamiliaInicio(AFamiliaInicio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATernarioExp(ATernarioExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEExp(AEExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComparacaoExp(AComparacaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorQueExp(AMenorQueExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorIgualExp(AMenorIgualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubtracaoExp(ASubtracaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiplicacaoExp(AMultiplicacaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivisaoExp(ADivisaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModuloExp(AModuloExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegacaoExp(ANegacaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegativoExp(ANegativoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoExp(ABlocoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAChamadaExp(AChamadaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstanciaExp(AInstanciaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumeroExp(ANumeroExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdExp(AIdExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringExp(AStringExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATextoExp(ATextoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVerdadeExp(AVerdadeExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalsoExp(AFalsoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFamiliaFamilia(AFamiliaFamilia node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVazioFamilia(AVazioFamilia node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFamiliaFecho(AFamiliaFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARelacao(ARelacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpListaExp(AExpListaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVazioListaExp(AVazioListaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInitListaInit(AInitListaInit node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVazioListaInit(AVazioListaInit node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALInitFecho(ALInitFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInitObjeto(AInitObjeto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALExpFecho(ALExpFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdIdOuAttr(AIdIdOuAttr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAttrIdOuAttr(AAttrIdOuAttr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdFecho(AIdFecho node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATipoPrimitivo(ATipoPrimitivo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATipoMolde(ATipoMolde node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPrimitivo(TPrimitivo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNumero(TNumero node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVerdade(TVerdade node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalso(TFalso node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMolde(TMolde node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSe(TSe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEntao(TEntao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSenao(TSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPassa(TPassa node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPor(TPor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPontoVirgula(TPontoVirgula node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTContem(TContem node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConstante(TConstante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFuncao(TFuncao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTObjeto(TObjeto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFim(TFim node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSeparador(TSeparador node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDoisPontos(TDoisPontos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPontoFinal(TPontoFinal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAbreParenteses(TAbreParenteses node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFechaParenteses(TFechaParenteses node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAbreColchete(TAbreColchete node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFechaColchete(TFechaColchete node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAbreAspas(TAbreAspas node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMultiplicacao(TMultiplicacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSoma(TSoma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSubtracao(TSubtracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDivisao(TDivisao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTModulo(TModulo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgualIgual(TIgualIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgual(TIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorQue(TMenorQue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorIgual(TMenorIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTExclamacao(TExclamacao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTE(TE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOu(TOu node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEntrada(TEntrada node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVazio(TVazio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioLinha(TComentarioLinha node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdMolde(TIdMolde node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTexto(TTexto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBloco(TComentarioBloco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
