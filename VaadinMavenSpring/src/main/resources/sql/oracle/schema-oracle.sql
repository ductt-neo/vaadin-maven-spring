--------------------------------------------------------
--  File created - Friday-December-02-2011   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SCHEMA_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SCHEMA_ID_SEQ"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_APPLICATION_FIELD_SPEC
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_APPLICATION_FIELD_SPEC"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_APPLICATION_SPECIFICATION
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_APPLICATION_SPECIFICATION"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_DATA_TYPE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_DATA_TYPE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_EXTERNAL_SYSTEM
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_EXTERNAL_SYSTEM"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_RULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_RULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_RULE_CASE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_RULE_CASE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_SCHEME
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_SCHEME"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PARTIAL_RESULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_PARTIAL_RESULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORE_CALCULATION
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORE_CALCULATION"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_FACTOR
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_FACTOR"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_ROLE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_ROLE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_RULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_RULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_RULE_CASE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_RULE_CASE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_SCHEME
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_SCHEME"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_USER
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_USER"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  CREATE TABLE "APPLICATION_FIELD_SPEC" ("APP_SPEC_ID" NUMBER, "NAME" VARCHAR2(80), "FORMAT_PATTERN" VARCHAR2(80), "DATA_TYPE_ID" NUMBER, "APP_FIELD_SPEC_ID" NUMBER) ;
--------------------------------------------------------
--  DDL for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  CREATE TABLE "APPLICATION_SPECIFICATION" ("APP_SPEC_ID" NUMBER, "EXTERNAL_SYSTEM_ID" NUMBER, "NAME" VARCHAR2(80), "CODE" VARCHAR2(50)) ;
--------------------------------------------------------
--  DDL for Table DATA_TYPE
--------------------------------------------------------

  CREATE TABLE "DATA_TYPE" ("DATA_TYPE_ID" NUMBER, "DESCRIPTION" VARCHAR2(255), "CODE" VARCHAR2(50)) ;
--------------------------------------------------------
--  DDL for Table EXTERNAL_SYSTEM
--------------------------------------------------------

  CREATE TABLE "EXTERNAL_SYSTEM" ("EXTERNAL_SYSTEM_ID" NUMBER, "NAME" VARCHAR2(255), "CODE" VARCHAR2(50)) ;
--------------------------------------------------------
--  DDL for Table MAPPING_RULE
--------------------------------------------------------

  CREATE TABLE "MAPPING_RULE" ("MAPPING_RULE_ID" NUMBER, "SCORING_RULE_ID" NUMBER, "MAPPING_SCHEME_ID" NUMBER) ;
--------------------------------------------------------
--  DDL for Table MAPPING_RULE_CASE
--------------------------------------------------------

  CREATE TABLE "MAPPING_RULE_CASE" ("MAPPING_RULE_CASE_ID" NUMBER, "MAPPING_RULE_ID" NUMBER, "CONDITION_EXPRESSION" VARCHAR2(1000 CHAR), "SCORING_RULE_CASE_ID" NUMBER) ;
--------------------------------------------------------
--  DDL for Table MAPPING_SCHEME
--------------------------------------------------------

  CREATE TABLE "MAPPING_SCHEME" ("MAPPING_SCHEME_ID" NUMBER, "NAME" VARCHAR2(50 CHAR), "APP_SPEC_ID" NUMBER, "SCORING_SCHEME_ID" NUMBER, "CODE" VARCHAR2(50 CHAR)) ;
 
--------------------------------------------------------
--  DDL for Table PARTIAL_RESULT
--------------------------------------------------------

  CREATE TABLE "PARTIAL_RESULT" ("PARTIAL_RESULT_ID" NUMBER, "CALCULATION_ID" NUMBER, "SCORING_RULE_ID" NUMBER, "MAPPING_RULE_CASE_ID" NUMBER, "PARTIAL_RESULT" NUMBER(6,2), "SCORING_RULE_CASE_ID" NUMBER) ;
--------------------------------------------------------
--  DDL for Table SCORE_CALCULATION
--------------------------------------------------------

  CREATE TABLE "SCORE_CALCULATION" ("CALCULATION_ID" NUMBER, "APP_SPEC_ID" NUMBER, "MAPPING_SCHEME_ID" NUMBER, "CREDIT_SCORE_RESULT" NUMBER(6,2), "APPLICATION_ID" VARCHAR2(255), "REQUEST_DATE" DATE) ;
