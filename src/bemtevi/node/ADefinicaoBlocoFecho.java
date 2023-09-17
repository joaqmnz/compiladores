/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ADefinicaoBlocoFecho extends PBlocoFecho
{
    private PIdOuAttr _idOuAttr_;
    private PExp _exp_;

    public ADefinicaoBlocoFecho()
    {
        // Constructor
    }

    public ADefinicaoBlocoFecho(
        @SuppressWarnings("hiding") PIdOuAttr _idOuAttr_,
        @SuppressWarnings("hiding") PExp _exp_)
    {
        // Constructor
        setIdOuAttr(_idOuAttr_);

        setExp(_exp_);

    }

    @Override
    public Object clone()
    {
        return new ADefinicaoBlocoFecho(
            cloneNode(this._idOuAttr_),
            cloneNode(this._exp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefinicaoBlocoFecho(this);
    }

    public PIdOuAttr getIdOuAttr()
    {
        return this._idOuAttr_;
    }

    public void setIdOuAttr(PIdOuAttr node)
    {
        if(this._idOuAttr_ != null)
        {
            this._idOuAttr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._idOuAttr_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._idOuAttr_)
            + toString(this._exp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._idOuAttr_ == child)
        {
            this._idOuAttr_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._idOuAttr_ == oldChild)
        {
            setIdOuAttr((PIdOuAttr) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
