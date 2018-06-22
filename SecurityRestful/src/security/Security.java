package security;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import javax.annotation.security.*;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;

import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import org.jboss.resteasy.util.Base64;
import enteties.*;
import model.*;

@Provider
@ServerInterceptor
public class Security implements PreProcessInterceptor {

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_SCHEME = "Basic";
	
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());
	private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());
	
	
	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod methodInvoke) 
			throws Failure, WebApplicationException {
		
		Method method = methodInvoke.getMethod();
		
		if(method.isAnnotationPresent(PermitAll.class)) {
			return null;
		}
		
		if(method.isAnnotationPresent(DenyAll.class)) {
			return ACCESS_FORBIDDEN;
		}
		
		final HttpHeaders headers = request.getHttpHeaders();
		
		final List<String> authorization = headers.getRequestHeader(AUTHORIZATION_PROPERTY);
		
		if(authorization == null || authorization.isEmpty()) {
			return ACCESS_DENIED;
		}
		
		final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");
		
		String usernameAndPassword;
		try {
			usernameAndPassword = new String(Base64.decode(encodedUserPassword));
		} catch (IOException e) {
			return SERVER_ERROR;
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		
		if(method.isAnnotationPresent(RolesAllowed.class)) {
			RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
			Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
			
			if(!isUserAllowed(username,password,rolesSet)) {
				return ACCESS_DENIED;
			}
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		AccountModel am = new AccountModel();
		Account acc = am.find(username);
		for(String role : rolesSet)
			for(String r : acc.getRole())
				if(role.equalsIgnoreCase(r))
					return true;
		return false;
	}

}
