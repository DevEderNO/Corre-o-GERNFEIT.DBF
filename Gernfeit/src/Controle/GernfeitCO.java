/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dao.gernfeitDao;
import Modelo.gernfeitTO;
import View.Tela_ConsultaGernfeit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Masterkaos
 */
public class GernfeitCO {

    gernfeitTO to = new gernfeitTO();
    gernfeitDao dao = new gernfeitDao();

    public void dadosTabela(String num_nfe, String mod_nfece, String num_seq, String des_prod, int qtde_prod, double val_unit, double val_desc, double val_total) throws ClassNotFoundException, SQLException {
        to.setNum_nfe(num_nfe);
        to.setMod_nfece(mod_nfece);
        to.setNum_seq(num_seq);
        to.setDes_prod(des_prod);
        to.setQtde_prod(qtde_prod);
        to.setVal_unit(val_unit);
        to.setVal_desc(val_desc);
        to.setVal_total(val_total);
        dao.atualizar(to);
    }
}
