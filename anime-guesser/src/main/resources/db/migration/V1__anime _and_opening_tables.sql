create table anime (
                       id bigserial primary key,
                       anime_name varchar(255) not null
);

create table opening (
                         id bigserial primary key,
                         anime bigint not null unique,
                         url varchar(500) not null,
                         constraint fk_opening_anime foreign key (anime) references anime(id)
);