CREATE SCHEMA jbehave_schema;
CREATE TABLE jbehave_schema.client(
   id         SERIAL            ,
   last_name  VARCHAR (250)     ,
   first_name VARCHAR (250)     ,
   age        INT               ,
   PRIMARY KEY (id)
);
