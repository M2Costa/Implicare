package br.cefetmg.implicare.server;

import br.cefetmg.implicare.model.daoImpl.AreaEstudoDaoImpl;
import br.cefetmg.implicare.model.daoImpl.CandidatoDaoImpl;
import br.cefetmg.implicare.model.daoImpl.CandidatoVagaDaoImpl;
import br.cefetmg.implicare.model.daoImpl.CargoDaoImpl;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaIdDaoImpl;
import br.cefetmg.implicare.model.daoImpl.EmpresaDaoImpl;
import br.cefetmg.implicare.model.daoImpl.ExperienciaProfissionalDaoImpl;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.daoImpl.TelefoneDaoImpl;
import br.cefetmg.implicare.model.daoImpl.UsuarioDaoImpl;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoVagaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaIdImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.UsuarioManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import br.cefetmg.implicare.model.service.FormacaoAcademicaIdManagement;

public class Servidor {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
    
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = LocateRegistry.createRegistry(2345);
        
        AreaEstudoManagement areaEstudo = new AreaEstudoManagementImpl(AreaEstudoDaoImpl.getInstance());
        registry.rebind("AreaEstudoManagement", areaEstudo); // registra este objeto
        
        CandidatoManagement candidato = new CandidatoManagementImpl(CandidatoDaoImpl.getInstance());
        registry.rebind("CandidatoManagement", candidato); // registra este objeto
        
        CandidatoVagaManagement candidatoVaga = new CandidatoVagaManagementImpl(CandidatoVagaDaoImpl.getInstance());
        registry.rebind("CandidatoVagaManagement", candidatoVaga); // registra este objeto
        
        FormacaoAcademicaIdManagement cargoInteresse = new FormacaoAcademicaIdImpl(FormacaoAcademicaIdDaoImpl.getInstance());
        registry.rebind("CargoInteresseManagement", cargoInteresse); // registra este objeto
        
        CargoManagement cargo = new CargoManagementImpl(CargoDaoImpl.getInstance());
        registry.rebind("CargoManagement", cargo); // registra este objeto
        
        EmpresaManagement empresa = new EmpresaManagementImpl(EmpresaDaoImpl.getInstance());
        registry.rebind("EmpresaManagement", empresa); // registra este objeto
        
        ExperienciaProfissionalManagement experienciaProfissional = new ExperienciaProfissionalManagementImpl(ExperienciaProfissionalDaoImpl.getInstance());
        registry.rebind("ExperienciaProfissionalManagement", experienciaProfissional); // registra este objeto
        
        FormacaoAcademicaManagement formacaoAcademica = new FormacaoAcademicaManagementImpl(FormacaoAcademicaDaoImpl.getInstance());
        registry.rebind("FormacaoAcademicaManagement", formacaoAcademica); // registra este objeto
        
        TelefoneManagement telefone = new TelefoneManagementImpl(TelefoneDaoImpl.getInstance());
        registry.rebind("TelefoneManagement", telefone); // registra este objeto
        
        UsuarioManagement usuario = new UsuarioManagementImpl(UsuarioDaoImpl.getInstance());
        registry.rebind("UsuarioManagement", usuario); // registra este objeto
        
        VagaManagement vaga = new VagaManagementImpl(VagaDaoImpl.getInstance());
        registry.rebind("VagaManagement", vaga); // registra este objeto
        
    }
}
