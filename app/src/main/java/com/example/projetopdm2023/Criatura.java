package com.example.projetopdm2023;

public class Criatura {
    private int ID;
    private int valords;
    private String nmcria;
    private String element;

    public Criatura() {
    }

    public Criatura(int ID, String nmcria, String element, int valords) {
        this.setIdUsuario(ID);
        this.setNomeCriatura(nmcria);
        this.setNomedoelemet(element);
        this.setVdCriatura(valords);
    }

    public Criatura(int ID, String nmcria, String element, float valords ) {
        this.nmcria = nmcria;
        this.valords = (int) valords;
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

    protected String getNomedoelemet() {
        return this.element;
    }

    protected void setNomedoelement(String element) {
        this.element = element;
    }
        private void setNomedoelemet(String element) {

    }

    protected int getVdCriatura() {
        return valords;
    }

    protected void setVdCriatura(int valords) {
        this.valords = valords;
    }

}