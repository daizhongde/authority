/** Effective config begin there   **/
--@JavaScript var AuthorityFunc = {};
--@JavaScript AuthorityFunc.query = {};
--@JavaScript AuthorityFunc.Add = {};
--@JavaScript AuthorityFunc.Update = {};
--@JavaScript AuthorityFunc.read = {};
--@JavaScript AuthorityFunc.Del = {};

--@JavaScript AuthorityFunc.Combobox = {};
--@JavaScript AuthorityModule.Tree = {};
--@JavaScript AuthorityFunc.Export = {};
--@JavaScript AuthorityFunc.Nest = {};

--@JavaScript AuthorityFunc.Query.query.SQL
SELECT 
  t1.n_fid "n_fid",
  t1.c_fcode "c_fcode",
  t1.c_fname "c_fname",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_func t1 

/* tableData HQL   */ 
--@JavaScript AuthorityFunc.Query.query.HQL

--@JavaScript AuthorityFunc.Query.query.JPQL

-- AuthorityFunc.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityFunc.Read.read.SQL
SELECT 
  t1.n_fid "n_fid",
  t1.c_fcode "c_fcode",
  t1.c_fname "c_fname",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_func t1 
  
-- AuthorityFunc.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityFunc.Read.read.HQL
-- AuthorityFunc.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityFunc t1 left outer join t1.NMparent p

--@JavaScript AuthorityFunc.Read.read.JPQL

-- SQL for select AuthorityFunc.Combobox.combobox.data
--@JavaScript AuthorityFunc.Combobox.combobox.SQL
select t1.c_fcode       "id",
       t1.c_fname     "text"
  from tool.t_authority_func t1

--HQL select AuthorityFunc.Combobox.combobox.data
--@JavaScript AuthorityFunc.Combobox.combobox.HQL

--@JavaScript AuthorityFunc.Combobox.combobox.JPQL

--@JavaScript AuthorityFunc.Export.export.SQL
SELECT 
  t1.n_fid "n_fid",
  t1.c_fcode "c_fcode",
  t1.c_fname "c_fname",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_func t1 

--@JavaScript AuthorityFunc.Export.export.HQL

--@JavaScript AuthorityFunc.Export.export.JPQL

--@JavaScript AuthorityFunc.Nest.nest.SQL
/**
select * 
  from tool.t_authority_level t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityFunc.Nest.nest.HQL

--@JavaScript AuthorityFunc.Nest.nest.JPQL
