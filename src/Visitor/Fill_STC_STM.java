package Visitor;

import java.util.ArrayList;

import ASTnodes.Class.*;
import ASTnodes.Decl.*;
import Attributes.ClassAttribute;
import Exceptioin.TypeCheckingException;
import SymbolTable.ClassSymbolTable;
import SymbolTable.SymbolTable;
import TypeDescriptor.*;

/*
 * Questa classe si occupa di aggiungere alla symboltable della classi chiamata ClassST la quale � composta come una HashTable<String,Attributes>, ogni riga conterr� il nome della classe
 * e i suo attributi i quali contengono classe estesa dalla classa , se esiste, e la symboltable della classe , la quale , composta come una HashTable<NodeId,SymbolTable>,
 *  conterr� a sua volta il NodeId e il typedescriptor di ogni metodo e varibile della classe corrento,durante il processo di iserimento della classe c'� un controllo sul nome della classe
 *  se il nome � gi� presente nella symboltable delle classi allora viene notificato un errore.
 */

public class Fill_STC_STM  {
	
	private ClassSymbolTable ClassST;
	private ArrayList<String> extClass;
	
	public Fill_STC_STM(ArrayList<NodeAST> listClass) throws TypeCheckingException 
	{
		this.setClassST(new ClassSymbolTable());
		this.visitProgram(listClass);
	}
	
	public ClassSymbolTable getClassST() {
		return ClassST;
	}



	public void setClassST(ClassSymbolTable classST) {
		ClassST = classST;
	}



//Aggiungo alla symbol table globale le classi  e i metodi
//////////////////////////////////////////////////////////////////////////////////////////////////////

	
	private void visitProgram(ArrayList<NodeAST> listClass) throws TypeCheckingException 
	{
		NodeId id=null;
		//per ogni classe la aggiungo alla Symboltable globale
		for(NodeAST klass :  listClass) 
		{
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				//prenod il NodeId della classe
				id= c.getIdClass();
				//prendo l'attributo della classe passandogli la symboltable della classe e il nome della classe ereditata e aggiungo alla symboltable
				//il nome della classe e ei suoi attributi
				if(this.getClassST().lookup(id.getName())==null) 
				{
					if(c.getIdextends()!=null) 
					{
						ClassAttribute attr= new ClassAttribute(((ClassTypeDescriptor) c.getType()).getST(), c.getIdextends().getName());
						this.getClassST().enter(id.getName(), attr);
					}
					else 
					{
						ClassAttribute attr= new ClassAttribute(((ClassTypeDescriptor) c.getType()).getST(), null);
						
						this.getClassST().enter(id.getName(), attr);
					}
					//faccio partire una visita nella classe
						this.visitClassDecl(c);
					
				}
				else 
				{
					System.err.println("La classe <"+id.getName()+"> � stata dichiarata pi� volte");
				}

			}
			else if(klass instanceof MainClass)
			{
				MainClass c= (MainClass) klass;
				id= c.getIdClass();
				ClassAttribute attr= new ClassAttribute(((ClassTypeDescriptor) c.getType()).getST(), id.getName());
				this.getClassST().enter(id.getName(), attr);
			}
			
		}
		
