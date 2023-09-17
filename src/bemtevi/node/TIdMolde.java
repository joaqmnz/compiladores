/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class TIdMolde extends Token
{
    public TIdMolde(String text)
    {
        setText(text);
    }

    public TIdMolde(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIdMolde(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIdMolde(this);
    }
}