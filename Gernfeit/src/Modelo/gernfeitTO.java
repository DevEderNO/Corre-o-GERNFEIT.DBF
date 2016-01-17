/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Masterkaos
 */
public class gernfeitTO {

    private String num_nfe;
    private String mod_nfece;
    private String num_seq;
    private String des_prod;
    private int qtde_prod;
    private double val_unit;
    private double val_desc;
    private double val_total;

    public gernfeitTO() {

        this.num_nfe = "";
        this.mod_nfece = "";
        this.num_seq = "";
        this.des_prod = "";
        this.qtde_prod = 0;
        this.val_unit = 0;
        this.val_desc = 0;
        this.val_total = 0;
    }

    public String getNum_nfe() {
        return num_nfe;
    }

    public void setNum_nfe(String num_nfe) {
        this.num_nfe = num_nfe;
    }

    public String getNum_seq() {
        return num_seq;
    }

    public void setNum_seq(String num_seq) {
        this.num_seq = num_seq;
    }

    public String getMod_nfece() {
        return mod_nfece;
    }

    public void setMod_nfece(String mod_nfece) {
        this.mod_nfece = mod_nfece;
    }

    public String getDes_prod() {
        return des_prod;
    }

    public void setDes_prod(String des_prod) {
        this.des_prod = des_prod;
    }

    public int getQtde_prod() {
        return qtde_prod;
    }

    public void setQtde_prod(int qtde_prod) {
        this.qtde_prod = qtde_prod;
    }

    public double getVal_unit() {
        return val_unit;
    }

    public void setVal_unit(double val_unit) {
        this.val_unit = val_unit;
    }

    public double getVal_desc() {
        return val_desc;
    }

    public void setVal_desc(double val_desc) {
        this.val_desc = val_desc;
    }

    public double getVal_total() {
        return val_total;
    }

    public void setVal_total(double val_total) {
        this.val_total = val_total;
    }

}