--------------------------------------------------------
--  DDL for Table SCORING_FACTOR
--------------------------------------------------------

  CREATE TABLE "SCORING_FACTOR" ("FACTOR_ID" NUMBER, "NAME" VARCHAR2(255)) ;
--------------------------------------------------------
--  DDL for Table SCORING_ROLE
--------------------------------------------------------

  CREATE TABLE "SCORING_ROLE" ("ID" NUMBER, "ROLE_NAME" VARCHAR2(50), "DESCRIPTION" VARCHAR2(100)) ;
--------------------------------------------------------
--  DDL for Table SCORING_RULE
--------------------------------------------------------

  CREATE TABLE "SCORING_RULE" ("RULE_ID" NUMBER, "SCHEME_ID" NUMBER, "FACTOR_ID" NUMBER, "WEIGHT" NUMBER, "REQUIRED" CHAR(1 CHAR) DEFAULT NULL) ;

   COMMENT ON COLUMN "SCORING_RULE"."REQUIRED" IS 'REQUIRED: Y; NOT REQUIRED: N';
--------------------------------------------------------
--  DDL for Table SCORING_RULE_CASE
--------------------------------------------------------

  CREATE TABLE "SCORING_RULE_CASE" ("RULE_CASE_ID" NUMBER, "FACTOR_CHOICE" VARCHAR2(50), "RULE_ID" NUMBER(*,0), "SCORE" NUMBER(6,2)) ;
--------------------------------------------------------
--  DDL for Table SCORING_SCHEME
--------------------------------------------------------

  CREATE TABLE "SCORING_SCHEME" ("SCHEME_ID" NUMBER, "NAME" VARCHAR2(255)) ;
--------------------------------------------------------
--  DDL for Table SCORING_USER
--------------------------------------------------------

  CREATE TABLE "SCORING_USER" ("USERNAME" VARCHAR2(50), "PASSWORD" VARCHAR2(50), "ENABLED" VARCHAR2(1), "USER_ID" NUMBER) ;
--------------------------------------------------------
--  DDL for Table SCORING_USER_ROLE
--------------------------------------------------------

  CREATE TABLE "SCORING_USER_ROLE" ("USER_ID" NUMBER, "ROLE_ID" NUMBER, "DESCRIPTION" VARCHAR2(100)) ;
--------------------------------------------------------
--  DDL for Table SEQUENCE_GENERATOR_TABLE
--------------------------------------------------------

  CREATE TABLE "SEQUENCE_GENERATOR_TABLE" ("SEQUENCE_NAME" VARCHAR2(80), "SEQUENCE_VALUE" NUMBER(15,0)) ;

