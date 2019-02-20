/** note: 
 * 		Don't support back comment 
 * 
var AuthorityInst = {};
AuthorityInst.Field = {...};
AuthorityInst.Export = {};
AuthorityInst.Export.export = {};

AuthorityInst.Export.export.ColumnMap = {...};
AuthorityInst.Export.export.DefaultColumns = {...};
 * 
 * 
 *  
 * */

/** the globel variable */
var AuthorityInst = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityInst.Field = {
		N_IID : [ 2, 8, 0, "机构ID", "id", "NIid", 0 ],
		C_ICODE : [ 12, 9, 0, "机构编码", "code", "CIcode", 1 ],
		C_INAME : [ 12, 90, 0, "机构名称", "name", "CIname", 2 ],
		N_ILEVEL : [ 2, 3, 0, "机构级别", "level", "NIlevel", 3 ],
		C_ILEAF : [ 12, 5, 0, "是否末级", "leaf", "CIleaf", 4 ],
		N_ISUPERIOR : [ 2, 8, 0, "上级机构", "superior", "NIsuperior", 5 ],
		N_ITYPE : [ 2, 3, 0, "机构类型", "type", "NItype", 6 ],
		C_IMANAGER : [ 12, 30, 0, "机构领导", "manager", "CImanager", 7 ],
		C_IMTEL : [ 12, 20, 0, "领导电话", "mtel", "CImtel", 8 ],
		C_IMEMAIL : [ 12, 30, 0, "领导邮箱", "memail", "CImemail", 9 ],
		C_IMQQ : [ 12, 10, 0, "领导QQ", "mqq", "CImqq", 10 ],
		C_ILINKMAN : [ 12, 30, 0, "机构联系人", "linkman", "CIlinkman", 11 ],
		C_ILTEL : [ 12, 20, 0, "联系人电话", "ltel", "CIltel", 12 ],
		C_ILEMAIL : [ 12, 30, 0, "联系人邮箱", "lemail", "CIlemail", 13 ],
		C_ILQQ : [ 12, 10, 0, "联系人QQ", "lqq", "CIlqq", 14 ],
		C_IADDRESS : [ 12, 120, 0, "机构地址", "address", "CIaddress", 15 ],
		C_IDESCRIPTION : [ 12, 240, 0, "机构描述", "description", "CIdescription", 16 ],
		C_ICTIME : [ 93, 0, 0, "创建时间", "ctime", "CIctime", 17 ],
		C_ICIP : [ 12, 60, 0, "创建者IP", "cip", "CIcip", 18 ],
		C_ICREATOR : [ 12, 24, 0, "创建者", "creator", "CIcreator", 19 ],
		C_IMTIME : [ 93, 0, 0, "最后修改时间", "mtime", "CImtime", 20 ],
		C_IMIP : [ 12, 60, 0, "最后修改者IP", "mip", "CImip", 21 ],
		C_IMODIFIER : [ 12, 24, 0, "最后修改者", "modifier", "CImodifier", 22 ],
		C_IONS : [ 12, 1, 0, "启用状态", "ions", "CIons", 23 ],
		C_IONT : [ 93, 0, 0, "启用时间", "iont", "CIont", 24 ]
	};
/**
 * front to back AuthorityInst.front2back = { "id" : "NMid", "name" :
 * "CMname", "level" : "NMlevel", "order" : "NMorder", "leaf" : "CMleaf",
 * "parent" : "NMparent", "target" : "CMtarget", "iconcls" : "CMiconcls",
 * "expanded" : "CMexpanded", "checked" : "CMchecked", "path" : "CMpath", "note" :
 * "CMnote", "ctime" : "CMctime", "cip" : "CMcip", "creator" : "CMcreator", "mtime" :
 * "CMmtime", "mip" : "CMmip", "modifier" : "CMmodifier" };
 */

AuthorityInst.Export={};
AuthorityInst.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh, index ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * all columns that can be export
 */
