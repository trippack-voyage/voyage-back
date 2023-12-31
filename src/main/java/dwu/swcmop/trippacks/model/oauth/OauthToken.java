package dwu.swcmop.trippacks.model.oauth;

import lombok.Data;

@Data
public class OauthToken {
        String token_type;
        String access_token;
        Integer expires_in;
        String refresh_token;
        String id_token;
        Integer refresh_token_expires_in;
        String scope;
}
