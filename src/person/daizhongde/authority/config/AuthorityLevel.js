/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityLevel = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityLevel.Field = {
	N_LID : [ 2, 4, 0, "级别", "id", "NLid", 0 ],
	C_LNAME : [ 12, 90, 0, "级别名称", "name", "CLname", 1 ],
	C_LNOTE : [ 12, 120, 0, "备注", "note", "CLnote", 2 ]
};

AuthorityLevel.Export={};
AuthorityLevel.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityLevel.Export.export.ColumnMap = {
	N_LID : [ 2, 4, 0, "级别" ],
	"level" : [ 12, 4, 0, "级别" ],
	C_LNAME : [ 12, 90, 0, "级别名称" ],
	C_LNOTE : [ 12, 120, 0, "备注" ]
};

//AuthorityLevel.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityLevel.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityLevel.Export.export.DefaultColumns = 
["N_LID","C_LNAME","C_LNOTE"];
