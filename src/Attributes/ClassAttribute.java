package Attributes;

import java.util.ArrayList;

import SymbolTable.SymbolTable;

public class ClassAttribute {
	public ClassAttribute(SymbolTable sT, String extendClass) {
		super();
		ST = sT;
		this.extendClass = extendClass;
		this.visited=false;
		this.listofextclass=null;
		}
	
	private SymbolTable ST;
	private String extendClass;
	private boolean visited ;
	private  ArrayList<String> listofextclass;
	
	public SymbolTable getST() {
		return ST;
	}
	public void setST(SymbolTable sT) {
		ST = sT;
	}
	public String getExtendClass() {
		return extendClass;
	}
	public void setExtendClass(String extendClass) {
		this.extendClass = extendClass;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public ArrayList<String> getListofextclass() {
		return listofextclass;
	}
	public void setListofextclass(ArrayList<String> listofextclass) {
		this.listofextclass = listofextclass;
	}
}
