create table diciplinas(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    carga_horaria int(11) not null,
    professor_id bigint(20) not null foreign key
    primary key(id)
);