CREATE TABLE T_MENUS(
	ID NUMBER(20) NOT NULL,
	MENU_NAME VARCHAR2(50) NOT NULL,
	MENU_URL VARCHAR2(250) NOT NULL,
	MENU_PARENT_ID NUMBER(20) NOT NULL,
	MENU_PRIVILEGE_CODE NUMBER(19) NOT NULL,
	MENU_PRIVILEGE_POS NUMBER(19) NOT NULL,
	MENU_DESCRIPTION VARCHAR2(250) NOT NULL,
	MENU_SORT_NO NUMBER(3) NOT NULL,
	PRIMARY KEY (ID)
);

COMMENT ON TABLE T_MENUS IS '菜单表';
COMMENT ON COLUMN T_MENUS.MENU_NAME  IS '菜单名称';
COMMENT ON COLUMN T_MENUS.MENU_URL  IS '菜单url';
COMMENT ON COLUMN T_MENUS.MENU_PARENT_ID  IS '上级id';
COMMENT ON COLUMN T_MENUS.MENU_PRIVILEGE_CODE  IS '权限码';
COMMENT ON COLUMN T_MENUS.MENU_PRIVILEGE_POS  IS '权限位';
COMMENT ON COLUMN T_MENUS.MENU_DESCRIPTION  IS '详细说明';
COMMENT ON COLUMN T_MENUS.MENU_SORT_NO  IS '排序';