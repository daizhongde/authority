/** a variable, like javascript

--@JavaScript var AuthorityUser = {};
--@JavaScript AuthorityUser.Query = {};
--@JavaScript AuthorityUser.Add = {};
--@JavaScript AuthorityUser.Update = {};
--@JavaScript AuthorityUser.Read = {};
--@JavaScript AuthorityUser.Del = {};

--@JavaScript AuthorityUser.Combobox = {};
--@JavaScript AuthorityUser.Tree = {};
--@JavaScript AuthorityUser.Nest = {};
--@JavaScript AuthorityUser.Export = {}
;

ten AuthorityUser's basic SQL(include HQL), You can see as query0,read0,combobox0,nest0,export0                         
	AuthorityUser.Query.query.SQL        AuthorityUser.Query.query.HQL        AuthorityUser.Query.query.JPQL    
	AuthorityUser.Read.read.SQL          AuthorityUser.Read.read.HQL          AuthorityUser.Read.read.JPQL      
	AuthorityUser.Combobox.combobox.SQL  AuthorityUser.Combobox.combobox.HQL  AuthorityUser.Combobox.combobox.JPQL
	AuthorityUser.Tree.tree.SQL  		   AuthorityUser.Tree.tree.HQL 		  AuthorityUser.Tree.tree.JPQL
	AuthorityUser.Export.export.SQL      AuthorityUser.Export.export.HQL      AuthorityUser.Export.export.JPQL  
	AuthorityUser.Nest.nest.SQL          AuthorityUser.Nest.nest.HQL          AuthorityUser.Nest.nest.JPQL     

note: 
	Don't support back comment 

**/
 
-- CURD sql config file
-- All table need use alias,the target table name's alias is 't1'
-- the target table name is back of the first 'from' key words, 
-- only a space are permit back of the 'from' key words 

/** Effective config begin there   **/
--@JavaScript var AuthorityUser = {};
--@JavaScript AuthorityUser.Query = {};
--@JavaScript AuthorityUser.Add = {};
--@JavaScript AuthorityUser.Update = {};
--@JavaScript AuthorityUser.Read = {};
--@JavaScript AuthorityUser.Del = {};

--@JavaScript AuthorityUser.Combobox = {};
--@JavaScript AuthorityUser.Nest = {};
--@JavaScript AuthorityUser.Export = {};

--@JavaScript AuthorityUser.Query.query.SQL
select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_UPASSWORD "password",
       t1.C_USEX      "sex",
       t1.EMPLOYEE_NUMBER      "employee_number",
       t1.SUPERVISOR_ID      "supervisor_id",
       t1.C_UPHONE    "phone",
       t1.C_UTEL    "tel",
       t1.C_UFAX    "fax",
       t1.C_UEMAIL    "email",
       t1.C_UQQ       "qq",
       t1.C_UADDR     "addr",
       t1.N_IID     "iid",
       t1.N_DID     "did",
       t1.C_UNOTE     "note",
       
       date_format(t1.C_UCTIME, '%Y-%m-%d %H:%i:%S') "ctime",
       --t1.C_UCTIME    "ctime",
       t1.C_UCIP      "cip",
       t1.C_UCREATOR  "creator",
       
       date_format(t1.C_UMTIME, '%Y-%m-%d %H:%i:%S') "mtime",
       --t1.C_UMTIME    "mtime",
       t1.C_UMIP      "mip",
       t1.C_UMODIFIER "modifier"
  from tool.t_authority_user t1

--@JavaScript AuthorityUser.Query.query_ExceptDev = {}
--@JavaScript AuthorityUser.Query.query_ExceptDev.SQL
select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_UPASSWORD "password",
       t1.C_USEX      "sex",
       t1.C_UPHONE    "phone",
       t1.C_UTEL    "tel",
       t1.C_UFAX    "fax",
       t1.C_UEMAIL    "email",
       t1.C_UQQ       "qq",
       t1.C_UADDR     "addr",
       t1.N_IID     "iid",
       t1.N_DID     "did",
       t1.C_UNOTE     "note",
       
       date_format(t1.C_UCTIME, '%Y-%m-%d %H:%i:%S') "ctime",
       --t1.C_UCTIME    "ctime",
       t1.C_UCIP      "cip",
       t1.C_UCREATOR  "creator",
       
       date_format(t1.C_UMTIME, '%Y-%m-%d %H:%i:%S') "mtime",
       --t1.C_UMTIME    "mtime",
       t1.C_UMIP      "mip",
       t1.C_UMODIFIER "modifier"
  from tool.t_authority_user t1
 where t1.C_ULOGNAME!='dev'
  
--@JavaScript AuthorityUser.Query.query4Chat = {}
--@JavaScript AuthorityUser.Query.query4Chat.SQL
select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_USEX      "sex",
       t1.C_LOGINS    "logins"
  from tool.t_authority_user t1
 where n_did=27451
 order by C_LOGINS desc, C_ULOGNAME asc
  
  
