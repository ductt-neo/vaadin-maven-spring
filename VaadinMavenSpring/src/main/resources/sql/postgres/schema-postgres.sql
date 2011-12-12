--------------------------------------------------------
--  File created - Friday-December-02-2011   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SCHEMA_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SCHEMA_ID_SEQ"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_APPLICATION_FIELD_SPEC
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_APPLICATION_FIELD_SPEC"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_APPLICATION_SPECIFICATION
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_APPLICATION_SPECIFICATION"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_DATA_TYPE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_DATA_TYPE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_EXTERNAL_SYSTEM
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_EXTERNAL_SYSTEM"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_RULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_RULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_RULE_CASE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_RULE_CASE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MAPPING_SCHEME
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_MAPPING_SCHEME"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PARTIAL_RESULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_PARTIAL_RESULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORE_CALCULATION
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORE_CALCULATION"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_FACTOR
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_FACTOR"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_ROLE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_ROLE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_RULE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_RULE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_RULE_CASE
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_RULE_CASE"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_SCHEME
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_SCHEME"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Sequence SEQ_SCORING_USER
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_SCORING_USER"  MINVALUE 1 MAXVALUE 1000000000000000000 INCREMENT 1 START 1 ;
--------------------------------------------------------
--  DDL for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  CREATE TABLE "APPLICATION_FIELD_SPEC" ("APP_SPEC_ID" NUMERIC, "NAME" VARCHAR(80), "FORMAT_PATTERN" VARCHAR(80), "DATA_TYPE_ID" NUMERIC, "APP_FIELD_SPEC_ID" NUMERIC) ;
--------------------------------------------------------
--  DDL for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  CREATE TABLE "APPLICATION_SPECIFICATION" ("APP_SPEC_ID" NUMERIC, "EXTERNAL_SYSTEM_ID" NUMERIC, "NAME" VARCHAR(80), "CODE" VARCHAR(50)) ;
--------------------------------------------------------
--  DDL for Table DATA_TYPE
--------------------------------------------------------

  CREATE TABLE "DATA_TYPE" ("DATA_TYPE_ID" NUMERIC, "DESCRIPTION" VARCHAR(255), "CODE" VARCHAR(50)) ;
--------------------------------------------------------
--  DDL for Table EXTERNAL_SYSTEM
--------------------------------------------------------

  CREATE TABLE "EXTERNAL_SYSTEM" ("EXTERNAL_SYSTEM_ID" NUMERIC, "NAME" VARCHAR(255), "CODE" VARCHAR(50)) ;
--------------------------------------------------------
--  DDL for Table MAPPING_RULE
--------------------------------------------------------

  CREATE TABLE "MAPPING_RULE" ("MAPPING_RULE_ID" NUMERIC, "SCORING_RULE_ID" NUMERIC, "MAPPING_SCHEME_ID" NUMERIC) ;
--------------------------------------------------------
--  DDL for Table MAPPING_RULE_CASE
--------------------------------------------------------

  CREATE TABLE "MAPPING_RULE_CASE" ("MAPPING_RULE_CASE_ID" NUMERIC, "MAPPING_RULE_ID" NUMERIC, "CONDITION_EXPRESSION" VARCHAR(1000), "SCORING_RULE_CASE_ID" NUMERIC) ;
--------------------------------------------------------
--  DDL for Table MAPPING_SCHEME
--------------------------------------------------------

  CREATE TABLE "MAPPING_SCHEME" ("MAPPING_SCHEME_ID" NUMERIC, "NAME" VARCHAR(50), "APP_SPEC_ID" NUMERIC, "SCORING_SCHEME_ID" NUMERIC, "CODE" VARCHAR(50)) ;
 
--------------------------------------------------------
--  DDL for Table PARTIAL_RESULT
--------------------------------------------------------

  CREATE TABLE "PARTIAL_RESULT" ("PARTIAL_RESULT_ID" NUMERIC, "CALCULATION_ID" NUMERIC, "SCORING_RULE_ID" NUMERIC, "MAPPING_RULE_CASE_ID" NUMERIC, "PARTIAL_RESULT" NUMERIC(6,2), "SCORING_RULE_CASE_ID" NUMERIC) ;
