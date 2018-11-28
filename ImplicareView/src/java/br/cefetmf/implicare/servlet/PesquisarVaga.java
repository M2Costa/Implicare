package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class PesquisarVaga {
    
    private PesquisarVaga(){}
    
    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            int Seq_Vaga = Integer.parseInt(request.getParameter("Seq_Vaga"));
            
            Vaga vaga = new VagaManagementImpl().pesquisar(Seq_Vaga);
            ArrayList<Cargo> ListaCargo = new CargoManagementImpl().listar();
            
            if (vaga != null) {
                jsp = "EditarVaga.jsp";
                request.setAttribute("Vaga", vaga);
                request.setAttribute("ListaCargo", ListaCargo);
            }
            
        } catch (PersistenceException | NumberFormatException e) {
            Logger.getLogger(PesquisarVaga.class.getName()).log(Level.SEVERE, null, e);
            jsp = "";
        }
        return jsp;
    }
    
}
