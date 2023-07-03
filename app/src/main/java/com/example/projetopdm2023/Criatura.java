package com.example.projetopdm2023;

public class Criatura {
    private int vd;
    private String nmcria;
    private String element ;

    public Criatura (){}

    public Criatura(int vd, String nmcria, String element) {
        this.setIdUsuario(vd);
        this.setNomeUsuario(nmcria);
        this.setNomeUsuario(element);
    }

    public Criatura(String nmcria, int vd) {
        this.nmcria =  nmcria;
        this.vd = vd;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + vd + ", nomeUsuario='" + nmcria + '\'' + ", setNomeUsuario=" + element + '}';
        //"Usuario{idUsuario=1, nomeUsuario=Ronan, idadeUsuario=30}"
    }

    protected int getIdUsuario() {
        return vd;
    }

    protected void setIdUsuario(int vd) {

        this.vd = vd;
    }

    protected String getNomeUsuario() {
        return nmcria;
    }

    protected void setNomeUsuario(String nmcria) {
        this.nmcria = nmcria;
    }

    protected String setNomeUsuario() {
        return element;
    }

    protected void setNomeUsuari(String element) {
        this.element = element;
}

    }
