/** a variable, like javascript

--@JavaScript var AuthorityModule = {};
--@JavaScript AuthorityModule.Query = {};
--@JavaScript AuthorityModule.Add = {};
--@JavaScript AuthorityModule.Update = {};
--@JavaScript AuthorityModule.Read = {};
--@JavaScript AuthorityModule.Del = {};

--@JavaScript AuthorityModule.Combobox = {};
--@JavaScript AuthorityModule.Tree = {};
--@JavaScript AuthorityModule.Nest = {};
--@JavaScript AuthorityModule.Export = {}
;

ten AuthorityModule's basic SQL(include HQL), You can see as query0,read0,combobox0,nest0,export0                         
	AuthorityModule.Query.query.SQL        AuthorityModule.Query.query.HQL        AuthorityModule.Query.query.JPQL    
	AuthorityModule.Read.read.SQL          AuthorityModule.Read.read.HQL          AuthorityModule.Read.read.JPQL      
	AuthorityModule.Combobox.combobox.SQL  AuthorityModule.Combobox.combobox.HQL  AuthorityModule.Combobox.combobox.JPQL
	AuthorityModule.Tree.tree.SQL  		   AuthorityModule.Tree.tree.HQL 		  AuthorityModule.Tree.tree.JPQL
	AuthorityModule.Export.export.SQL      AuthorityModule.Export.export.HQL      AuthorityModule.Export.export.JPQL  
	AuthorityModule.Nest.nest.SQL          AuthorityModule.Nest.nest.HQL          AuthorityModule.Nest.nest.JPQL     

note: 
	Don't support back comment 

**/
 
-- CURD sql config file
-- All table need use alias,the target table name's alias is 't1'
-- the target table name is back of the first 'from' key words, 
-- only a space are permit back of the 'from' key words 

/** Effective config begin there   **/
--@JavaScript var AuthorityModule = {};
--@JavaScript AuthorityModule.Query = {};
--@JavaScript AuthorityModule.Add = {};
--@JavaScript AuthorityModule.Update = {};
--@JavaScript AuthorityModule.Read = {};
--@JavaScript AuthorityModule.Del = {};

--@JavaScript AuthorityModule.Combobox = {};
--@JavaScript AuthorityModule.Nest = {};
--@JavaScript AuthorityModule.Export = {};

--@JavaScript AuthorityModule.Query.query.SQL
select t1.N_MID       "id",--ttt##
       t1.C_MNAME     "name",       
       t1.N_MLEVEL    "level",
       t1.C_MLEAF     "leaf",
       t1.N_MORDER    "order",
       t2.C_MNAME     "super",
       t1.C_MTARGET   "target",
       t1.C_MICONCLS  "iconcls",
       t1.C_MEXPANDED "expanded",
       t1.C_MCHECKED  "checked",
       t1.C_MPATH     "path",
       t1.C_MNOTE     "note",
       --t1.C_MCTIME    "ctime",
date_format(t1.C_MCTIME, '%Y-%m-%d %H:%i:%S') "ctime",
       t1.C_MCIP      "cip",
       t1.C_MCREATOR    "creator",
       
       -- t1.C_MMTIME    "mtime",
date_format(t1.C_MMTIME, '%Y-%m-%d %H:%i:%S') "mtime",
       t1.C_MMIP      "mip",
       t1.C_MMODIFIER    "modifier",
       t1.C_MONS      "ons",
       t1.C_MONT      "ont"
  from tool.t_authority_module t1
  left outer join tool.t_authority_module t2
    on t1.N_MPARENT = t2.N_MID

/* tableData HQL   */ 
--@JavaScript AuthorityModule.Query.query.HQL

--@JavaScript AuthorityModule.Query.query.JPQL

-- AuthorityModule.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityModule.Read.read.SQL
select t1.N_Mid as "id",
       t1.C_Mname as "name",
       decode(t1.N_Mlevel,
              0,
              '零级',
              1,
              '一级',
              2,
              '二级',
              3,
              '三级',
              4,
              '四级',
              5,
              '五级',
              6,
              '六级',
              t1.N_Mlevel) as "level",
       decode(t1.C_Mleaf, 'true', '是', 'false', '否', t1.C_Mleaf) as "leaf",
       t1.N_Morder as "order",
       t2.C_Mname as "t2.name",
       t1.C_Mpath as "path",
       t1.C_Mnote as "note",
       t1.C_MCTIME,
       t1.C_MCIP,
       t1.C_MCREATOR,
       t1.C_MMTIME,
       t1.C_MMIP,
       t1.C_MMODIFIER,
       t1.C_MONS      "ons",
       t1.C_MONT      "ont"
  from tool.t_authority_module t1
  left outer join tool.t_authority_module t2
    on t1.N_Mparent = t2.N_Mid

