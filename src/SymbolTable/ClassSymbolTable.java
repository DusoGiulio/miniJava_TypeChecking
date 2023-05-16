package SymbolTable;

import java.util.Hashtable;

import ASTnodes.Decl.Decl;
import Attributes.ClassAttribute;

//classe statica
public class ClassSymbolTable {
	private Hashtable<String, ClassAttribute> SymbolTable;
	
	public ClassSymbolTable() {
		this.SymbolTable = new Hashtable<String, ClassAttribute>();
	}

	public SymbolTable openScope(Decl node)
	{
		return new SymbolTable(); 
	}
	
	public void closeScope(Decl node)
	{
		this.SymbolTable.clear();
	}
	public void enter(String name,ClassAttribute attr) 
	{
		this.SymbolTable.put(name, attr);
	}

	
	public  ClassAttribute lookup(String name) 
	{

			return this.SymbolTable.get(name);
	}
	public Hashtable<String,ClassAttribute> ST()
	{
		return this.SymbolTable;
	}
	@Override
	public String toString() 
	{
		return this.SymbolTable.toString();
	}


}
