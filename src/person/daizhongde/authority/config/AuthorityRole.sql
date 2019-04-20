/** a variable, like javascript

--@JavaScript var AuthorityRole = {};
--@JavaScript AuthorityRole.Query = {};
--@JavaScript AuthorityRole.Add = {};
--@JavaScript AuthorityRole.Update = {};
--@JavaScript AuthorityRole.Read = {};
--@JavaScript AuthorityRole.Del = {};

--@JavaScript AuthorityRole.Combobox = {};
--@JavaScript AuthorityRole.Nest = {};
--@JavaScript AuthorityRole.Export = {};

ten AuthorityRole's basic SQL(include HQL), You can see as query0,read0,combobox0,nest0,export0                         
	AuthorityRole.Query.query.SQL        AuthorityRole.Query.query.HQL        AuthorityRole.Query.query.JPQL    
	AuthorityRole.Read.read.SQL          AuthorityRole.Read.read.HQL          AuthorityRole.Read.read.JPQL      
	AuthorityRole.Combobox.combobox.SQL  AuthorityRole.Combobox.combobox.HQL  AuthorityRole.Combobox.combobox.JPQL
	AuthorityRole.Nest.nest.SQL          AuthorityRole.Nest.nest.HQL          AuthorityRole.Nest.nest.JPQL      
	AuthorityRole.Export.export.SQL      AuthorityRole.Export.export.HQL      AuthorityRole.Export.export.JPQL  

note: 
	Don't support back comment 

**/
 
-- CURD sql config file
-- All table need use alias,the target table name's alias is 't1'
-- the target table name is back of the first 'from' key words, 
-- only a space are permit back of the 'from' key words 

/** Effective config begin there   **/
--@JavaScript var AuthorityRole = {};
--@JavaScript AuthorityRole.Query = {};
--@JavaScript AuthorityRole.Add = {};
--@JavaScript AuthorityRole.Update = {};
--@JavaScript AuthorityRole.Read = {};
--@JavaScript AuthorityRole.Del = {};

--@JavaScript AuthorityRole.Combobox = {};
--@JavaScript AuthorityRole.Nest = {};
--@JavaScript AuthorityRole.Export = {};

--@JavaScript AuthorityRole.Query.query.SQL
select t1.N_RID      "n_rid",
       t1.C_RNO      "c_rno",
       t1.C_RNAME    "c_rname",
       t1.N_RLEVEL   "n_rlevel",
       t1.C_RNOTE    "c_rnote",
       t1.C_RCTIME   "c_rctime",
       t1.C_RCIP     "c_rcip",
       t1.C_RCREATOR "c_rcreator",
       t1.C_RONS     "ons",
       t1.C_RONT     "ont"
  from tool.t_authority_role t1

/* tableData HQL   */ 
--@JavaScript AuthorityRole.Query.query.HQL

--@JavaScript AuthorityRole.Query.query.JPQL

-- AuthorityRole.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityRole.Read.read.SQL
select t1.N_RID      "n_rid",
       t1.C_RNO      "c_rno",
       t1.C_RNAME    "c_rname",
       t1.N_RLEVEL   "n_rlevel",
       t1.C_RNOTE    "c_rnote",
       t1.C_RCTIME   "c_rctime",
       t1.C_RCIP     "c_rcip",
       t1.C_RCREATOR "c_rcreator",
       t1.C_RONS     "ons",
       t1.C_RONT     "ont"
  from tool.t_authority_role t1

-- AuthorityRole.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityRole.Read.read.HQL
-- AuthorityRole.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityRole t1 left outer join t1.NMparent p

--@JavaScript AuthorityRole.Read.read.JPQL

-- SQL for select AuthorityRole.Combobox.combobox.data
--@JavaScript AuthorityRole.Combobox.combobox.SQL
select t1.C_RNO      "c_rno",
       t1.C_RNAME    "c_rname"
  from tool.t_authority_role t1

-- HQL select AuthorityRole.Combobox.combobox.data
--@JavaScript AuthorityRole.Combobox.combobox.HQL

--@JavaScript AuthorityRole.Combobox.combobox.JPQL

--@JavaScript AuthorityRole.Tree.tree_CheckBoxTree = {};
--@JavaScript AuthorityRole.Tree.tree_CheckBoxTree.SQL
select t1.N_RID,
       t1.C_RNO,
       t1.C_RNAME,
       t1.N_RLEVEL,
       t1.C_RNOTE,
       t1.C_RCTIME,
       --t1.C_RCIP 
       ifnull(t2.c_mchecked, 'false') as C_RCIP,
       t1.C_RCREATOR,
       t1.C_RONS,
       t1.C_RONT
  from tool.t_authority_role t1
  left outer join (select t4.n_rid, 'true' as "C_MCHECKED"
                     from tool.t_authority_role t4
                    where t4.n_rid in (select t3.n_rid
                                         from tool.t_authority_urrelation t3
                                        where t3.n_uid = :userId
                                       )) t2
    on t1.N_RID = t2.N_RID
 order by t1.C_RNO

--@JavaScript AuthorityRole.Tree.tree_CheckBoxTree_ExceptDev = {};
--@JavaScript AuthorityRole.Tree.tree_CheckBoxTree_ExceptDev.SQL
select t1.N_RID,
       t1.C_RNO,
       t1.C_RNAME,
       t1.N_RLEVEL,
       t1.C_RNOTE,
       t1.C_RCTIME,
       --t1.C_RCIP 
       ifnull(t2.c_mchecked, 'false') as C_RCIP,
       t1.C_RCREATOR,
       t1.C_RONS,
       t1.C_RONT
  from tool.t_authority_role t1
  left outer join (select t4.n_rid, 'true' as "C_MCHECKED"
                     from tool.t_authority_role t4
                    where t4.n_rid in (select t3.n_rid
                                         from tool.t_authority_urrelation t3
                                        where t3.n_uid = :userId
                                       )) t2
    on t1.N_RID = t2.N_RID
 where t1.N_RID != 98
 order by t1.C_RNO
 
--@JavaScript AuthorityRole.Export.export.SQL
select t1.N_RID      "n_rid",
       t1.C_RNO      "c_rno",
       t1.C_RNAME    "c_rname",
       t1.N_RLEVEL   "n_rlevel",
       t1.C_RNOTE    "c_rnote",
       t1.C_RCTIME   "c_rctime",
       t1.C_RCIP     "c_rcip",
       t1.C_RCREATOR "c_rcreator",
       t1.C_RONS     "ons",
       t1.C_RONT     "ont"
  from tool.t_authority_role t1
  
--@JavaScript AuthorityRole.Export.export.HQL

--@JavaScript AuthorityRole.Export.export.JPQL

--@JavaScript AuthorityRole.Nest.nest.SQL
/**select * 
  from tool.t_authority_module t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityRole.Nest.nest.HQL

--@JavaScript AuthorityRole.Nest.nest.JPQL
