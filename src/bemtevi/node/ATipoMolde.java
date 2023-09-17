/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ATipoMolde extends PTipoMolde
{
    private TIdMolde _idMolde_;

    public ATipoMolde()
    {
        // Constructor
    }

    public ATipoMolde(
        @SuppressWarnings("hiding") TIdMolde _idMolde_)
    {
        // Constructor
        setIdMolde(_idMolde_);

    }

    @Override
    public Object clone()
    {
        return new ATipoMolde(
            cloneNode(this._idMolde_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATipoMolde(this);
    }

    public TIdMolde getIdMolde()
    {
        return this._idMolde_;
    }

    public void setIdMolde(TIdMolde node)
    {
        if(this._idMolde_ != null)
        {
            this._idMolde_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._idMolde_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._idMolde_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._idMolde_ == child)
        {
            this._idMolde_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._idMolde_ == oldChild)
        {
            setIdMolde((TIdMolde) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
