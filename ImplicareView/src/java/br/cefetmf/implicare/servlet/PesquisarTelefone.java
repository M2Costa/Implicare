package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class PesquisarTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            int Seq_Telefone = Integer.parseInt(request.getParameter("Seq_Telefone"));
            
            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            Telefone Tel = TelefoneManagement.pesquisar(Seq_Telefone);
            
            if (Tel != null) {
                jsp = "EditarTelefone.jsp";
                request.setAttribute("Telefone", Tel);
            }
            
        } catch (PersistenceException | NumberFormatException e) {
            Logger.getLogger(PesquisarTelefone.class.getName()).log(Level.SEVERE, null, e);
            jsp = "";
        }
        return jsp;
    }
    
}