--------------------------------------------------------
--  DDL for Table SCORE_CALCULATION
--------------------------------------------------------

  CREATE TABLE "SCORE_CALCULATION" ("CALCULATION_ID" NUMERIC, "APP_SPEC_ID" NUMERIC, "MAPPING_SCHEME_ID" NUMERIC, "CREDIT_SCORE_RESULT" NUMERIC(6,2), "APPLICATION_ID" VARCHAR(255), "REQUEST_DATE" DATE) ;
--------------------------------------------------------
--  DDL for Table SCORING_FACTOR
--------------------------------------------------------

  CREATE TABLE "SCORING_FACTOR" ("FACTOR_ID" NUMERIC, "NAME" VARCHAR(255)) ;
--------------------------------------------------------
--  DDL for Table SCORING_ROLE
--------------------------------------------------------

  CREATE TABLE "SCORING_ROLE" ("ID" NUMERIC, "ROLE_NAME" VARCHAR(50), "DESCRIPTION" VARCHAR(100)) ;
--------------------------------------------------------
--  DDL for Table SCORING_RULE
--------------------------------------------------------

  CREATE TABLE "SCORING_RULE" ("RULE_ID" NUMERIC, "SCHEME_ID" NUMERIC, "FACTOR_ID" NUMERIC, "WEIGHT" NUMERIC, "REQUIRED" CHAR(1) DEFAULT NULL) ;

   COMMENT ON COLUMN "SCORING_RULE"."REQUIRED" IS 'REQUIRED: Y; NOT REQUIRED: N';
--------------------------------------------------------
--  DDL for Table SCORING_RULE_CASE
--------------------------------------------------------

  CREATE TABLE "SCORING_RULE_CASE" ("RULE_CASE_ID" NUMERIC, "FACTOR_CHOICE" VARCHAR(50), "RULE_ID" NUMERIC(10,0), "SCORE" NUMERIC(6,2)) ;
--------------------------------------------------------
--  DDL for Table SCORING_SCHEME
--------------------------------------------------------

  CREATE TABLE "SCORING_SCHEME" ("SCHEME_ID" NUMERIC, "NAME" VARCHAR(255)) ;
--------------------------------------------------------
--  DDL for Table SCORING_USER
--------------------------------------------------------

  CREATE TABLE "SCORING_USER" ("USERNAME" VARCHAR(50), "PASSWORD" VARCHAR(50), "ENABLED" VARCHAR(1), "USER_ID" NUMERIC) ;
--------------------------------------------------------
--  DDL for Table SCORING_USER_ROLE
--------------------------------------------------------

  CREATE TABLE "SCORING_USER_ROLE" ("USER_ID" NUMERIC, "ROLE_ID" NUMERIC, "DESCRIPTION" VARCHAR(100)) ;
--------------------------------------------------------
--  DDL for Table SEQUENCE_GENERATOR_TABLE
--------------------------------------------------------

  CREATE TABLE "SEQUENCE_GENERATOR_TABLE" ("SEQUENCE_NAME" VARCHAR(80), "SEQUENCE_VALUE" NUMERIC(15,0)) ;

--------------------------------------------------------
--  Constraints for Table SCORING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE_CASE" ALTER "FACTOR_CHOICE" SET NOT NULL;
  ALTER TABLE "SCORING_RULE_CASE" ALTER "RULE_ID" SET NOT NULL;
  ALTER TABLE "SCORING_RULE_CASE" ALTER "RULE_CASE_ID" SET NOT NULL;
  ALTER TABLE "SCORING_RULE_CASE" ADD CONSTRAINT "ID_SCORING_RULE_CASE_FK" PRIMARY KEY ("RULE_CASE_ID") ;

--------------------------------------------------------
--  Constraints for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  ALTER TABLE "APPLICATION_FIELD_SPEC" ALTER "APP_FIELD_SPEC_ID" SET NOT NULL;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ALTER "DATA_TYPE_ID" SET NOT NULL;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ALTER "APP_SPEC_ID" SET NOT NULL;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_PK" PRIMARY KEY ("APP_FIELD_SPEC_ID") ;

