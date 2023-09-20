/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ASomaExp extends PExp
{
    private PExp _esquerdo_;
    private PExp _direito_;

    public ASomaExp()
    {
        // Constructor
    }

    public ASomaExp(
        @SuppressWarnings("hiding") PExp _esquerdo_,
        @SuppressWarnings("hiding") PExp _direito_)
    {
        // Constructor
        setEsquerdo(_esquerdo_);

        setDireito(_direito_);

    }

    @Override
    public Object clone()
    {
        return new ASomaExp(
            cloneNode(this._esquerdo_),
            cloneNode(this._direito_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASomaExp(this);
    }

    public PExp getEsquerdo()
    {
        return this._esquerdo_;
    }

    public void setEsquerdo(PExp node)
    {
        if(this._esquerdo_ != null)
        {
            this._esquerdo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._esquerdo_ = node;
    }

    public PExp getDireito()
    {
        return this._direito_;
    }

    public void setDireito(PExp node)
    {
        if(this._direito_ != null)
        {
            this._direito_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._direito_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._esquerdo_)
            + toString(this._direito_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._esquerdo_ == child)
        {
            this._esquerdo_ = null;
            return;
        }

        if(this._direito_ == child)
        {
            this._direito_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._esquerdo_ == oldChild)
        {
            setEsquerdo((PExp) newChild);
            return;
        }

        if(this._direito_ == oldChild)
        {
            setDireito((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
