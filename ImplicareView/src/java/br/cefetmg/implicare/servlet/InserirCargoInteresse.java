/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaIdImpl;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.implicare.model.service.FormacaoAcademicaIdManagement;

/**
 *
 * @author Gabriel
 * 
 */

class InserirCargoInteresse {

    static String execute(HttpServletRequest request) {
        String jsp="";
        try{

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            
            FormacaoAcademicaIdManagement CargoManagement = new FormacaoAcademicaIdImpl(); 
            CargoInteresse CargoInteresse = new CargoInteresse();
            
            CargoInteresse.setCPF(CPF);
            CargoInteresse.setCod_Cargo(Cod_Cargo);
            
            boolean Cargo = CargoManagement.insert(CargoInteresse);

            if (Cargo =! false) {
                jsp="ImplicareServlet?acao=PerfilCandidato";
            } else {
                String Erro = "Ocorreu erro ao Inserir Cargo Interesse!";
                jsp="/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return jsp;
    }
    
}
