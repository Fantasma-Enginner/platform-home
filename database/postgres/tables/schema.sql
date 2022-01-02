DO $$
DECLARE
	V_COUNT NUMERIC;
	V_TABLE_NAME VARCHAR(32);
BEGIN
	V_TABLE_NAME = 'resources';
	SELECT count(1) INTO V_COUNT from information_schema.tables where table_name = V_TABLE_NAME;
	IF V_COUNT = 0 THEN 
		EXECUTE ('
			CREATE TABLE '||V_TABLE_NAME||' (
				RESOURCE_ID NUMERIC(19), 
				CODE NUMERIC(10) NOT NULL, 
				LABEL VARCHAR(32) NOT NULL, 
				PATH VARCHAR(128),
				LOCATION VARCHAR(256),
				TYPE NUMERIC(2) NOT NULL,
				ACTIVE NUMERIC(2), 
				ICON VARCHAR(64), 
				PARENT_ID NUMERIC(19),
				CONSTRAINT RESORCES_PK PRIMARY KEY (RESOURCE_ID)
			)');
		RAISE NOTICE 'TABLA CREADA SATISFACTORIAMENTE: %', V_TABLE_NAME;
	ELSE
		RAISE NOTICE 'TABLA VALIDADA SATISFACTORIAMENTE: %', V_TABLE_NAME;
	END IF;
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.RESOURCE_ID IS ''Identificador númerico del recurso.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.CODE IS ''Codigo asignado a la operación, modulo o dominio en el registro de recursos.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.LABEL IS ''Nombre de visuaización del vinculo título de la operación.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.PATH IS ''Ruta de la entrada para un recurso que representa un módulo o redireccionamientos de aplicación.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.LOCATION IS ''URL de ubicación o exposición del servicio que permite el acceso a un módulo.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.TYPE IS ''Código del tipo de recurso. 0=DOMINIO, 1=MODULO, 2=OPERACION, 3=API''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.ACTIVE IS ''Estado de activación del módulo. 0=INACTIVO, 1=ACTIVO.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.ICON IS ''Nombre del icóno que se asocia visualmente a un recurso en las interfaces visuales.''');
	EXECUTE ('COMMENT ON COLUMN '||V_TABLE_NAME||'.PARENT_ID IS ''Identificador del recurso padre al cual pertenece el recurso. Los recursos que representan dominios no se les asigna padre.''');
	EXECUTE ('COMMENT ON TABLE '||V_TABLE_NAME||'  IS ''Tabla que almacena el detalle de los recursos de la plataforma VIAL PLUS. Cada recurso representa un dominio, modulo u operación.''');
	
END $$;
