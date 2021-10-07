DROP TABLE IF EXISTS medicine CASCADE;
CREATE TABLE medicine
(
   id BIGINT NOT NULL AUTO_INCREMENT,
   chemical_formula VARCHAR (255),
   common_name VARCHAR (255),
   is_approved_by_mhra BIT (1),
   is_controlled_drug BIT (1),
   iupac_name VARCHAR (255),
   max_store_temp FLOAT,
   min_store_temp FLOAT,
   molecular_weight DOUBLE,
    PRIMARY KEY (id)
);