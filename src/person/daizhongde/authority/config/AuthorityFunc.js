/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityFunc = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityFunc.Field = {
		"n_fid" : [ 5, 4, 0, "功能ID", "n_fid", "N_FID", 0 ],
		"c_fcode" : [ 12, 30, 0, "功能代码", "c_fcode", "C_FCODE", 1 ],
		"c_fname" : [ 12, 30, 0, "功能名称", "c_fname", "C_FNAME", 2 ],
		C_CTIME : [ 93, 19, 0, "创建时间", "c_ctime", "C_CTIME", 3 ],
		C_CIP : [ 12, 180, 0, "创建者IP", "c_cip", "C_CIP", 4 ],
		C_CREATOR : [ 12, 72, 0, "创建者登陆名", "c_creator", "C_CREATOR", 5 ]
	};

AuthorityFunc.Export={};
AuthorityFunc.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityFunc.Export.export.ColumnMap = {
		"n_fid" : [ 5, 4, 0, "功能ID", 0 ],
		"c_fcode" : [ 12, 30, 0, "功能代码", 1 ],
		"c_fname" : [ 12, 30, 0, "功能名称", 2 ],
		C_CTIME : [ 93, 19, 0, "创建时间", 3 ],
		C_CIP : [ 12, 180, 0, "创建者IP", 4 ],
		C_CREATOR : [ 12, 72, 0, "创建者登陆名", 5 ]
	};

//AuthorityFunc.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityFunc.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityFunc.Export.export.DefaultColumns = 
["n_fid","c_fcode","c_fname"];
