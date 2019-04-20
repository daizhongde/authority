/** Effective config begin there   **/
--@JavaScript var AuthorityRbrelation = {};
--@JavaScript AuthorityRbrelation.query = {};
--@JavaScript AuthorityRbrelation.Add = {};
--@JavaScript AuthorityRbrelation.Update = {};
--@JavaScript AuthorityRbrelation.read = {};
--@JavaScript AuthorityRbrelation.Del = {};

--@JavaScript AuthorityRbrelation.Combobox = {};
--@JavaScript AuthorityRbrelation.Nest = {};
--@JavaScript AuthorityRbrelation.Export = {};

--@JavaScript AuthorityRbrelation.Query.query.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_MID "n_mid",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator",
  t1.create_btn "create_btn",
  t1.update_btn "update_btn",
  t1.update_btn1 "update_btn1",
  t1.read_btn "read_btn",
  t1.delete_btn "delete_btn",
  t1.delete_btn1 "delete_btn1",
  t1.delete_btn2 "delete_btn2",
  t1.search_btn "search_btn",
  t1.import_btn "import_btn",
  t1.import_wizardbtn "import_wizardbtn",
  t1.export_btn "export_btn",
  t1.export_wizardbtn "export_wizardbtn",
  t1.print_btn "print_btn",
  t1.print_previewbtn "print_previewbtn",
  t1.btn15 "btn15",
  t1.btn16 "btn16",
  t1.btn17 "btn17",
  t1.btn18 "btn18",
  t1.btn19 "btn19",
  t1.btn20 "btn20",
  t1.btn21 "btn21",
  t1.btn22 "btn22" 
FROM
  tool.t_authority_rmrelation t1 

--@JavaScript AuthorityRbrelation.Query.query.HQL

--@JavaScript AuthorityRbrelation.Query.query.JPQL

--@JavaScript AuthorityRbrelation.Query.query_userButton4tb.SQL
SELECT IFNULL(MAX(IF(create_btn='Y',1,0)),0) create_btn,  IFNULL(MAX(IF(update_btn='Y',1,0)),0) update_btn, IFNULL(MAX(IF(update_btn1='Y',1,0)),0) update_btn1,
       IFNULL(MAX(IF(read_btn='Y',1,0)),0) read_btn,      IFNULL(MAX(IF(delete_btn='Y',1,0)),0) delete_btn, IFNULL(MAX(IF(delete_btn1='Y',1,0)),0) delete_btn1,
       IFNULL(MAX(IF(delete_btn2='Y',1,0)),0) delete_btn2,IFNULL(MAX(IF(import_btn='Y',1,0)),0) import_btn, IFNULL(MAX(IF(import_wizardbtn='Y',1,0)),0) import_wizardbtn,
       IFNULL(MAX(IF(search_btn='Y',1,0)),0) search_btn,  IFNULL(MAX(IF(export_btn='Y',1,0)),0) export_btn, IFNULL(MAX(IF(export_wizardbtn='Y',1,0)),0) export_wizardbtn,
       IFNULL(MAX(IF(print_btn='Y',1,0)),0) print_btn,    IFNULL(MAX(IF(print_previewbtn='Y',1,0)),0) print_previewbtn, IFNULL(MAX(IF(btn15='Y',1,0)),0) btn15,
       IFNULL(MAX(IF(btn16='Y',1,0)),0) btn16,            IFNULL(MAX(IF(btn17='Y',1,0)),0) btn17,           IFNULL(MAX(IF(btn18='Y',1,0)),0) btn18,
       IFNULL(MAX(IF(btn19='Y',1,0)),0) btn19,            IFNULL(MAX(IF(btn20='Y',1,0)),0) btn20,           IFNULL(MAX(IF(btn21='Y',1,0)),0) btn21,
       IFNULL(MAX(IF(btn22='Y',1,0)),0) btn22
  FROM tool.`t_authority_rmrelation`
 WHERE n_mid= :n_mid AND n_rid IN
     ( SELECT n_rid FROM tool.`t_authority_urrelation` WHERE n_uid= :n_uid )
     
-- AuthorityRbrelation.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityRbrelation.Read.read.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_MID "n_mid",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator",
  t1.create_btn "create_btn",
  t1.update_btn "update_btn",
  t1.update_btn1 "update_btn1",
  t1.read_btn "read_btn",
  t1.delete_btn "delete_btn",
  t1.delete_btn1 "delete_btn1",
  t1.delete_btn2 "delete_btn2",
  t1.search_btn "search_btn",
  t1.import_btn "import_btn",
  t1.import_wizardbtn "import_wizardbtn",
  t1.export_btn "export_btn",
  t1.export_wizardbtn "export_wizardbtn",
  t1.print_btn "print_btn",
  t1.print_previewbtn "print_previewbtn",
  t1.btn15 "btn15",
  t1.btn16 "btn16",
  t1.btn17 "btn17",
  t1.btn18 "btn18",
  t1.btn19 "btn19",
  t1.btn20 "btn20",
  t1.btn21 "btn21",
  t1.btn22 "btn22"
FROM
  tool.t_authority_rmrelation t1 
  
-- AuthorityRbrelation.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityRbrelation.Read.read.HQL
-- AuthorityRbrelation.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityRbrelation t1 left outer join t1.NMparent p

--@JavaScript AuthorityRbrelation.Read.read.JPQL

-- SQL for select AuthorityRbrelation.Combobox.combobox.data
--@JavaScript AuthorityRbrelation.Combobox.combobox.SQL
select t1.N_RID     "n_rid",
       t1.N_MID     "n_mid"
  from tool.t_authority_rmrelation t1

--HQL select AuthorityRbrelation.Combobox.combobox.data
--@JavaScript AuthorityRbrelation.Combobox.combobox.HQL

--@JavaScript AuthorityRbrelation.Combobox.combobox.JPQL

--@JavaScript AuthorityRbrelation.Export.export.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_MID "n_mid",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator",
  t1.create_btn "create_btn",
  t1.update_btn "update_btn",
  t1.update_btn1 "update_btn1",
  t1.read_btn "read_btn",
  t1.delete_btn "delete_btn",
  t1.delete_btn1 "delete_btn1",
  t1.delete_btn2 "delete_btn2",
  t1.search_btn "search_btn",
  t1.import_btn "import_btn",
  t1.import_wizardbtn "import_wizardbtn",
  t1.export_btn "export_btn",
  t1.export_wizardbtn "export_wizardbtn",
  t1.print_btn "print_btn",
  t1.print_previewbtn "print_previewbtn",
  t1.btn15 "btn15",
  t1.btn16 "btn16",
  t1.btn17 "btn17",
  t1.btn18 "btn18",
  t1.btn19 "btn19",
  t1.btn20 "btn20",
  t1.btn21 "btn21",
  t1.btn22 "btn22"
FROM
  tool.t_authority_rmrelation t1 

--@JavaScript AuthorityRbrelation.Export.export.HQL

--@JavaScript AuthorityRbrelation.Export.export.JPQL

--@JavaScript AuthorityRbrelation.Nest.nest.SQL
 
--@JavaScript AuthorityRbrelation.Nest.nest.HQL

--@JavaScript AuthorityRbrelation.Nest.nest.JPQL
