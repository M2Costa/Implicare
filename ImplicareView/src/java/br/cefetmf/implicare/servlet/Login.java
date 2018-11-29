package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.UsuarioManagementImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            long CPF_CNPJ = Long.parseLong(request.getParameter("CPF_CNPJ"));
            String Senha = request.getParameter("Senha");

            UsuarioManagement UsuarioManagement = new UsuarioManagementImpl();
            Usuario user = UsuarioManagement.login(CPF_CNPJ, Senha);
            
            if(user == null) {
                return "/login.jsp";
            }
            
            
            if (CPF_CNPJ == 0 || Senha.isEmpty()) {
                jsp = "/login.jsp";
            } 
            else {
                
                CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
                Candidato Cand = CandidatoManagement.pesquisar(CPF_CNPJ);
                if(Cand == null) {
                    request.getSession().setAttribute("Tipo","E");
                    jsp = "ImplicareServlet?acao=ListarVagaEmpresa";
                } else {
                    request.getSession().setAttribute("Tipo","C");
                    jsp = "ImplicareServlet?acao=ListarVagaCandidato";
                }
                request.getSession().setAttribute("CPF_CNPJ",user.getCPF_CNPJ());
                request.getSession().setAttribute("Email", user.getEmail());
                request.getSession().setAttribute("Foto",user.getFoto());
                request.getSession().setAttribute("Endereço", user.getEndereco());
                request.getSession().setAttribute("Cod_CEP",user.getCod_CEP());
                request.getSession().setAttribute("Desc_Usuario", user.getDesc_Usuario());
                
                
            }
        } catch (PersistenceException | NumberFormatException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }

        return jsp;
    }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        if (request.getSession().getAttribute("CPF_CNPJ") == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
   
}
