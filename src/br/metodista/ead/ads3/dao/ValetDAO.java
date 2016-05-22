package br.metodista.ead.ads3.dao;

import br.metodista.ead.ads3.model.Valet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luiz Fernando de Souza Matricula: 225272 ADS - EAD - Polo Sorocaba
 */
public class ValetDAO {

    private Connection conectar() throws Exception {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String usuario = "system";
            String senha = "Gil@@3442";

            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com o Banco de Dados!!!");

        } catch (Exception ex) {

            ex.printStackTrace();
            throw new Exception("Erro ao conectar no BD.");
        }

        return conn;
    }

    public void desconectar(Connection conn) throws Exception {

        try {

            if (conn != null) {

                conn.close();
                System.out.println("Desconectado do Banco de Dados!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            throw new Exception("Não conseguiu fechar a conexão!");

        }

    }

    public Valet salvar(Valet valet) throws Exception {

        Connection conn = conectar();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            if (valet.getId() == null) {

                String consultarID = "SELECT VALET_SEQ.NEXTVAL AS PROXIMO_ID"
                        + " FROM DUAL";
                stm = conn.prepareStatement(consultarID);

                rs = stm.executeQuery();

                if (rs.next()) {

                    valet.setId(rs.getLong("PROXIMO_ID"));
                    String inserir = "INSERT INTO VALET (ID, MODELO, PLACA,"
                            + "ENTRADA) VALUES (?,?,?,?)";
                    stm = conn.prepareStatement(inserir);
                    stm.setLong(1, valet.getId());
                    stm.setString(2, valet.getModelo());
                    stm.setString(3, valet.getPlaca());
                    stm.setTimestamp(4,
                            new java.sql.Timestamp(valet.getEntrada().getTime()));

                    stm.execute();

                }
            } else {

                String atualizar = "UPDATE VALET SET MODELO = ?, PLACA = ?,"
                        + " ENTRADA = ?, SAIDA = ?, PRECO = ?"
                        + " WHERE ID=?";

                stm = conn.prepareStatement(atualizar);
                stm.setString(1, valet.getModelo());
                stm.setString(2, valet.getPlaca());
                stm.setDate(3, new java.sql.Date(valet.getEntrada().getTime()));
                stm.setDate(4, new java.sql.Date(valet.getSaida().getTime()));
                stm.setDouble(5, valet.getValor());
                stm.setLong(6, valet.getId());

                stm.executeUpdate();
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            throw new SQLException("Erro ao salvar Valet!");

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            desconectar(conn);
        }

        return valet;

    }

    public List<Valet> consultarValetsGaragem() throws Exception {

        List<Valet> valets = new ArrayList<Valet>();
        Connection conn = conectar();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            String consulta = "SELECT * From VALET "
                    + "WHERE saida IS NULL"
                    + " ORDER BY entrada";

            stm = conn.prepareStatement(consulta);

            rs = stm.executeQuery();

            while (rs.next()) {

                Valet valet = new Valet(rs.getLong("ID"),
                        rs.getString("MODELO"), rs.getString("PLACA"),
                        new Date(rs.getTimestamp("ENTRADA").getTime()));

                valets.add(valet);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            throw new Exception("Erro ao consultar os Valets!");

        } finally {

            if (rs != null) {
                rs.close();

            }
            if (stm != null) {

                stm.close();
            }
            
            desconectar(conn);
        }

        return valets;
        
    }

}
