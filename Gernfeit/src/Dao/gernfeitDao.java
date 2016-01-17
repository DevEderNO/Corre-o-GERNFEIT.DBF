/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.Conexao;
import Modelo.dbfTO;
import Modelo.gernfeitTO;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Masterkaos
 */
public class gernfeitDao {

    private Connection con;
    private PreparedStatement state;
    private ResultSet rs;
    private dbfTO dbf;

    public void salvar(gernfeitTO to) throws SQLException,ClassNotFoundException {

        try {
            con = Conexao.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into GERNFEIT ");
            sql.append("(NUMR_NFE ,\n"
                    + "MODL_NFECE ,\n"
                    + "NUMR_SEQIT ,\n"
                    + "DESC_PRODU ,\n"
                    + "QTDE_PRODT ,\n"
                    + "VALR_UNITT ,\n"
                    + "VALR_DESCN ,\n"
                    + "VALR_TOTAL ) ");
            sql.append("values (?,?,?,?,?,?,?,?) ");

            state = con.prepareStatement(sql.toString());
            state.setString(1, to.getNum_nfe());
            state.setString(2, to.getMod_nfece());
            state.setString(3, to.getNum_seq());
            state.setString(4, to.getDes_prod());
            state.setInt(5,to.getQtde_prod()) ;
            state.setDouble(6,to.getVal_unit() );
            state.setDouble(7, to.getVal_desc());
            state.setDouble(8, to.getVal_total());

            state.execute();
            System.out.println("Cadastrado com sucesso!");

            state.close();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO: \n" + e.getMessage());
        }

    }
    
    public ArrayList<gernfeitTO> listarAluno() throws SQLException,ClassNotFoundException {

        ArrayList<gernfeitTO> alunos = new ArrayList();
       

        try {
            con = Conexao.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("select * from GERNFEIT");

            state = con.prepareStatement(sql.toString());
            rs = state.executeQuery();
            
            while (rs.next()) {
                gernfeitTO to = new gernfeitTO();
                to.setNum_nfe(rs.getString("NUMR_NFE"));
                to.setMod_nfece(rs.getString("MODL_NFECE"));
                to.setNum_seq(rs.getString("NUMR_SEQIT"));
                to.setDes_prod(rs.getString("DESC_PRODU"));
                to.setQtde_prod(rs.getInt("QTDE_PRODT"));
                to.setVal_unit(rs.getDouble("VALR_UNITT"));
                to.setVal_desc(rs.getDouble("VALR_DESCN"));
                to.setVal_total(rs.getDouble("VALR_TOTAL"));
                alunos.add(to);
            }
            rs.close();
            state.close();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ERRO: \n"+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return alunos;

    }
    
    public void atualizar(gernfeitTO to) throws SQLException,ClassNotFoundException {

        try {
            con = Conexao.getConexao();
            StringBuilder sql = new StringBuilder();
            
            sql.append("update GERNFEIT ");
            sql.append("set MODL_NFECE  = ?,"
                    + "NUMR_SEQIT  = ?,"
                    + "DESC_PRODU  = ?,"
                    + "QTDE_PRODT  = ?,"
                    + "VALR_UNITT  = ?,"
                    + "VALR_DESCN  = ?,"
                    + "VALR_TOTAL  = ? ");
            sql.append("where  NUMR_NFE = ? ");

            state = con.prepareStatement(sql.toString());
            state.setString(1, to.getMod_nfece());
            state.setString(2, to.getNum_seq());
            state.setString(3, to.getDes_prod());
            state.setInt(4, to.getQtde_prod());
            state.setDouble(5, to.getVal_unit());
            state.setDouble(6, to.getVal_desc());
            state.setDouble(7, to.getVal_total());
            state.setString(8, to.getNum_nfe());

            state.execute();
            state.close();
            con.close();

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ERRO ao alterar \n"+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            printStackTrace();
        }
    }
    
    public void excluir(gernfeitTO to) throws ClassNotFoundException {

        try {
            con = Conexao.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("delete from GERNFEIT ");
            sql.append("where NUMR_NFE  = ? ");

            state = con.prepareStatement(sql.toString());
            state.setString(1, to.getNum_nfe());
            state.executeUpdate();
            state.close();
            con.close();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ERRO ao excluir \n"+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            printStackTrace();
        }

    }
}
