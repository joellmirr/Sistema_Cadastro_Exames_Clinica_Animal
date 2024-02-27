/* Lógico_SaudeAnimal:*/

 CREATE TABLE Usuario (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);
 
 CREATE TABLE Fazenda (
    idfazenda INTEGER PRIMARY key unique AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    proprietario VARCHAR(100) NOT NULL,
    car VARCHAR(100) NOT NULL,/*Cadastro Ambiental Rural*/
    email VARCHAR(100),
    telefone VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL
    
);

CREATE TABLE Animal (
    idanimal INTEGER PRIMARY KEY unique AUTO_INCREMENT,
    nomeanimal VARCHAR(100) NOT NULL,
    especie VARCHAR(100) NOT NULL,
    datanascimente DATE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    descricaoanimal VARCHAR(100) NOT NULL,
    fazendaanimal INTEGER NOT NULL REFERENCES Fazenda (idfazenda)
);

CREATE TABLE Veterinario (
    idveterinario INTEGER PRIMARY KEY unique AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    crmv VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    especilaidade VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL
);

CREATE TABLE ExamesAnimal (
    idexameeanimal INTEGER PRIMARY key AUTO_INCREMENT,
    tipoexame VARCHAR(100) NOT NULL,
    resultadoexame VARCHAR(100) NOT NULL,
    datavacina DATE NOT NULL,
    vacina VARCHAR(100) NOT NULL,
    pesoanimal FLOAT NOT NULL,
    datapeso DATE NOT NULL,
    animal INTEGER NOT NULL REFERENCES Animal (idanimal),
    veterinario INTEGER NOT NULL REFERENCES Veterinario (idveterinario)
);






 
    
   
   
   
   
   
   
   

