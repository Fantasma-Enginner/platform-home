package org.tsir.toll.platform.resources.application.register;

import static org.tsir.common.modules.ResourceConstants.PLATAFORM_DOMAIN;
import static org.tsir.common.modules.ResourceConstants.SEPARATOR;
import static org.tsir.common.modules.ResourceConstants.RESOURCES_MODULE;

import org.tsir.common.modules.Operation;
import org.tsir.common.modules.Registrable;

public final class ResourcesModule implements Registrable {

	public static final ResourcesModule INSTANCE = new ResourcesModule();

	private ResourcesModule() {
	}

	private static final String FIND_RESOURCES_CODE = "1";
	public static final String FIND_RESOURCES_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + RESOURCES_MODULE + SEPARATOR
			+ FIND_RESOURCES_CODE;
	public static final Operation FIND_RESOURCES_RESOURCE = Operation.getFromAuthority("Consultar",
			FIND_RESOURCES_AUTHORITY);

	private static final String REGISTER_RESOURCE_CODE = "2";
	public static final String REGISTER_RESOURCE_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + RESOURCES_MODULE + SEPARATOR
			+ REGISTER_RESOURCE_CODE;
	public static final Operation REGISTER_RESOURCE_RESOURCE = Operation.getFromAuthority("Registrar",
			REGISTER_RESOURCE_AUTHORITY);

	private static final String GET_RESOURCE_CODE = "4";
	public static final String GET_RESOURCE_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + RESOURCES_MODULE + SEPARATOR
			+ GET_RESOURCE_CODE;
	public static final Operation GET_RESOURCE_RESOURCE = Operation.getFromAuthority("Detalle", GET_RESOURCE_AUTHORITY);

	private static final String UPDATE_RESOURCE_CODE = "8";
	public static final String UPDATE_RESOURCE_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + RESOURCES_MODULE + SEPARATOR
			+ UPDATE_RESOURCE_CODE;
	public static final Operation UPDATE_RESOURCE_RESOURCE = Operation.getFromAuthority("Modificar",
			UPDATE_RESOURCE_AUTHORITY);

	private static final String DELETE_RESOURCE_CODE = "10";
	public static final String DELETE_RESOURCE_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + RESOURCES_MODULE + SEPARATOR
			+ DELETE_RESOURCE_CODE;
	public static final Operation DELETE_RESOURCE_RESOURCE = Operation.getFromAuthority("Inactivar",
			DELETE_RESOURCE_AUTHORITY);

}