/* tableData HQL   */ 
--@JavaScript AuthorityUser.Query.query.HQL

--@JavaScript AuthorityUser.Query.query.JPQL

-- AuthorityUser.Read.read.SQL,Criteria.ALIAS_TO_ENTITY_MAP will convert column name to UpperCase,column alias must different avoid map key cover
--@JavaScript AuthorityUser.Read.read.SQL
select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_UPASSWORD "password",
       t1.C_USEX      "sex",
       t1.EMPLOYEE_NUMBER      "employee_number",
       t1.SUPERVISOR_ID      "supervisor_id",
       t1.C_UPHONE    "phone",
       t1.C_UTEL    "tel",
       t1.C_UFAX    "fax",
       t1.C_UEMAIL    "email",
       t1.C_UQQ       "qq",
       t1.C_UADDR     "addr",
       t1.C_UNOTE     "note",
       t1.N_IID     "iid",
       t1.N_DID     "did",
       t1.C_UCTIME    "ctime",
       t1.C_UCIP      "cip",
       t1.C_UCREATOR  "creator",
       t1.C_UMTIME    "mtime",
       t1.C_UMIP      "mip",
       t1.C_UMODIFIER "modifier",
       t2.c_icode "icode",
       t2.c_iname "iname"
  from tool.t_authority_user t1
  left outer join tool.t_authority_inst t2
    on t1.n_iid = t2.n_iid
/** select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_UPASSWORD "password",
       t1.C_USEX      "sex",
       t1.C_UPHONE    "phone",
       t1.C_UTEL    "tel",
       t1.C_UFAX    "fax",
       t1.C_UEMAIL    "email",
       t1.C_UQQ       "qq",
       t1.C_UADDR     "addr",
       t1.C_UNOTE     "note",
       t1.N_IID     "iid",
       t1.N_DID     "did",
       t1.C_UCTIME    "ctime",
       t1.C_UCIP      "cip",
       t1.C_UCREATOR  "creator",
       t1.C_UMTIME    "mtime",
       t1.C_UMIP      "mip",
       t1.C_UMODIFIER "modifier"
  from tool.t_authority_user t1
*/

-- AuthorityUser.Read.read.HQL, hql haven't decode function, also '||' can't explain in hql
--@JavaScript AuthorityUser.Read.read.HQL
-- AuthorityUser.Read.read.hql=select new map(t1.NMid as id, t1.CMname as name, decode(t1.CMleaf, 'true', '\u662F', 'false', '\u5426', t1.CMleaf) as leaf,t1.NMorder as order1,p.CMname as name2, t1.CMpath as path, t1.CMnote as note ) from TAuthorityUser t1 left outer join t1.NMparent p

--@JavaScript AuthorityUser.Read.read.JPQL

-- SQL for select AuthorityUser.Combobox.combobox.data
--@JavaScript AuthorityUser.Combobox.combobox.SQL
select t1.n_mid "id", t1.c_mname "text"
  from tool.t_authority_module t1
 where t1.c_mleaf = 'false'

-- HQL select AuthorityUser.Combobox.combobox.data
--@JavaScript AuthorityUser.Combobox.combobox.HQL

--@JavaScript AuthorityUser.Combobox.combobox.JPQL


--@JavaScript AuthorityUser.Tree.tree_CheckBoxTree = {};
--@JavaScript AuthorityUser.Tree.tree_CheckBoxTree.SQL

--@JavaScript AuthorityUser.Export.export.SQL
select t1.N_UID       "id",
       t1.C_ULOGNAME  "logname",
       t1.C_UNAME     "name",
       t1.C_UPASSWORD "password",
       t1.C_USEX      "sex",
       t1.EMPLOYEE_NUMBER      "employee_number",
       t1.SUPERVISOR_ID      "supervisor_id",
       t1.C_UPHONE    "phone",
       t1.C_UTEL    "tel",
       t1.C_UFAX    "fax",
       t1.C_UEMAIL    "email",
       t1.C_UQQ       "qq",
       t1.C_UADDR     "addr",
       t1.N_IID     "iid",
       t1.N_DID     "did",
       t1.C_UCTIME    "ctime",
       t1.C_UCIP      "cip",
       t1.C_UCREATOR  "creator",
       t1.C_UMTIME    "mtime",
       t1.C_UMIP      "mip",
       t1.C_UMODIFIER "modifier"
  from tool.t_authority_user t1

       
--@JavaScript AuthorityUser.Export.export.HQL

--@JavaScript AuthorityUser.Export.export.JPQL

--@JavaScript AuthorityUser.Nest.nest.SQL
 
--@JavaScript AuthorityUser.Nest.nest.HQL

--@JavaScript AuthorityUser.Nest.nest.JPQL
