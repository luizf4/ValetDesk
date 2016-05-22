/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.ead.ads3.view;

import br.metodista.ead.ads3.dao.ValetDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.metodista.ead.ads3.model.Valet;

/**
 *
 * @author Luiz Fernando de Souza Matricula: 225272 ADS - EAD - Polo Sorocaba
 */
public class ValetTableModel extends AbstractTableModel {

    private List<Valet> valets = new ArrayList<Valet>();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public ValetTableModel() {

        try {

            ValetDAO dao = new ValetDAO();
            valets = dao.consultarValetsGaragem();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    @Override
    public int getRowCount() {

        return valets.size();

    }

    @Override
    public int getColumnCount() {

        return 3;

    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Valet v = valets.get(linha);

        switch (coluna) {

            case 0:

                return df.format(v.getEntrada());

            case 1:

                return v.getModelo();

            case 2:

                return v.getPlaca();

            default:

                return "";
        }

    }

    @Override
    public String getColumnName(int coluna) {

        switch (coluna) {

            case 0:

                return "Data Entrada";

            case 1:

                return "Modelo";

            case 2:

                return "Placa";

            default:

                return "";
        }

    }

    public void adicionar(Valet v) {

        valets.add(v);
        fireTableRowsInserted(valets.size() - 1, valets.size() - 1);

    }

    public void remover(Valet v) {

        valets.remove(v);
        fireTableRowsInserted(valets.size() - 1, valets.size() - 1);

    }

}