--------------------------------------------------------
--  Constraints for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  ALTER TABLE "APPLICATION_SPECIFICATION" ALTER "CODE" SET NOT NULL;
  ALTER TABLE "APPLICATION_SPECIFICATION" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "APPLICATION_SPECIFICATION" ALTER "EXTERNAL_SYSTEM_ID" SET NOT NULL;
  ALTER TABLE "APPLICATION_SPECIFICATION" ALTER "APP_SPEC_ID" SET NOT NULL;
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_NAME_UC" UNIQUE ("EXTERNAL_SYSTEM_ID", "NAME") ;
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_CODE_UC" UNIQUE ("EXTERNAL_SYSTEM_ID", "CODE") ;
  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPECIFICATION_PK" PRIMARY KEY ("APP_SPEC_ID") ;

--------------------------------------------------------
--  Constraints for Table MAPPING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE_CASE" ALTER "SCORING_RULE_CASE_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE_CASE" ALTER "CONDITION_EXPRESSION" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE_CASE" ALTER "MAPPING_RULE_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE_CASE" ALTER "MAPPING_RULE_CASE_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_PK" PRIMARY KEY ("MAPPING_RULE_CASE_ID") ;
--------------------------------------------------------
--  Constraints for Table SCORING_USER
--------------------------------------------------------

  ALTER TABLE "SCORING_USER" ADD CONSTRAINT "SYS_C007198" PRIMARY KEY ("USER_ID") ;
  ALTER TABLE "SCORING_USER" ALTER "USER_ID" SET NOT NULL;
  ALTER TABLE "SCORING_USER" ALTER "ENABLED" SET NOT NULL;
  ALTER TABLE "SCORING_USER" ALTER "PASSWORD" SET NOT NULL;
  ALTER TABLE "SCORING_USER" ALTER "USERNAME" SET NOT NULL;

--------------------------------------------------------
--  Constraints for Table MAPPING_SCHEME
--------------------------------------------------------

  ALTER TABLE "MAPPING_SCHEME" ALTER "CODE" SET NOT NULL;
  ALTER TABLE "MAPPING_SCHEME" ALTER "SCORING_SCHEME_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_SCHEME" ALTER "APP_SPEC_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_SCHEME" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "MAPPING_SCHEME" ALTER "MAPPING_SCHEME_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_PK" PRIMARY KEY ("MAPPING_SCHEME_ID") ;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_NAME_UC" UNIQUE ("NAME", "APP_SPEC_ID") ;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_CODE_UC" UNIQUE ("APP_SPEC_ID", "CODE") ;

--------------------------------------------------------
--  Constraints for Table SCORING_RULE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE" ALTER "REQUIRED" SET NOT NULL;
  ALTER TABLE "SCORING_RULE" ADD CHECK (WEIGHT between 0 and 1) ;
  ALTER TABLE "SCORING_RULE" ALTER "WEIGHT" SET NOT NULL;
  ALTER TABLE "SCORING_RULE" ALTER "FACTOR_ID" SET NOT NULL;
  ALTER TABLE "SCORING_RULE" ALTER "SCHEME_ID" SET NOT NULL;
  ALTER TABLE "SCORING_RULE" ALTER "RULE_ID" SET NOT NULL;
  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_PK" PRIMARY KEY ("RULE_ID") ;

--------------------------------------------------------
--  Constraints for Table SCORING_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_ROLE" ADD CONSTRAINT "SCORING_ROLE_PK" PRIMARY KEY ("ID") ;
  ALTER TABLE "SCORING_ROLE" ALTER "ROLE_NAME" SET NOT NULL;
  ALTER TABLE "SCORING_ROLE" ALTER "ID" SET NOT NULL;

--------------------------------------------------------
--  Constraints for Table PARTIAL_RESULT
--------------------------------------------------------

  ALTER TABLE "PARTIAL_RESULT" ALTER "SCORING_RULE_CASE_ID" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ALTER "PARTIAL_RESULT" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ALTER "MAPPING_RULE_CASE_ID" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ALTER "SCORING_RULE_ID" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ALTER "CALCULATION_ID" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ALTER "PARTIAL_RESULT_ID" SET NOT NULL;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_PK" PRIMARY KEY ("PARTIAL_RESULT_ID") ;

--------------------------------------------------------
--  Constraints for Table SCORING_USER_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_PK" PRIMARY KEY ("USER_ID", "ROLE_ID") ;
  ALTER TABLE "SCORING_USER_ROLE" ALTER "ROLE_ID" SET NOT NULL;
  ALTER TABLE "SCORING_USER_ROLE" ALTER "USER_ID" SET NOT NULL;

