create table aulunos(

    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null unique,
    cpf varchar(255) not null unique,

    primary key (id)

);