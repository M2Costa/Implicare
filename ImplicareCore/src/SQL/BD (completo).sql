-- Create tables section -------------------------------------------------

-- Table Cargo

CREATE TABLE Cargo(
 Cod_Cargo Integer NOT NULL,
 Nom_Cargo Character varying NOT NULL
);

-- Add keys for table Cargo

ALTER TABLE Cargo ADD CONSTRAINT Key1 PRIMARY KEY (Cod_Cargo);

-- Table Usuario

CREATE TABLE Usuario(
 CPF_CNPJ Bigint NOT NULL,
 Email Character varying NOT NULL,
 Senha Character(44) NOT NULL,
 Foto Bytea,
 Cod_CEP Bigint,
 Endereco Character varying NOT NULL,
 Desc_Usuario Character varying
);

-- Add keys for table Usuario

ALTER TABLE Usuario ADD CONSTRAINT Key3 PRIMARY KEY (CPF_CNPJ);

-- Table Area_Estudo

CREATE TABLE Area_Estudo(
 Cod_Area_Estudo Integer NOT NULL,
 Nom_Area_Estudo Character varying NOT NULL
);

-- Add keys for table Area_Estudo

ALTER TABLE Area_Estudo ADD CONSTRAINT Key6 PRIMARY KEY (Cod_Area_Estudo);

-- Table Empresa

CREATE TABLE Empresa(
 CNPJ Bigint NOT NULL,
 Nom_Razao_Social Character varying NOT NULL,
 Nome_Fantasia Character varying NOT NULL
);

-- Add keys for table Empresa

ALTER TABLE Empresa ADD CONSTRAINT Key11 PRIMARY KEY (CNPJ);

-- Table Candidato

CREATE TABLE Candidato(
 CPF Bigint NOT NULL,
 Nome Character varying NOT NULL,
 Data_Nascimento Date NOT NULL
);

-- Add keys for table Candidato

ALTER TABLE Candidato ADD CONSTRAINT Key13 PRIMARY KEY (CPF);

-- Table Formacao_Academica

CREATE TABLE Formacao_Academica(
 CPF Bigint NOT NULL,
 Seq_Formacao Serial NOT NULL,
 Instituicao_Ensino Character varying NOT NULL,
 Cod_Area_Estudo Integer,
 Atividades_Desenvolvidas Character varying,
 Data_Inicio Date NOT NULL,
 Data_Termino Date NOT NULL,
 Desc_Formacao_Academica Character varying
);

-- Create indexes for table Formacao_Academica

CREATE INDEX IX_Relationship20 ON Formacao_Academica (Cod_Area_Estudo);

-- Add keys for table Formacao_Academica

ALTER TABLE Formacao_Academica ADD CONSTRAINT Key16 PRIMARY KEY (CPF, Seq_Formacao);

-- Table Experiencia_Profissional

CREATE TABLE Experiencia_Profissional(
 CPF Bigint NOT NULL,
 Seq_Experiencia_Profissional Serial NOT NULL,
 Nom_Empresa Character varying NOT NULL,
 Cod_Cargo Integer NOT NULL,
 Data_Inicio Date NOT NULL,
 Data_Termino Date,
 Desc_Experiencia_Profissional Character varying
);


-- Add keys for table Experiencia_Profissional

ALTER TABLE Experiencia_Profissional ADD CONSTRAINT Key17 PRIMARY KEY (CPF, Seq_Experiencia_Profissional, Cod_Cargo);

-- Table Telefone

CREATE TABLE Telefone(
 CPF_CNPJ Bigint NOT NULL,
 Seq_Telefone Serial NOT NULL,
 Num_Telefone Character(9) NOT NULL,
 Tipo_Telefone Character(1) NOT NULL,
 DDD integer NOT NULL,
 Ramal Integer
);

-- Add keys for table Telefone

ALTER TABLE Telefone ADD CONSTRAINT Key19 PRIMARY KEY (CPF_CNPJ, Seq_Telefone, Num_Telefone);

-- Table Cargo_Interesse

CREATE TABLE Cargo_Interesse(
 CPF Bigint NOT NULL,
 Cod_Cargo Integer NOT NULL
);

-- Add keys for table Cargo_Interesse

ALTER TABLE Cargo_Interesse ADD CONSTRAINT Key21 PRIMARY KEY (Cod_Cargo, CPF);

