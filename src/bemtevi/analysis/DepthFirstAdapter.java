/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.analysis;

import java.util.*;
import bemtevi.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPInicio().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAExpInicio(AExpInicio node)
    {
        defaultIn(node);
    }

    public void outAExpInicio(AExpInicio node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpInicio(AExpInicio node)
    {
        inAExpInicio(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAExpInicio(node);
    }

    public void inAFamiliaInicio(AFamiliaInicio node)
    {
        defaultIn(node);
    }

    public void outAFamiliaInicio(AFamiliaInicio node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFamiliaInicio(AFamiliaInicio node)
    {
        inAFamiliaInicio(node);
        if(node.getFamilia() != null)
        {
            node.getFamilia().apply(this);
        }
        outAFamiliaInicio(node);
    }

    public void inAFuncaoInicio(AFuncaoInicio node)
    {
        defaultIn(node);
    }

    public void outAFuncaoInicio(AFuncaoInicio node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncaoInicio(AFuncaoInicio node)
    {
        inAFuncaoInicio(node);
        if(node.getDecFuncao() != null)
        {
            node.getDecFuncao().apply(this);
        }
        outAFuncaoInicio(node);
    }

    public void inATernarioExp(ATernarioExp node)
    {
        defaultIn(node);
    }

    public void outATernarioExp(ATernarioExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATernarioExp(ATernarioExp node)
    {
        inATernarioExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getCent() != null)
        {
            node.getCent().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outATernarioExp(node);
    }

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        inAOuExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAOuExp(node);
    }

    public void inAEExp(AEExp node)
    {
        defaultIn(node);
    }

    public void outAEExp(AEExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEExp(AEExp node)
    {
        inAEExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAEExp(node);
    }

    public void inAComparacaoExp(AComparacaoExp node)
    {
        defaultIn(node);
    }

    public void outAComparacaoExp(AComparacaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComparacaoExp(AComparacaoExp node)
    {
        inAComparacaoExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAComparacaoExp(node);
    }

    public void inAMenorQueExp(AMenorQueExp node)
    {
        defaultIn(node);
    }

    public void outAMenorQueExp(AMenorQueExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorQueExp(AMenorQueExp node)
    {
        inAMenorQueExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAMenorQueExp(node);
    }

    public void inAMenorIgualExp(AMenorIgualExp node)
    {
        defaultIn(node);
    }

    public void outAMenorIgualExp(AMenorIgualExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorIgualExp(AMenorIgualExp node)
    {
        inAMenorIgualExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAMenorIgualExp(node);
    }

    public void inASomaExp(ASomaExp node)
    {
        defaultIn(node);
    }

    public void outASomaExp(ASomaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        inASomaExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outASomaExp(node);
    }

    public void inASubtracaoExp(ASubtracaoExp node)
    {
        defaultIn(node);
    }

    public void outASubtracaoExp(ASubtracaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubtracaoExp(ASubtracaoExp node)
    {
        inASubtracaoExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outASubtracaoExp(node);
    }

    public void inAMultiplicacaoExp(AMultiplicacaoExp node)
    {
        defaultIn(node);
    }

    public void outAMultiplicacaoExp(AMultiplicacaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiplicacaoExp(AMultiplicacaoExp node)
    {
        inAMultiplicacaoExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAMultiplicacaoExp(node);
    }

    public void inADivisaoExp(ADivisaoExp node)
    {
        defaultIn(node);
    }

    public void outADivisaoExp(ADivisaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivisaoExp(ADivisaoExp node)
    {
        inADivisaoExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outADivisaoExp(node);
    }

    public void inAModuloExp(AModuloExp node)
    {
        defaultIn(node);
    }

    public void outAModuloExp(AModuloExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModuloExp(AModuloExp node)
    {
        inAModuloExp(node);
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
        }
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        outAModuloExp(node);
    }

    public void inANegacaoExp(ANegacaoExp node)
    {
        defaultIn(node);
    }

    public void outANegacaoExp(ANegacaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegacaoExp(ANegacaoExp node)
    {
        inANegacaoExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANegacaoExp(node);
    }

    public void inANegativoExp(ANegativoExp node)
    {
        defaultIn(node);
    }

    public void outANegativoExp(ANegativoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegativoExp(ANegativoExp node)
    {
        inANegativoExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANegativoExp(node);
    }

    public void inABlocoExp(ABlocoExp node)
    {
        defaultIn(node);
    }

    public void outABlocoExp(ABlocoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocoExp(ABlocoExp node)
    {
        inABlocoExp(node);
        {
            List<PBlocoFecho> copy = new ArrayList<PBlocoFecho>(node.getBlocoFecho());
            for(PBlocoFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outABlocoExp(node);
    }

    public void inAChamadaExp(AChamadaExp node)
    {
        defaultIn(node);
    }

    public void outAChamadaExp(AChamadaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAChamadaExp(AChamadaExp node)
    {
        inAChamadaExp(node);
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getListaExp() != null)
        {
            node.getListaExp().apply(this);
        }
        outAChamadaExp(node);
    }

    public void inAInstanciaExp(AInstanciaExp node)
    {
        defaultIn(node);
    }

    public void outAInstanciaExp(AInstanciaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstanciaExp(AInstanciaExp node)
    {
        inAInstanciaExp(node);
        if(node.getListaInit() != null)
        {
            node.getListaInit().apply(this);
        }
        outAInstanciaExp(node);
    }

    public void inANumeroExp(ANumeroExp node)
    {
        defaultIn(node);
    }

    public void outANumeroExp(ANumeroExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumeroExp(ANumeroExp node)
    {
        inANumeroExp(node);
        if(node.getNumero() != null)
        {
            node.getNumero().apply(this);
        }
        outANumeroExp(node);
    }

    public void inAIdExp(AIdExp node)
    {
        defaultIn(node);
    }

    public void outAIdExp(AIdExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdExp(AIdExp node)
    {
        inAIdExp(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdExp(node);
    }

    public void inAStringExp(AStringExp node)
    {
        defaultIn(node);
    }

    public void outAStringExp(AStringExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringExp(AStringExp node)
    {
        inAStringExp(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringExp(node);
    }

    public void inATextoExp(ATextoExp node)
    {
        defaultIn(node);
    }

    public void outATextoExp(ATextoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATextoExp(ATextoExp node)
    {
        inATextoExp(node);
        if(node.getTexto() != null)
        {
            node.getTexto().apply(this);
        }
        outATextoExp(node);
    }

    public void inAVerdadeExp(AVerdadeExp node)
    {
        defaultIn(node);
    }

    public void outAVerdadeExp(AVerdadeExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVerdadeExp(AVerdadeExp node)
    {
        inAVerdadeExp(node);
        if(node.getVerdade() != null)
        {
            node.getVerdade().apply(this);
        }
        outAVerdadeExp(node);
    }

    public void inAFalsoExp(AFalsoExp node)
    {
        defaultIn(node);
    }

    public void outAFalsoExp(AFalsoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalsoExp(AFalsoExp node)
    {
        inAFalsoExp(node);
        if(node.getFalso() != null)
        {
            node.getFalso().apply(this);
        }
        outAFalsoExp(node);
    }

    public void inAFamiliaFamilia(AFamiliaFamilia node)
    {
        defaultIn(node);
    }

    public void outAFamiliaFamilia(AFamiliaFamilia node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFamiliaFamilia(AFamiliaFamilia node)
    {
        inAFamiliaFamilia(node);
        if(node.getRelacao() != null)
        {
            node.getRelacao().apply(this);
        }
        {
            List<PFamiliaFecho> copy = new ArrayList<PFamiliaFecho>(node.getFamiliaFecho());
            for(PFamiliaFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAFamiliaFamilia(node);
    }

    public void inAVazioFamilia(AVazioFamilia node)
    {
        defaultIn(node);
    }

    public void outAVazioFamilia(AVazioFamilia node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioFamilia(AVazioFamilia node)
    {
        inAVazioFamilia(node);
        outAVazioFamilia(node);
    }

    public void inAFamiliaFecho(AFamiliaFecho node)
    {
        defaultIn(node);
    }

    public void outAFamiliaFecho(AFamiliaFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFamiliaFecho(AFamiliaFecho node)
    {
        inAFamiliaFecho(node);
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        if(node.getRelacao() != null)
        {
            node.getRelacao().apply(this);
        }
        outAFamiliaFecho(node);
    }

    public void inARelacao(ARelacao node)
    {
        defaultIn(node);
    }

    public void outARelacao(ARelacao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARelacao(ARelacao node)
    {
        inARelacao(node);
        if(node.getEsquerdo() != null)
        {
            node.getEsquerdo().apply(this);
        }
        if(node.getDireito() != null)
        {
            node.getDireito().apply(this);
        }
        outARelacao(node);
    }

    public void inAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        defaultIn(node);
    }

    public void outAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        inAConstanteBlocoFecho(node);
        if(node.getTipoPrimitivo() != null)
        {
            node.getTipoPrimitivo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAConstanteBlocoFecho(node);
    }

    public void inAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        defaultIn(node);
    }

    public void outAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        inAObjetoBlocoFecho(node);
        if(node.getTipoMolde() != null)
        {
            node.getTipoMolde().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAObjetoBlocoFecho(node);
    }

    public void inADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        defaultIn(node);
    }

    public void outADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        inADefinicaoBlocoFecho(node);
        if(node.getIdOuAttr() != null)
        {
            node.getIdOuAttr().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outADefinicaoBlocoFecho(node);
    }

    public void inAExpListaExp(AExpListaExp node)
    {
        defaultIn(node);
    }

    public void outAExpListaExp(AExpListaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpListaExp(AExpListaExp node)
    {
        inAExpListaExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PLExpFecho> copy = new ArrayList<PLExpFecho>(node.getLExpFecho());
            for(PLExpFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAExpListaExp(node);
    }

    public void inAVazioListaExp(AVazioListaExp node)
    {
        defaultIn(node);
    }

    public void outAVazioListaExp(AVazioListaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioListaExp(AVazioListaExp node)
    {
        inAVazioListaExp(node);
        outAVazioListaExp(node);
    }

    public void inAInitListaInit(AInitListaInit node)
    {
        defaultIn(node);
    }

    public void outAInitListaInit(AInitListaInit node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInitListaInit(AInitListaInit node)
    {
        inAInitListaInit(node);
        if(node.getInitObjeto() != null)
        {
            node.getInitObjeto().apply(this);
        }
        {
            List<PLInitFecho> copy = new ArrayList<PLInitFecho>(node.getLInitFecho());
            for(PLInitFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAInitListaInit(node);
    }

    public void inAVazioListaInit(AVazioListaInit node)
    {
        defaultIn(node);
    }

    public void outAVazioListaInit(AVazioListaInit node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioListaInit(AVazioListaInit node)
    {
        inAVazioListaInit(node);
        outAVazioListaInit(node);
    }

    public void inALInitFecho(ALInitFecho node)
    {
        defaultIn(node);
    }

    public void outALInitFecho(ALInitFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALInitFecho(ALInitFecho node)
    {
        inALInitFecho(node);
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
        }
        if(node.getInitObjeto() != null)
        {
            node.getInitObjeto().apply(this);
        }
        outALInitFecho(node);
    }

    public void inAInitObjeto(AInitObjeto node)
    {
        defaultIn(node);
    }

    public void outAInitObjeto(AInitObjeto node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInitObjeto(AInitObjeto node)
    {
        inAInitObjeto(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAInitObjeto(node);
    }

    public void inALExpFecho(ALExpFecho node)
    {
        defaultIn(node);
    }

    public void outALExpFecho(ALExpFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALExpFecho(ALExpFecho node)
    {
        inALExpFecho(node);
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outALExpFecho(node);
    }

    public void inAIdIdOuAttr(AIdIdOuAttr node)
    {
        defaultIn(node);
    }

    public void outAIdIdOuAttr(AIdIdOuAttr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdIdOuAttr(AIdIdOuAttr node)
    {
        inAIdIdOuAttr(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdIdOuAttr(node);
    }

    public void inAAttrIdOuAttr(AAttrIdOuAttr node)
    {
        defaultIn(node);
    }

    public void outAAttrIdOuAttr(AAttrIdOuAttr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAttrIdOuAttr(AAttrIdOuAttr node)
    {
        inAAttrIdOuAttr(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAAttrIdOuAttr(node);
    }

    public void inAIdFecho(AIdFecho node)
    {
        defaultIn(node);
    }

    public void outAIdFecho(AIdFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdFecho(AIdFecho node)
    {
        inAIdFecho(node);
        if(node.getPontoFinal() != null)
        {
            node.getPontoFinal().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdFecho(node);
    }

    public void inATipoPrimitivo(ATipoPrimitivo node)
    {
        defaultIn(node);
    }

    public void outATipoPrimitivo(ATipoPrimitivo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoPrimitivo(ATipoPrimitivo node)
    {
        inATipoPrimitivo(node);
        if(node.getPrimitivo() != null)
        {
            node.getPrimitivo().apply(this);
        }
        outATipoPrimitivo(node);
    }

    public void inATipoMolde(ATipoMolde node)
    {
        defaultIn(node);
    }

    public void outATipoMolde(ATipoMolde node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoMolde(ATipoMolde node)
    {
        inATipoMolde(node);
        if(node.getIdMolde() != null)
        {
            node.getIdMolde().apply(this);
        }
        outATipoMolde(node);
    }

    public void inAPrimitivoTipo(APrimitivoTipo node)
    {
        defaultIn(node);
    }

    public void outAPrimitivoTipo(APrimitivoTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrimitivoTipo(APrimitivoTipo node)
    {
        inAPrimitivoTipo(node);
        if(node.getTipoPrimitivo() != null)
        {
            node.getTipoPrimitivo().apply(this);
        }
        outAPrimitivoTipo(node);
    }

    public void inAMoldeTipo(AMoldeTipo node)
    {
        defaultIn(node);
    }

    public void outAMoldeTipo(AMoldeTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoldeTipo(AMoldeTipo node)
    {
        inAMoldeTipo(node);
        if(node.getTipoMolde() != null)
        {
            node.getTipoMolde().apply(this);
        }
        outAMoldeTipo(node);
    }

    public void inAFunc2DecFuncao(AFunc2DecFuncao node)
    {
        defaultIn(node);
    }

    public void outAFunc2DecFuncao(AFunc2DecFuncao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunc2DecFuncao(AFunc2DecFuncao node)
    {
        inAFunc2DecFuncao(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getParametros() != null)
        {
            node.getParametros().apply(this);
        }
        outAFunc2DecFuncao(node);
    }

    public void inAParametroParametros(AParametroParametros node)
    {
        defaultIn(node);
    }

    public void outAParametroParametros(AParametroParametros node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametroParametros(AParametroParametros node)
    {
        inAParametroParametros(node);
        if(node.getParametro() != null)
        {
            node.getParametro().apply(this);
        }
        {
            List<PParametroFecho> copy = new ArrayList<PParametroFecho>(node.getParametroFecho());
            for(PParametroFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAParametroParametros(node);
    }

    public void inAVazioParametros(AVazioParametros node)
    {
        defaultIn(node);
    }

    public void outAVazioParametros(AVazioParametros node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioParametros(AVazioParametros node)
    {
        inAVazioParametros(node);
        outAVazioParametros(node);
    }

    public void inAParametroFecho(AParametroFecho node)
    {
        defaultIn(node);
    }

    public void outAParametroFecho(AParametroFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametroFecho(AParametroFecho node)
    {
        inAParametroFecho(node);
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
        }
        if(node.getParametro() != null)
        {
            node.getParametro().apply(this);
        }
        outAParametroFecho(node);
    }

    public void inAIdParametro(AIdParametro node)
    {
        defaultIn(node);
    }

    public void outAIdParametro(AIdParametro node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdParametro(AIdParametro node)
    {
        inAIdParametro(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdParametro(node);
    }

    public void inAAssinaturaParametro(AAssinaturaParametro node)
    {
        defaultIn(node);
    }

    public void outAAssinaturaParametro(AAssinaturaParametro node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssinaturaParametro(AAssinaturaParametro node)
    {
        inAAssinaturaParametro(node);
        if(node.getAssinatura() != null)
        {
            node.getAssinatura().apply(this);
        }
        outAAssinaturaParametro(node);
    }

    public void inAAssinatura(AAssinatura node)
    {
        defaultIn(node);
    }

    public void outAAssinatura(AAssinatura node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssinatura(AAssinatura node)
    {
        inAAssinatura(node);
        if(node.getParametrosAssinatura() != null)
        {
            node.getParametrosAssinatura().apply(this);
        }
        outAAssinatura(node);
    }

    public void inAParametrosAssinatura(AParametrosAssinatura node)
    {
        defaultIn(node);
    }

    public void outAParametrosAssinatura(AParametrosAssinatura node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametrosAssinatura(AParametrosAssinatura node)
    {
        inAParametrosAssinatura(node);
        if(node.getParametroAssinatura() != null)
        {
            node.getParametroAssinatura().apply(this);
        }
        {
            List<PParametrosAssinaturaFecho> copy = new ArrayList<PParametrosAssinaturaFecho>(node.getParametrosAssinaturaFecho());
            for(PParametrosAssinaturaFecho e : copy)
            {
                e.apply(this);
            }
        }
        outAParametrosAssinatura(node);
    }

    public void inAVazioParametrosAssinatura(AVazioParametrosAssinatura node)
    {
        defaultIn(node);
    }

    public void outAVazioParametrosAssinatura(AVazioParametrosAssinatura node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioParametrosAssinatura(AVazioParametrosAssinatura node)
    {
        inAVazioParametrosAssinatura(node);
        outAVazioParametrosAssinatura(node);
    }

    public void inAParametrosAssinaturaFecho(AParametrosAssinaturaFecho node)
    {
        defaultIn(node);
    }

    public void outAParametrosAssinaturaFecho(AParametrosAssinaturaFecho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametrosAssinaturaFecho(AParametrosAssinaturaFecho node)
    {
        inAParametrosAssinaturaFecho(node);
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
        }
        if(node.getParametroAssinatura() != null)
        {
            node.getParametroAssinatura().apply(this);
        }
        outAParametrosAssinaturaFecho(node);
    }

    public void inATipoParametroAssinatura(ATipoParametroAssinatura node)
    {
        defaultIn(node);
    }

    public void outATipoParametroAssinatura(ATipoParametroAssinatura node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoParametroAssinatura(ATipoParametroAssinatura node)
    {
        inATipoParametroAssinatura(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        outATipoParametroAssinatura(node);
    }

    public void inAAssinaturaParametroAssinatura(AAssinaturaParametroAssinatura node)
    {
        defaultIn(node);
    }

    public void outAAssinaturaParametroAssinatura(AAssinaturaParametroAssinatura node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssinaturaParametroAssinatura(AAssinaturaParametroAssinatura node)
    {
        inAAssinaturaParametroAssinatura(node);
        if(node.getAssinatura() != null)
        {
            node.getAssinatura().apply(this);
        }
        outAAssinaturaParametroAssinatura(node);
    }
}
