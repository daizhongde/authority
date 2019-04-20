/** note: 
 * 		Don't support back comment 
 * 
var AuthorityUser = {};
AuthorityUser.Field = {...};
AuthorityUser.Export = {};
AuthorityUser.Export.export = {};

AuthorityUser.Export.export.ColumnMap = {...};
AuthorityUser.Export.export.DefaultColumns = {...};
 * 
 * 
 *  
 * */

/** the globel variable */
var AuthorityUser = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityUser.Field = {
		N_UID : [ 2, 8, 0, "用户ID", "id", "NUid", 0 ],
		C_ULOGNAME : [ 12, 24, 0, "用户登陆名", "logname", "CUlogname", 1 ],
		C_UNAME : [ 12, 90, 0, "用户姓名", "name", "CUname", 2 ],
		C_UPASSWORD : [ 12, 40, 0, "密码", "password", "CUpassword", 3 ],
		C_USEX : [ 1, 3, 0, "性别", "sex", "CUsex", 4 ],
		EMPLOYEE_NUMBER : [ 12, 10, 0, "员工号", "employee_number", "EmployeeNumber", 5 ],
		SUPERVISOR_ID : [ 2, 8, 0, "上司ID", "supervisor_id", "SupervisorId", 6 ],
		C_UPHONE : [ 12, 15, 0, "手机", "phone", "CUphone", 7 ],
		C_UEMAIL : [ 12, 40, 0, "电子邮箱", "email", "CUemail", 8 ],
		C_UQQ : [ 12, 10, 0, "QQ", "qq", "CUqq", 9 ],
		C_UADDR : [ 12, 100, 0, "用户地址", "addr", "CUaddr", 10 ],
		N_IID : [ 2, 8, 0, "机构ID", "iid", "NIid", 11 ],
		C_UTEL : [ 12, 15, 0, "座机(办公电话)", "tel", "CUtel", 12 ],
		C_UFAX : [ 12, 15, 0, "传真", "fax", "CUfax", 13 ],
		N_DID : [ 2, 8, 0, "部门ID", "did", "NDid", 14 ],
		C_UCTIME : [ 93, 0, 0, "用户创建时间", "ctime", "CUctime", 15 ],
		C_UCIP : [ 12, 60, 0, "用户创建者创建时所用IP", "cip", "CUcip", 16 ],
		C_UCREATOR : [ 12, 24, 0, "用户创建者", "creator", "CUcreator", 17 ],
		C_UMTIME : [ 93, 0, 0, "最后更新时间", "mtime", "CUmtime", 18 ],
		C_UMIP : [ 12, 60, 0, "最后修改者IP", "mip", "CUmip", 19 ],
		C_UMODIFIER : [ 12, 24, 0, "最后修改信息改者", "modifier", "CUmodifier", 20 ],
		C_UNOTE : [ 12, 512, 0, "备注", "note", "CUnote", 21 ],
		C_UONS : [ 12, 1, 0, "启用状态", "uons", "CUons", 22 ],
		C_UONT : [ 93, 0, 0, "启用时间", "uont", "CUont", 23 ]
};
/**
 * front to back AuthorityUser.front2back = { "id" : "NMid", "name" :
 * "CMname", "level" : "NMlevel", "order" : "NMorder", "leaf" : "CMleaf",
 * "parent" : "NMparent", "target" : "CMtarget", "iconcls" : "CMiconcls",
 * "expanded" : "CMexpanded", "checked" : "CMchecked", "path" : "CMpath", "note" :
 * "CMnote", "ctime" : "CMctime", "cip" : "CMcip", "creator" : "CMcreator", "mtime" :
 * "CMmtime", "mip" : "CMmip", "modifier" : "CMmodifier" };
 */

AuthorityUser.Export={};
AuthorityUser.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh, index ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * all columns that can be export
 */
