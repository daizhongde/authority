/** a variable, like javascript

--@JavaScript var AuthorityInst = {};
--@JavaScript AuthorityInst.Query = {};
--@JavaScript AuthorityInst.Add = {};
--@JavaScript AuthorityInst.Update = {};
--@JavaScript AuthorityInst.Read = {};
--@JavaScript AuthorityInst.Del = {};

--@JavaScript AuthorityInst.Combobox = {};
--@JavaScript AuthorityInst.Tree = {};
--@JavaScript AuthorityInst.Nest = {};
--@JavaScript AuthorityInst.Export = {}
;

ten AuthorityInst's basic SQL(include HQL), You can see as query0,read0,combobox0,nest0,export0                         
	AuthorityInst.Query.query.SQL        AuthorityInst.Query.query.HQL        AuthorityInst.Query.query.JPQL    
	AuthorityInst.Read.read.SQL          AuthorityInst.Read.read.HQL          AuthorityInst.Read.read.JPQL      
	AuthorityInst.Combobox.combobox.SQL  AuthorityInst.Combobox.combobox.HQL  AuthorityInst.Combobox.combobox.JPQL
	AuthorityInst.Tree.tree.SQL  		   AuthorityInst.Tree.tree.HQL 		  AuthorityInst.Tree.tree.JPQL
	AuthorityInst.Export.export.SQL      AuthorityInst.Export.export.HQL      AuthorityInst.Export.export.JPQL  
	AuthorityInst.Nest.nest.SQL          AuthorityInst.Nest.nest.HQL          AuthorityInst.Nest.nest.JPQL     

note: 
	Don't support back comment 

**/
 
-- CURD sql config file
-- All table need use alias,the target table name's alias is 't1'
-- the target table name is back of the first 'from' key words, 
-- only a space are permit back of the 'from' key words 

/** Effective config begin there   **/
--@JavaScript var AuthorityInst = {};
--@JavaScript AuthorityInst.Query = {};
--@JavaScript AuthorityInst.Add = {};
--@JavaScript AuthorityInst.Update = {};
--@JavaScript AuthorityInst.Read = {};
--@JavaScript AuthorityInst.Del = {};

--@JavaScript AuthorityInst.Combobox = {};
--@JavaScript AuthorityInst.Nest = {};
--@JavaScript AuthorityInst.Export = {};

--@JavaScript AuthorityInst.Query.query.SQL
select t1.N_IID          "n_iid",
       t1.C_ICODE        "c_icode",
       t1.C_INAME        "c_iname",
       t1.N_ILEVEL       "n_ilevel",
       t1.C_ILEAF        "c_ileaf",
       t1.N_ISUPERIOR    "n_isuperior",
       t1.N_ITYPE        "n_itype",
       t1.C_IMANAGER     "c_imanager",
       t1.C_IMTEL        "c_imtel",
       t1.C_IMEMAIL      "c_imemail",
       t1.C_IMQQ         "c_imqq",
       t1.C_ILINKMAN     "c_ilinkman",
       t1.C_ILTEL        "c_iltel",
       t1.C_ILEMAIL      "c_ilemail",
       t1.C_ILQQ         "c_ilqq",
       t1.C_IADDRESS     "c_iaddress",
       t1.C_IDESCRIPTION "c_idescription",
       t1.C_ICTIME       "c_ictime",
       t1.C_ICIP         "c_icip",
       t1.C_ICREATOR     "c_icreator",
       t1.C_IMTIME       "c_imtime",
       t1.C_IMIP         "c_imip",
       t1.C_IMODIFIER    "c_imodifier"
  from tool.t_authority_inst t1

/* tableData HQL   */ 
--@JavaScript AuthorityInst.Query.query.HQL

--@JavaScript AuthorityInst.Query.query.JPQL

