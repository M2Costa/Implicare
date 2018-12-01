package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class PesquisarUsuarioEmpresa {
    
    PesquisarUsuarioEmpresa(){}
    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");

            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            Empresa Empr = EmpresaManagement.pesquisar(CNPJ);

            if (Empr != null) {
                jsp = "/EditarUsuarioEmpresa.jsp";
                request.setAttribute("Empresa", Empr);
            } else {
                String Erro = "Erro Empresa Não Existe";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (PersistenceException e) {
            Logger.getLogger(PesquisarVaga.class.getName()).log(Level.SEVERE, null, e);
        }
        return jsp;
    }
    
}
