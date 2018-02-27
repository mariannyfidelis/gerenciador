package gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookie) {
		this.cookies = cookie;
	}

	public Cookie getUsuarioLogado() {
		
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("usuario.logado")) {
					return cookie;
				}
			}
			return null;
		}
	}

}