AuthorityInst.Export.export.ColumnMap = {
		N_IID : [ 2, 8, 0, "机构ID", 0 ],
		C_ICODE : [ 12, 9, 0, "机构编码", 1 ],
		C_INAME : [ 12, 90, 0, "机构名称", 2 ],
		N_ILEVEL : [ 2, 3, 0, "机构级别", 3 ],
		C_ILEAF : [ 12, 5, 0, "是否末级", 4 ],
		N_ISUPERIOR : [ 2, 8, 0, "上级机构", 5 ],
		N_ITYPE : [ 2, 3, 0, "机构类型", 6 ],
		C_IMANAGER : [ 12, 30, 0, "机构领导", 7 ],
		C_IMTEL : [ 12, 20, 0, "领导电话", 8 ],
		C_IMEMAIL : [ 12, 30, 0, "领导邮箱", 9 ],
		C_IMQQ : [ 12, 10, 0, "领导QQ", 10 ],
		C_ILINKMAN : [ 12, 30, 0, "机构联系人", 11 ],
		C_ILTEL : [ 12, 20, 0, "联系人电话", 12 ],
		C_ILEMAIL : [ 12, 30, 0, "联系人邮箱", 13 ],
		C_ILQQ : [ 12, 10, 0, "联系人QQ", 14 ],
		C_IADDRESS : [ 12, 120, 0, "机构地址", 15 ],
		C_IDESCRIPTION : [ 12, 240, 0, "机构描述", 16 ],
		C_ICTIME : [ 93, 0, 0, "创建时间", 17 ],
		C_ICIP : [ 12, 60, 0, "创建者IP", 18 ],
		C_ICREATOR : [ 12, 24, 0, "创建者", 19 ],
		C_IMTIME : [ 93, 0, 0, "最后修改时间", 20 ],
		C_IMIP : [ 12, 60, 0, "最后修改者IP", 21 ],
		C_IMODIFIER : [ 12, 24, 0, "最后修改者", 22 ]
	};

//AuthorityInst.Export.export.DefaultColumns = "N_MID|C_MNAME|level|leaf|N_MORDER" +
//		"|parent|target|C_MICONCLS|expanded|checked";

//AuthorityInst.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityInst.Export.export.DefaultColumns = [ "N_IID", "C_ICODE", "C_INAME", "N_ILEVEL", "C_ILEAF", "N_ISUPERIOR",
                                       		"N_ITYPE", "C_IMANAGER", "C_IMTEL", "C_IMEMAIL", "C_IMQQ",
                                    		"C_ILINKMAN", "C_ILTEL", "C_ILEMAIL", "C_ILQQ", "C_IADDRESS",
                                    		"C_IDESCRIPTION", "C_ICTIME", "C_ICIP", "C_ICREATOR", "C_IMTIME",
                                    		"C_IMIP", "C_IMODIFIER" ];
/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted. eg: decode, case when,other
 * table's column.
 * 
 * AuthorityInst.exp.columnNames_zh = { N_MID : "模块ID", C_MNAME : "模块名称",
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
 * AuthorityInst.exp.columnTypes = { N_MID : 2, C_MNAME : 12, "LEVEL" : 12,
 * "LEAF" : 12, N_MORDER : 2, "PARENT" : 12, "TARGET" : 12, C_MICONCLS : 12,
 * "EXPANDED" : 12, "CHECKED" : 12, C_MPATH : 12, C_MNOTE : 12, C_MCTIME : 93,
 * C_MCIP : 12, C_MCREATOR : 2, C_MMTIME : 93, C_MMIP : 12, C_MMODIFIER : 2 };
 */

/*
 * columnTypes direct in there, if read dynamic will cause read database twice
 * double quotation marks illustrate it's converted, eg: decode, case when,other
 * table's column.
 * 
 * AuthorityInst.exp.columnPrecisions = { N_MID : 8, C_MNAME : 90, "LEVEL_" :
 * 41, "LEAF" : 5, N_MORDER : 4, "PARENT" : 90, "TARGET" : 7, C_MICONCLS : 30,
 * "EXPANDED" : 5, "CHECKED" : 5, C_MPATH : 120, C_MNOTE : 120, C_MCTIME : 0,
 * C_MCIP : 60, C_MCREATOR : 8, C_MMTIME : 0, C_MMIP : 60, C_MMODIFIER : 8 };
 */

/*
 * columnScale direct in there, if read dynamic will cause read database twice,
 * the digit count after point double quotation marks illustrate it's converted,
 * eg: decode, case when,other table's column.
 * 
 * AuthorityInst.exp.columnScales = { N_MID : 0, C_MNAME : 0, "LEVEL" : 0,
 * "LEAF" : 0, N_MORDER : 0, "PARENT" : 0, "TARGET" : 0, C_MICONCLS : 0,
 * "EXPANDED" : 0, "CHECKED" : 0, C_MPATH : 0, C_MNOTE : 0, C_MCTIME : 0, C_MCIP :
 * 0, C_MCREATOR : 0, C_MMTIME : 0, C_MMIP : 0, C_MMODIFIER : 0 };
 */
