/** note: 
 * 		Don't support back comment 
 * 
var AuthorityModule = {};
AuthorityModule.Field = {...};
AuthorityModule.Export = {};
AuthorityModule.Export.export = {};

AuthorityModule.Export.export.ColumnMap = {...};
AuthorityModule.Export.export.DefaultColumns = {...};
 * 
 * 
 *  
 * */

/** the globel variable */
var AuthorityModule = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityModule.Field = {
	N_MID : [ 2, 8, 0, "模块ID", "id", "NMid", 0 ],
	C_MNAME : [ 12, 90, 0, "模块名称", "name", "CMname", 1 ],
	N_MLEVEL : [ 2, 3, 0, "模块级别", "level", "NMlevel", 2 ],
	C_MLEAF : [ 12, 5, 0, "模块类型", "leaf", "CMleaf", 3 ],
	N_MPARENT : [ 2, 8, 0, "上级模块", "parent", "NMparent", 4 ],
	N_MORDER : [ 2, 3, 0, "模块次序号", "order", "NMorder", 5 ],
	C_MTARGET : [ 12, 3, 0, "模块链接目标", "target", "CMtarget", 6 ],
	C_MICONCLS : [ 12, 30, 0, "模块图标样式", "iconcls", "CMiconcls", 7 ],
	C_MEXPANDED : [ 12, 5, 0, "模块结点展开状态", "expanded", "CMexpanded", 8 ],
	C_MCHECKED : [ 12, 5, 0, "模块结点是否被选定", "checked", "CMchecked", 9 ],
	C_MPATH : [ 12, 180, 0, "模块url路径", "path", "CMpath", 10 ],
	C_MNOTE : [ 12, 768, 0, "备注", "note", "CMnote", 11 ],
	C_MCTIME : [ 93, 0, 0, "模块创建时间", "ctime", "CMctime", 12 ],
	C_MCIP : [ 12, 60, 0, "模块创建者创建时所使用的IP", "cip", "CMcip", 13 ],
	C_MCREATOR : [ 12, 24, 0, "模块创建者", "creator", "CMcreator", 14 ],
	C_MMTIME : [ 93, 0, 0, "模块修改时间", "mtime", "CMmtime", 15 ],
	C_MMIP : [ 12, 60, 0, "模块个最后修改者使用的IP", "mip", "CMmip", 16 ],
	C_MMODIFIER : [ 12, 24, 0, "模块最后一次的个修改者", "modifier", "CMmodifier", 17 ],
	C_MONS : [ 1, 1, 0, "启用状态", "ons", "CMons", 18 ],
	C_MONT : [ 93, 0, 0, "启用时间", "ont", "CMont", 19 ]
};
/**
 * front to back AuthorityModule.front2back = { "id" : "NMid", "name" :
 * "CMname", "level" : "NMlevel", "order" : "NMorder", "leaf" : "CMleaf",
 * "parent" : "NMparent", "target" : "CMtarget", "iconcls" : "CMiconcls",
 * "expanded" : "CMexpanded", "checked" : "CMchecked", "path" : "CMpath", "note" :
 * "CMnote", "ctime" : "CMctime", "cip" : "CMcip", "creator" : "CMcreator", "mtime" :
 * "CMmtime", "mip" : "CMmip", "modifier" : "CMmodifier" };
 */

AuthorityModule.Export={};
AuthorityModule.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh, index ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * all columns that can be export
 */
