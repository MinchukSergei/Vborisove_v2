package by.bsu.famcs.minchuk.utils.handlers;


import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class CustomPasswordEncoder extends MessageDigestPasswordEncoder {
    public CustomPasswordEncoder(String algorithm) {
        super(algorithm);
    }
}