--------------------------------------------------------
--  Constraints for Table SCORING_FACTOR
--------------------------------------------------------

  ALTER TABLE "SCORING_FACTOR" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "SCORING_FACTOR" ALTER "FACTOR_ID" SET NOT NULL;
  ALTER TABLE "SCORING_FACTOR" ADD CONSTRAINT "SCORING_FACTOR_PK" PRIMARY KEY ("FACTOR_ID") ;
  ALTER TABLE "SCORING_FACTOR" ADD CONSTRAINT "SCORING_FACTOR_NAME_UK" UNIQUE ("NAME") ;

--------------------------------------------------------
--  Constraints for Table EXTERNAL_SYSTEM
--------------------------------------------------------

  ALTER TABLE "EXTERNAL_SYSTEM" ALTER "CODE" SET NOT NULL;
  ALTER TABLE "EXTERNAL_SYSTEM" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "EXTERNAL_SYSTEM" ALTER "EXTERNAL_SYSTEM_ID" SET NOT NULL;
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_PK" PRIMARY KEY ("EXTERNAL_SYSTEM_ID") ;
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_NAME_UC" UNIQUE ("NAME") ;
  ALTER TABLE "EXTERNAL_SYSTEM" ADD CONSTRAINT "EXTERNAL_SYSTEM_CODE_UC" UNIQUE ("CODE") ;

--------------------------------------------------------
--  Constraints for Table SEQUENCE_GENERATOR_TABLE
--------------------------------------------------------

  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" ADD PRIMARY KEY ("SEQUENCE_NAME") ;
  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" ALTER "SEQUENCE_VALUE" SET NOT NULL;
  ALTER TABLE "SEQUENCE_GENERATOR_TABLE" ALTER "SEQUENCE_NAME" SET NOT NULL;

--------------------------------------------------------
--  Constraints for Table DATA_TYPE
--------------------------------------------------------

  ALTER TABLE "DATA_TYPE" ALTER "CODE" SET NOT NULL;
  ALTER TABLE "DATA_TYPE" ALTER "DATA_TYPE_ID" SET NOT NULL;
  ALTER TABLE "DATA_TYPE" ADD CONSTRAINT "DATA_TYPE_PK" PRIMARY KEY ("DATA_TYPE_ID") ;
--------------------------------------------------------
--  Constraints for Table MAPPING_RULE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE" ALTER "MAPPING_SCHEME_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE" ALTER "SCORING_RULE_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE" ALTER "MAPPING_RULE_ID" SET NOT NULL;
  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_PK" PRIMARY KEY ("MAPPING_RULE_ID") ;

--------------------------------------------------------
--  Constraints for Table SCORING_SCHEME
--------------------------------------------------------

  ALTER TABLE "SCORING_SCHEME" ALTER "NAME" SET NOT NULL;
  ALTER TABLE "SCORING_SCHEME" ALTER "SCHEME_ID" SET NOT NULL;
  ALTER TABLE "SCORING_SCHEME" ADD CONSTRAINT "SCORING_SCHEME_PK" PRIMARY KEY ("SCHEME_ID") ;
  ALTER TABLE "SCORING_SCHEME" ADD CONSTRAINT "SCORING_SCHEME_NAME_UK" UNIQUE ("NAME") ;
--------------------------------------------------------
--  Constraints for Table SCORE_CALCULATION
--------------------------------------------------------

  ALTER TABLE "SCORE_CALCULATION" ALTER "REQUEST_DATE" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ALTER "APPLICATION_ID" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ALTER "CREDIT_SCORE_RESULT" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ALTER "MAPPING_SCHEME_ID" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ALTER "APP_SPEC_ID" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ALTER "CALCULATION_ID" SET NOT NULL;
  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_PK" PRIMARY KEY ("CALCULATION_ID") ;

