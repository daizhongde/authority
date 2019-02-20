/** Effective config begin there   **/
--@JavaScript var AuthorityUrrelation = {};
--@JavaScript AuthorityUrrelation.query = {};
--@JavaScript AuthorityUrrelation.Add = {};
--@JavaScript AuthorityUrrelation.Update = {};
--@JavaScript AuthorityUrrelation.read = {};
--@JavaScript AuthorityUrrelation.Del = {};

--@JavaScript AuthorityUrrelation.Combobox = {};
--@JavaScript AuthorityUrrelation.Nest = {};
--@JavaScript AuthorityUrrelation.Export = {};

--@JavaScript AuthorityUrrelation.Query.query.SQL
select t1.N_UID     "n_uid",
       t1.N_RID     "n_rid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from tool.t_authority_urrelation t1


/* tableData HQL   */ 
--@JavaScript AuthorityUrrelation.Query.query.HQL

--@JavaScript AuthorityUrrelation.Query.query.JPQL

-- AuthorityUrrelation.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityUrrelation.Read.read.SQL
select t1.N_UID     "n_uid",
       t1.N_RID     "n_rid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from tool.t_authority_urrelation t1

  
-- AuthorityUrrelation.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityUrrelation.Read.read.HQL
-- AuthorityUrrelation.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityUrrelation t1 left outer join t1.NMparent p

--@JavaScript AuthorityUrrelation.Read.read.JPQL

-- SQL for select AuthorityUrrelation.Combobox.combobox.data
--@JavaScript AuthorityUrrelation.Combobox.combobox.SQL
select t1.N_UID     "n_uid",
       t1.N_RID     "n_rid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from tool.t_authority_urrelation t1


--HQL select AuthorityUrrelation.Combobox.combobox.data
--@JavaScript AuthorityUrrelation.Combobox.combobox.HQL

--@JavaScript AuthorityUrrelation.Combobox.combobox.JPQL

--@JavaScript AuthorityUrrelation.Export.export.SQL
select t1.N_UID     "n_uid",
       t1.N_RID     "n_rid",
       t1.C_CTIME   "c_ctime",
       t1.C_CIP     "c_cip",
       t1.C_CREATOR "c_creator"
  from tool.t_authority_urrelation t1


--@JavaScript AuthorityUrrelation.Export.export.HQL

--@JavaScript AuthorityUrrelation.Export.export.JPQL

--@JavaScript AuthorityUrrelation.Nest.nest.SQL
/**
select * 
  from tool.t_authority_level t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityUrrelation.Nest.nest.HQL

--@JavaScript AuthorityUrrelation.Nest.nest.JPQL
