/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityButton = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityButton.Field = {
		"n_bid" : [ 4, 8, 0, "按钮ID", "NBid", "NBid", 0 ],
		"c_bcode" : [ 12, 30, 0, "按钮代码", "CBcode", "CBcode", 1 ],
		"c_bname" : [ 12, 30, 0, "按钮名称", "CBname", "CBname", 2 ],
		"url" : [ 12, 180, 0, "请求路径", "url", "URL", 3 ],
		"remark" : [ 12, 1024, 0, "备注", "remark", "REMARK", 4 ],
		"n_mid" : [ 4, 8, 0, "模块ID", "NMid", "NMid", 5 ]
	};

AuthorityButton.Export={};
AuthorityButton.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityButton.Export.export.ColumnMap = {
		"n_bid" : [ 4, 8, 0, "按钮ID", 0 ],
		"c_bcode" : [ 12, 30, 0, "按钮代码", 1 ],
		"c_bname" : [ 12, 30, 0, "按钮名称", 2 ],
		"url" : [ 12, 180, 0, "请求路径", 3 ],
		"remark" : [ 12, 1024, 0, "备注", 4 ],
		"n_mid" : [ 4, 8, 0, "模块ID", 5 ]
	};

//AuthorityButton.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityButton.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityButton.Export.export.DefaultColumns = 
["n_bid","c_bcode","c_bname","url","remark","n_mid"];
