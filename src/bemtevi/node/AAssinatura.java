/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AAssinatura extends PAssinatura
{
    private PParametrosAssinatura _parametrosAssinatura_;

    public AAssinatura()
    {
        // Constructor
    }

    public AAssinatura(
        @SuppressWarnings("hiding") PParametrosAssinatura _parametrosAssinatura_)
    {
        // Constructor
        setParametrosAssinatura(_parametrosAssinatura_);

    }

    @Override
    public Object clone()
    {
        return new AAssinatura(
            cloneNode(this._parametrosAssinatura_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssinatura(this);
    }

    public PParametrosAssinatura getParametrosAssinatura()
    {
        return this._parametrosAssinatura_;
    }

    public void setParametrosAssinatura(PParametrosAssinatura node)
    {
        if(this._parametrosAssinatura_ != null)
        {
            this._parametrosAssinatura_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parametrosAssinatura_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._parametrosAssinatura_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parametrosAssinatura_ == child)
        {
            this._parametrosAssinatura_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parametrosAssinatura_ == oldChild)
        {
            setParametrosAssinatura((PParametrosAssinatura) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}