AuthorityUser.Export.export.ColumnMap = {
		N_UID : [ 2, 8, 0, "用户ID", 0 ],
		C_ULOGNAME : [ 12, 24, 0, "用户登陆名", 1 ],
		C_UNAME : [ 12, 90, 0, "用户姓名", 2 ],
		C_UPASSWORD : [ 12, 40, 0, "密码", 3 ],
		C_USEX : [ 1, 3, 0, "性别", 4 ],
		EMPLOYEE_NUMBER : [ 12, 10, 0, "员工号", 5 ],
		SUPERVISOR_ID : [ 2, 8, 0, "上司ID", 6 ],
		C_UPHONE : [ 12, 15, 0, "手机", 7 ],
		C_UEMAIL : [ 12, 40, 0, "电子邮箱", 8 ],
		C_UQQ : [ 12, 10, 0, "QQ", 9 ],
		C_UADDR : [ 12, 100, 0, "用户地址", 10 ],
		N_IID : [ 2, 8, 0, "机构ID", 11 ],
		C_UTEL : [ 12, 15, 0, "座机(办公电话)", 12 ],
		C_UFAX : [ 12, 15, 0, "传真", 13 ],
		N_DID : [ 2, 8, 0, "部门ID", 14 ],
		C_UCTIME : [ 93, 0, 0, "用户创建时间", 15 ],
		C_UCIP : [ 12, 60, 0, "用户创建者创建时所用IP", 16 ],
		C_UCREATOR : [ 12, 24, 0, "用户创建者", 17 ],
		C_UMTIME : [ 93, 0, 0, "最后更新时间", 18 ],
		C_UMIP : [ 12, 60, 0, "最后修改者IP", 19 ],
		C_UMODIFIER : [ 12, 24, 0, "最后修改信息改者", 20 ]
	};

//AuthorityUser.Export.export.DefaultColumns = "N_MID|C_MNAME|level|leaf|N_MORDER" +
//		"|parent|target|C_MICONCLS|expanded|checked";

//AuthorityUser.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityUser.Export.export.DefaultColumns = [ "N_UID", "C_ULOGNAME", "C_UNAME", "C_UPASSWORD", "C_USEX",
                                               "EMPLOYEE_NUMBER","SUPERVISOR_ID",
                                       		"C_UPHONE", "C_UEMAIL", "C_UQQ", "C_UADDR", "N_IID", "C_UTEL",
                                    		"C_UFAX", "N_DID", "C_UCTIME", "C_UCIP", "C_UCREATOR", "C_UMTIME",
                                    		"C_UMIP", "C_UMODIFIER" ];
/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted. eg: decode, case when,other
 * table's column.
 * 
 * AuthorityUser.exp.columnNames_zh = { N_MID : "模块ID", C_MNAME : "模块名称",
 * "LEVEL_" : "模块级别", "LEAF" : "叶子结点", N_MORDER : "模块次序", "PARENT" : "上次模块",
 * "TARGET" : "目标窗口", C_MICONCLS : "模块图标样式", "EXPANDED" : "展开状态", "CHECKED" :
 * "选定状态", C_MPATH : "模块路径", C_MNOTE : "说明", C_MCTIME : "创建时间", C_MCIP :
 * "创建者IP", C_MCREATOR : "创建者", C_MMTIME : "修改时间", C_MMIP : "修改者IP", C_MMODIFIER :
 * "修改者" };
 */

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted, eg: decode, case when,other
 * table's column.
 * 
 * AuthorityUser.exp.columnTypes = { N_MID : 2, C_MNAME : 12, "LEVEL" : 12,
 * "LEAF" : 12, N_MORDER : 2, "PARENT" : 12, "TARGET" : 12, C_MICONCLS : 12,
 * "EXPANDED" : 12, "CHECKED" : 12, C_MPATH : 12, C_MNOTE : 12, C_MCTIME : 93,
 * C_MCIP : 12, C_MCREATOR : 2, C_MMTIME : 93, C_MMIP : 12, C_MMODIFIER : 2 };
 */

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted, eg: decode, case when,other
 * table's column.
 * 
 * AuthorityUser.exp.columnPrecisions = { N_MID : 8, C_MNAME : 90, "LEVEL_" :
 * 41, "LEAF" : 5, N_MORDER : 4, "PARENT" : 90, "TARGET" : 7, C_MICONCLS : 30,
 * "EXPANDED" : 5, "CHECKED" : 5, C_MPATH : 120, C_MNOTE : 120, C_MCTIME : 0,
 * C_MCIP : 60, C_MCREATOR : 8, C_MMTIME : 0, C_MMIP : 60, C_MMODIFIER : 8 };
 */

/*
 * columnScale direct in there, if read dynamic will cause read database twice,
 * the digit count after point double quotation marks illustrate it's converted,
 * eg: decode, case when,other table's column.
 * 
 * AuthorityUser.exp.columnScales = { N_MID : 0, C_MNAME : 0, "LEVEL" : 0,
 * "LEAF" : 0, N_MORDER : 0, "PARENT" : 0, "TARGET" : 0, C_MICONCLS : 0,
 * "EXPANDED" : 0, "CHECKED" : 0, C_MPATH : 0, C_MNOTE : 0, C_MCTIME : 0, C_MCIP :
 * 0, C_MCREATOR : 0, C_MMTIME : 0, C_MMIP : 0, C_MMODIFIER : 0 };
 */