-- AuthorityModule.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityModule.Read.read.HQL
-- AuthorityModule.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityModule t1 left outer join t1.NMparent p

--@JavaScript AuthorityModule.Read.read.JPQL

-- SQL for select AuthorityModule.Combobox.combobox.data
--@JavaScript AuthorityModule.Combobox.combobox.SQL
select t1.n_mid "id", t1.c_mname "text"
  from tool.t_authority_module t1
 where t1.c_mleaf = 'false'

-- HQL select AuthorityModule.Combobox.combobox.data
--@JavaScript AuthorityModule.Combobox.combobox.HQL

--@JavaScript AuthorityModule.Combobox.combobox.JPQL


--@JavaScript AuthorityModule.Tree.tree_CheckBoxTree = {};
--@JavaScript AuthorityModule.Tree.tree_CheckBoxTree.SQL
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
       t1.C_MMODIFIER,
       t1.C_MONS,
       t1.C_MONT
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
where FIND_IN_SET( t1.N_Mid, f_getChildModuleList( :moduleId ) )
order by t1.N_Mlevel, t1.N_Morder

--@JavaScript AuthorityModule.Tree.tree_CheckBoxTree_ExceptDev = {};
--@JavaScript AuthorityModule.Tree.tree_CheckBoxTree_ExceptDev.SQL
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
       t1.C_MMODIFIER,
       t1.C_MONS,
       t1.C_MONT
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
where FIND_IN_SET( t1.N_Mid, f_getChildModuleList( :moduleId ) ) and t1.N_Mid not in (98,9801,9802,9803,9804,9805)
order by t1.N_Mlevel, t1.N_Morder

--@JavaScript AuthorityModule.Export.export.SQL
select t1.N_MID,
       t1.C_MNAME,
       t1.N_Mlevel,
       decode(t1.N_Mlevel,
              0,
              '零级',
              1,
              '一级',
              2,
              '二级',
              3,
              '三级',
              4,
              '四级',
              5,
              '五级',
              6,
              '六级',
              t1.N_Mlevel || '级') as "level",
       t1.C_Mleaf,
       decode(t1.C_Mleaf, 'true', '是', 'false', '否', t1.C_Mleaf) as "leaf",
       t1.N_MORDER,
       t1.N_MPARENT,
       t2.C_MNAME "parent",
       t1.C_MTARGET,
       decode(t1.C_MTARGET,
              'R',
              '右边框架',
              'B',
              '新窗口',
              'T',
              '当前浏览器窗口',
              'S',
              '当前框架',
              t1.C_MTARGET) as "target",
       t1.C_MICONCLS,
       t1.C_MEXPANDED,
       decode(t1.C_MEXPANDED, 'true', '是', 'false', '否', t1.C_MEXPANDED) as "expanded",
       t1.C_MCHECKED,
       decode(t1.C_MCHECKED, 'true', '是', 'false', '否', t1.C_MCHECKED) as "checked",
       t1.C_MPATH,
       t1.C_MNOTE,
       t1.C_MCTIME,
       t1.C_MCIP,
       t1.C_MCREATOR,
       t1.C_MMTIME,
       t1.C_MMIP,
       t1.C_MMODIFIER,
       t1.C_MONS,
       t1.C_MONT
  from tool.t_authority_module t1
  left outer join tool.t_authority_module t2
    on t1.N_MPARENT = t2.N_MID
       
--@JavaScript AuthorityModule.Export.export.HQL

--@JavaScript AuthorityModule.Export.export.JPQL

--@JavaScript AuthorityModule.Nest.nest.SQL
/**select * 
  from tool.t_authority_module t2 
 where t2.name = t1.name**/
 
--@JavaScript AuthorityModule.Nest.nest.HQL

--@JavaScript AuthorityModule.Nest.nest.JPQL