--------------------------------------------------------
--  Constraints for Table SCORING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE_CASE" MODIFY ("FACTOR_CHOICE" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE_CASE" MODIFY ("RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE_CASE" MODIFY ("RULE_CASE_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE_CASE" ADD CONSTRAINT "ID_SCORING_RULE_CASE_FK" PRIMARY KEY ("RULE_CASE_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  ALTER TABLE "APPLICATION_FIELD_SPEC" MODIFY ("APP_FIELD_SPEC_ID" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_FIELD_SPEC" MODIFY ("DATA_TYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_FIELD_SPEC" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_FIELD_SPEC" MODIFY ("APP_SPEC_ID" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_PK" PRIMARY KEY ("APP_FIELD_SPEC_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  ALTER TABLE "APPLICATION_SPECIFICATION" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_SPECIFICATION" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_SPECIFICATION" MODIFY ("EXTERNAL_SYSTEM_ID" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_SPECIFICATION" MODIFY ("APP_SPEC_ID" NOT NULL ENABLE);
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_NAME_UC" UNIQUE ("EXTERNAL_SYSTEM_ID", "NAME") ENABLE;
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_CODE_UC" UNIQUE ("EXTERNAL_SYSTEM_ID", "CODE") ENABLE;
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPECIFICATION_PK" PRIMARY KEY ("APP_SPEC_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table MAPPING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE_CASE" MODIFY ("SCORING_RULE_CASE_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE_CASE" MODIFY ("CONDITION_EXPRESSION" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE_CASE" MODIFY ("MAPPING_RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE_CASE" MODIFY ("MAPPING_RULE_CASE_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_PK" PRIMARY KEY ("MAPPING_RULE_CASE_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table SCORING_USER
--------------------------------------------------------

  ALTER TABLE "SCORING_USER" ADD CONSTRAINT "SYS_C007198" PRIMARY KEY ("USER_ID") ENABLE;
  ALTER TABLE "SCORING_USER" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_USER" MODIFY ("ENABLED" NOT NULL ENABLE);
  ALTER TABLE "SCORING_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "SCORING_USER" MODIFY ("USERNAME" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table MAPPING_SCHEME
--------------------------------------------------------

  ALTER TABLE "MAPPING_SCHEME" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_SCHEME" MODIFY ("SCORING_SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_SCHEME" MODIFY ("APP_SPEC_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_SCHEME" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_SCHEME" MODIFY ("MAPPING_SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_PK" PRIMARY KEY ("MAPPING_SCHEME_ID") ENABLE;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_NAME_UC" UNIQUE ("NAME", "APP_SPEC_ID") ENABLE;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_CODE_UC" UNIQUE ("APP_SPEC_ID", "CODE") ENABLE;

--------------------------------------------------------
--  Constraints for Table SCORING_RULE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE" MODIFY ("REQUIRED" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE" ADD CHECK (WEIGHT between 0 and 1) ENABLE;
  ALTER TABLE "SCORING_RULE" MODIFY ("WEIGHT" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE" MODIFY ("FACTOR_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE" MODIFY ("SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE" MODIFY ("RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_PK" PRIMARY KEY ("RULE_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table SCORING_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_ROLE" ADD CONSTRAINT "SCORING_ROLE_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "SCORING_ROLE" MODIFY ("ROLE_NAME" NOT NULL ENABLE);
  ALTER TABLE "SCORING_ROLE" MODIFY ("ID" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table PARTIAL_RESULT
--------------------------------------------------------

  ALTER TABLE "PARTIAL_RESULT" MODIFY ("SCORING_RULE_CASE_ID" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" MODIFY ("PARTIAL_RESULT" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" MODIFY ("MAPPING_RULE_CASE_ID" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" MODIFY ("SCORING_RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" MODIFY ("CALCULATION_ID" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" MODIFY ("PARTIAL_RESULT_ID" NOT NULL ENABLE);
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_PK" PRIMARY KEY ("PARTIAL_RESULT_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table SCORING_USER_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_PK" PRIMARY KEY ("USER_ID", "ROLE_ID") ENABLE;
  ALTER TABLE "SCORING_USER_ROLE" MODIFY ("ROLE_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_USER_ROLE" MODIFY ("USER_ID" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table SCORING_FACTOR
--------------------------------------------------------

  ALTER TABLE "SCORING_FACTOR" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SCORING_FACTOR" MODIFY ("FACTOR_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_FACTOR" ADD CONSTRAINT "SCORING_FACTOR_PK" PRIMARY KEY ("FACTOR_ID") ENABLE;
  ALTER TABLE "SCORING_FACTOR" ADD CONSTRAINT "SCORING_FACTOR_NAME_UK" UNIQUE ("NAME") ENABLE;

--------------------------------------------------------
--  Constraints for Table EXTERNAL_SYSTEM
--------------------------------------------------------

  ALTER TABLE "EXTERNAL_SYSTEM" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "EXTERNAL_SYSTEM" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "EXTERNAL_SYSTEM" MODIFY ("EXTERNAL_SYSTEM_ID" NOT NULL ENABLE);
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_PK" PRIMARY KEY ("EXTERNAL_SYSTEM_ID") ENABLE;
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_NAME_UC" UNIQUE ("NAME") ENABLE;
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_CODE_UC" UNIQUE ("CODE") ENABLE;

--------------------------------------------------------
--  Constraints for Table SEQUENCE_GENERATOR_TABLE
--------------------------------------------------------

  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" ADD PRIMARY KEY ("SEQUENCE_NAME") ENABLE;
  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" MODIFY ("SEQUENCE_VALUE" NOT NULL ENABLE);
  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" MODIFY ("SEQUENCE_NAME" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table DATA_TYPE
--------------------------------------------------------

  ALTER TABLE "DATA_TYPE" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "DATA_TYPE" MODIFY ("DATA_TYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "DATA_TYPE" ADD CONSTRAINT "DATA_TYPE_PK" PRIMARY KEY ("DATA_TYPE_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table MAPPING_RULE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE" MODIFY ("MAPPING_SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE" MODIFY ("SCORING_RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE" MODIFY ("MAPPING_RULE_ID" NOT NULL ENABLE);
  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_PK" PRIMARY KEY ("MAPPING_RULE_ID") ENABLE;

--------------------------------------------------------
--  Constraints for Table SCORING_SCHEME
--------------------------------------------------------

  ALTER TABLE "SCORING_SCHEME" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SCORING_SCHEME" MODIFY ("SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORING_SCHEME" ADD CONSTRAINT "SCORING_SCHEME_PK" PRIMARY KEY ("SCHEME_ID") ENABLE;
  ALTER TABLE "SCORING_SCHEME" ADD CONSTRAINT "SCORING_SCHEME_NAME_UK" UNIQUE ("NAME") ENABLE;
--------------------------------------------------------
--  Constraints for Table SCORE_CALCULATION
--------------------------------------------------------

  ALTER TABLE "SCORE_CALCULATION" MODIFY ("REQUEST_DATE" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" MODIFY ("APPLICATION_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" MODIFY ("CREDIT_SCORE_RESULT" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" MODIFY ("MAPPING_SCHEME_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" MODIFY ("APP_SPEC_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" MODIFY ("CALCULATION_ID" NOT NULL ENABLE);
  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_PK" PRIMARY KEY ("CALCULATION_ID") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_APP_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ENABLE;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_DT_FK" FOREIGN KEY ("DATA_TYPE_ID") REFERENCES "DATA_TYPE" ("DATA_TYPE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_EXTS_FK" FOREIGN KEY ("EXTERNAL_SYSTEM_ID") REFERENCES "EXTERNAL_SYSTEM" ("EXTERNAL_SYSTEM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_RULE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_MSCHEME_FK" FOREIGN KEY ("MAPPING_SCHEME_ID") REFERENCES "MAPPING_SCHEME" ("MAPPING_SCHEME_ID") ENABLE;
  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_SCRULE_FK" FOREIGN KEY ("SCORING_RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_RULE_FK" FOREIGN KEY ("MAPPING_RULE_ID") REFERENCES "MAPPING_RULE" ("MAPPING_RULE_ID") ENABLE;
  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_SRC_FK" FOREIGN KEY ("SCORING_RULE_CASE_ID") REFERENCES "SCORING_RULE_CASE" ("RULE_CASE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_SCHEME
--------------------------------------------------------

  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_APPSPEC_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ENABLE;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_SCS_FK" FOREIGN KEY ("SCORING_SCHEME_ID") REFERENCES "SCORING_SCHEME" ("SCHEME_ID") ENABLE;
--
--------------------------------------------------------
--  Ref Constraints for Table PARTIAL_RESULT
--------------------------------------------------------

  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_CALC_FK" FOREIGN KEY ("CALCULATION_ID") REFERENCES "SCORE_CALCULATION" ("CALCULATION_ID") ENABLE;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_MRC_FK" FOREIGN KEY ("MAPPING_RULE_CASE_ID") REFERENCES "MAPPING_RULE_CASE" ("MAPPING_RULE_CASE_ID") ENABLE;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_SRC_FK" FOREIGN KEY ("SCORING_RULE_CASE_ID") REFERENCES "SCORING_RULE_CASE" ("RULE_CASE_ID") ENABLE;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_SR_FK" FOREIGN KEY ("SCORING_RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCORE_CALCULATION
--------------------------------------------------------

  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_AS_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ENABLE;
  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_MS_FK" FOREIGN KEY ("MAPPING_SCHEME_ID") REFERENCES "MAPPING_SCHEME" ("MAPPING_SCHEME_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_RULE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_FACTOR_FK" FOREIGN KEY ("FACTOR_ID") REFERENCES "SCORING_FACTOR" ("FACTOR_ID") ENABLE;
  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_SCHEME_FK" FOREIGN KEY ("SCHEME_ID") REFERENCES "SCORING_SCHEME" ("SCHEME_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE_CASE" ADD CONSTRAINT "FK_RULE_ID" FOREIGN KEY ("RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_USER_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_SCORING_FK1" FOREIGN KEY ("ROLE_ID") REFERENCES "SCORING_ROLE" ("ID") ENABLE;
  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_SCORING_FK2" FOREIGN KEY ("USER_ID") REFERENCES "SCORING_USER" ("USER_ID") ENABLE;
