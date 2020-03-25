create sequence hibernate_sequence start 1 increment 1;
create table companies (id int8 not null, description varchar(255), name varchar(255), primary key (id));
create table positions (id int8 not null, name varchar(255), company_id int8, primary key (id));
create table users (id int8 not null, age int4, first_name varchar(255), company_id int8, position_id int8, primary key (id));
alter table positions add constraint FKcp04rkt24x05oleew0hliak1b foreign key (company_id) references companies;
alter table users add constraint FKin8gn4o1hpiwe6qe4ey7ykwq7 foreign key (company_id) references companies;
alter table users add constraint FK6ph6xiiydudp6umjf2xckbbmi foreign key (position_id) references positions;

INSERT INTO companies (id, description, name) VALUES (1, 'BMW', 'Car manufacturer'), (2, 'Bosch', 'Engineering company');
INSERT INTO positions (id, name, company_id) VALUES (1, 'Engineer', 1), (2, 'Sales', 1), (3, 'Engineer', 2);
INSERT INTO users (id, first_name, age, company_id, position_id) VALUES (1, 'John', 21, 1, 1), (2, 'Mark', 24, 1, 2), (3, 'Steve', 22, 2, 3)
