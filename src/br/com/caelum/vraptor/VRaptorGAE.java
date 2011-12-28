package br.com.caelum.vraptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.VRaptor;

public class VRaptorGAE extends VRaptor {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)req).getRequestURI();
		
		if (uri.startsWith("/_ah") || uri.startsWith("/appstats") || uri.startsWith("/remote_api")) {
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}
	}
	
}
