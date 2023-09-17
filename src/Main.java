import bemtevi.parser.*;
import bemtevi.lexer.*;
import bemtevi.node.*;
import java.io.*;
import bemtevi.ASTDisplay;
import bemtevi.ASTPrinter;

public class Main
{
 public static void main(String[] args)
 {
  try
  {
   String arquivo = "../teste/teste.calc";
  
   Lexer lex = new Lexer(
		    new PushbackReader(  
		    new FileReader(arquivo), 1024));
   
   Lexer lexer = new Lexer(
		    new PushbackReader(  
		    new FileReader(arquivo), 1024));
   
   // Token token;
	// while(!((token = lexer.next()) instanceof EOF)) {
	// 	System.out.println(token.getClass());
	// 	System.out.println(" ( "+token.toString()+")");
	// }   
   
   Parser p = new Parser(lex); 
   
   Start tree = p.parse();
   //Imprime árvore na saída padrão
   tree.apply(new ASTPrinter());

   System.out.println("\n\n");

   //Imprime árvore em interface gráfica
   tree.apply(new ASTDisplay());
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
 }
}