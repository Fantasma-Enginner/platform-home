package org.tsir.toll.platform.resources.application.register;

import static org.tsir.common.modules.ResourceConstants.PLATAFORM_DOMAIN;
import static org.tsir.common.modules.ResourceConstants.HOME_MODULE;
import static org.tsir.common.modules.ResourceConstants.SEPARATOR;

import org.tsir.common.modules.Operation;
import org.tsir.common.modules.Registrable;

public class HomeModule implements Registrable {

	public static final HomeModule INSTANCE = new HomeModule();

	private HomeModule() {
	}

	private static final String GET_HOME_CODE = "1";
	public static final String GET_HOME_AUTHORITY = PLATAFORM_DOMAIN + SEPARATOR + HOME_MODULE + SEPARATOR
			+ GET_HOME_CODE;
	public static final Operation GET_HOME_RESOURCE = Operation.getFromAuthority("Obtener", GET_HOME_AUTHORITY);

}
