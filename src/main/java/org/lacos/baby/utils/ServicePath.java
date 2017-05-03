package org.lacos.baby.utils;

public final class ServicePath {

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";

	public static final String ROOT_PATH = "/api";

	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";

	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

	///////////////////////////////////////////////////////////////
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////
	public static final String EDITUSER_PATH = PRIVATE_ROOT_PATH + "/edituser";
	public static final String CLIENTES_PATH = PRIVATE_ROOT_PATH + "/clientes";
	public static final String MODELOS_PATH = PRIVATE_ROOT_PATH + "/modelos";
	public static final String PEDIDOS_PATH = PRIVATE_ROOT_PATH + "/pedidos";

	public static final String CAIXA_PATH = PRIVATE_ROOT_PATH + "/caixa";
	public static final String MES_PATH = PRIVATE_ROOT_PATH + "/mes";
	public static final String COMPRA_PATH = PRIVATE_ROOT_PATH + "/compra";


	public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";
	public static final String USER_PERMISSION_PATH = PRIVATE_ROOT_PATH + "/userpermission";

	public static final String PERVISIT_PATH = PUBLIC_ROOT_PATH + "/permisvisit";
	public static final String VISITANTES_PATH = PUBLIC_ROOT_PATH + "/visitantes";
	public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";
	public static final String FILE_UPLOAD_PESSOA_PATH = PRIVATE_ROOT_PATH + "/fileuploadpessoa";



	///////////////////////////////////////////////////////////////
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////

	public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

	public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";

}
