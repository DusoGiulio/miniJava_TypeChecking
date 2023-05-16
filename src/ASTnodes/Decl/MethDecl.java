package ASTnodes.Decl;

import java.util.ArrayList;

import ASTnodes.Class.Body;
import ASTnodes.Class.NodeId;
import TypeDescriptor.TypeDescriptor;

public class MethDecl extends Decl{
	
	
	private ArrayList<VarDecl> formals;
	private  TypeDescriptor retType;
	private NodeId id;
	private Body body;
	@SuppressWarnings("unused")
	private boolean isStatic;
	
	public MethDecl(TypeDescriptor type, ArrayList<VarDecl> formals, TypeDescriptor retType, NodeId name, Body body, boolean isStatic) {
		super(type);
		this.formals = formals;
		this.retType = retType;
		this.id = name;
		this.body = body;
		
	}

	public ArrayList<VarDecl> getFormals() {
		return formals;
	}
	public TypeDescriptor getRetType() {
		return retType;
	}
	public NodeId getId() {
		return id;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
}
