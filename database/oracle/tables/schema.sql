DECLARE
	V_COUNT NUMBER;
	V_TABLE_NAME VARCHAR2(32);

BEGIN
	V_TABLE_NAME := 'RESOURCES';
	SELECT count(1) INTO V_COUNT from user_tables where table_name = V_TABLE_NAME;
	IF V_COUNT = 0 THEN
		 EXECUTE IMMEDIATE ('
			CREATE TABLE RESOURCES (
				RESOURCE_ID NUMBER(19), 
				CODE NUMBER(10) NOT NULL, 
				LABEL VARCHAR2(32) NOT NULL, 
				PATH VARCHAR2(128),
				LOCATION VARCHAR2(256),
                TYPE NUMBER(2) NOT NULL,
				ACTIVE NUMBER(2), 
				ICON VARCHAR2(64), 
				PARENT_ID NUMBER(19),
				CONSTRAINT RESORCES_PK PRIMARY KEY (RESOURCE_ID))');
		DBMS_OUTPUT.PUT_LINE('TABLA CREADA SATISFACTORIAMENTE: '|| V_TABLE_NAME);
	ELSE 
		DBMS_OUTPUT.PUT_LINE('TABLA VALIDADA: ' || V_TABLE_NAME);
	END IF;	
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.RESOURCE_ID IS ''Identificador numerico del recurso.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.CODE IS ''Codigo asignado a la operación, modulo o dominio en el registro de recursos.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.LABEL IS ''Nombre de visuaización del vinculo título de la operación.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.PATH IS ''Ruta de la entrada para un recurso que representa un módulo o redireccionamientos de aplicación.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.LOCATION IS ''URL de ubicación o exposición del servicio que permite el acceso a un módulo.''');
    EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.TYPE IS ''Código del tipo de recurso. 0=DOMINIO, 1=MODULO, 2=OPERACION, 3=API''');
    EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.ACTIVE IS ''Estado de activación del módulo. 0=INACTIVO, 1=ACTIVO.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.ICON IS ''Nombre del icono que se asocia visualmente a un recurso en las interfaces visuales.''');
	EXECUTE IMMEDIATE ('COMMENT ON COLUMN RESOURCES.PARENT_ID IS ''Identificador del recurso padre al cual pertenece el recurso. Los recursos que representan dominios no se les asigna padre.''');
	EXECUTE IMMEDIATE ('COMMENT ON TABLE RESOURCES  IS ''Tabla que almacena el detalle de los recursos de la plataforma VIAL PLUS. Cada recurso representa un dominio, modulo u operación.''');
	
END;
