/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ARelacao extends PRelacao
{
    private TIdMolde _esquerdo_;
    private TIdMolde _direito_;

    public ARelacao()
    {
        // Constructor
    }

    public ARelacao(
        @SuppressWarnings("hiding") TIdMolde _esquerdo_,
        @SuppressWarnings("hiding") TIdMolde _direito_)
    {
        // Constructor
        setEsquerdo(_esquerdo_);

        setDireito(_direito_);

    }

    @Override
    public Object clone()
    {
        return new ARelacao(
            cloneNode(this._esquerdo_),
            cloneNode(this._direito_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARelacao(this);
    }

    public TIdMolde getEsquerdo()
    {
        return this._esquerdo_;
    }

    public void setEsquerdo(TIdMolde node)
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

    public TIdMolde getDireito()
    {
        return this._direito_;
    }

    public void setDireito(TIdMolde node)
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
            setEsquerdo((TIdMolde) newChild);
            return;
        }

        if(this._direito_ == oldChild)
        {
            setDireito((TIdMolde) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
