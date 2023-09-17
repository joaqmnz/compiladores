/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AExpInicio extends PInicio
{
    private PExp _exp_;

    public AExpInicio()
    {
        // Constructor
    }

    public AExpInicio(
        @SuppressWarnings("hiding") PExp _exp_)
    {
        // Constructor
        setExp(_exp_);

    }

    @Override
    public Object clone()
    {
        return new AExpInicio(
            cloneNode(this._exp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpInicio(this);
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
            + toString(this._exp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
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
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
