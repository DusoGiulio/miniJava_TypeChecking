package Visitor;

import java.util.ArrayList;
import ASTnodes.Class.*;
import ASTnodes.Decl.*;
import ASTnodes.Exp.*;
import ASTnodes.Exp.Boolean;
import ASTnodes.Stm.*;
import Exceptioin.TypeCheckingException;
import SymbolTable.*;
import TypeDescriptor.*;

public class TypeCheking {
	private ArrayList<NodeAST> ast;
	private ClassSymbolTable classST;
	private SymbolTable bTable;
	private SymbolTable cTable;
	private ClassDecl actualClass;
	private boolean arrelem;
	private boolean isStatic;

	public TypeCheking(ArrayList<NodeAST> ast, ClassSymbolTable classST)  throws TypeCheckingException {
		this.ast=ast;
		this.classST=classST;
		this.arrelem=false;
			if(this.visitProgram(this.ast)instanceof ErrorTypeDescriptor) 
			{
				throw new TypeCheckingException ();
			}

	}
//se ogni classe non ritorna errore allora ritorno non lancio eccezioni, senno lancio un eccezione di tipo TypeCheckingexception
	private TypeDescriptor visitProgram(ArrayList<NodeAST> ast){
		for(NodeAST klass :  ast) 
		{
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				System.out.println("\n\tANALISI CLASSE "+c.getIdClass().getName()+"\t\n");
				this.setActualClass(c);
				TypeDescriptor type=this.visitClass(c);
				if(type instanceof ErrorTypeDescriptor ) 
				{
					System.err.println("Nella Classe "+c.getIdClass().getName()+ " è presente un errore");
					return  new ErrorTypeDescriptor();
				}
			}
		}
		//se tutte le clasi sono ok analizzo la classe main
		for(NodeAST klass : ast) 
		{
			if(klass instanceof MainClass) 
			{
				System.out.println("\n\tANALISI MAIN\t\n");
				MainClass c= (MainClass) klass;
				TypeDescriptor type=this.visitMain(c);
				if(type instanceof ErrorTypeDescriptor ) 
					{
						System.err.println("Nella Classe "+c.getIdClass().getName()+ " è presente un errore");
						return  new ErrorTypeDescriptor();
					}
			}

		}	
		return  new BoolTypeDescriptor();
	}
//Se l'exp riotorna errore allora ritornerò errore se ritorna un tipo allora sarà ok
	private TypeDescriptor visitMain(MainClass c) {
		TypeDescriptor t= this.vistiExp(c.getExp());
		if(t!=null) 
		{	
			return t;
		}
		return new IntTypeDescriptor();
		
	}
//se tutti i body dei metodi sono ok allora ritorno il tipo della classe senno ritono errore
	private TypeDescriptor visitClass(ClassDecl c) {
		for(MethDecl met :c.getMets()) 
		{
			//creo una nuova symboltable per il body
			this.bTable= new SymbolTable();
			this.isStatic= ((MethTypeDescriptor)met.getType()).isStatic();
			//inserisco in questa symboltable le variabili dichiarate nell'intestazione del metodo
			for(VarDecl var: met.getFormals()) 
			{
				this.bTable.enter(var.getId(), var.getType());
			}
			//invoco la visita del body, passandogli il body e la symboltable ad esso associata
			this.cTable= this.getClassST().lookup(c.getIdClass().getName()).getST();
			TypeDescriptor type= this.visitBody(met.getBody());
			//svuoto la symboltable temporanea
			this.bTable.closeScope();
			if(type instanceof ClassTypeDescriptor) 
			{
				if(((ClassTypeDescriptor)type).getName().equals(((IdTypeDescriptor)met.getRetType()).getNomeTipo()))
				{
					return type;
				}else if(this.getClassST().lookup(((ClassTypeDescriptor)type).getName()).getListofextclass().contains(((IdTypeDescriptor)met.getRetType()).getNomeTipo())) 
				{
					return type;
				}
			}
			if(type instanceof ErrorTypeDescriptor ) 
			{				
				return new ErrorTypeDescriptor();
			}else if(type.getClass() != met.getRetType().getClass()) 
			{
				return new ErrorTypeDescriptor();
			}
			this.isStatic=false;//andare a exp if
		}
		return c.getType();
	}
		
//il body può ritornare eerore oppure se è tutto corretto ritornera il tipo di ritorno dell'exp
	private TypeDescriptor visitBody(Body body) {
		//per ogni variabile presente nel body la aggiungo alla symboltable del body solo se non è già stata dichiarata
		for(VarDecl var: body.getDecs()) 
		{//se la variabile non esiste nella Symboltable della classe e in quella del body
			if(!this.Exist(var,this.bTable) && !this.Exist(var,this.cTable)) 
			{
				this.bTable.enter(var.getId(), var.getType());
			}
		}
		
		for(Stm stm: body.getStms()) 
		{
			TypeDescriptor type= this.vistiStm(stm);
			if(type instanceof ErrorTypeDescriptor ) 
			{
				return new ErrorTypeDescriptor();
			}
		}
		System.out.println("\tRETURN\t");
		return this.vistiExp(body.getRetExp());		
	}

