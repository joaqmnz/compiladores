/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AMenorIgualExp extends PExp
{
    private PExp _esq_;
    private PExp _dir_;

    public AMenorIgualExp()
    {
        // Constructor
    }

    public AMenorIgualExp(
        @SuppressWarnings("hiding") PExp _esq_,
        @SuppressWarnings("hiding") PExp _dir_)
    {
        // Constructor
        setEsq(_esq_);

        setDir(_dir_);

    }

    @Override
    public Object clone()
    {
        return new AMenorIgualExp(
            cloneNode(this._esq_),
            cloneNode(this._dir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMenorIgualExp(this);
    }

    public PExp getEsq()
    {
        return this._esq_;
    }

    public void setEsq(PExp node)
    {
        if(this._esq_ != null)
        {
            this._esq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._esq_ = node;
    }

    public PExp getDir()
    {
        return this._dir_;
    }

    public void setDir(PExp node)
    {
        if(this._dir_ != null)
        {
            this._dir_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dir_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._esq_)
            + toString(this._dir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._esq_ == child)
        {
            this._esq_ = null;
            return;
        }

        if(this._dir_ == child)
        {
            this._dir_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._esq_ == oldChild)
        {
            setEsq((PExp) newChild);
            return;
        }

        if(this._dir_ == oldChild)
        {
            setDir((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}