-- AuthorityInst.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityInst.Read.read.SQL
select t1.N_IID          "n_iid",
       t1.C_ICODE        "c_icode",
       t1.C_INAME        "c_iname",
       t1.N_ILEVEL       "n_ilevel",
       t1.C_ILEAF        "c_ileaf",
       t1.N_ISUPERIOR    "n_isuperior",
       t1.N_ITYPE        "n_itype",
       t1.C_IMANAGER     "c_imanager",
       t1.C_IMTEL        "c_imtel",
       t1.C_IMEMAIL      "c_imemail",
       t1.C_IMQQ         "c_imqq",
       t1.C_ILINKMAN     "c_ilinkman",
       t1.C_ILTEL        "c_iltel",
       t1.C_ILEMAIL      "c_ilemail",
       t1.C_ILQQ         "c_ilqq",
       t1.C_IADDRESS     "c_iaddress",
       t1.C_IDESCRIPTION "c_idescription",
       t1.C_ICTIME       "c_ictime",
       t1.C_ICIP         "c_icip",
       t1.C_ICREATOR     "c_icreator",
       t1.C_IMTIME       "c_imtime",
       t1.C_IMIP         "c_imip",
       t1.C_IMODIFIER    "c_imodifier"
  from tool.t_authority_inst t1


-- AuthorityInst.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityInst.Read.read.HQL
-- AuthorityInst.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityInst t1 left outer join t1.NMparent p

--@JavaScript AuthorityInst.Read.read.JPQL

-- SQL for select AuthorityInst.Combobox.combobox.data
--@JavaScript AuthorityInst.Combobox.combobox.SQL
select t1.n_mid "id", t1.c_mname "text"
  from tool.t_authority_module t1
 where t1.c_mleaf = 'false'

-- HQL select AuthorityInst.Combobox.combobox.data
--@JavaScript AuthorityInst.Combobox.combobox.HQL

--@JavaScript AuthorityInst.Combobox.combobox.JPQL


--@JavaScript AuthorityInst.Tree.tree_CheckBoxTree = {};
--@JavaScript AuthorityInst.Tree.tree_CheckBoxTree.SQL
select t1.N_MID,
       t1.C_MNAME,
       t1.N_MLEVEL,
       t1.C_MLEAF,
       t1.N_MPARENT,
       --t2.C_MNAME     "super",
       t1.N_MORDER,
       t1.C_MTARGET,
       t1.C_MICONCLS,
       t1.C_MEXPANDED,
       --t1.C_MCHECKED  "checked",
       ifnull(t2.c_mchecked, t1.C_MCHECKED) as "C_MCHECKED", 
       
       t1.C_MPATH,
       t1.C_MNOTE,
       t1.C_MCTIME,
       t1.C_MCIP,
       t1.C_MCREATOR,
       t1.C_MMTIME,
       t1.C_MMIP,
       t1.C_MMODIFIER
  from tool.t_authority_module t1 
  left outer join 
   (  
       select t4.n_mid,'true' as "C_MCHECKED"
         from tool.t_authority_module  t4
        where t4.n_mid in 
        (
            select t3.n_mid from tool.t_authority_rmrelation t3 
             where t3.n_rid = :roleId
        )
   ) t2
   on t1.N_MID = t2.N_MID
start with t1.N_Mid = :moduleId connect by prior t1.N_Mid=t1.N_Mparent
order by t1.N_Mlevel, t1.N_Morder

--@JavaScript AuthorityInst.Export.export.SQL
select t1.N_IID          "n_iid",
       t1.C_ICODE        "c_icode",
       t1.C_INAME        "c_iname",
       t1.N_ILEVEL       "n_ilevel",
       t1.C_ILEAF        "c_ileaf",
       t1.N_ISUPERIOR    "n_isuperior",
       t1.N_ITYPE        "n_itype",
       t1.C_IMANAGER     "c_imanager",
       t1.C_IMTEL        "c_imtel",
       t1.C_IMEMAIL      "c_imemail",
       t1.C_IMQQ         "c_imqq",
       t1.C_ILINKMAN     "c_ilinkman",
       t1.C_ILTEL        "c_iltel",
       t1.C_ILEMAIL      "c_ilemail",
       t1.C_ILQQ         "c_ilqq",
       t1.C_IADDRESS     "c_iaddress",
       t1.C_IDESCRIPTION "c_idescription",
       t1.C_ICTIME       "c_ictime",
       t1.C_ICIP         "c_icip",
       t1.C_ICREATOR     "c_icreator",
       t1.C_IMTIME       "c_imtime",
       t1.C_IMIP         "c_imip",
       t1.C_IMODIFIER    "c_imodifier"
  from tool.t_authority_inst t1
       
--@JavaScript AuthorityInst.Export.export.HQL

--@JavaScript AuthorityInst.Export.export.JPQL

--@JavaScript AuthorityInst.Nest.nest.SQL
/**select * 
  from tool.t_authority_module t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityInst.Nest.nest.HQL

--@JavaScript AuthorityInst.Nest.nest.JPQL
