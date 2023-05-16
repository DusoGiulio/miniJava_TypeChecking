package SymbolTable;

import java.util.Hashtable;

import ASTnodes.Class.NodeId;
import ASTnodes.Decl.Decl;
import TypeDescriptor.TypeDescriptor;


public class SymbolTable {
	private Hashtable<NodeId, TypeDescriptor> SymbolTable;
	
	public SymbolTable() {
		this.SymbolTable = new Hashtable<NodeId, TypeDescriptor>();
	}
	
	public void closeScope()
	{
		this.SymbolTable.clear();
	}
	public void enter(NodeId name, TypeDescriptor attr) 
	{
		this.SymbolTable.put(name, attr);
	}
	
	public  TypeDescriptor lookup(NodeId name) 
	{

			return this.SymbolTable.get(name);
	}

	public Hashtable<NodeId, TypeDescriptor> getSymbolTable() {
		return SymbolTable;
	}

	public void setSymbolTable(Hashtable<NodeId, TypeDescriptor> symbolTable) {
		SymbolTable = symbolTable;
	}


	
}
