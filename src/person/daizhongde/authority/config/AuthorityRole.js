/** note: 
 * 		Don't support back comment 
 * 
var AuthorityRole = {};
AuthorityRole.Field = {...};
AuthorityRole.Export = {};
AuthorityRole.Export.export = {};

AuthorityRole.Export.export.ColumnMap = {...};
AuthorityRole.Export.export.DefaultColumns = {...};
 * 
 * 
 *  
 * */

/** the globel variable */
var AuthorityRole = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityRole.Field = {
		N_RID : [ 2, 3, 0, "角色ID", "id", "NRid", 0 ],
		C_RNO : [ 1, 3, 0, "注备", "no", "CRno", 1 ],
		C_RNAME : [ 12, 60, 0, "角色名称", "name", "CRname", 2 ],
		N_RLEVEL : [ 2, 3, 0, "角色级别(树用上级模块)", "level", "NRlevel", 3 ],
		C_RNOTE : [ 12, 120, 0, "注备", "note", "CRnote", 4 ],
		C_RCTIME : [ 93, 0, 0, "创建时间", "ctime", "CRctime", 5 ],
		C_RCIP : [ 12, 60, 0, "创建者IP", "cip", "CRcip", 6 ],
		C_RCREATOR : [ 12, 24, 0, "创建者", "creator", "CRcreator", 7 ],
		C_RONS : [ 12, 1, 0, "启用状态", "rons", "CRons", 8 ],
		C_RONT : [ 93, 0, 0, "启用时间", "ront", "CRont", 9 ]
	};
/**
 * front to back AuthorityRole.front2back = { "id" : "NMid", "name" :
 * "CMname", "level" : "NMlevel", "order" : "NMorder", "leaf" : "CMleaf",
 * "parent" : "NMparent", "target" : "CMtarget", "iconcls" : "CMiconcls",
 * "expanded" : "CMexpanded", "checked" : "CMchecked", "path" : "CMpath", "note" :
 * "CMnote", "ctime" : "CMctime", "cip" : "CMcip", "creator" : "CMcreator", "mtime" :
 * "CMmtime", "mip" : "CMmip", "modifier" : "CMmodifier" };
 */

AuthorityRole.Export={};
AuthorityRole.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh, index ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * all columns that can be export
 */
AuthorityRole.Export.export.ColumnMap = {
		N_RID : [ 2, 3, 0, "角色ID", 0 ],
		C_RNO : [ 1, 3, 0, "注备", 1 ],
		C_RNAME : [ 12, 60, 0, "角色名称", 2 ],
		N_RLEVEL : [ 2, 3, 0, "角色级别(树用上级模块)", 3 ],
		C_RNOTE : [ 12, 120, 0, "注备", 4 ],
		C_RCTIME : [ 93, 0, 0, "创建时间", 5 ],
		C_RCIP : [ 12, 60, 0, "创建者IP", 6 ],
		C_RCREATOR : [ 12, 24, 0, "创建者", 7 ]
	};

//AuthorityRole.Export.export.DefaultColumns = "N_MID|C_MNAME|level|leaf|N_MORDER" +
//		"|parent|target|C_MICONCLS|expanded|checked";

//AuthorityRole.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityRole.Export.export.DefaultColumns = [ "N_RID", "C_RNO", "C_RNAME", "N_RLEVEL", "C_RNOTE", "C_RCTIME",
                                       		"C_RCIP", "C_RCREATOR" ];

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted. eg: decode, case when,other
 * table's column.
 * 
 * AuthorityRole.exp.columnNames_zh = { N_MID : "模块ID", C_MNAME : "模块名称",
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
 * AuthorityRole.exp.columnTypes = { N_MID : 2, C_MNAME : 12, "LEVEL" : 12,
 * "LEAF" : 12, N_MORDER : 2, "PARENT" : 12, "TARGET" : 12, C_MICONCLS : 12,
 * "EXPANDED" : 12, "CHECKED" : 12, C_MPATH : 12, C_MNOTE : 12, C_MCTIME : 93,
 * C_MCIP : 12, C_MCREATOR : 2, C_MMTIME : 93, C_MMIP : 12, C_MMODIFIER : 2 };
 */

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted, eg: decode, case when,other
 * table's column.
 * 
 * AuthorityRole.exp.columnPrecisions = { N_MID : 8, C_MNAME : 90, "LEVEL_" :
 * 41, "LEAF" : 5, N_MORDER : 4, "PARENT" : 90, "TARGET" : 7, C_MICONCLS : 30,
 * "EXPANDED" : 5, "CHECKED" : 5, C_MPATH : 120, C_MNOTE : 120, C_MCTIME : 0,
 * C_MCIP : 60, C_MCREATOR : 8, C_MMTIME : 0, C_MMIP : 60, C_MMODIFIER : 8 };
 */

/*
 * columnScale direct in there, if read dynamic will cause read database twice,
 * the digit count after point double quotation marks illustrate it's converted,
 * eg: decode, case when,other table's column.
 * 
 * AuthorityRole.exp.columnScales = { N_MID : 0, C_MNAME : 0, "LEVEL" : 0,
 * "LEAF" : 0, N_MORDER : 0, "PARENT" : 0, "TARGET" : 0, C_MICONCLS : 0,
 * "EXPANDED" : 0, "CHECKED" : 0, C_MPATH : 0, C_MNOTE : 0, C_MCTIME : 0, C_MCIP :
 * 0, C_MCREATOR : 0, C_MMTIME : 0, C_MMIP : 0, C_MMODIFIER : 0 };
 */
