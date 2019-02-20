/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityUrrelation = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityUrrelation.Field = {
		N_UID : [ 2, 8, 0, "用户ID", "uid", "NUid", 0 ],
		N_RID : [ 2, 3, 0, "角色ID", "rid", "NRid", 1 ],
		C_CTIME : [ 93, 0, 0, "挂接时间", "time", "CCtime", 2 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", "ip", "CCip", 3 ],
		C_CREATOR : [ 12, 24, 0, "挂接者所使用的IP", "creator", "CCreator", 4 ]
	};

AuthorityUrrelation.Export={};
AuthorityUrrelation.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityUrrelation.Export.export.ColumnMap =  {
		N_UID : [ 2, 8, 0, "用户ID", 0 ],
		N_RID : [ 2, 3, 0, "角色ID", 1 ],
		C_CTIME : [ 93, 0, 0, "挂接时间", 2 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", 3 ],
		C_CREATOR : [ 12, 24, 0, "挂接者所使用的IP", 4 ]
	};

//AuthorityUrrelation.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityUrrelation.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityUrrelation.Export.export.DefaultColumns = 
	["N_UID","N_RID","C_CTIME","C_CIP","C_CREATOR"];
