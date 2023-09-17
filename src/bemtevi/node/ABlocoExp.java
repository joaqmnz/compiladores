/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ABlocoExp extends PExp
{
    private PBlloco _blloco_;

    public ABlocoExp()
    {
        // Constructor
    }

    public ABlocoExp(
        @SuppressWarnings("hiding") PBlloco _blloco_)
    {
        // Constructor
        setBlloco(_blloco_);

    }

    @Override
    public Object clone()
    {
        return new ABlocoExp(
            cloneNode(this._blloco_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABlocoExp(this);
    }

    public PBlloco getBlloco()
    {
        return this._blloco_;
    }

    public void setBlloco(PBlloco node)
    {
        if(this._blloco_ != null)
        {
            this._blloco_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._blloco_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._blloco_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._blloco_ == child)
        {
            this._blloco_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._blloco_ == oldChild)
        {
            setBlloco((PBlloco) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
