INSERT INTO medicine
(
   common_name,
   iupac_name,
   chemical_formula,
   molecular_weight,
   is_approved_by_mhra,
   is_controlled_drug,
   min_store_temp,
   max_store_temp
)
VALUES
(
   'Ibuprofen',
   '(RS)-2-(4-(2-methylpropyl)phenyl)propanoic acid',
   'C13H18O2',
   206.29,
   true,
   false,
   null,
   25.2
);