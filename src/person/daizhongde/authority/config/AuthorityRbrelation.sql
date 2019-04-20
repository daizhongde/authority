/** Effective config begin there   **/
--@JavaScript var AuthorityRbrelation = {};
--@JavaScript AuthorityRbrelation.query = {};
--@JavaScript AuthorityRbrelation.Add = {};
--@JavaScript AuthorityRbrelation.Update = {};
--@JavaScript AuthorityRbrelation.read = {};
--@JavaScript AuthorityRbrelation.Del = {};

--@JavaScript AuthorityRbrelation.Combobox = {};
--@JavaScript AuthorityModule.Tree = {};
--@JavaScript AuthorityRbrelation.Export = {};
--@JavaScript AuthorityRbrelation.Nest = {};

--@JavaScript AuthorityRbrelation.Query.query.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_BID "n_bid",
  t1.C_RULE "c_rule",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_rbrelation t1 

/* tableData HQL   */ 
--@JavaScript AuthorityRbrelation.Query.query.HQL

--@JavaScript AuthorityRbrelation.Query.query.JPQL

--@JavaScript AuthorityRbrelation.Query.query_userButton4tb.SQL
SELECT 
  IF(t2.n_bid IS NULL, 'N', 'Y') AS "checked",
  t1.n_bid "NBid",
  t1.c_bcode "CBcode",
  t1.c_bname "CBname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "NMid" 
FROM
  tool.t_authority_button t1 
  LEFT OUTER JOIN tool.t_authority_rbrelation t2 
    ON t2.n_bid = t1.n_bid 
    AND t2.n_rid IN 
    (SELECT 
      n_rid 
    FROM
      tool.`t_authority_urrelation` 
    WHERE n_uid = :n_uid ) 
WHERE t1.n_mid = :n_mid 

-- AuthorityRbrelation.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityRbrelation.Read.read.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_BID "n_bid",
  t1.C_RULE "c_rule",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_rbrelation t1 
  
-- AuthorityRbrelation.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityRbrelation.Read.read.HQL
-- AuthorityRbrelation.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityRbrelation t1 left outer join t1.NMparent p

--@JavaScript AuthorityRbrelation.Read.read.JPQL

-- SQL for select AuthorityRbrelation.Combobox.combobox.data
--@JavaScript AuthorityRbrelation.Combobox.combobox.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "text"
  from tool.t_authority_level t1

--HQL select AuthorityRbrelation.Combobox.combobox.data
--@JavaScript AuthorityRbrelation.Combobox.combobox.HQL

--@JavaScript AuthorityRbrelation.Combobox.combobox.JPQL

--@JavaScript AuthorityRbrelation.Export.export.SQL
SELECT 
  t1.N_RID "n_rid",
  t1.N_BID "n_bid",
  t1.C_RULE "c_rule",
  t1.C_CTIME "c_ctime",
  t1.C_CIP "c_cip",
  t1.C_CREATOR "c_creator" 
FROM
  tool.t_authority_rbrelation t1 

--@JavaScript AuthorityRbrelation.Export.export.HQL

--@JavaScript AuthorityRbrelation.Export.export.JPQL

--@JavaScript AuthorityRbrelation.Nest.nest.SQL
/**
select * 
  from tool.t_authority_level t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityRbrelation.Nest.nest.HQL

--@JavaScript AuthorityRbrelation.Nest.nest.JPQL
