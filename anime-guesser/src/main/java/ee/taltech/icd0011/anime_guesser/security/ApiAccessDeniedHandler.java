package ee.taltech.icd0011.anime_guesser.security;


import ee.taltech.icd0011.anime_guesser.dto.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import tools.jackson.databind.json.JsonMapper;
import java.io.IOException;

public class ApiAccessDeniedHandler implements AccessDeniedHandler {

    private final JsonMapper mapper = new JsonMapper();
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        mapper.writeValue(response.getOutputStream(),
                new ErrorResponse(403, "Forbidden"));


    }
}
