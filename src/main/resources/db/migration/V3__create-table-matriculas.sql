create table matriculas(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    carga_horaria int(11) not null,
    primary key(id));