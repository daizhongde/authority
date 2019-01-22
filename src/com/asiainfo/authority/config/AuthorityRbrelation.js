/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityRbrelation = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityRbrelation.Field = {
		N_RID : [ 4, 11, 0, "角色ID", "n_rid", "N_RID", 0 ],
		N_BID : [ 4, 11, 0, "按钮ID", "n_bid", "N_BID", 1 ],
		C_RULE : [ 12, 1024, 0, "权限规则sql", "c_rule", "C_RULE", 2 ],
		C_CTIME : [ 93, 19, 0, "挂接时间", "c_ctime", "C_CTIME", 3 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", "c_cip", "C_CIP", 4 ],
		C_CREATOR : [ 12, 24, 0, "挂接者", "c_creator", "C_CREATOR", 5 ]
	};

AuthorityRbrelation.Export={};
AuthorityRbrelation.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityRbrelation.Export.export.ColumnMap = {
		N_RID : [ 4, 11, 0, "角色ID", 0 ],
		N_BID : [ 4, 11, 0, "按钮ID", 1 ],
		C_RULE : [ 12, 1024, 0, "权限规则sql", 2 ],
		C_CTIME : [ 93, 19, 0, "挂接时间", 3 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", 4],
		C_CREATOR : [ 12, 24, 0, "挂接者", 5 ]
	};

//AuthorityRbrelation.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityRbrelation.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityRbrelation.Export.export.DefaultColumns = 
["N_RID","N_BID","C_CTIME"];