-- Table Vaga

CREATE TABLE Vaga(
 CNPJ Bigint NOT NULL,
 Seq_Vaga Serial NOT NULL,
 Cod_Cargo Integer NOT NULL,
 Dat_Publicacao Bigint NOT NULL,
 Num_Vagas Integer,
 Carga_Horaria Bigint NOT NULL,
 Remuneração Money,
 Desc_Vaga Character varying,
 Status_Vaga Bit(1) NOT NULL
 CONSTRAINT Check_Status CHECK (Status_Vaga = '0'::Bit(1) OR Status_Vaga = '1'::Bit(1))
);

COMMENT ON COLUMN Vaga.Status_Vaga IS '0 - Aberta; 1 - Fechada;';

-- Add keys for table Vaga

ALTER TABLE Vaga ADD CONSTRAINT Key23 PRIMARY KEY (Cod_Cargo, Seq_Vaga, CNPJ, Dat_Publicacao);

-- Table Candidato_Vaga

CREATE TABLE Candidato_Vaga(
 CPF Bigint NOT NULL,
 Seq_Vaga Serial NOT NULL,
 Cod_Cargo Integer NOT NULL,
 CNPJ Bigint NOT NULL,
 Dat_Publicacao Bigint NOT NULL,
 Status_Candidato Character(1) NOT NULL
 CONSTRAINT Check_Status CHECK (Status_Candidato = 'A'::Character(1) OR Status_Candidato = 'H'::Character(1) OR Status_Candidato = 'R'::Character(1) OR Status_Candidato = 'E'::Character(1))
);

COMMENT ON COLUMN Candidato_Vaga.Status_Candidato IS 'A - Aceito; H - Habilitado; R - Rejeitado; E - Espera;';

-- Add keys for table Candidato_Vaga

ALTER TABLE Candidato_Vaga ADD CONSTRAINT Key24 PRIMARY KEY (CPF, Seq_Vaga, Cod_Cargo, CNPJ, Dat_Publicacao);

-- Table Cargo_areaestudo

CREATE TABLE Cargo_areaestudo(
 Cod_Area_Estudo Integer NOT NULL,
 Cod_Cargo Integer NOT NULL
);

-- Add keys for table Cargo_areaestudo

