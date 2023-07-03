package com.example.projetopdm2023;

public class Criatura {
    private int ID;
    private int valords;
    private String nmcria;
    private String element;

    public Criatura() {
    }

    public Criatura(int ID, String nmcria, String element) {
        this.setIdUsuario(ID);
        this.setNomeCriatura(nmcria);
        this.setNomedoelemet(element);
        this.setVdCriatura(valords);
    }

    public Criatura(String nmcria, int vd) {
        this.nmcria = nmcria;
        this.valords = valords;
    }

    @Override
    public String toString() {
        return "Criatura{" + "idUsuario=" + ID + ", nomeCriatura='" + nmcria + '\'' + ", setNomedoelemet" + element + "setVdCriatura =" + valords + "}";
    }

    protected int getIdUsuario() {
        return ID;
    }

    protected void setIdUsuario(int ID) {

        this.ID = ID;
    }

    protected String getNomeCriatura() {
        return nmcria;
    }

    protected void setNomeCriatura(String nmcria) {
        this.nmcria = nmcria;
    }

    protected String setNomedoelemet() {
        return element;
    }

    protected void setNomedoelement(String element) {
        this.element = element;
    }

    protected int setVdCriatura() {
        return valords;
    }

    protected void setVdCriatura(int valords) {
        this.valords = valords;
    }

}