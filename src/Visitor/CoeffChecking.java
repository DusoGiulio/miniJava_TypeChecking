package Visitor;

import java.util.ArrayList;

import ASTnodes.Class.NodeAST;
import ASTnodes.Decl.ClassDecl;
import ASTnodes.Decl.MethDecl;
import ASTnodes.Decl.VarDecl;
import Exceptioin.TypeCheckingException;
import SymbolTable.ClassSymbolTable;
import TypeDescriptor.BoolTypeDescriptor;
import TypeDescriptor.ClassTypeDescriptor;
import TypeDescriptor.Coef;
import TypeDescriptor.ErrorTypeDescriptor;
import TypeDescriptor.IdTypeDescriptor;
import TypeDescriptor.TypeDescriptor;

public class CoeffChecking {

	private ArrayList<NodeAST> ast;
	private ClassSymbolTable classST;
	
	public CoeffChecking(ArrayList<NodeAST> ast, ClassSymbolTable classST) throws TypeCheckingException {

		this.ast=ast;
		this.classST=classST;
		//centerr� tutti i metodi che devono essere contenuti in una COEFFECT class

			if(this.visitProgram(this.ast)instanceof ErrorTypeDescriptor) 
			{
				throw new TypeCheckingException ();
			}
	}

	 
	private TypeDescriptor visitProgram(ArrayList<NodeAST> ast){
		for(NodeAST klass :  ast) 
		{
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				TypeDescriptor type=null;

				if(((ClassTypeDescriptor)c.getType()).isCoeff()== Coef.COEFF ) 
				{
					System.out.println("\n\tANALISI CLASSE COEFFECT: "+c.getIdClass().getName()+"\t\n");
					type =this.visitClassCoeff(c);
				}else if(((ClassTypeDescriptor)c.getType()).isCoeff()== Coef.SUBCOEF) 
				{
					System.out.println("\n\tANALISI CLASSE SUBCOEFFECT: "+c.getIdClass().getName()+"\t\n");
					type =this.visitClassSubCoeff(c);
				}
			
				if(type instanceof ErrorTypeDescriptor ) 
				{
					System.err.println("Nella Classe "+c.getIdClass().getName()+ " � presente un errore");
					return  new ErrorTypeDescriptor();
				}
			}
		}
		return null;
	}

	private TypeDescriptor visitClassSubCoeff(ClassDecl c) {
		return new BoolTypeDescriptor() ;
	}


	private TypeDescriptor visitClassCoeff(ClassDecl c) {

		if(this.containsAllMethCoeff(c.getMets(), c))
			{
				return new BoolTypeDescriptor();
			}
		return new ErrorTypeDescriptor() ;
	}
	
	private boolean containsAllMethCoeff(ArrayList<MethDecl> mets, ClassDecl c) {

		ArrayList<Boolean> meths= new ArrayList<Boolean>();
		for(MethDecl met:mets) 
		{//Se il metodo della classe e il metodo che deve esiste hanno lo stesso nome
			String nId= met.getId().getName();
			if(nId.equals("sup") ||nId.equals("sum") ||nId.equals("mult")) 
			{
				if(((IdTypeDescriptor)met.getRetType()).getNomeTipo().equals(c.getIdClass().getName()))	
				{
					if(met.getFormals().size()==1) 
					{	
						if(((IdTypeDescriptor)((VarDecl)met.getFormals().get(0)).getType()).getNomeTipo().equals(((ClassTypeDescriptor) c.getType()).getName()))
						{
							meths.add(true);
						}
					}
				}
			}else if(nId.equals("leq"))
			{
				if(met.getRetType() instanceof BoolTypeDescriptor)	
				{
					if(met.getFormals().size()==1) 
					{
						if(((IdTypeDescriptor)((VarDecl)met.getFormals().get(0)).getType()).getNomeTipo().equals(((ClassTypeDescriptor) c.getType()).getName()))
						{
							meths.add(true);
						}
					}
				}
					
			}else if(nId.equals("zero") || nId.equals("one")) 
			{
				if(((IdTypeDescriptor)met.getRetType()).getNomeTipo().equals(c.getIdClass().getName()))	
				{
					if(met.getFormals().size()==0) 
					{	
						meths.add(true);
					}
				}
					
			}
		}
		if(!meths.contains(false) && mets.size()==6 ) 
		{
			return true;
		}
		return false;	
	}
}
