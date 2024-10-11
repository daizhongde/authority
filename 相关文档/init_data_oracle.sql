--系统名称
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (1, '权限管理系统', 0, 'false', null, 1, 'R', 'icon-web', 'true', 'false', null, '系统名称', to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, '1', to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'));


--dev的系统管理
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (98, '系统管理(dev)', 1, 'false', 1, 1, 'R', null, 'true', 'false', 'fold/new.html', '备注...', to_date('28-05-2014 15:19:18', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('28-05-2014 15:26:32', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:19:18', 'dd-mm-yyyy hh24:mi:ss'));

insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9801, '机构管理(dev)', 2, 'true', 98, 1, 'R', null, 'true', 'false', 'dev/tAuthorityInst/inst_main.html', '备注...', to_date('28-05-2014 15:20:17', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:13:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:20:17', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9802, '人员管理(dev)', 2, 'true', 98, 2, 'R', null, 'true', 'false', 'dev/tAuthorityUser/user_main.html', '备注...', to_date('28-05-2014 15:20:23', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:13:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:20:23', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9803, '角色管理(dev)', 2, 'true', 98, 3, 'R', null, 'true', 'false', 'dev/tAuthorityRole/role_main.html', '备注...', to_date('28-05-2014 15:20:24', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:13:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:20:24', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9804, '菜单管理(dev)', 2, 'true', 98, 4, 'R', null, 'true', 'false', 'dev/tAuthorityModule/module_main.html', '备注...', to_date('28-05-2014 15:20:25', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:13:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:20:25', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9805, '权限级别管理(dev)', 2, 'true', 98, 5, 'R', null, 'true', 'false', 'dev/tAuthorityLevel/level_main.html', '备注...', to_date('28-05-2014 15:21:14', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:13:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 15:21:14', 'dd-mm-yyyy hh24:mi:ss'));

--admin的系统管理
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (99, '系统管理', 1, 'false', 1, 2, 'R', null, 'true', 'false', '../loginmain.jsp', null, to_date('19-05-2014 16:48:56', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('28-05-2014 15:21:55', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('19-05-2014 16:48:56', 'dd-mm-yyyy hh24:mi:ss'));

insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9901, '机构管理', 2, 'true', 99, 1, 'R', null, 'true', 'false', 'admin/tAuthorityInst/inst_main.html', null, to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('28-05-2014 15:22:15', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9902, '人员管理', 2, 'true', 99, 2, 'R', null, 'true', 'false', 'admin/tAuthorityUser/user_main.jsp', null, to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 23:09:21', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9903, '角色管理', 2, 'true', 99, 3, 'R', null, 'true', 'false', 'admin/tAuthorityRole/role_main.html', null, to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 11:26:59', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('19-05-2014 16:50:19', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9904, '机构资料', 2, 'true', 99, 4, 'R', null, 'true', 'false', 'common/tAuthorityInst/tAuthorityInst_modify.jsp', null, to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 16:32:45', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9905, '个人资料', 2, 'true', 99, 5, 'R', null, 'true', 'false', 'common/tAuthorityUser/tAuthorityUser_modify.jsp', null, to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 16:32:51', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9906, '机构信息查询', 2, 'true', 99, 6, 'R', null, 'true', 'false', 'common/tAuthorityInst/inst_main.html', null, to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 16:32:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'));
insert into t_authority_module (n_mid, c_mname, n_mlevel, c_mleaf, n_mparent, n_morder, c_mtarget, c_miconcls, c_mexpanded, c_mchecked, c_mpath, c_mnote, c_mctime, c_mcip, c_mcreator, c_mmtime, c_mmip, c_mmodifier, c_mons, c_mont)
values (9907, '人员信息查询', 2, 'true', 99, 7, 'R', null, 'true', 'false', 'common/tAuthorityUser/user_main.html', null, to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 16:32:54', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('23-05-2014 16:12:29', 'dd-mm-yyyy hh24:mi:ss'));


--角色信息
insert into t_authority_role (n_rid, c_rno, c_rname, n_rlevel, c_rnote, c_rctime, c_rcip, c_rcreator, c_rons, c_ront)
values (98, '098', '开发人员(dev)', 1, '仅限开发人员使用的角色', to_date('27-05-2014 09:56:55', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('27-05-2014 09:56:55', 'dd-mm-yyyy hh24:mi:ss'));

insert into t_authority_role (n_rid, c_rno, c_rname, n_rlevel, c_rnote, c_rctime, c_rcip, c_rcreator, c_rons, c_ront)
values (99, '099', '系统角色', 1, '系统角色权限', to_date('30-12-1899 01:00:00', 'dd-mm-yyyy hh24:mi:ss'), '2009/9/7', '2009/9/7', '1', to_date('20-05-2014 09:46:32', 'dd-mm-yyyy hh24:mi:ss'));

--用户信息 3656D8356A6905C2BB05069547051D94  
insert into t_authority_user (n_uid, c_ulogname, c_uname, c_upassword, c_usex, c_uphone, c_utel, c_ufax, c_uemail, c_uqq, c_uaddr, c_unote, n_iid, n_did, c_uctime, c_ucip, c_ucreator, c_umtime, c_umip, c_umodifier, c_uons, c_uont, c_logins, c_loginip, c_logint, c_logoutt)
values (9801, 'dev', '戴忠(dev)', '3656D8356A6905C2BB05069547051D94', '男', '137238682', '0731-88998735', '0731-88998932', 'dzd2746679@163.com', '413881461', '湖南长沙岳麓区玉兰路2号', '系统开发人员33', 1, null, to_date('28-05-2014 10:19:02', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('29-05-2014 16:33:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('28-05-2014 10:19:02', 'dd-mm-yyyy hh24:mi:ss'), '0', null, null, null);

insert into t_authority_user (n_uid, c_ulogname, c_uname, c_upassword, c_usex, c_uphone, c_utel, c_ufax, c_uemail, c_uqq, c_uaddr, c_unote, n_iid, n_did, c_uctime, c_ucip, c_ucreator, c_umtime, c_umip, c_umodifier, c_uons, c_uont, c_logins, c_loginip, c_logint, c_logoutt)
values (9901, 'admin', '系统管理员', '698D51A19D8A121CE581499D7B701668', '男', null, null, null, null, null, null, null, 1, null, to_date('21-05-2014 11:41:48', 'dd-mm-yyyy hh24:mi:ss'), null, null, to_date('27-05-2014 17:00:16', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', to_date('21-05-2014 11:41:48', 'dd-mm-yyyy hh24:mi:ss'), '0', null, null, null);