		/*Per ogni classe k controllo se ne estende un'alta se la classe p estesa esiste allora 
		 * aggiunger� alla symbolTable della classe k metodi e variabile della classe p*/
		for(NodeAST klass :  listClass) 
		{
			
			this.extClass= new ArrayList<String>();
			this.extClass.clear();
			
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				//se la classe non � ancora stata visitata
				if(!this.getClassST().lookup(c.getIdClass().getName()).isVisited())
				{//se il nodo ast contiene una classe in extend
					if(c.getIdextends()!=null) 
					{//se la classe esiste nella symboltable delle classi
						if(this.getClassST().lookup(c.getIdextends().getName())!=null) 
						{
							//invoco la funzione che sar� ricorsiva passandogli il nome della classe e riempio this.extClass con le classi che estende la classe attuale
								this.visitExtendClass(c.getIdextends().getName());															
							//per ogni classe in extClass Agggiungo partendo dall'ultima classe aggiunta la sua symboltable alla precedente
							int i= this.extClass.size()-1;
							
							//Segno le classi estese dalla classe
							(this.getClassST().lookup(c.getIdClass().getName())).setListofextclass(this.extClass);;
							boolean flag = false;
							while(i>=0) 
							{//prendo la symboltable della stringa iesima
								SymbolTable extSymTab=this.getClassST().lookup(this.extClass.get(i)).getST();
								if(i>0) 
								{/**verifico che le due symbol table siano diverse l'unico nome uguale � accettto se due metodi hanno
								 * stesso nome stesso
								 * stesso tipo di ritorno
								 * stesse variabili nell'intestanzione
								 **/
										for(NodeId Id: this.getClassST().lookup(this.extClass.get(i-1)).getST().getSymbolTable().keySet()) 
										{
											
											if(Id.getType().getClass()!=MethTypeDescriptor.class) 
											{
												if(this.SSCheckExist(new VarDecl(Id.getType(),Id), extSymTab, null)) 
												{
													System.err.println("La variabile <"+Id.getName()+"> � gi� presente nella classe < "+ this.extClass.get(i-1) + "> quindi non pu� essere estesa");
													flag=true;
												}
											}
											else 
											{
												if(this.SSCheckExist(new VarDecl(Id.getType(),Id), extSymTab,(this.getClassST().lookup(this.extClass.get(i-1)).getST()))) 
												{
													System.err.println("Il Metodo <"+Id.getName()+"> � gi� presente nella classe < "+ this.extClass.get(i-1) + "> quindi non pu� essere estesa");
													flag=true;
												}
											}
										}
										if(!flag) 
										{
											//aggiorno nella symboltable dellaclasse i+1esima la symboltable della classe iesima estesa
											for(NodeId nid: extSymTab.getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, extSymTab.lookup(nid));
											}
											for(NodeId nid: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, this.getClassST().lookup(c.getIdClass().getName()).getST().lookup(nid));
											}
										}else 
										{
											System.err.println("Non � stato possibile estendere le classi a causa di nomi di variabili o metodi uguali");
										}
								}
								else 
								{ 

										
										for(NodeId Id: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
										{
											if(Id.getType().getClass()!=MethTypeDescriptor.class) 
											{
												if(this.SSCheckExist(new VarDecl(Id.getType(),Id), extSymTab, null)) 
												{
													System.err.println("La variabile <"+Id.getName()+"> � gi� presente nella classe < "+ c.getIdClass().getName() + "> quindi non pu� essere estesa");
													flag=true;
												}
											}
											else 
											{
												if(this.SSCheckExist(new VarDecl(Id.getType(),Id), extSymTab,(this.getClassST().lookup(c.getIdClass().getName()).getST()))) 
												{
													System.err.println("Il Metodo <"+Id.getName()+"> � gi� presente nella classe < "+ c.getIdClass().getName() + "> quindi non pu� essere estesa");
													flag=true;
												}
											}
										}
										if(!flag) 
										{
											for(NodeId nid: extSymTab.getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, extSymTab.lookup(nid));
											}
											for(NodeId nid: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, this.getClassST().lookup(c.getIdClass().getName()).getST().lookup(nid));
											}
										}else 
										{
											System.err.println("Non � stato possibile estendere le classi a causa di nomi di variabili o metodi uguali");
											throw new TypeCheckingException();
										}
								}
								i--;
							}
						}
					}
				}
			}
		}
		
	}
	private void visitExtendClass(String extendClass) 
	{	//se extendClass � contenuta nella symboltable
		if(this.getClassST().lookup(extendClass)!=null ) 
		{//se la classe non � gi� presente 
			if(!this.extClass.contains(extendClass)) 
			{//setto la condizione di visited a true
				this.getClassST().lookup(extendClass).setVisited(true);
				//aggiungo la classe corrente alla lista delle classi
				this.extClass.add(extendClass);
				//se la classe ne estende un'altra
				if(this.getClassST().lookup(extendClass).getExtendClass()!=null) 
				{// visito la classe che estende 
					this.visitExtendClass(this.getClassST().lookup(extendClass).getExtendClass());
				}
			}
			else 
			{
				System.err.println("La classe <"+extendClass+"> si estende in modo ciclico");
			}
		}
		else 
		{
			System.err.println("La classe <"+extendClass+"> non esiste");
		}
		
	}

	public void visitClassDecl(ClassDecl ctx) 
	{
		for(VarDecl var :ctx.getVars()) 
		{//per ogni variabile dichiarata nella classe aggiungo alla symbol della classe contenuta nella symboltable globale la variabile
			if(!this.SSCheckExist(var, this.getClassST().lookup(ctx.getIdClass().getName()).getST(), null)) 
			{
				(this.getClassST().lookup(ctx.getIdClass().getName())).getST().enter(var.getId(), var.getType());
			}
			else 
			{
				System.err.println("La variabile <"+var.getId().getName()+"> � gi� presente nella classe "+ ctx.getIdClass().getName());
			}
		}
		for(MethDecl met :ctx.getMets()) 
		{
			//faccio partire una visita del metodo
			

			if(!this.SSCheckExist(new VarDecl(met.getType(),met.getId()), this.getClassST().lookup(ctx.getIdClass().getName()).getST(), null)) 
			{
				MethTypeDescriptor mt=this.visitMethodDecl(met);
				//assegno ai metodi la symbol table aggiornata
				met.getId().setType(mt);
				met.setType(mt);
				//per ogni metodo dichiarato nella classe aggiungo alla symbol della classe contenuta nella symboltable globale il metodo
				(this.getClassST().lookup(ctx.getIdClass().getName())).getST().enter(met.getId(), met.getType());
			}
			else 
			{
				System.err.println("Il metodo <"+met.getId().getName()+"> � gi� presente nella classe "+ ctx.getIdClass().getName());
			}

		}
	}
	
	public MethTypeDescriptor visitMethodDecl(MethDecl ctx)
	{
		MethTypeDescriptor mt= (MethTypeDescriptor) ctx.getId().getType();
		for(VarDecl var :ctx.getFormals()) 
		{//assegno alla variabile mt tutte le variabile contenute nell'intestanzione del metodo
			mt.getSymbolTable().enter( var.getId(), var.getType());
		}
		//ritorno il tipo del metodo
		return mt;
	}
	
	//ritorno true se la variabile esiste, si occupa di controllare se in una datat classe il nome di una data variabile gi� esiste
	private  boolean SSCheckExist(VarDecl var, SymbolTable extendor, SymbolTable extended) 
	{      //per ogni NodeId presente nella symboltable extendor
		for(NodeId p:extendor.getSymbolTable().keySet()) 
		{//se il nome di p e di var sono uguali
			if((var.getId().getName()).equals(p.getName()) )
				
					{ //se sono entrambi metodi
						if(var.getType().getClass()== MethTypeDescriptor.class && p.getType().getClass() == MethTypeDescriptor.class ) 
						{//se extended non eiste allora ci si trova all'interno della stessa classe
							
							if(extended == null ) 
							{
								return true;
							}
							
							else if(((MethTypeDescriptor)(extendor.lookup(p))).isStatic() || ((MethTypeDescriptor)(extended.lookup(var.getId()))).isStatic())
							{
								
								boolean st1=((MethTypeDescriptor)(extendor.lookup(p))).isStatic() ;
								boolean st2=((MethTypeDescriptor)(extended.lookup(var.getId()))).isStatic();
								if((st1 == true && st2==true) || (st1 == true && st2 == false) || (st1 == false && st2 == true) ) 
								{
									return true;
								}
							
							}//se ritornano lo stesso tipo
							else if(p.getType().getClass()== var.getType().getClass())
							{
								SymbolTable extendFormals= ((MethTypeDescriptor)(extendor.lookup(p))).getSymbolTable();//iesima
								SymbolTable extendorFormals= ((MethTypeDescriptor)(extended.lookup(var.getId()))).getSymbolTable();//i-1esima
								//se hanno la stessa dimensione
								if(extendFormals.getSymbolTable().size()== extendorFormals.getSymbolTable().size()) 
								{  
									if(extendFormals.getSymbolTable().size() == 0 ) 
									{
										return false;
									}
									 
									ArrayList<TypeDescriptor> aar= new ArrayList<TypeDescriptor>() ;
									ArrayList<TypeDescriptor> arr=new ArrayList<TypeDescriptor>();
									//se l'ordine dei tipi � il medesimo e sono gli stessi
									for(NodeId id : extendorFormals.getSymbolTable().keySet()) 
									{
										arr.add(id.getType());
									}
									for(NodeId id : extendFormals.getSymbolTable().keySet()) 
									{
										aar.add(id.getType());
									}
									for(int i=0; i<extendFormals.getSymbolTable().size();i++) 
									{
										if(arr.get(i).getClass()!=aar.get(i).getClass()) 
										{
											return true;
										}
									}
									//allora va tutto bene
									return false;
								}
							}
							return true;
							
							
						}else if(var.getType().getClass()== MethTypeDescriptor.class && p.getType().getClass() != MethTypeDescriptor.class )
						{
							return false;
							
						}else if(var.getType().getClass()!= MethTypeDescriptor.class && p.getType().getClass() == MethTypeDescriptor.class ) 
						{
							return false;
						}
						else if(var.getType().getClass()!= MethTypeDescriptor.class && p.getType().getClass() != MethTypeDescriptor.class ) 
						{
							return true;
						}

					}
		}
		return false;	
	}

}

