/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.implicare.model.domain.jpa.Empresa;
import br.cefetmg.implicare.model.domain.jpa.Telefone;
import br.cefetmg.implicare.model.domain.jpa.Vaga;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarVagaCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            
            VagaManagement VagaManagement = new VagaManagementImpl();
            ArrayList<Vaga> ListaVaga = VagaManagement.listarVagaCandidato(CPF);
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = CargoManagement.listar();
            
            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            ArrayList<Empresa> ListaEmpresa = new ArrayList();
            
            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            ArrayList<Telefone> ListaTelefone = new ArrayList();
            
            for(int i = 0; i < ListaVaga.size(); i++) {
                Empresa Empr = EmpresaManagement.pesquisar(ListaVaga.get(i).getCNPJ());
                ListaEmpresa.add(Empr);
                
                Telefone Tel;
                ArrayList<Telefone> tel1 = TelefoneManagement.listar(ListaVaga.get(i).getCNPJ());
                
                for(int j = 0; j < tel1.size(); j++){
                    Tel = TelefoneManagement.pesquisar(tel1.get(i).getSeq_Telefone());
                    ListaTelefone.add(Tel);
                }
            }
            
            jsp = "/AvaliarVagas.jsp";
            request.setAttribute("ListaVaga", ListaVaga); 
            request.setAttribute("ListaCargo", ListaCargo); 
            request.setAttribute("ListaEmpresa", ListaEmpresa); 
            request.setAttribute("ListaTelefone", ListaTelefone); 
            
        } catch (PersistenceException | RemoteException e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