ALTER TABLE Cargo_areaestudo ADD CONSTRAINT Key26 PRIMARY KEY (Cod_Area_Estudo,Cod_Cargo);
-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Empresa ADD CONSTRAINT Relationship6 FOREIGN KEY (CNPJ) REFERENCES Usuario (CPF_CNPJ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Candidato ADD CONSTRAINT Relationship9 FOREIGN KEY (CPF) REFERENCES Usuario (CPF_CNPJ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Formacao_Academica ADD CONSTRAINT Relationship19 FOREIGN KEY (CPF) REFERENCES Candidato (CPF) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Formacao_Academica ADD CONSTRAINT Relationship20 FOREIGN KEY (Cod_Area_Estudo) REFERENCES Area_Estudo (Cod_Area_Estudo) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Experiencia_Profissional ADD CONSTRAINT Relationship21 FOREIGN KEY (CPF) REFERENCES Candidato (CPF) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Experiencia_Profissional ADD CONSTRAINT Relationship22 FOREIGN KEY (Cod_Cargo) REFERENCES Cargo (Cod_Cargo) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Telefone ADD CONSTRAINT Relationship28 FOREIGN KEY (CPF_CNPJ) REFERENCES Usuario (CPF_CNPJ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Cargo_Interesse ADD CONSTRAINT Relationship33 FOREIGN KEY (Cod_Cargo) REFERENCES Cargo (Cod_Cargo) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Cargo_Interesse ADD CONSTRAINT Relationship34 FOREIGN KEY (CPF) REFERENCES Candidato (CPF) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Vaga ADD CONSTRAINT Relationship39 FOREIGN KEY (Cod_Cargo) REFERENCES Cargo (Cod_Cargo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Candidato_Vaga ADD CONSTRAINT Relationship42 FOREIGN KEY (CPF) REFERENCES Candidato (CPF) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Candidato_Vaga ADD CONSTRAINT Relationship43 FOREIGN KEY (Cod_Cargo, Seq_Vaga, CNPJ, Dat_Publicacao) REFERENCES Vaga (Cod_Cargo, Seq_Vaga, CNPJ, Dat_Publicacao) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Vaga ADD CONSTRAINT Relationship46 FOREIGN KEY (CNPJ) REFERENCES Empresa (CNPJ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Cargo_areaestudo ADD CONSTRAINT Relationship48 FOREIGN KEY (Cod_Area_Estudo) REFERENCES Area_Estudo (Cod_Area_Estudo) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Cargo_areaestudo ADD CONSTRAINT Relationship49 FOREIGN KEY (Cod_Cargo) REFERENCES Cargo (Cod_Cargo) ON DELETE NO ACTION ON UPDATE NO ACTION;

--Adicionando conteúdo às tabelas, quase todas -----------------------------------------------------------------

INSERT INTO Cargo (Cod_Cargo, Nom_Cargo) VALUES 
(0, 'Administrador'),
(1, 'Analista Programador') ,
(2, 'Advogado'),
(3, 'Advogado Criminalista'),
(4, 'Babá'),
(5, 'Balconista'),
(6, 'Biomédico'),
(7, 'Biólogo'),
(8, 'Cobrador de Ônibus'),
(9, 'Churrasqueiro'),
(10, 'Consultor Financeiro'),
(11, 'Coordenador Contábil'),
(12, 'Desenhista Projetista Elétricos'),
(13, 'Dentista'),
(14, 'Diretor de Marketing'),
(15, 'Diretor de Vendas'),
(16, 'Estágio em Comunicação e Marketing'),
(17, 'Estágio em Farmácia'),
(18, 'Eletricista de Instalações'),
(19, 'Eletrotécnico'),
(20, 'Farmacêutico'),
(21, 'Fiscal de Obras'),
(22, 'Fiscal de Loja'),
(23, 'Fisioterapeuta'),
(24, 'Guia de Turismo'),
(25, 'Gerente Administrativo'),
(26, 'Gerente de Nutrição'),
(27, 'Gerente de Transportes'),
(28, 'Historiador'),
(29, 'Analista Fiscal'),
(30, 'Analista Financeiro'),
(31, 'Coordenador Administrativo'),
(32, 'Inspetor de Qualidade'),
(33, 'Instalador de Equipamentos Eletrônicos'),
(34, 'Intérprete'),
(35, 'Instalador de Telecomunicações'),
(36, 'Jornalista'),
(37, 'Jardineiro'),
(38, 'Engenheiro Civil'),
(39, 'Engenheiro de Software'),
(40, 'Limpador'),
(41, 'Líder de Manutenção Elétrica'),
(42, 'Mecânico'),
(43, 'Matemático'),
(44, 'Motorista de Ônibus'),
(45, 'Motorista Entregador'),
(46, 'Médico Endocrinologista'),
(47, 'Nutricionista'),
(48, 'Nutricionista Clínico'),
(49, 'Nutricionista do Esporte'),
(50, 'Office-boy'),
(51, 'Operador de Áudio'),
(52, 'Operador de Caixa'),
(53, 'Operador de Turismo'),
(54, 'Orçamentista'),
(55, 'Operador de Rádio'),
(56, 'Professor de Engenharia Civil'),
(57, 'Professor de Engenharia da Computação'),
(58, 'Professor de Ensino Médio'),
(59, 'Professor de Futebol'),
(60, 'Químico Industrial'),
(61, 'Químico'),
(62, 'Professor de Engenharia Mecânica'),
(63, 'Professor de Física'),
(64, 'Radialista'),
(65, 'Revisor de Texto'),
(66, 'Repórter'),
(67, 'Relações Públicas'),
(68, 'Supervisor de Farmácia'),
(69, 'Supervisor de Nutrição'),
(70, 'Supervisor de Marketing'),
(71, 'Suporte Técnico'),
(72, 'Técnico em Edificações'),
(73, 'Técnico em Informática'),
(74, 'Técnico em Mecânica'),
(75, 'Técnico em Mecatrônica'),
(76, 'Vigilante'),
(77, 'Vendedor de Loja'),
(78, 'Veterinário'),
(79, 'Veterinário Patologista'),
(80, 'Web Designer'),
(81, 'Web Designer Trainee'),
(82, 'Web Developer'),
(83, 'Webmaster'),
(84, 'Zelador');

INSERT INTO Area_Estudo (Cod_Area_Estudo, Nom_Area_Estudo) VALUES
(0, 'Ensino Fundamental'),
(1, 'Ensino Médio'),
(2, 'Técnico em Meio Ambiente'),
(3, 'Técnico em Redes de Computadores'),
(4, 'Técnico em Mecânica'),
(5, 'Técnico em Eletrotécnica'),
(6, 'Técnico em Informática'),
(7, 'Técnico em Hospedagem'),
(8, 'Técnico em Mecatrônica'),
(9, 'Técnico em Eletrônica'),
(10, 'Técnico em Estradas e Trânsito'),
(11, 'Técnico em Infemagem'),
(12, 'Técnico em Quimica'),
(13, 'Engenharia Mecânica'),
(14, 'Engenharia Elétrica'),
(15, 'Engenharia Civil'),
(16, 'Engenharia Produção'),
(17, 'Engenheida Computação'),
(19, 'Engenharia Software'),
(20, 'Finaças'),
(21, 'Contabilidade'),
(22, 'Economia'),
(23, 'Direito'),
(24, 'Educação Fisica'),
(25, 'Ciência Computação'),
(26, 'Matemática'),
(27, 'Matemática Computacional'),
(28, 'Fisica'),
(29, 'História'),
(30, 'Quimica'),
(31, 'Engenharia Quimica'),
(32, 'Medicina'),
(35, 'Cinema'),
(36, 'Veterinário'),
(37, 'Dentista'),
(38, 'Biologia'),
(39, 'Administração'),
(40, 'Ciências Contábeis'),
(41, 'Gestão'),
(42, 'Jornalismo'),
(43, 'Economia'),
(45, 'Marketing'),
(46, 'Técnico em Comunicação'),
(47, 'Marketing Comunicação'),
(48, 'Letras'),
(49, 'Linguagem'),
(50, 'Publicidade'),
(51, 'Relações Publicas'),
(52, 'Ciências Políticas'),
(53, 'Nutricionista'),
(54, 'Farmácia');

INSERT INTO Cargo_AreaEstudo(Cod_Area_Estudo, Cod_Cargo) VALUES
(0, 4), (0, 5), (0, 9), (0, 37), (0, 40), (0, 50), (0, 76), (0, 84),
(1, 4), (1, 5), (1, 9), (1, 37), (1, 40), (1, 44), (1, 45), (1, 50),
(1, 76), (1, 84), (1, 8), (1, 22), (1, 77), (2, 24), (3, 71), (3, 73),
(4, 42), (4, 74), (5, 12), (5, 18), (5, 19), (5, 33), (5, 35), (5, 41),
(5, 51), (5, 55), (5, 71), (6, 71), (6, 73), (6, 80), (6, 82), (7, 24),
(7, 53), (8, 12), (8, 18), (8, 19), (8, 33), (8, 35), (8, 41), (8, 51),
(8, 55), (8, 71), (8, 75), (9, 12), (9, 18), (9, 19), (9, 33), (9, 35),
(9, 41), (9, 51), (9, 55), (9, 71), (10, 21), (10, 27), (11, 17), (11, 20),
(12, 17), (12, 20), (12, 60), (12, 61), (12, 68), (13, 42), (13, 43),
(13, 58), (13, 62), (13, 63), (13, 74), (14, 12), (14, 18), (14, 19),
(14, 33), (14, 41), (14, 43), (14, 56), (14, 57), (14, 58), (14, 62),
(14, 63), (15, 21), (15, 38), (15, 56), (15, 58), (15, 72), (16, 21),
(16, 38), (16, 56), (16, 58), (16, 72), (17, 1), (17, 12), (17, 39),
(17, 43), (17, 57), (17, 58), (17, 63), (17, 73), (17, 80), (17, 81),
(17, 82), (17, 83), (19, 1), (19, 12), (19, 39), (19, 43), (19, 57),
(19, 58), (19, 63), (19, 73), (19, 80), (19, 81), (19, 82), (19, 83),
(20, 10), (20, 11), (20, 15), (20, 25), (20, 29), (20, 30), (20, 31),
(20, 54), (21, 0), (21, 10), (21, 11), (21, 15), (21, 25), (21, 29),
(21, 30), (21, 31), (21, 54), (22, 0), (22, 10), (22, 11), (22, 15),
(22, 25), (22, 29), (22, 30), (22, 31), (22, 54), (23, 2), (23, 3),
(24, 58), (24, 59), (25, 1), (25, 12), (25, 39), (25, 43), (25, 57),
(25, 58), (25, 63), (25, 73), (25, 80), (25, 81), (25, 82), (25, 83),
(26, 43), (26, 58), (27, 1), (27, 12), (27, 39), (27, 43), (27, 57),
(27, 58), (27, 63), (27, 73), (27, 80), (27, 81), (27, 82), (27, 83),
(28, 43), (28, 58), (28, 63), (29, 28), (30, 17), (30, 20), (30, 32),
(30, 28), (30, 60), (30, 61), (30, 68), (31, 17), (31, 20), (31, 32),
(31, 28), (31, 60), (31, 61), (31, 68), (32, 6), (32, 46), (35, 34),
(35, 51), (35, 55), (35, 65), (35, 67), (36, 78), (36, 79), (37, 13),
(38, 6), (38, 7), (38, 58), (39, 0), (39, 10), (39, 11), (39, 15),
(39, 25), (39, 29), (39, 30), (39, 31), (39, 54), (40, 0), (40, 10),
(40, 11), (40, 15), (40, 25), (40, 29), (40, 30), (40, 31), (40, 54),
(41, 0), (41, 10), (41, 11), (41, 15), (41, 25), (41, 29), (41, 30),
(41, 31), (41, 54), (43, 0), (43, 10), (43, 11), (43, 15), (43, 25),
(43, 29), (43, 30), (43, 31), (43, 54), (42, 16), (42, 36), (42, 34),
(42, 64), (42, 65), (42, 66), (45, 14), (45, 16), (45, 67), (45, 70),
(46, 16), (46, 67), (47, 14), (47, 16), (47, 67), (47, 70), (48, 34),
(48, 58), (48, 65), (49, 34), (49, 58), (49, 65), (50, 14), (50, 16),
(50, 67), (50, 70), (51, 14), (51, 16), (51, 67), (51, 70), (52, 67),
(53, 47), (53, 48), (53, 49), (53, 69), (54, 17), (54, 20), (54, 68);

INSERT INTO Usuario (CPF_CNPJ, Email, Senha, Foto, Cod_CEP, Endereco, Desc_Usuario) VALUES
(12189917699, 'positivo@positivo.com', '21ad84adv3a', NULL, 31310960, 'Av. Amazonas', 'Empresa de Tecnologia & Eletronicos'),
(18986913678, 'Lg@LG.com', 'hndfuimG', NULL, 31290756, 'Av. São Paulo', 'Empresa de Tecnologia & Eletronicos'),
(19289916798, 'Hostel@gmail.com', 'hjdfiufdgng', NULL, 39209760, 'Av. Contorno', 'Empresa Hoteleira'),
(89213819628, 'Betsona@hotmail.com', 'giduhgdgngdsg', NULL, 38210980, 'Av. Rio de Janeiro', 'Empresa Farmacêutica'),
(25889918652, 'philco@philco.com', '189359521hb', NULL, 36250836, 'Av. Brasil', 'Empresa de Tecnologia & Eletronicos');

INSERT INTO Empresa (CNPJ, Nom_Razao_Social, Nome_Fantasia) VALUES
(12189917699, 'Positivo', 'Positivo'),
(18986913678, 'LG', 'LG'),
(19289916798, 'Hostel', 'Hostel'),
(89213819628, 'Betsona', 'Betsona'),
(25889918652, 'Philco', 'Philco');

INSERT INTO Telefone(CPF_CNPJ, Seq_Telefone, Num_Telefone, Tipo_Telefone, DDD, Ramal) VALUES
(12189917699, 1, '35424987', 'C', 31, null),
(12189917699, 2,'35315894', 'F', 31, 2),
(18986913678, 3, '991045968', 'M', 14, null),
(18986913678, 4,'985687557', 'M', 14, null),
(18986913678, 5, '392424685', 'C', 14, null),
(19289916798, 6,'32596875', 'C', 31, 12),
(19289916798, 7,'32596875', 'C', 31, 16),
(89213819628, 8,'38956759', 'C', 21, null),
(89213819628, 9,'37598650', 'C', 31, null),
(89213819628, 10,'39578965', 'C', 31, null);