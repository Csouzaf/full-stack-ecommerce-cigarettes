package api.ecommerce.br.apiecommerce.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class VerifyAuthentication {
    
      public boolean verifyUserIsAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return false;
        }
        return true;
    }

    public boolean verifyIsAdminRole() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (!hasAdminRole) {
            return false;
        }
        return true;
    }

}
