package ASTnodes.Decl;

import java.util.ArrayList;

import ASTnodes.Class.NodeAST;
import ASTnodes.Class.NodeId;
import TypeDescriptor.TypeDescriptor;

public class ClassDecl  extends NodeAST{
	public ClassDecl(TypeDescriptor type, NodeId nome, NodeId parent,ArrayList<VarDecl> vars,ArrayList<MethDecl> met) {
		super(type);
		this.vars = vars;
		this.mets = met;
		this.setIdClass(nome);
		this.setIdextends(parent);
	}
	
	private ArrayList<VarDecl> vars;
	private ArrayList<MethDecl> mets;
	private NodeId IdClass;
	private NodeId Idextends;
	
	public ArrayList<VarDecl> getVars() {
		return vars;
	}
	public void setVars(ArrayList<VarDecl> vars) {
		this.vars = vars;
	}
	public ArrayList<MethDecl> getMets() {
		return mets;
	}
	public void setMets(ArrayList<MethDecl> mets) {
		this.mets = mets;
	}
	public NodeId getIdClass() {
		return IdClass;
	}
	public void setIdClass(NodeId idclass) {
		IdClass = idclass;
	}
	public NodeId getIdextends() {
		return Idextends;
	}
	public void setIdextends(NodeId idextends) {
		Idextends = idextends;
	}


}
