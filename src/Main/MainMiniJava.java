package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ANTLR4.miniJavaLexer;
import ANTLR4.miniJavaParser;
import ANTLR4.miniJavaParser.ProgramContext;
import ASTnodes.Class.NodeAST;
import Exceptioin.TypeCheckingException;
import Visitor.ASTGenerator;
import Visitor.CoeffChecking;
import Visitor.Fill_STC_STM;
import Visitor.TypeCheking;

public class MainMiniJava {
	public static void main(String[] args) throws IOException
	{
		//creo un char stream, posso inserire sia un file di testo che una stringa	
		FileInputStream inputStream=null;
		try 
		{
			//inputStream = new FileInputStream("src\\TestText\\generale.txt");
			//inputStream = new FileInputStream("src\\TestText\\mod_cast.txt");
			//inputStream = new FileInputStream("src\\TestText\\mod_iof.txt");
			//inputStream = new FileInputStream("src\\TestText\\mod_static_meth.txt");
			inputStream = new FileInputStream("src\\TestText\\Affinity.txt");
			//inputStream= new FileInputStream("src\\TestText\\Privacy.txt");
			//inputStream= new FileInputStream("src\\TestText\\Predef_Coeff.txt");
			//inputStream= new FileInputStream("src\\TestText\\Ext_Nat.txt");
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input = new  ANTLRInputStream(inputStream );
		//creo uno scanner utilizzando il lexer generato automaticamente da ANTLR4
		miniJavaLexer lexer = new miniJavaLexer(input);
		//creo una sequenza di token usando lo scanner
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		//Creo un parser usando il parser di ANTLR immettendo la sequenza dei token
		miniJavaParser parser = new miniJavaParser(tokens);
		// creo un albero di parsing partendo dal nodo prog che è il nodo di partenza della grammatica
		System.out.println("\tINIZIO PARSING\n//////////////////////////////////////");
		ProgramContext p= parser.program();
		if(parser.getNumberOfSyntaxErrors()==0)
		{
			System.out.println("\tPARSING PASSATO\n");
			//istanzio un nuovo visitor
			ASTGenerator visitor= new ASTGenerator();
			//eseguo la visita sull'albero
			ArrayList<NodeAST> AST=visitor.visitProgram(p);
			try 
			{
				Fill_STC_STM firstvisit = new Fill_STC_STM(AST);
				try 
				{
					System.out.println("\tINIZIO TYPE CHECKING\n//////////////////////////////////////");
					 new TypeCheking(AST, firstvisit.getClassST());
					System.out.println("//////////////////////////////////////\n\tTYPE CHECKING PASSATO");
					System.out.println("\tGESTIONE COEFFETTI\n//////////////////////////////////////");
					new CoeffChecking(AST, firstvisit.getClassST());
					
				} catch (TypeCheckingException e) 
				{
					System.err.println("//////////////////////////////////////\n\tTYPE CHECKING FALLITO");
				}
			} catch (TypeCheckingException e1) {}
		}
		else 
		{
    	System.err.println("//////////////////////////////////////\n\tPARSING FALLITO");
		}
	}
}