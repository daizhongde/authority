/** note: 
 * 		Don't support back comment */
/** the globel variable */
var AuthorityRmrelation = {};
/*
 * ColumnLabel: [ columnTypes, precision, scale, columnNames_zh, front, back,index ] attemtion:
 * ColumnLabel, front, back, index. All of the four field are unique.
 */
AuthorityRmrelation.Field = {
		N_RID : [ 3, 3, 0, "角色ID", "rid", "N_RID", 0 ],
		N_MID : [ 3, 8, 0, "模块ID", "mid", "N_MID", 1 ],
		C_CTIME : [ 93, 19, 0, "挂接时间", "ctime", "C_CTIME", 2 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", "cip", "C_CIP", 3 ],
		C_CREATOR : [ 12, 24, 0, "挂接者", "creator", "C_CREATOR", 4 ],
		"create_btn" : [ 12,1, 0, "新增按钮", "create_btn", "CREATE_BTN", 5 ],
		"update_btn" : [ 12,1, 0, "修改按钮", "update_btn", "UPDATE_BTN", 6 ],
		"update_btn1" : [ 12,1, 0, "修改按钮1", "update_btn1", "UPDATE_BTN1", 7 ],
		"read_btn" : [ 12,1, 0, "查看按钮", "read_btn", "READ_BTN", 8 ],
		"delete_btn" : [ 12,1, 0, "删除按钮", "delete_btn", "DELETE_BTN", 9 ],
		"delete_btn1" : [ 12,1, 0, "删除按钮1", "delete_btn1", "DELETE_BTN1", 10 ],
		"delete_btn2" : [ 12,1, 0, "删除按钮2", "delete_btn2", "DELETE_BTN2", 11 ],
		"search_btn" : [ 12,1, 0, "", "search_btn", "SEARCH_BTN", 12 ],
		"import_btn" : [ 12,1, 0, "导入按钮", "import_btn", "IMPORT_BTN", 13 ],
		"import_wizardbtn" : [ 12,1, 0, "导入向导按钮", "import_wizardbtn",
				"IMPORT_WIZARDBTN", 14 ],
		"export_btn" : [ 12,1, 0, "导出按钮", "export_btn", "EXPORT_BTN", 15 ],
		"export_wizardbtn" : [ 12,1, 0, "导出向导按钮", "export_wizardbtn",
				"EXPORT_WIZARDBTN", 16 ],
		"print_btn" : [ 12,1, 0, "打印按钮", "print_btn", "PRINT_BTN", 17 ],
		"print_previewbtn" : [ 12,1, 0, "打印预览按钮", "print_previewbtn",
				"PRINT_PREVIEWBTN", 18 ],
		"btn15" : [ 12,1, 0, "按钮15", "btn15", "BTN15", 19 ],
		"btn16" : [ 12,1, 0, "按钮16", "btn16", "BTN16", 20 ],
		"btn17" : [ 12,1, 0, "按钮17", "btn17", "BTN17", 21 ],
		"btn18" : [ 12,1, 0, "按钮18", "btn18", "BTN18", 22 ],
		"btn19" : [ 12,1, 0, "按钮19", "btn19", "BTN19", 23 ],
		"btn20" : [ 12,1, 0, "按钮20", "btn20", "BTN20", 24 ],
		"btn21" : [ 12,1, 0, "按钮21", "btn21", "BTN21", 25 ],
		"btn22" : [ 12,1, 0, "按钮22", "btn22", "BTN22", 26 ]
	};

AuthorityRmrelation.Export={};
AuthorityRmrelation.Export.export={};
/*
 * ColumnLabel: [ columnTypes, columnPrecisions, columnScales, columnNames_zh ]
 * key whom double quotation marks illustrate it's converted. eg: decode, case
 * when and other process table's column.
 * 
 */
AuthorityRmrelation.Export.export.ColumnMap = {
		N_RID : [ 3, 3, 0, "角色ID", 0 ],
		N_MID : [ 3, 8, 0, "模块ID", 1 ],
		C_CTIME : [ 93, 19, 0, "挂接时间", 2 ],
		C_CIP : [ 12, 60, 0, "挂接者所使用的IP", 3 ],
		C_CREATOR : [ 12, 24, 0, "挂接者", 4 ],
		"create_btn" : [ 12,1, 0, "新增按钮", 5 ],
		"update_btn" : [ 12,1, 0, "修改按钮", 6 ],
		"update_btn1" : [ 12,1, 0, "修改按钮1", 7 ],
		"read_btn" : [ 12,1, 0, "查看按钮", 8 ],
		"delete_btn" : [ 12,1, 0, "删除按钮", 9 ],
		"delete_btn1" : [ 12,1, 0, "删除按钮1", 10 ],
		"delete_btn2" : [ 12,1, 0, "删除按钮2", 11 ],
		"search_btn" : [ 12,1, 0, "", 12 ],
		"import_btn" : [ 12,1, 0, "导入按钮", 13 ],
		"import_wizardbtn" : [ 12,1, 0, "导入向导按钮", 14 ],
		"export_btn" : [ 12,1, 0, "导出按钮", 15 ],
		"export_wizardbtn" : [ 12,1, 0, "导出向导按钮", 16 ],
		"print_btn" : [ 12,1, 0, "打印按钮", 17 ],
		"print_previewbtn" : [ 12,1, 0, "打印预览按钮", 18 ],
		"btn15" : [ 12,1, 0, "按钮15", 19 ],
		"btn16" : [ 12,1, 0, "按钮16", 20 ],
		"btn17" : [ 12,1, 0, "按钮17", 21 ],
		"btn18" : [ 12,1, 0, "按钮18", 22 ],
		"btn19" : [ 12,1, 0, "按钮19", 23 ],
		"btn20" : [ 12,1, 0, "按钮20", 24 ],
		"btn21" : [ 12,1, 0, "按钮21", 25 ],
		"btn22" : [ 12,1, 0, "按钮22", 26 ]
	};

//AuthorityRmrelation.Export.export.DefaultColumns = "N_LID|C_LNAME|C_LNOTE";
//AuthorityRmrelation.Export.export.DefaultColumns = "0|1|2|3|4" +
//"|5";
AuthorityRmrelation.Export.export.DefaultColumns = 
	[ "N_RID", "N_MID", "C_CTIME", "C_CIP", "C_CREATOR", "create_btn",
		"update_btn", "update_btn1", "read_btn", "delete_btn", "delete_btn1",
		"delete_btn2", "search_btn", "import_btn", "import_wizardbtn",
		"export_btn", "export_wizardbtn", "print_btn", "print_previewbtn",
		"btn15", "btn16", "btn17", "btn18", "btn19", "btn20", "btn21", "btn22" ];
