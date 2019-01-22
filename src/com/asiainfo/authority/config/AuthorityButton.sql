/** Effective config begin there   **/
--@JavaScript var AuthorityButton = {};
--@JavaScript AuthorityButton.query = {};
--@JavaScript AuthorityButton.Add = {};
--@JavaScript AuthorityButton.Update = {};
--@JavaScript AuthorityButton.read = {};
--@JavaScript AuthorityButton.Del = {};

--@JavaScript AuthorityButton.Combobox = {};
--@JavaScript AuthorityModule.Tree = {};
--@JavaScript AuthorityButton.Export = {};
--@JavaScript AuthorityButton.Nest = {};

--@JavaScript AuthorityButton.Query.query.SQL
SELECT 
  t1.n_bid "NBid",
  t1.c_bcode "CBcode",
  t1.c_bname "CBname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "NMid" 
FROM
  tool.t_authority_button t1 

/* tableData HQL   */ 
--@JavaScript AuthorityButton.Query.query.HQL

--@JavaScript AuthorityButton.Query.query.JPQL

--@JavaScript AuthorityButton.Query.query_WithCheckRow.SQL
SELECT 
  IF((SELECT n_bid FROM tool.t_authority_rbrelation t2 WHERE t2.n_rid= :n_rid AND t2.n_bid=t1.n_bid) IS NULL, 'N','Y') AS "checked",
  t1.n_bid "NBid",
  t1.c_bcode "CBcode",
  t1.c_bname "CBname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "NMid" 
FROM
  tool.t_authority_button t1 

--@JavaScript AuthorityButton.Query.query_WithCheckRow2.SQL 
SELECT 
  IF(t2.n_bid IS NULL, 'N', 'Y') AS "checked",
  t1.n_bid "NBid",
  t2.c_rule "CRule",
  t1.c_bcode "CBcode",
  t1.c_bname "CBname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "NMid" 
FROM
  tool.t_authority_button t1 
  LEFT OUTER JOIN tool.t_authority_rbrelation t2 
    ON t2.n_rid = :n_rid
    AND t2.n_bid = t1.n_bid

-- AuthorityButton.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityButton.Read.read.SQL
SELECT 
  t1.n_bid "n_bid",
  t1.c_bcode "c_bcode",
  t1.c_bname "c_bname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "n_mid" 
FROM
  tool.t_authority_button t1 
  
-- AuthorityButton.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityButton.Read.read.HQL
-- AuthorityButton.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityButton t1 left outer join t1.NMparent p

--@JavaScript AuthorityButton.Read.read.JPQL

-- SQL for select AuthorityButton.Combobox.combobox.data
--@JavaScript AuthorityButton.Combobox.combobox.SQL
select t1.N_LID       "id",
       t1.C_LNAME     "text"
  from tool.t_authority_level t1

--HQL select AuthorityButton.Combobox.combobox.data
--@JavaScript AuthorityButton.Combobox.combobox.HQL

--@JavaScript AuthorityButton.Combobox.combobox.JPQL

--@JavaScript AuthorityButton.Export.export.SQL
SELECT 
  t1.n_bid "n_bid",
  t1.c_bcode "c_bcode",
  t1.c_bname "c_bname",
  t1.url "url",
  t1.remark "remark",
  t1.n_mid "n_mid" 
FROM
  tool.t_authority_button t1 

--@JavaScript AuthorityButton.Export.export.HQL

--@JavaScript AuthorityButton.Export.export.JPQL

--@JavaScript AuthorityButton.Nest.nest.SQL
/**
select * 
  from tool.t_authority_level t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityButton.Nest.nest.HQL

--@JavaScript AuthorityButton.Nest.nest.JPQL