//ritona il suo tipo oppure err
		private TypeDescriptor vistiStm(Stm stm) {
			/*algoritmo da eseguire sia per ARRAYASSIGN che per ASSIGN; se this.visitExp(dotExp) ritorna un tipo classe allora devo controllare
			 * che l'identifcatore sia uguale ad una variabile presente nella symboltable solo se è VarDecl, se così è ritorno il tipo come già
			 * faccio senno esco da tutto e rilascio errore 
			 * */
			if(stm instanceof ARRAYASSIGN ) 
			{
				if(this.vistiExp(((ARRAYASSIGN) stm).getLExp()) instanceof IntTypeDescriptor)
				{
					System.out.println("\tArrayAssign\t");
					TypeDescriptor  type= this.vistiExp(((ARRAYASSIGN) stm).getRexp());
					if(((ArrayTypeDescriptor)this.getTypeDesc(((ARRAYASSIGN) stm).getId())).getElement().getClass() == type.getClass() ) 
					{
						return type; 
					}
				}
			}else if(stm instanceof ASSIGN ) 
			{
				System.out.println("\tASSIGN(=)\t");
				TypeDescriptor  type= this.vistiExp(((ASSIGN) stm).getLExp());				
				if(this.getTypeDesc(((ASSIGN) stm).getId()).getClass() == type.getClass() ) 
				{
					return type; 
				}else if(type instanceof ClassTypeDescriptor && this.getTypeDesc(((ASSIGN) stm).getId())instanceof IdTypeDescriptor) 
				{
					IdTypeDescriptor id=(IdTypeDescriptor) this.getTypeDesc(((ASSIGN) stm).getId());
					if(id.getNomeTipo().equals(((ClassTypeDescriptor)type).getName())) 
					{
						return type;
					}else if(this.getClassST().lookup(((ClassTypeDescriptor)type).getName()).getListofextclass().contains(id.getNomeTipo())) 
					{
						return type;
					}
				}				
			}else if(stm instanceof IF) 
			{
				System.out.println("\tIF-ELSE\t");
				if(this.vistiExp(((IF) stm).getExp()) instanceof BoolTypeDescriptor && (this.vistiStm(((IF) stm).getIfstm())).getClass()!=ErrorTypeDescriptor.class && (this.vistiStm(((IF) stm).getElsestm())).getClass()!=ErrorTypeDescriptor.class)
				{
					return new BoolTypeDescriptor();
				}
			}else if(stm instanceof SOP) 
			{
				System.out.println("\tSystemOutPrintln\t");
				if(this.vistiExp(((SOP) stm).getLExp()).getClass()!=ErrorTypeDescriptor.class) 
				{
					return new BoolTypeDescriptor();
				}
			}else if(stm instanceof WHILE) 
			{
				System.out.println("\tWHILE\t");
				if((this.vistiExp(((WHILE) stm).getExp()) instanceof BoolTypeDescriptor && this.vistiStm(((WHILE) stm).getStm1()).getClass()!=ErrorTypeDescriptor.class ))
				{				
					return new BoolTypeDescriptor();
				}
			}else if(stm instanceof Multi) 
			{
				System.out.println("\tMULTI\t");
				for(Stm s: ((Multi)stm).getStms()) 
				{
					if(this.vistiStm(s).getClass()== ErrorTypeDescriptor.class) 
					{
						return new ErrorTypeDescriptor();
					}
				}
				return new BoolTypeDescriptor();
			}
			return new ErrorTypeDescriptor();
		}
				
		//ritona il suo tipo oppure err
		private TypeDescriptor vistiExp(Exp exp) {
			//BINOP se i tip a dx e sx sono uguali e fra di loro esiste <,>,&&,|| allora ritorn un tipo booleano, in caso contrario cioè se esiste
			// fra le due espressioni +,-,*,/,= allora ritorno un tipo intero, se i due tipi delle espressioni a dx e sinistra non sono uguali allora 
			//ritorno errore
			if(exp instanceof BinOp ) 
			{
				TypeDescriptor TypeLexp=this.vistiExp(((BinOp)exp).getLexp());
				TypeDescriptor TypeRexp=this.vistiExp(((BinOp)exp).getRexp());
				if(TypeLexp.getClass() == TypeRexp.getClass())
				{
					if((((BinOp)exp).getOp().getText()).equals("=")) 
					{					System.out.println("BinOp--> Arr "+((BinOp)exp).getOp());
										return this.vistiExp(((BinOp)exp).getLexp());
					}
					else if( TypeLexp instanceof IntTypeDescriptor && (((BinOp)exp).getOp().getText()).equals(">") || (((BinOp)exp).getOp().getText()).equals("<") ) 
					{
						System.out.println("BinOp--> Bool "+((BinOp)exp).getOp());
						return new BoolTypeDescriptor();
					}
					else if(TypeLexp instanceof BoolTypeDescriptor &&  (((BinOp)exp).getOp().getText()).equals("&&") || (((BinOp)exp).getOp().getText()).equals("||")) 
					{
						System.out.println("BinOp--> Bool "+((BinOp)exp).getOp());
						return new BoolTypeDescriptor();
					}
					else 
					{
						System.out.println("BiOp--> Int "+((BinOp)exp).getOp());
						return new IntTypeDescriptor();
					}

				}
			}
			//UNIOP se il tipo di ritorno dell'espressione è booleano allora posso ritornare un tipo booleano, senò tornerò un tipo errore
			else if(exp instanceof UnaryOp) 
			{
				if(this.vistiExp(((UnaryOp)exp).getExp()) instanceof BoolTypeDescriptor) 
				{
					System.out.println("Uniop");
					return new BoolTypeDescriptor();
				}
			}
			//BOOLEAN
			else if(exp instanceof Boolean) 
			{
				System.out.println("TypeBool");
				return new BoolTypeDescriptor();
			}
			//INT
			else if(exp instanceof Decimal) 
			{
				System.out.println("TypeInt");
				return new IntTypeDescriptor();
			}
			//Parentesi ritorno il tipo dell'espressione fra parentesi
			else if(exp instanceof Paren)
			{
				System.out.println("Paren");
				 return this.vistiExp(((Paren)exp).getExp());
			}
			//IDENTIFIER ritorno il tipo dell'ID fra parentesi 
			else if(exp instanceof Id) 
			{
				System.out.println("TypeID:"+((IdTypeDescriptor)((Id)exp).getType()).getNomeTipo());
				if(this.getTypeDesc(((IdTypeDescriptor)((Id)exp).getType()).getNomeTipo()) instanceof ArrayTypeDescriptor) 
				{
					this.arrelem=true;
				}
				//ritorno il tipo dell'identificatore se non esiste ritornerò un <error Type descriptor
					return this.getTypeDesc(((IdTypeDescriptor)((Id)exp).getType()).getNomeTipo());
			}
			//THIS deve ritornare il tipo della classe che attulmente viene scansionanta
			else if(exp instanceof This) 
			{	System.out.println("This");
				if(!this.isStatic) 
				{
					return this.getActualClass().getType();
				}
			}
			//ARRAY ELEM
			else if(exp instanceof ArrElem) 
			{
			//se il tipo descritto dalla prima espressine è di tipo Array e la posizione indicata nella seconda è intero ritorno
				//il tipo contenuto all'interno dell'array
				TypeDescriptor TypeExp=this.vistiExp(((ArrElem)exp).getExp());
				
				if( TypeExp instanceof ArrayTypeDescriptor && this.vistiExp(((ArrElem)exp).getExpEl()) instanceof IntTypeDescriptor) 
				{	System.out.println("ArrElem");
					return ((ArrayTypeDescriptor)TypeExp).getElement();
				}
				//Lenght
			}else if(exp instanceof Lenght) 
			{System.out.println("Lenght");
			
				if(this.vistiExp(((Lenght)exp).getExp()).getClass() != ErrorTypeDescriptor.class && this.arrelem) 
				{	
					return new IntTypeDescriptor();
				}
			//CAST
			}else if(exp instanceof Cast) 
			{
				System.out.println("CAST  ");
			
				TypeDescriptor TypeExp=this.vistiExp(((Cast)exp).getExp());
				if(TypeExp instanceof IdTypeDescriptor)
				{
					//se  l'Id (dx)fra parentesi è una classe
					if(this.getClassST().lookup(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo()) !=null)
						{
							//prendo il nome della classe dx
							String classdx=((IdTypeDescriptor)TypeExp).getNomeTipo(); 
							if(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo().equals(classdx))
								{
									return this.getTypeDesc(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo());
								}
							//se la classe a destra non ha una lista di superclassi	
							if( this.getClassST().lookup(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo()).getListofextclass() !=null) 
								{//se il nome della classe a dx è un supertipo della classe a sx
									if((this.getClassST().lookup(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo())).getListofextclass().contains(classdx) ) 
										{
											return this.getTypeDesc(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo());
										}
								}
							//se la classe a dx è sottotipo  della classe di sx
							if((this.getClassST().lookup(classdx).getListofextclass()).contains(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo()))
							{
								return this.getTypeDesc(((IdTypeDescriptor)((Cast)exp).getType()).getNomeTipo());
							}
						}
				}
			}
			//callfunc
			else if(exp instanceof CallFuncObj) 
			{
				System.out.println("call func obj");
				TypeDescriptor ctl = this.vistiExp(((CallFuncObj)exp).getLexp());
				
				if(ctl instanceof ClassTypeDescriptor)
				{
					ClassTypeDescriptor ctd= (ClassTypeDescriptor) ctl;
					for(NodeAST klass :  this.ast) 
					{
						if(klass instanceof ClassDecl) 
						{
							ClassDecl c= (ClassDecl) klass;
							boolean contains=false;
							if( (this.getClassST().lookup(ctd.getName()).getListofextclass())!=null) 
							{
								contains= this.getClassST().lookup(ctd.getName()).getListofextclass().contains(c.getIdClass().getName());
							}
							//se il nome dellla classe è uguale
							if(c.getIdClass().getName().equals(ctd.getName()) || contains ) 
							{					
								for(MethDecl met: c.getMets()) 
								{
									//se il nome del metodo è uguale
									if(met.getId().getName().equals(((IdTypeDescriptor)((CallFuncObj)exp).getType()).getNomeTipo())) 
									{
										int i =0;
										boolean flag= false;
										for(Exp expession : ((CallFuncObj)exp).getRexp()) 
										{
											if(this.vistiExp(expession).getClass() == met.getFormals().get(i).getType().getClass()) 
											{
												i++;
											}else 
											{
												flag=true;
												i++;
											}
										}
										if(flag==false) 
										{
											
											if(met.getRetType() instanceof IdTypeDescriptor) 
											{
												return this.getTypeDesc(((IdTypeDescriptor)met.getRetType()).getNomeTipo());
											}
											return met.getRetType();
										}
									}
								}
							}

						}
							
					}				
				}
			}else if (exp instanceof New) 
			{	
				if(((New)exp).getExp()==null) 
				{
					System.out.println("NEW class type ");
					return this.getTypeDesc(((IdTypeDescriptor)((New)exp).getType()).getNomeTipo());
				}else 
				{
					TypeDescriptor TypeExp= this.vistiExp(((New)exp).getExp());
					if(TypeExp instanceof IntTypeDescriptor || TypeExp instanceof BoolTypeDescriptor) 
					{System.out.println("NEW  type ");
						return ((New)exp).getType();
					}
				}
			} else if(exp instanceof Instanceof) 
			{
				if(this.getClassST().lookup(((IdTypeDescriptor)((Instanceof)exp).getType()).getNomeTipo())!= null) 
				{	
					if(this.vistiExp(((Instanceof)exp).getExp()) instanceof IdTypeDescriptor) 
					{	
						return new BoolTypeDescriptor();
					}
				}
			}
			return new ErrorTypeDescriptor();
			
		}

		private TypeDescriptor getTypeDesc(String id) {
			//se id è presente nella tabella delle classi allora ritorno il tipo della classe
			if(this.classST.lookup(id)!= null) 
			{
				for(NodeAST klass :  ast) 
				{
					if(klass instanceof ClassDecl) 
					{
						ClassDecl c= (ClassDecl) klass;
						if(id.equals(c.getIdClass().getName())) 
						{
							return c.getType();
						}
					}
				}
			}
			//controllo se la variabile è nella tabella del body
				for(NodeId var: this.bTable.getSymbolTable().keySet()) 
				{
					if(var.getType().getClass()!= MethTypeDescriptor.class) 
					{
						if(var.getName().equals(id)) 
						{
							return var.getType();
						}
					}
				}
				//controllo se à presente nella tabella della classe
				for(NodeId var: this.cTable.getSymbolTable().keySet()) 
				{
					if(var.getType().getClass()!= MethTypeDescriptor.class) 
					{
						if(var.getName().equals(id)) 
						{
							return var.getType();
						}
					}
				}

				return new ErrorTypeDescriptor();
		}
		
		private boolean Exist(VarDecl var, SymbolTable sTable) {
			for(NodeId p:sTable.getSymbolTable().keySet()) 
			{//se il nome di p e di var sono uguali e p non è uun istanza di metodo
				if((var.getId().getName()).equals(p.getName()) && p.getType().getClass() != MethTypeDescriptor.class )
				{
					return true;
				}
			}
			return false;
		}
		
	public ClassSymbolTable getClassST() {
		return classST;
	}
	public ClassDecl getActualClass() {
		return actualClass;
	}
	public void setActualClass(ClassDecl actualClass) {
		this.actualClass = actualClass;
	}
}
