/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.analysis;

import java.util.*;
import bemtevi.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
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
        node.getEOF().apply(this);
        node.getPInicio().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getCent() != null)
        {
            node.getCent().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getDir() != null)
        {
            node.getDir().apply(this);
        }
        if(node.getEsq() != null)
        {
            node.getEsq().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PBlocoFecho> copy = new ArrayList<PBlocoFecho>(node.getBlocoFecho());
            Collections.reverse(copy);
            for(PBlocoFecho e : copy)
            {
                e.apply(this);
            }
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
        if(node.getListaExp() != null)
        {
            node.getListaExp().apply(this);
        }
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            Collections.reverse(copy);
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
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
        {
            List<PFamiliaFecho> copy = new ArrayList<PFamiliaFecho>(node.getFamiliaFecho());
            Collections.reverse(copy);
            for(PFamiliaFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getRelacao() != null)
        {
            node.getRelacao().apply(this);
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
        if(node.getRelacao() != null)
        {
            node.getRelacao().apply(this);
        }
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
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
        if(node.getDireito() != null)
        {
            node.getDireito().apply(this);
        }
        if(node.getEsquerdo() != null)
        {
            node.getEsquerdo().apply(this);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getTipoPrimitivo() != null)
        {
            node.getTipoPrimitivo().apply(this);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getTipoMolde() != null)
        {
            node.getTipoMolde().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getIdOuAttr() != null)
        {
            node.getIdOuAttr().apply(this);
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
        {
            List<PLExpFecho> copy = new ArrayList<PLExpFecho>(node.getLExpFecho());
            Collections.reverse(copy);
            for(PLExpFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
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
        {
            List<PLInitFecho> copy = new ArrayList<PLInitFecho>(node.getLInitFecho());
            Collections.reverse(copy);
            for(PLInitFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getInitObjeto() != null)
        {
            node.getInitObjeto().apply(this);
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
        if(node.getInitObjeto() != null)
        {
            node.getInitObjeto().apply(this);
        }
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            Collections.reverse(copy);
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getSeparador() != null)
        {
            node.getSeparador().apply(this);
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
        {
            List<PIdFecho> copy = new ArrayList<PIdFecho>(node.getIdFecho());
            Collections.reverse(copy);
            for(PIdFecho e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPontoFinal() != null)
        {
            node.getPontoFinal().apply(this);
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
}
