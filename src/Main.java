import bemtevi.parser.*;
import bemtevi.lexer.*;
import bemtevi.node.*;
import java.io.*;

public class Main
{
   public static void main(String[] args)
   {
      try
      {
         String arquivo = "../testes/teste.btv";
      
         Lexer lex = new Lexer(
               new PushbackReader(  
               new FileReader(arquivo), 1024));  
         
         Parser p = new Parser(lex); 
         
         Start tree = p.parse();
         
         tree.apply(new Semantico_2());

      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
   }
}