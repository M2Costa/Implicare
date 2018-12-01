package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class AlterarExperienciaProfissional {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            int Seq_Experiencia = Integer.parseInt(request.getParameter("Seq_Experiencia"));
            String Nom_Empresa = request.getParameter("Nom_Empresa");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Inicio = (Date) formato.parse(request.getParameter("Data_Inicio"));
            Date Data_Termino = (Date) formato.parse(request.getParameter("Data_Termino"));
            String Desc_Experiencia_Profissional = request.getParameter("Desc_Experiencia_Profissional");

            ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
            ExperienciaProfissional Exp = new ExperienciaProfissional();
            
            Exp.setCPF(CPF);
            Exp.setSeq_Experiencia(Seq_Experiencia);
            Exp.setNom_Empresa(Nom_Empresa);
            Exp.setCod_Cargo(Cod_Cargo);
            Exp.setData_Inicio(Dat_Inicio);
            Exp.setData_Termino(Data_Termino);
            Exp.setDesc_Experiencia_Profissional(Desc_Experiencia_Profissional);
            
            boolean Experiencia = ExperienciaManagement.update(Exp);

            if (Experiencia) {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
                request.setAttribute("ExperienciaProfissional", Exp);
            } else {
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", "Erro ao Editar Experiencia Profissional");
            }
        } catch (BusinessException | PersistenceException | NumberFormatException | ParseException e) {
            Logger.getLogger(PesquisarVaga.class.getName()).log(Level.SEVERE, null, e);
        }
        return jsp;
    }
    
}
