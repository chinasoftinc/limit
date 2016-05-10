CREATE TABLE  T_DEPARTMENTS
(
  	ID 								NUMBER(20) NOT NULL,
    DEPT_CODE      					VARCHAR2(50) NOT NULL,
    DEPT_SHORT_NAME  				VARCHAR2(50) NOT NULL,
    DEPT_NAME      					VARCHAR2(50) NOT NULL,
    DEPT_AREA_CODE					NUMBER(20) 	 DEFAULT 0 NOT NULL,
    DEPT_DISTRICT_CODE				NUMBER(20) 	 DEFAULT 0 NOT NULL,
    DEPT_DESCRIPTION 				VARCHAR2(255) DEFAULT '' NOT NULL,
    DEPT_TYPE						CHAR(1) NOT NULL,
    DEPT_PARENT_ID 					NUMBER(20) DEFAULT 0 NOT NULL,
	DEPT_SUB_COUNT   				NUMBER(4) DEFAULT 0 NOT NULL,
    DEPT_SORT_NO   					NUMBER(3) NOT NULL,
    DEPT_DEEP 						NUMBER(2) NOT NULL,
	
    IS_DEL    						CHAR(1) DEFAULT '0' NOT NULL,
    CREATE_TIME  					DATE NOT NULL,
    UPDATE_TIME 					DATE NOT NULL,
    CREATE_USERID 					NUMBER(20) DEFAULT 0 NOT NULL,
    UPDATE_USERID 					NUMBER(20) DEFAULT 0 NOT NULL,
    VERSION_NO     					NUMBER(20) DEFAULT 0 NOT NULL,
    PRIMARY KEY (ID)
);

COMMENT ON TABLE T_DEPARTMENTS IS '部门表';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_CODE  IS '部门编码, 自动生成';

COMMENT ON COLUMN T_DEPARTMENTS.DEPT_SHORT_NAME  IS '部门简称';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_NAME  IS '部门名称';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_AREA_CODE  IS '地区代码';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_DISTRICT_CODE  IS '区县代码';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_DESCRIPTION  IS '部门备注';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_TYPE  IS '部门类型(0:机构, 1:部门)';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_PARENT_ID  IS '上级ID';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_SUB_COUNT  IS '下级部门数量';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_SORT_NO  IS '排序';
COMMENT ON COLUMN T_DEPARTMENTS.DEPT_DEEP  IS '部门路径深度';

CREATE INDEX INDEX_T_DEPARTMENTS_PARENT_ID ON T_DEPARTMENTS(DEPT_PARENT_ID);