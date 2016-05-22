
package br.metodista.ead.ads3.view;

import br.metodista.ead.ads3.dao.ValetDAO;
import br.metodista.ead.ads3.model.Valet;
import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

/**
 *
 * @author Luiz
 */
public class ClassTest {
    
    public static void main(String[] args) throws Exception {
        
        ValetDAO dao = new ValetDAO();
        Valet valet = new Valet();
        List<Valet> lista = new ArrayList<Valet>();
        
//        valet.setModelo("MAREA");
//        valet.setPlaca("MAA-1234");
//        valet.setEntrada(new Date(System.currentTimeMillis()));
//        valet.setSaida(new Date(System.currentTimeMillis()));
//        valet.setValor(0.0);
//        valet.setId(1L);
        
        //System.out.println(System.currentTimeMillis());        
        
        
        //dao.salvar(valet);
        
        lista = dao.consultarValetsGaragem();
        
        //System.out.println(lista.size());
        
                   
            System.out.println(lista);
                       
            
        
        
        
    }
    
}
