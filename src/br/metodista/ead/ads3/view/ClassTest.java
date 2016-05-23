package br.metodista.ead.ads3.view;

import br.metodista.ead.ads3.dao.ValetDAO;
import br.metodista.ead.ads3.model.Valet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;


/**
 *
 * @author Luiz
 */
public class ClassTest {

    public static void main(String[] args) throws Exception {

        ValetDAO dao = new ValetDAO();
        Valet valet = new Valet();
        List<Valet> valets = dao.consultarTodos();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();

//        valet.setModelo("MAREA");
//        valet.setPlaca("MAA-1234");
//        valet.setEntrada(new Date(System.currentTimeMillis()));
//        valet.setSaida(new Date(System.currentTimeMillis()));
//        valet.setValor(0.0);
//        valet.setId(1L);
        //System.out.println(System.currentTimeMillis());        
        //dao.salvar(valet);
//        for (Valet v : valets) {
//
//            System.out.println(v);
//            
//        }
        
        System.out.println(valets);
        
        System.out.println(df.format(data.getTime()));
        
        

    }

}