--------------------------------------------------------
--  Ref Constraints for Table APPLICATION_FIELD_SPEC
--------------------------------------------------------

  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_APP_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ;
  ALTER TABLE "APPLICATION_FIELD_SPEC" ADD CONSTRAINT "APPLICATION_FIELD_SPEC_DT_FK" FOREIGN KEY ("DATA_TYPE_ID") REFERENCES "DATA_TYPE" ("DATA_TYPE_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table APPLICATION_SPECIFICATION
--------------------------------------------------------

  ALTER TABLE "APPLICATION_SPECIFICATION" ADD CONSTRAINT "APPLICATION_SPEC_EXTS_FK" FOREIGN KEY ("EXTERNAL_SYSTEM_ID") REFERENCES "EXTERNAL_SYSTEM" ("EXTERNAL_SYSTEM_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_RULE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_MSCHEME_FK" FOREIGN KEY ("MAPPING_SCHEME_ID") REFERENCES "MAPPING_SCHEME" ("MAPPING_SCHEME_ID") ;
  ALTER TABLE "MAPPING_RULE" ADD CONSTRAINT "MAPPING_RULE_SCRULE_FK" FOREIGN KEY ("SCORING_RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_RULE_FK" FOREIGN KEY ("MAPPING_RULE_ID") REFERENCES "MAPPING_RULE" ("MAPPING_RULE_ID") ;
  ALTER TABLE "MAPPING_RULE_CASE" ADD CONSTRAINT "MAPPING_RULE_CASE_SRC_FK" FOREIGN KEY ("SCORING_RULE_CASE_ID") REFERENCES "SCORING_RULE_CASE" ("RULE_CASE_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table MAPPING_SCHEME
--------------------------------------------------------

  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_APPSPEC_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ;
  ALTER TABLE "MAPPING_SCHEME" ADD CONSTRAINT "MAPPING_SCHEME_SCS_FK" FOREIGN KEY ("SCORING_SCHEME_ID") REFERENCES "SCORING_SCHEME" ("SCHEME_ID") ;
--
--------------------------------------------------------
--  Ref Constraints for Table PARTIAL_RESULT
--------------------------------------------------------

  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_CALC_FK" FOREIGN KEY ("CALCULATION_ID") REFERENCES "SCORE_CALCULATION" ("CALCULATION_ID") ;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_MRC_FK" FOREIGN KEY ("MAPPING_RULE_CASE_ID") REFERENCES "MAPPING_RULE_CASE" ("MAPPING_RULE_CASE_ID") ;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_SRC_FK" FOREIGN KEY ("SCORING_RULE_CASE_ID") REFERENCES "SCORING_RULE_CASE" ("RULE_CASE_ID") ;
  ALTER TABLE "PARTIAL_RESULT" ADD CONSTRAINT "PARTIAL_RESULT_SR_FK" FOREIGN KEY ("SCORING_RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table SCORE_CALCULATION
--------------------------------------------------------

  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_AS_FK" FOREIGN KEY ("APP_SPEC_ID") REFERENCES "APPLICATION_SPECIFICATION" ("APP_SPEC_ID") ;
  ALTER TABLE "SCORE_CALCULATION" ADD CONSTRAINT "SCORE_CALCULATION_MS_FK" FOREIGN KEY ("MAPPING_SCHEME_ID") REFERENCES "MAPPING_SCHEME" ("MAPPING_SCHEME_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_RULE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_FACTOR_FK" FOREIGN KEY ("FACTOR_ID") REFERENCES "SCORING_FACTOR" ("FACTOR_ID") ;
  ALTER TABLE "SCORING_RULE" ADD CONSTRAINT "SCORING_RULE_SCHEME_FK" FOREIGN KEY ("SCHEME_ID") REFERENCES "SCORING_SCHEME" ("SCHEME_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_RULE_CASE
--------------------------------------------------------

  ALTER TABLE "SCORING_RULE_CASE" ADD CONSTRAINT "FK_RULE_ID" FOREIGN KEY ("RULE_ID") REFERENCES "SCORING_RULE" ("RULE_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table SCORING_USER_ROLE
--------------------------------------------------------

  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_SCORING_FK1" FOREIGN KEY ("ROLE_ID") REFERENCES "SCORING_ROLE" ("ID") ;
  ALTER TABLE "SCORING_USER_ROLE" ADD CONSTRAINT "SCORING_USER_ROLE_SCORING_FK2" FOREIGN KEY ("USER_ID") REFERENCES "SCORING_USER" ("USER_ID") ;
