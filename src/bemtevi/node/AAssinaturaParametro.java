/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AAssinaturaParametro extends PParametro
{
    private PAssinatura _assinatura_;

    public AAssinaturaParametro()
    {
        // Constructor
    }

    public AAssinaturaParametro(
        @SuppressWarnings("hiding") PAssinatura _assinatura_)
    {
        // Constructor
        setAssinatura(_assinatura_);

    }

    @Override
    public Object clone()
    {
        return new AAssinaturaParametro(
            cloneNode(this._assinatura_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssinaturaParametro(this);
    }

    public PAssinatura getAssinatura()
    {
        return this._assinatura_;
    }

    public void setAssinatura(PAssinatura node)
    {
        if(this._assinatura_ != null)
        {
            this._assinatura_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assinatura_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._assinatura_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._assinatura_ == child)
        {
            this._assinatura_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._assinatura_ == oldChild)
        {
            setAssinatura((PAssinatura) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