AuthorityModule.Export.export.ColumnMap = {
	N_MID : [ 2, 8, 0, "模块ID", 0 ],
	C_MNAME : [ 12, 90, 0, "模块名称", 1 ],
	N_MLEVEL : [ 2, 4, 0, "模块级别", 2 ],
	"level" : [ 12, 41, 0, "模块级别", 3 ],
	C_MLEAF : [ 12, 5, 0, "叶子节点", 4 ],
	"leaf" : [ 12, 5, 0, "叶子节点", 5 ],
	N_MORDER : [ 2, 4, 0, "模块次序号", 6 ],
	N_MPARENT : [ 2, 8, 0, "上级模块", 7 ],
	"parent" : [ 12, 90, 0, "上级模块", 8 ],
	C_MTARGET : [ 12, 3, 0, "模块" +
			"链接" +
			"目标", 9 ],
	"target" : [ 12, 7, 0, "链接目录", 10 ],
	C_MICONCLS : [ 12, 30, 0, "图标样式", 11 ],
	C_MEXPANDED : [ 12, 5, 0, "模块结点" 
			+"展开" +
			"状态", 12 ],
	"expanded" : [ 12, 5, 0, "展开状态", 13 ],
	C_MCHECKED : [ 12, 5, 0, "模块结点是否被选定", 14 ],
	"checked" : [ 12, 5, 0, "选定状态", 15 ],
	C_MPATH : [ 12, 120, 0, "模块路径", 16 ],
	C_MNOTE : [ 12, 120, 0, "备注", 17 ],
	C_MCTIME : [ 93, 0, 0, "创建时间", 18 ],
	C_MCIP : [ 12, 60, 0, "创建者IP", 19 ],
	C_MCREATOR : [ 12, 24, 0, "创建者", 20 ],
	C_MMTIME : [ 93, 0, 0, "修改时间", 21 ],
	C_MMIP : [ 12, 60, 0, "修改者" +
			"IP", 22 ],
	C_MMODIFIER : [ 12, 24, 0, "修改" +
			"者", 23 ]};

//AuthorityModule.Export.export.DefaultColumns = "N_MID|C_MNAME|level|leaf|N_MORDER" +
//		"|parent|target|C_MICONCLS|expanded|checked";

//AuthorityModule.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityModule.Export.export.DefaultColumns = [
	"N_MID","C_MNAME","level","leaf","N_MORDER",
	"parent","target","C_MICONCLS","expanded","checked"                               
];

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted. eg: decode, case when,other
 * table's column.
 * 
 * AuthorityModule.exp.columnNames_zh = { N_MID : "模块ID", C_MNAME : "模块名称",
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
 * AuthorityModule.exp.columnTypes = { N_MID : 2, C_MNAME : 12, "LEVEL" : 12,
 * "LEAF" : 12, N_MORDER : 2, "PARENT" : 12, "TARGET" : 12, C_MICONCLS : 12,
 * "EXPANDED" : 12, "CHECKED" : 12, C_MPATH : 12, C_MNOTE : 12, C_MCTIME : 93,
 * C_MCIP : 12, C_MCREATOR : 2, C_MMTIME : 93, C_MMIP : 12, C_MMODIFIER : 2 };
 */

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted, eg: decode, case when,other
 * table's column.
 * 
 * AuthorityModule.exp.columnPrecisions = { N_MID : 8, C_MNAME : 90, "LEVEL_" :
 * 41, "LEAF" : 5, N_MORDER : 4, "PARENT" : 90, "TARGET" : 7, C_MICONCLS : 30,
 * "EXPANDED" : 5, "CHECKED" : 5, C_MPATH : 120, C_MNOTE : 120, C_MCTIME : 0,
 * C_MCIP : 60, C_MCREATOR : 8, C_MMTIME : 0, C_MMIP : 60, C_MMODIFIER : 8 };
 */

/*
 * columnScale direct in there, if read dynamic will cause read database twice,
 * the digit count after point double quotation marks illustrate it's converted,
 * eg: decode, case when,other table's column.
 * 
 * AuthorityModule.exp.columnScales = { N_MID : 0, C_MNAME : 0, "LEVEL" : 0,
 * "LEAF" : 0, N_MORDER : 0, "PARENT" : 0, "TARGET" : 0, C_MICONCLS : 0,
 * "EXPANDED" : 0, "CHECKED" : 0, C_MPATH : 0, C_MNOTE : 0, C_MCTIME : 0, C_MCIP :
 * 0, C_MCREATOR : 0, C_MMTIME : 0, C_MMIP : 0, C_MMODIFIER : 0 };
 */
