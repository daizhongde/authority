/** Effective config begin there   **/
--@JavaScript var AuthorityLevel = {};
--@JavaScript AuthorityLevel.query = {};
--@JavaScript AuthorityLevel.Add = {};
--@JavaScript AuthorityLevel.Update = {};
--@JavaScript AuthorityLevel.read = {};
--@JavaScript AuthorityLevel.Del = {};

--@JavaScript AuthorityLevel.Combobox = {};
--@JavaScript AuthorityModule.Tree = {};
--@JavaScript AuthorityLevel.Export = {};
--@JavaScript AuthorityLevel.Nest = {};

--@JavaScript AuthorityLevel.Query.query.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "name",
       t1.C_LNOTE     "note"
  from tool.t_authority_level t1

/* tableData HQL   */ 
--@JavaScript AuthorityLevel.Query.query.HQL

--@JavaScript AuthorityLevel.Query.query.JPQL

-- AuthorityLevel.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityLevel.Read.read.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "name",
       t1.C_LNOTE     "note"
  from tool.t_authority_level t1
  
-- AuthorityLevel.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityLevel.Read.read.HQL
-- AuthorityLevel.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityLevel t1 left outer join t1.NMparent p

--@JavaScript AuthorityLevel.Read.read.JPQL

-- SQL for select AuthorityLevel.Combobox.combobox.data
--@JavaScript AuthorityLevel.Combobox.combobox.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "text"
  from tool.t_authority_level t1

--HQL select AuthorityLevel.Combobox.combobox.data
--@JavaScript AuthorityLevel.Combobox.combobox.HQL

--@JavaScript AuthorityLevel.Combobox.combobox.JPQL

--@JavaScript AuthorityLevel.Export.export.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "name",
       t1.C_LNOTE     "note"
  from tool.t_authority_level t1

--@JavaScript AuthorityLevel.Export.export.HQL

--@JavaScript AuthorityLevel.Export.export.JPQL

--@JavaScript AuthorityLevel.Nest.nest.SQL
/**
select * 
  from tool.t_authority_level t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityLevel.Nest.nest.HQL

--@JavaScript AuthorityLevel.Nest.nest.JPQL
