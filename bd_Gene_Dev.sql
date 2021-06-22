create database Gene_Dev;

use Gene_Dev;

CREATE TABLE Tipos_Trabalho (
	id bigint  AUTO_INCREMENT,
	tipo_trabalho varchar(255) NOT NULL ,
	local_Do_Trabalho varchar(255) NOT NULL,
	PRIMARY KEY (id)
);
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("front-end","home-office");
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("front-end","presencial");
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("back-end","home-office");
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("back-end","presencial");
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("Full-Stack","home-office");
insert into Tipos_Trabalho (tipo_trabalho, local_Do_Trabalho) values ("Full-Stack","presencial");

select * from Tipos_Trabalho;

CREATE TABLE Usuario (
	id bigint AUTO_INCREMENT,
	nome_user varchar(255) NOT NULL,
	idade int NOT NULL,
	empregador boolean NOT NULL,
	email varchar(233) NOT NULL,
	senha varchar(233) NOT NULL,
	genero varchar(233) NOT NULL,
    especialidade bigint not null,
    Foreign key (especialidade) references tipos_Trabalho(id), 
	PRIMARY KEY (id)
);

insert into Usuario (nome_user, idade, empregador, email, senha, genero, especialidade) values ("Jakeline",19,false, "ja.ckeline@gmail.com", "kiqlove","femenino", 2);

select * from Usuario;
select * from Usuario inner join  Tipos_trabalho on Tipos_trabalho.id = Usuario.especialidade;


CREATE TABLE O_Trabalho (
	id bigint  AUTO_INCREMENT,
	tema varchar(255) NOT NULL ,
	descricao varchar(255) NOT NULL ,
	valor DECIMAL NOT NULL ,
	experiencia varchar(255) NOT NULL,
	tipo_trampos_id bigint NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (tipo_trampos_id) REFERENCES Tipos_Trabalho(id)
);

insert into O_trabalho(tema, descricao, valor, experiencia, tipo_trampos_id)values("Back-end free","quero um back end para finalizar o site da minha loginha",450,"Junior",3);

select * from O_trabalho;

select * from O_trabalho inner join  Tipos_trabalho on Tipos_trabalho.id = O_trabalho.tipo_trampos_id;

